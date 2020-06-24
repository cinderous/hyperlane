package net.cinderous.hyperlane;

import net.cinderous.hyperlane.entities.HyphinitySwoop;
import net.cinderous.hyperlane.util.RegistryHandler;
import net.cinderous.hyperlane.util.packethandler.MyMessage;
import net.cinderous.hyperlane.world.gen.HyperlaneOreGen;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("hyperl")
@Mod.EventBusSubscriber(modid = Hyperlane.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Hyperlane
{


    public static final String NETWORK_PROTOCOL = "2";

    public static final SimpleChannel INSTANCE = NetworkRegistry.ChannelBuilder.named(new ResourceLocation(Hyperlane.MOD_ID, "net"))

            .networkProtocolVersion(() -> NETWORK_PROTOCOL)

            .clientAcceptedVersions(NETWORK_PROTOCOL::equals)

            .serverAcceptedVersions(NETWORK_PROTOCOL::equals)

            .simpleChannel();
    //public static CommonProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new CommonProxy());

//    @ObjectHolder("packedup:container")
//    public static ContainerType<DimensionalBridgeBuilderContainer> container;

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "hyperl";
    public static final ResourceLocation CINDERBANE_DIM_TYPE = new ResourceLocation(MOD_ID, "cinderbane");
    public static final ResourceLocation HYPERLANE_DIM_TYPE = new ResourceLocation(MOD_ID, "hyperlane");
    public static final ResourceLocation HYPHINITY_DIM_TYPE = new ResourceLocation(MOD_ID, "hyphinity");
    public static final ResourceLocation VEOMESHED_DIM_TYPE = new ResourceLocation(MOD_ID, "veomeshed");
    public static final ResourceLocation VOIDEROUS_DIM_TYPE = new ResourceLocation(MOD_ID, "voiderous");


    public Hyperlane() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        setupMessages();

        RegistryHandler.init();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);


    }

    public void setupMessages(){

        INSTANCE.messageBuilder(MyMessage.class, 0)

                .encoder(MyMessage::serialize).decoder(MyMessage::deserialize)

                .consumer(MyMessage::handle)

                .add();

    }
    //    @SubscribeEvent
//    public static void onContainerRegistry(final RegistryEvent.Register<ContainerType<?>> e){
//        e.getRegistry().register(IForgeContainerType.create((windowId, inv, data) -> new DimensionalBridgeBuilderContainer(windowId,data.readInt(), inv)).setRegistryName("dimensional_bridge_builder_container"));
//    }
    private void setup(final FMLCommonSetupEvent event)
    {



        HyphinitySwoop.registerPlacementTypes();

        registerEntityWorldSpawn(RegistryHandler.HYPHINITY_WISP.get(), 200, 1,1,
                RegistryHandler.HYPERLANE_DRIFTS.get());


        DeferredWorkQueue.runLater(HyperlaneOreGen::generateOre);

    }

    private void registerEntityWorldSpawn(EntityType<?> entity, int weight, int minGroupIn, int maxGroupIn, Biome... biomes) {
        for(Biome biome : biomes) {
            if(biome !=null) {
                biome.getSpawns(entity.getClassification()).add(new Biome.SpawnListEntry(entity, weight, minGroupIn, maxGroupIn));
                }

        }
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }


    public static final ItemGroup HYPERLANE_TAB = new ItemGroup("hyperlaneTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.HYPERLANE_GEL_BLOCK_ITEM.get());
        }

    };

    public static final ItemGroup VOIDEROUS_TAB = new ItemGroup("voiderousTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.VOIDEROUS_MUCK.get());
        }

    };

    @SubscribeEvent
    public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event) {
        RegistryHandler.registerBiomes();
    }


}
