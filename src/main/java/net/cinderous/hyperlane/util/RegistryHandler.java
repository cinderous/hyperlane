package net.cinderous.hyperlane.util;

import net.cinderous.hyperlane.Hyperlane;


import net.cinderous.hyperlane.effects.CinderbanedEffect;
import net.cinderous.hyperlane.effects.HyperlaneEffect;
import net.cinderous.hyperlane.entities.Cinderling;
import net.cinderous.hyperlane.entities.HyperlanePhantom;
import net.cinderous.hyperlane.entities.HyphinitySwoop;
import net.cinderous.hyperlane.entities.HyphinityWisp;

import net.cinderous.hyperlane.items.*;
import net.cinderous.hyperlane.util.enums.ModArmorTiers;
import net.cinderous.hyperlane.util.enums.ModItemTiers;

import net.cinderous.hyperlane.blocks.*;
import net.cinderous.hyperlane.containers.ExperimentBoxContainer;
import net.cinderous.hyperlane.containers.HyperlaneFurnaceContainer;
import net.cinderous.hyperlane.containers.HyperlaneStaffPedestalContainer;
import net.cinderous.hyperlane.containers.MultiboxChestContainer;
import net.cinderous.hyperlane.tileentities.*;
import net.cinderous.hyperlane.world.biomes.*;
import net.cinderous.hyperlane.world.dimensions.*;
import net.cinderous.hyperlane.world.feature.*;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.*;
import net.minecraft.potion.*;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class RegistryHandler {


    public static final ResourceLocation COBBLESTONE_SOLUTION_STILL_RL = new ResourceLocation(Hyperlane.MOD_ID,
            "blocks/cobblestone_solution_still");
    public static final ResourceLocation COBBLESTONE_SOLUTION_FLOWING_RL = new ResourceLocation(Hyperlane.MOD_ID,
            "blocks/cobblestone_solution_flow");
    public static final ResourceLocation COBBLESTONE_SOLUTION_OVERLAY_RL = new ResourceLocation(Hyperlane.MOD_ID,
            "blocks/cobblestone_solution_overlay");

    //public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = new DeferredRegister<>(ForgeRegistries.PARTICLE_TYPES, CrystalArchitect.MOD_ID);

    public static final DeferredRegister<SoundEvent> SOUNDS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS, Hyperlane.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Hyperlane.MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS = new DeferredRegister<>(ForgeRegistries.FLUIDS, Hyperlane.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Hyperlane.MOD_ID);
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, Hyperlane.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, Hyperlane.MOD_ID);
    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPE_DEFERRED_REGISTER = new DeferredRegister<>(ForgeRegistries.CONTAINERS, Hyperlane.MOD_ID);
    public static final DeferredRegister<Effect> POTIONS = new DeferredRegister<>(ForgeRegistries.POTIONS, Hyperlane.MOD_ID);
    public static final DeferredRegister<Potion> POTION_EFFECTS = new DeferredRegister<>(ForgeRegistries.POTION_TYPES, Hyperlane.MOD_ID);
    public static final DeferredRegister<Feature<?>> FEATURE_TYPES = new DeferredRegister<>(ForgeRegistries.FEATURES, Hyperlane.MOD_ID);





    //public static final DeferredRegister<Gui<?>> GUI = new DeferredRegister<>(ForgeRegistries.CONTAINERS, CrystalArchitect.MOD_ID);


    public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, Hyperlane.MOD_ID);
    //


    public static void init() {
       // PARTICLE_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        //CrystalArchitect.LOGGER.info("SOUNDS LOADED");
        POTIONS.register(FMLJavaModLoadingContext.get().getModEventBus());
        POTION_EFFECTS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        FEATURE_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        Hyperlane.LOGGER.info("FEATURES LOADED");
        TILE_ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        CONTAINER_TYPE_DEFERRED_REGISTER.register(FMLJavaModLoadingContext.get().getModEventBus());


        BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
        Hyperlane.LOGGER.info("BIOMES LOADED");
        MOD_DIMENSIONS.register(FMLJavaModLoadingContext.get().getModEventBus());




    }



    //Items
    public static final RegistryObject<Item> CINDERIUM_INGOT = ITEMS.register("cinderium_ingot", ItemBase::new);
    public static final RegistryObject<Item> CINDERITE_DUST = ITEMS.register("cinderite_dust", CinderiteDust::new);
    public static final RegistryObject<Item> CINDERFLUX = ITEMS.register("cinderflux", ItemBase::new);
    public static final RegistryObject<Item> CINDERDEV = ITEMS.register("cinderdev", CinderDev::new);
    public static final RegistryObject<Item> DIMENSIONAL_BRIDGE_BUILDER = ITEMS.register("dimensional_bridge_builder", DimensionalBridgeBuilder::new);


    //POTION ITEMS
    public static final RegistryObject<PotionItem> CINDERBANE_POTION_BOTTLE = ITEMS.register("cinderbane_potion_bottle", CinderbanePoisonPotion::new);



    //potion effects
    public static final RegistryObject<Effect> CINDERBANED_EFFECT = POTIONS.register("cinderbaned_effect",
            () -> new CinderbanedEffect(EffectType.BENEFICIAL, 37848743).addAttributesModifier(
                    SharedMonsterAttributes.ATTACK_SPEED, "AF8B6E3F-3328-4C0A-AA36-5BA2BB9DBEF3", 1.0D,
                    AttributeModifier.Operation.ADDITION));

    public static final RegistryObject<Effect> HYPERLANE_EFFECT = POTIONS.register("hyperlane_effect",
            () -> new HyperlaneEffect(EffectType.NEUTRAL, 37848743).addAttributesModifier(
                    SharedMonsterAttributes.ATTACK_SPEED, "AF8B6E3F-3328-4C0A-AA36-5BA2BB9DBEF3", 1.0D,
                    AttributeModifier.Operation.ADDITION));

    public static final RegistryObject<Effect> HYPHINITY_SICKNESS_GRAVITY = POTIONS.register("hyphinity_sickness_gravity",
            () -> new HyperlaneEffect(EffectType.HARMFUL, 37848743));

    //potions
    public static final RegistryObject<Potion> CINDERBANE_POTION = POTION_EFFECTS.register("cinderbane_potion",
            () -> new Potion(new EffectInstance(CINDERBANED_EFFECT.get())));

    //Tool Items
    public static final RegistryObject<AxeItem> SHARPENED_CINDERITE_ROCK = ITEMS.register("sharpened_cinderite_rock",
            () -> new AxeItem( ModItemTiers.SHARPENED_CINDERITE_ROCK_CONFIG, 6.0F, -3.2f, new Item.Properties().group(Hyperlane.TAB)));

    public static final RegistryObject<CinderlingShell> CINDERLING_SHELL = ITEMS.register("cinderling_shell",
            () -> new CinderlingShell(Fluids.EMPTY, new Item.Properties().group(Hyperlane.TAB)));

    public static final RegistryObject<CinderlingShell> CINDERLING_SHELL_WATER = ITEMS.register("cinderling_shell_water",
            () -> new CinderlingShell(Fluids.WATER, new Item.Properties().group(Hyperlane.TAB)));

    public static final RegistryObject<BucketItem> CINDERLING_SHELL_COBBLESTONE_SOLUTION = ITEMS.register("cinderling_shell_cobblestone_solution",
            () -> new BucketItem(RegistryHandler.COBBLESTONE_SOLUTION_FLUID, new Item.Properties().group(Hyperlane.TAB)));

    //stick needs to be Item properties MATERIALS, do later
    public static final RegistryObject<Item> CINDERWOOD_STICK = ITEMS.register("cinderwood_stick", ItemBase::new);

    //rough crystals
    public static final RegistryObject<Item> ROUGH_COBBLESTONE_CRYSTAL = ITEMS.register("rough_cobblestone_crystal", ItemBase::new);




    //hyperlane items
    public static final RegistryObject<Item> HYPERLANE_STAFF = ITEMS.register("hyperlane_staff", HyperlaneStaff::new);
    public static final RegistryObject<Item> HYPHINITY_WISP_INJECTOR = ITEMS.register("hyphinity_wisp_injector", HyphinityWispInjector::new);
    public static final RegistryObject<Item> HYPERLANE_GEL_RESIDUE = ITEMS.register("hyperlane_gel_residue", HyperlaneItemBase::new);
    public static final RegistryObject<Item> HYPHERIUM_INGOT = ITEMS.register("hypherium_ingot", HyperlaneItemBase::new);

    public static final RegistryObject<Item> HYPHINITY_STAFF = ITEMS.register("hyphinity_staff", HyphinityStaff::new);


    public static final RegistryObject<HyphinityPickaxe> HYPHINITY_PICKAXE = ITEMS.register("hyphinity_pickaxe",
            () -> new HyphinityPickaxe( ModItemTiers.HYPHINITY_PICKAXE_CONFIG, 6, -3.2f, new Item.Properties().group(Hyperlane.HYPERLANE_TAB)));

    public static final RegistryObject<AxeItem> HYPHINITY_AXE = ITEMS.register("hyphinity_axe",
            () -> new AxeItem( ModItemTiers.HYPHINITY_AXE_CONFIG, 6, -3.2f, new Item.Properties().group(Hyperlane.HYPERLANE_TAB)));

    public static final RegistryObject<ShovelItem> HYPHINITY_SHOVEL = ITEMS.register("hyphinity_shovel",
            () -> new ShovelItem( ModItemTiers.HYPHINITY_SHOVEL_CONFIG, 6, -3.2f, new Item.Properties().group(Hyperlane.HYPERLANE_TAB)));

//    public static final RegistryObject<HoeItem> HYPHINITY_HOE = ITEMS.register("hyphinity_hoe",
//            () -> new HoeItem( ModItemTiers.HYPHINITY_HOE_CONFIG, 6, new Item.Properties().group(CrystalArchitect.HYPERLANE_TAB)));

    public static final RegistryObject<ArmorItem> HYPHINITY_HELMET = ITEMS.register("hyphinity_helmet",
            () -> new ArmorItem(ModArmorTiers.HYPHINITY_ARMOR_CONFIG,EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<ArmorItem> HYPHINITY_CHESTPLATE = ITEMS.register("hyphinity_chestplate",
            () -> new ArmorItem(ModArmorTiers.HYPHINITY_ARMOR_CONFIG,EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<ArmorItem> HYPHINITY_LEGGINGS = ITEMS.register("hyphinity_leggings",
            () -> new ArmorItem(ModArmorTiers.HYPHINITY_ARMOR_CONFIG,EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<ArmorItem> HYPHINITY_BOOTS = ITEMS.register("hyphinity_boots",
            () -> new ArmorItem(ModArmorTiers.HYPHINITY_ARMOR_CONFIG,EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));


    public static final RegistryObject<CinderousArmorItem> CINDEROUS_TEST_BOOTS = ITEMS.register("cinderous_test_boots",
            () -> new CinderousArmorItem(ModArmorTiers.HYPHINITY_ARMOR_CONFIG,EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));


    public static final RegistryObject<Item> HYPHINITY_SHARD = ITEMS.register("hyphinity_shard", HyphinityShard::new);


    //voiderous items
    public static final RegistryObject<Item> VOIDEROUS_STAFF = ITEMS.register("voiderous_staff", VoiderousStaff::new);
    //public static final RegistryObject<Item> VOIDEROUS_RIFT_MATRIX = ITEMS.register("voiderous_rift_matrix", VoiderousRiftMatrix::new);



    //public static final RegistryObject<HyperlaneBaseItem> HYPERLANE_BASIC_TELEPORTER = ITEMS.register("hyperlane_basic_teleporter", HyperlaneBaseItem::new);

    //fluids
    public static final RegistryObject<FlowingFluid> COBBLESTONE_SOLUTION_FLUID = FLUIDS.register("cobblestone_solution_fluid",
            () -> new ForgeFlowingFluid.Source(RegistryHandler.COBBLESTONE_SOLUTION_PROPERTIES));

    public static final RegistryObject<FlowingFluid> COBBLESTONE_SOLUTION_FLOWING = FLUIDS.register("cobblestone_solution_flowing",
            () -> new ForgeFlowingFluid.Flowing(RegistryHandler.COBBLESTONE_SOLUTION_PROPERTIES));

    public static final ForgeFlowingFluid.Properties COBBLESTONE_SOLUTION_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> COBBLESTONE_SOLUTION_FLUID.get(), () -> COBBLESTONE_SOLUTION_FLOWING.get(),
            FluidAttributes.builder(COBBLESTONE_SOLUTION_STILL_RL, COBBLESTONE_SOLUTION_FLOWING_RL).density(5).luminosity(10).rarity(Rarity.RARE).color(13158600)
                    .sound(SoundEvents.ITEM_HONEY_BOTTLE_DRINK).overlay(COBBLESTONE_SOLUTION_OVERLAY_RL))
            .block(() -> RegistryHandler.COBBLESTONE_SOLUTION_BLOCK.get());

    public static final RegistryObject<FlowingFluidBlock> COBBLESTONE_SOLUTION_BLOCK = RegistryHandler.BLOCKS.register("milk",
            () -> new FlowingFluidBlock(() -> RegistryHandler.COBBLESTONE_SOLUTION_FLUID.get(), Block.Properties.create(Material.WATER)
                    .doesNotBlockMovement().hardnessAndResistance(100.0f).noDrops()));



    //blocks
    public static final RegistryObject<Block> CINDERIUM_BLOCK = BLOCKS.register("cinderium_block", CinderiumBlock::new);
    public static final RegistryObject<Block> CINDERITE_STONE = BLOCKS.register("cinderite_stone", CinderiteStone::new);

    public static final RegistryObject<Block> CINDERITE_ROCK = BLOCKS.register("cinderite_rock", CinderiteRock::new);

    //public static final RegistryObject<Block> CINDERITE_MULCH = BLOCKS.register("cinderite_mulch", CinderiteMulch::new);
    public static final RegistryObject<CinderflameTorch> CINDERFLAME_TORCH = BLOCKS.register("cinderflame_torch",
            () -> new CinderflameTorch(Block.Properties.from(Blocks.TORCH).doesNotBlockMovement().hardnessAndResistance(0).lightValue(14).sound(SoundType.WOOD)));


    public static final RegistryObject<Block> CINDIRT = BLOCKS.register("cindirt",
            () -> new Block(Block.Properties.from(Blocks.DIRT)));

    public static final RegistryObject<Block> ENRICHED_CINDIRT = BLOCKS.register("enriched_cindirt",
            () -> new Block(Block.Properties.from(Blocks.DIRT)));

    public static final RegistryObject<Block> CINDIRT_GRASS = BLOCKS.register("cindirt_grass",
            () -> new Block(Block.Properties.from(Blocks.DIRT)));

    public static final RegistryObject<Block> CINDERWOOD_PLANKS = BLOCKS.register("cinderwood_planks",
            () -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> CINDERWOOD_LOG = BLOCKS.register("cinderwood_log",
            () -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));

    public static final RegistryObject<Block> CINDERWOOD_LEAVES = BLOCKS.register("cinderwood_leaves",
            () -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));

    public static final RegistryObject<Block> CINDERWOOD_SAPLING = BLOCKS.register("cinderwood_sapling",
            () -> new CinderwoodSapling(() -> new CinderwoodTree(), Block.Properties.from(Blocks.OAK_SAPLING)));





    public static final RegistryObject<Block> MULTIBOX_CHEST = BLOCKS.register("multibox_chest", MultiboxChest::new);

    public static final RegistryObject<Block> EXPERIMENT_BOX = BLOCKS.register("experiment_box", ExperimentBox::new);

    public static final RegistryObject<Block> SOLUTION_TANK = BLOCKS.register("solution_tank", SolutionTank::new);


    public static final RegistryObject<Cinderfern> CINDERFERN = BLOCKS.register("cinderfern",
            () -> new Cinderfern(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)));

    public static final RegistryObject<CinderbaneGrass> CINDERBANE_GRASS = BLOCKS.register("cinderbane_grass",
            () -> new CinderbaneGrass(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)));

    public static final RegistryObject<CinderbaneTallGrass> CINDERBANE_TALL_GRASS = BLOCKS.register("cinderbane_tall_grass",
            () -> new CinderbaneTallGrass(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)));


    public static final RegistryObject<Block> HYPERLANE_GEL_BLOCK = BLOCKS.register("hyperlane_gel_block", HyperlaneGelBlock::new);

    public static final RegistryObject<SlabBlock> HYPERLANE_GEL_SLAB = BLOCKS.register("hyperlane_gel_slab",
            () -> new SlabBlock(Block.Properties.from(RegistryHandler.HYPERLANE_GEL_BLOCK.get())));

    public static final RegistryObject<Block> HYPERLANE_GRAVEL = BLOCKS.register("hyperlane_gravel", HyperlaneGravel::new);

    public static final RegistryObject<Block> HYPERLANE_FURNACE = BLOCKS.register("hyperlane_furnace", HyperlaneFurnace::new);

    public static final RegistryObject<Block> HYPERLANE_STAFF_PEDESTAL = BLOCKS.register("hyperlane_staff_pedestal",
            () -> new HyperlaneStaffPedestalBlock(Block.Properties.from(Blocks.ANVIL)));
    //hyphinity BLOCKS


    //hyphinity tree blocks
    public static final RegistryObject<Block> HYPHINITY_PLANKS = BLOCKS.register("hyphinity_planks",
            () -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> HYPHINITY_LOG = BLOCKS.register("hyphinity_log",
            () -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));

    public static final RegistryObject<Block> HYPHINITY_LEAVES = BLOCKS.register("hyphinity_leaves",
            () -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));

    public static final RegistryObject<Block> HYPHINITY_SAPLING = BLOCKS.register("hyphinity_sapling",
            () -> new HyphinitySapling(() -> new HyphinityTree(), Block.Properties.from(Blocks.OAK_SAPLING)));
    //hyphinity ores
    public static final RegistryObject<Block> HYPHINITY_ORE = BLOCKS.register("hyphinity_ore", HyphinityOre::new);
    public static final RegistryObject<Block> HYPHERIUM_BLOCK = BLOCKS.register("hypherium_block", HypheriumBlock::new);
    //Hyphinity fauna
    public static final RegistryObject<HyphinityFern> HYPHINITY_FERN = BLOCKS.register("hyphinity_fern",
            () -> new HyphinityFern(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)));

    public static final RegistryObject<HyphinityGrass> HYPHINITY_GRASS = BLOCKS.register("hyphinity_grass",
            () -> new HyphinityGrass(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)));

    public static final RegistryObject<HyphinityTallGrass> HYPHINITY_TALL_GRASS = BLOCKS.register("hyphinity_tall_grass",
            () -> new HyphinityTallGrass(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)));

    public static final RegistryObject<HyphinitySeaGrass> HYPHINITY_SEAGRASS = BLOCKS.register("hyphinity_seagrass",
            () -> new HyphinitySeaGrass(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)));

    public static final RegistryObject<HyphinityTallSeaGrass> HYPHINITY_TALL_SEAGRASS = BLOCKS.register("hyphinity_tall_seagrass",
            () -> new HyphinityTallSeaGrass(Block.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)));

    public static final RegistryObject<HyphinityKelp> HYPHINITY_KELP = BLOCKS.register("hyphinity_kelp",
            () -> new HyphinityKelp(Block.Properties.create(Material.OCEAN_PLANT).tickRandomly().doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)));


    public static final RegistryObject<HyphinityKelpPlant> HYPHINITY_KELP_PLANT = BLOCKS.register("hyphinity_kelp_plant",
            () -> new HyphinityKelpPlant((HyphinityKelp)HYPHINITY_KELP.get(), Block.Properties.create(Material.OCEAN_PLANT).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.WET_GRASS)));

    public static final RegistryObject<HyphinityFlower> HYPHINITY_FLOWER = BLOCKS.register("hyphinity_flower",
            () -> new HyphinityFlower(Effects.POISON, 12, Block.Properties.create(Material.OCEAN_PLANT).doesNotBlockMovement().hardnessAndResistance(0).sound(SoundType.PLANT)));

    //hyphinity biome blocks
    public static final RegistryObject<HyphinitySoil> HYPHINITY_SOIL = BLOCKS.register("hyphinity_soil",
            () -> new HyphinitySoil(Block.Properties.create(Material.EARTH)));
    public static final RegistryObject<Block> HYPHINITY_GEL_BLOCK = BLOCKS.register("hyphinity_gel_block", HyphinityGelBlock::new);
    public static final RegistryObject<Block> HYPHINITY_STONE = BLOCKS.register("hyphinity_stone", HyphinityStone::new);


    //voiderous blocks
    public static final RegistryObject<Block> VOIDEROUS_MUCK = BLOCKS.register("voiderous_muck", VoiderousMuck::new);
    public static final RegistryObject<Block> VOIDEROUS_GRAVEL = BLOCKS.register("voiderous_gravel", VoiderousGravel::new);
    public static final RegistryObject<Block> VOIDEROUS_STONE = BLOCKS.register("voiderous_stone", VoiderousStone::new);
    public static final RegistryObject<Block> VOIDEROUS_DENSE_STONE = BLOCKS.register("voiderous_dense_stone", VoiderousDenseStone::new);

    public static final RegistryObject<Block> VOIDEROUS_LOG = BLOCKS.register("voiderous_log",
            () -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));


    public static final RegistryObject<Block> VOIDEROUS_TREE_BUILDER_BLOCK = BLOCKS.register("voiderous_tree_builder_block", VoiderousTreeBuilderBlock::new);
    //public static final RegistryObject<Block> VOIDEROUS_FIRE = BLOCKS.register("voiderous_fire", VoiderousFire::new);


    //CINDEROUS DEVELOPMENT BLOCKS
    public static final RegistryObject<Block> BLOCKWORM = BLOCKS.register("blockworm", Blockworm::new);
    public static final RegistryObject<Block> BLOCKWORMY = BLOCKS.register("blockwormy", Blockwormy::new);
    public static final RegistryObject<Block> TREE_BUILDER_BLOCK = BLOCKS.register("tree_builder_block", TreeBuilderBlock::new);


    //crystal blocks

    public static final RegistryObject<Block> COBBLESTONE_CRYSTAL = BLOCKS.register("cobblestone_crystal", CobblestoneCrystal::new);



    //block items
    public static final RegistryObject<Item> CINDERIUM_BLOCK_ITEM = ITEMS.register("cinderium_block", () -> new BlockItemBase(CINDERIUM_BLOCK.get()));
    public static final RegistryObject<Item> CINDERITE_STONE_ITEM = ITEMS.register("cinderite_stone", () -> new BlockItemBase(CINDERITE_STONE.get()));
    public static final RegistryObject<Item> CINDERITE_ROCK_ITEM = ITEMS.register("cinderite_rock", () -> new BlockItemBase(CINDERITE_ROCK.get()));
    //public static final RegistryObject<Item> CINDERITE_MULCH_ITEM = ITEMS.register("cinderite_mulch", () -> new BlockItemBase(CINDERITE_MULCH.get()));
    public static final RegistryObject<Item> CINDIRT_ITEM = ITEMS.register("cindirt", () -> new BlockItemBase(CINDIRT.get()));
    public static final RegistryObject<Item> CINDIRT_GRASS_ITEM = ITEMS.register("cindirt_grass", () -> new BlockItemBase(CINDIRT_GRASS.get()));

    public static final RegistryObject<Item> CINDERWOOD_PLANKS_ITEM = ITEMS.register("cinderwood_planks", () -> new BlockItemBase(CINDERWOOD_PLANKS.get()));
    public static final RegistryObject<Item> CINDERWOOD_LOG_ITEM = ITEMS.register("cinderwood_log", () -> new BlockItemBase(CINDERWOOD_LOG.get()));
    public static final RegistryObject<Item> CINDERWOOD_LEAVES_ITEM = ITEMS.register("cinderwood_leaves", () -> new BlockItemBase(CINDERWOOD_LEAVES.get()));
    public static final RegistryObject<Item> CINDERWOOD_SAPLING_ITEM = ITEMS.register("cinderwood_sapling", () -> new BlockItemBase(CINDERWOOD_SAPLING.get()));
    public static final RegistryObject<Item> EXPERIMENT_BOX_ITEM = ITEMS.register("experiment_box", () -> new BlockItemBase(EXPERIMENT_BOX.get()));
    public static final RegistryObject<Item> ENRICHED_CINDIRT_ITEM = ITEMS.register("enriched_cindirt", () -> new BlockItemBase(ENRICHED_CINDIRT.get()));
    public static final RegistryObject<Item> COBBLESTONE_CRYSTAL_ITEM = ITEMS.register("cobblestone_crystal", () -> new BlockItemBase(COBBLESTONE_CRYSTAL.get()));
    public static final RegistryObject<Item> CINDERFLAME_TORCH_ITEM = ITEMS.register("cinderflame_torch", () -> new BlockItemBase(CINDERFLAME_TORCH.get()));




//hyphinity block items
    public static final RegistryObject<Item> MULTIBOX_CHEST_ITEM = ITEMS.register("multibox_chest", () -> new BlockItemBase(MULTIBOX_CHEST.get()));
    public static final RegistryObject<Item> SOLUTION_TANK_ITEM = ITEMS.register("solution_tank", () -> new BlockItemBase(SOLUTION_TANK.get()));
    public static final RegistryObject<Item> HYPERLANE_GEL_BLOCK_ITEM = ITEMS.register("hyperlane_gel_block", () -> new HyperlaneBlockItemBase(HYPERLANE_GEL_BLOCK.get()));
    public static final RegistryObject<Item> HYPERLANE_GEL_SLAB_ITEM = ITEMS.register("hyperlane_gel_slab", () -> new HyperlaneBlockItemBase(HYPERLANE_GEL_SLAB.get()));
    public static final RegistryObject<Item> HYPERLANE_GRAVEL_ITEM = ITEMS.register("hyperlane_gravel", () -> new HyperlaneBlockItemBase(HYPERLANE_GRAVEL.get()));
    public static final RegistryObject<Item> HYPERLANE_FURNACE_ITEM = ITEMS.register("hyperlane_furnace", () -> new HyperlaneBlockItemBase(HYPERLANE_FURNACE.get()));
    public static final RegistryObject<Item> HYPHINITY_ORE_ITEM = ITEMS.register("hyphinity_ore", () -> new HyperlaneBlockItemBase(HYPHINITY_ORE.get()));
    public static final RegistryObject<Item> HYPHERIUM_BLOCK_ITEM = ITEMS.register("hypherium_block", () -> new HyperlaneBlockItemBase(HYPHERIUM_BLOCK.get()));
    public static final RegistryObject<Item> HYPHINITY_FERN_ITEM = ITEMS.register("hyphinity_fern", () -> new HyperlaneBlockItemBase(HYPHINITY_FERN.get()));
    public static final RegistryObject<Item> HYPHINITY_GRASS_ITEM = ITEMS.register("hyphinity_grass", () -> new HyperlaneBlockItemBase(HYPHINITY_GRASS.get()));
    public static final RegistryObject<Item> HYPHINITY_TALL_GRASS_ITEM = ITEMS.register("hyphinity_tall_grass", () -> new HyperlaneBlockItemBase(HYPHINITY_TALL_GRASS.get()));
    public static final RegistryObject<Item> HYPHINITY_SEAGRASS_ITEM = ITEMS.register("hyphinity_seagrass", () -> new HyperlaneBlockItemBase(HYPHINITY_SEAGRASS.get()));
    public static final RegistryObject<Item> HYPHINITY_TALL_SEAGRASS_ITEM = ITEMS.register("hyphinity_tall_seagrass", () -> new HyperlaneBlockItemBase(HYPHINITY_TALL_SEAGRASS.get()));
    public static final RegistryObject<Item> HYPHINITY_KELP_ITEM = ITEMS.register("hyphinity_kelp", () -> new HyperlaneBlockItemBase(HYPHINITY_KELP.get()));
    public static final RegistryObject<Item> HYPHINITY_KELP_PLANT_ITEM = ITEMS.register("hyphinity_kelp_plant", () -> new HyperlaneBlockItemBase(HYPHINITY_KELP_PLANT.get()));
    public static final RegistryObject<Item> HYPHINITY_FLOWER_ITEM = ITEMS.register("hyphinity_flower", () -> new HyperlaneBlockItemBase(HYPHINITY_FLOWER.get()));
    public static final RegistryObject<Item> HYPHINITY_SOIL_ITEM = ITEMS.register("hyphinity_soil", () -> new HyperlaneBlockItemBase(HYPHINITY_SOIL.get()));
    public static final RegistryObject<Item> HYPHINITY_GEL_BLOCK_ITEM = ITEMS.register("hyphinity_gel_block", () -> new HyperlaneBlockItemBase(HYPHINITY_GEL_BLOCK.get()));
    public static final RegistryObject<Item> HYPHINITY_STONE_ITEM = ITEMS.register("hyphinity_stone", () -> new HyperlaneBlockItemBase(HYPHINITY_SOIL.get()));

//voiderous block items
    public static final RegistryObject<Item> VOIDEROUS_MUCK_ITEM = ITEMS.register("voiderous_muck", () -> new VoiderousBlockItemBase(VOIDEROUS_MUCK.get()));
    public static final RegistryObject<Item> VOIDEROUS_GRAVEL_ITEM = ITEMS.register("voiderous_gravel", () -> new VoiderousBlockItemBase(VOIDEROUS_GRAVEL.get()));
    public static final RegistryObject<Item> VOIDEROUS_STONE_ITEM = ITEMS.register("voiderous_stone", () -> new VoiderousBlockItemBase(VOIDEROUS_STONE.get()));
    public static final RegistryObject<Item> VOIDEROUS_DENSE_STONE_ITEM = ITEMS.register("voiderous_dense_stone", () -> new VoiderousBlockItemBase(VOIDEROUS_DENSE_STONE.get()));
    public static final RegistryObject<Item> VOIDEROUS_LOG_ITEM = ITEMS.register("voiderous_log", () -> new VoiderousBlockItemBase(VOIDEROUS_LOG.get()));
    public static final RegistryObject<Item> VOIDEROUS_TREE_BUILDER_BLOCK_ITEM = ITEMS.register("voiderous_tree_builder_block", () -> new VoiderousBlockItemBase(VOIDEROUS_TREE_BUILDER_BLOCK.get()));




    //hyperlane hyphinity  BLOCK items
    public static final RegistryObject<Item> HYPHINITY_PLANKS_ITEM = ITEMS.register("hyphinity_planks", () -> new HyperlaneBlockItemBase(HYPHINITY_PLANKS.get()));
    public static final RegistryObject<Item> HYPHINITY_LOG_ITEM = ITEMS.register("hyphinity_log", () -> new HyperlaneBlockItemBase(HYPHINITY_LOG.get()));
    public static final RegistryObject<Item> HYPHINITY_LEAVES_ITEM = ITEMS.register("hyphinity_leaves", () -> new HyperlaneBlockItemBase(HYPHINITY_LEAVES.get()));
    public static final RegistryObject<Item> HYPHINITY_SAPLING_ITEM = ITEMS.register("hyphinity_sapling", () -> new HyperlaneBlockItemBase(HYPHINITY_SAPLING.get()));
    public static final RegistryObject<Item> HYPERLANE_STAFF_PEDESTAL_ITEM = ITEMS.register("hyperlane_staff_pedestal", () -> new HyperlaneBlockItemBase(HYPERLANE_STAFF_PEDESTAL.get()));

    //CINDEROUS DEV BLOCK ITEMS
    public static final RegistryObject<Item> BLOCKWORM_ITEM = ITEMS.register("blockworm", () -> new HyperlaneBlockItemBase(BLOCKWORM.get()));
    public static final RegistryObject<Item> BLOCKWORMY_ITEM = ITEMS.register("blockwormy", () -> new HyperlaneBlockItemBase(BLOCKWORMY.get()));
    public static final RegistryObject<Item> TREE_BUILDER_BLOCK_ITEM = ITEMS.register("tree_builder_block", () -> new HyperlaneBlockItemBase(TREE_BUILDER_BLOCK.get()));







    //features

    public static final RegistryObject<HyphinitySeaGrassFeature> HYPHINITY_SEAGRASS_FEATURE = FEATURE_TYPES.register("hyphinity_seagrass_feature", () -> new HyphinitySeaGrassFeature(HyphinitySeaGrassFeatureConfig::deserialize));
    public static final RegistryObject<Feature<NoFeatureConfig>> TEST_FEATURE = FEATURE_TYPES.register("test_feature", () -> new TestFeature<>(NoFeatureConfig::deserialize));


    //entities
    public static final RegistryObject<EntityType<Cinderling>> CINDERLING = ENTITY_TYPES
            .register("cinderling",
                    () -> EntityType.Builder.<Cinderling>create(Cinderling::new, EntityClassification.MONSTER)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(Hyperlane.MOD_ID, "cinderling").toString()));

    public static final RegistryObject<EntityType<HyperlanePhantom>> HYPERLANE_PHANTOM = ENTITY_TYPES
            .register("hyperlane_phantom",
                    () -> EntityType.Builder.<HyperlanePhantom>create(HyperlanePhantom::new, EntityClassification.CREATURE)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(Hyperlane.MOD_ID, "hyperlane_phantom").toString()));

    public static final RegistryObject<EntityType<HyphinityWisp>> HYPHINITY_WISP = ENTITY_TYPES
            .register("hyphinity_wisp",
                    () -> EntityType.Builder.<HyphinityWisp>create(HyphinityWisp::new, EntityClassification.AMBIENT)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(Hyperlane.MOD_ID, "hyphinity_wisp").toString()));

    public static final RegistryObject<EntityType<HyphinitySwoop>> HYPHINITY_SWOOP = ENTITY_TYPES
            .register("hyphinity_swoop",
                    () -> EntityType.Builder.<HyphinitySwoop>create(HyphinitySwoop::new, EntityClassification.MONSTER)
                            .size(0.9f, 1.3f)
                            .build(new ResourceLocation(Hyperlane.MOD_ID, "hyphinity_swoop").toString()));



    //tile entities

    public static final RegistryObject<TileEntityType<ExperimentBoxTileEntity>> EXPERIMENT_BOX_TILE_ENTITY = TILE_ENTITY_TYPES
            .register("experiment_box", () -> TileEntityType.Builder
                    .create(ExperimentBoxTileEntity::new, RegistryHandler.EXPERIMENT_BOX.get()).build(null));

    public static final RegistryObject<TileEntityType<MultiboxChestTileEntity>> MULTIBOX_CHEST_TILE_ENTITY = TILE_ENTITY_TYPES
            .register("multiblock_chest", () -> TileEntityType.Builder
                    .create(MultiboxChestTileEntity::new, RegistryHandler.MULTIBOX_CHEST.get()).build(null));

    public static final RegistryObject<TileEntityType<SolutionTankTileEntity>> SOLUTION_TANK_TILE_ENTITY = TILE_ENTITY_TYPES
            .register("solution_tank", () -> TileEntityType.Builder
                    .create(SolutionTankTileEntity::new, RegistryHandler.SOLUTION_TANK.get()).build(null));

//    public static final RegistryObject<TileEntityType<HyperlaneBasicTeleporterTileEntity>> HYPERLANE_BASIC_TELEPORTER_TILE_ENTITY = TILE_ENTITY_TYPES
//            .register("hyperlane_basic_teleporter", () -> TileEntityType.Builder
//                    .create(HyperlaneBasicTeleporterTileEntity::new, RegistryHandler.HYPERLANE_BASIC_TELEPORTER.get()).build(null));

    public static final RegistryObject<TileEntityType<HyperlaneFurnaceTileEntity>> HYPERLANE_FURNACE_TILE_ENTITY = TILE_ENTITY_TYPES
            .register("hyperlane_furnace", () -> TileEntityType.Builder
                    .create(HyperlaneFurnaceTileEntity::new, RegistryHandler.HYPERLANE_FURNACE.get()).build(null));

    public static final RegistryObject<TileEntityType<HyperlaneStaffPedestalTileEntity>> HYPERLANE_STAFF_PEDESTAL_TILE_ENTITY = TILE_ENTITY_TYPES
            .register("hyperlane_staff_pedestal", () -> TileEntityType.Builder
                    .create(HyperlaneStaffPedestalTileEntity::new, RegistryHandler.HYPERLANE_STAFF_PEDESTAL.get()).build(null));

    public static final RegistryObject<TileEntityType<BlockwormTileEntity>> BLOCKWORM_TILE_ENTITY = TILE_ENTITY_TYPES
            .register("blockworm", () -> TileEntityType.Builder
                    .create(BlockwormTileEntity::new, RegistryHandler.BLOCKWORM.get()).build(null));

    public static final RegistryObject<TileEntityType<TreeBuilderBlockTileEntity>> TREE_BUILDER_BLOCK_TILE_ENTITY = TILE_ENTITY_TYPES
            .register("tree_builder_block", () -> TileEntityType.Builder
                    .create(TreeBuilderBlockTileEntity::new, RegistryHandler.TREE_BUILDER_BLOCK.get()).build(null));

    public static final RegistryObject<TileEntityType<BlockwormyTileEntity>> BLOCKWORMY_TILE_ENTITY = TILE_ENTITY_TYPES
            .register("blockwormy", () -> TileEntityType.Builder
                    .create(BlockwormyTileEntity::new, RegistryHandler.BLOCKWORMY.get()).build(null));

    public static final RegistryObject<TileEntityType<VoiderousTreeBuilderBlockTileEntity>> VOIDEROUS_TREE_BUILDER_BLOCK_TILE_ENTITY = TILE_ENTITY_TYPES
            .register("voiderous_tree_builder_block", () -> TileEntityType.Builder
                    .create(VoiderousTreeBuilderBlockTileEntity::new, RegistryHandler.VOIDEROUS_TREE_BUILDER_BLOCK.get()).build(null));

    //crystal tile entities
    public static final RegistryObject<TileEntityType<CobblestoneCrystalTileEntity>> COBBLESTONE_CRYSTAL_TILE_ENTITY = TILE_ENTITY_TYPES
            .register("cobblestone_crystal_tile_entity", () -> TileEntityType.Builder
                    .create(CobblestoneCrystalTileEntity::new, RegistryHandler.COBBLESTONE_CRYSTAL.get()).build(null));


    //containers

    public static final RegistryObject<ContainerType<ExperimentBoxContainer>> EXPERIMENT_BOX_CONTAINER = CONTAINER_TYPE_DEFERRED_REGISTER
            .register("experiment_box_container", () -> IForgeContainerType.create(ExperimentBoxContainer::new));

    public static final RegistryObject<ContainerType<MultiboxChestContainer>> MULTIBOX_CHEST_CONTAINER = CONTAINER_TYPE_DEFERRED_REGISTER
            .register("multibox_chest_container", () -> IForgeContainerType.create(MultiboxChestContainer::new));

//    public static final RegistryObject<ContainerType<HyperlaneBasicTeleporterContainer>> HYPERLANE_BASIC_TELEPORTER_CONTAINER = CONTAINER_TYPE_DEFERRED_REGISTER
//            .register("hyperlane_basic_teleporter_container", () -> IForgeContainerType.create(HyperlaneBasicTeleporterContainer::new));

    public static final RegistryObject<ContainerType<HyperlaneFurnaceContainer>> HYPERLANE_FURNACE_CONTAINER = CONTAINER_TYPE_DEFERRED_REGISTER
            .register("hyperlane_furance_container", () -> IForgeContainerType.create(HyperlaneFurnaceContainer::new));

    public static final RegistryObject<ContainerType<HyperlaneStaffPedestalContainer>> HYPERLANE_STAFF_PEDESTAL_CONTAINER = CONTAINER_TYPE_DEFERRED_REGISTER
            .register("hyperlane_staff_pedestal", () -> IForgeContainerType.create(HyperlaneStaffPedestalContainer::new));

//    public static final RegistryObject<ContainerType<DimensionalBridgeBuilderContainer>> DIMENSIONAL_BRIDGE_BUILDER_CONTAINER = CONTAINER_TYPE_DEFERRED_REGISTER
//            .register("dimensional_bridge_builder", () -> IForgeContainerType.create(DimensionalBridgeBuilderContainer::new));


    //sounds
    public static final RegistryObject<SoundEvent> AMBIENT = SOUNDS.register("entity.cinderling.ambient",
            () -> new SoundEvent(new ResourceLocation(Hyperlane.MOD_ID, "entity.cinderling.ambient")));

    public static void registerEntityWorldSpawn(EntityType<?> entity, int weight, int minGroupIn, int maxGroupIn, Biome... biomes) {
        for(Biome biome : biomes) {
            if (biome != null) {
                biome.getSpawns(entity.getClassification()).add(new Biome.SpawnListEntry(entity, weight, minGroupIn, maxGroupIn));
            }
        }

    }






    //biomes
    public static final RegistryObject<Biome> CINDERBANE = BIOMES.register("cinderbane_biome",
            () -> new CinderbaneBiome(new Biome.Builder().precipitation(Biome.RainType.SNOW).scale(1.2f).temperature(2f)
                    .waterColor(9211020).waterFogColor(9211020)
                    .surfaceBuilder(SurfaceBuilder.DEFAULT,
                            new SurfaceBuilderConfig(
                                    RegistryHandler.CINDIRT_GRASS.get().getDefaultState(),
                                    RegistryHandler.CINDIRT.get().getDefaultState(),
                                    RegistryHandler.CINDERITE_STONE.get().getDefaultState()))
                    .category(Biome.Category.PLAINS)
                    .downfall(0.5f)
                    .depth(0.12f)
                    .parent(null)
            ));
    public static final RegistryObject<Biome> HYPERLANE_DRIFTS = BIOMES.register("hyperlane_drifts",
            () -> new HyperlaneDrifts(new Biome.Builder().precipitation(Biome.RainType.SNOW).scale(1.2f).temperature(0.5f)
                    .waterColor(16777215).waterFogColor(16777215)
                    .surfaceBuilder(HyperlaneDriftsSurfaceBuilder.DEFAULT,
                            new SurfaceBuilderConfig(
                                    RegistryHandler.HYPERLANE_GEL_BLOCK.get().getDefaultState(),
                                    RegistryHandler.HYPERLANE_GRAVEL.get().getDefaultState(),
                                    RegistryHandler.HYPERLANE_GEL_BLOCK.get().getDefaultState()))
                    .category(Biome.Category.ICY)
                    .downfall(0.5f)

                    .depth(0.12f)
                    .parent(null)

            ));

    public static final RegistryObject<Biome> HYPHINITY_LIMBO = BIOMES.register("hyphinity_oasis",
            () -> new HyphinityLimbo(new Biome.Builder().precipitation(Biome.RainType.SNOW).scale(1.2f).temperature(0.5f)
                    .waterColor(16777215).waterFogColor(16777215)
                    .surfaceBuilder(HyperlaneDriftsSurfaceBuilder.DEFAULT,
                            new SurfaceBuilderConfig(
                                    RegistryHandler.HYPHINITY_GEL_BLOCK.get().getDefaultState(),
                                    RegistryHandler.HYPHINITY_SOIL.get().getDefaultState(),
                                    RegistryHandler.HYPHINITY_GEL_BLOCK.get().getDefaultState()))
                    .category(Biome.Category.ICY)
                    .downfall(0.5f)
                    .depth(0.12f)
                    .parent(null)

            ));

    public static final RegistryObject<Biome> VOIDEROUS_NIGHTMARE = BIOMES.register("voiderous_nightmare",
            () -> new VoiderousNightmare(new Biome.Builder().precipitation(Biome.RainType.NONE).scale(1.2f).temperature(2f)
                    .waterColor(14205695).waterFogColor(11103743)
                    .surfaceBuilder(HyperlaneDriftsSurfaceBuilder.DEFAULT,
                            new SurfaceBuilderConfig(
                                    RegistryHandler.VOIDEROUS_GRAVEL.get().getDefaultState(),
                                    RegistryHandler.VOIDEROUS_STONE.get().getDefaultState(),
                                    RegistryHandler.VOIDEROUS_STONE.get().getDefaultState()))
                    .category(Biome.Category.MESA)
                    .downfall(0.5f)
                    .depth(0.12f)
                    .parent(null)

            ));

    public static final RegistryObject<Biome> VOIDEROUS_HELL = BIOMES.register("voiderous_hell",
            () -> new VoiderousHell(new Biome.Builder().precipitation(Biome.RainType.NONE).scale(.4f).temperature(2f)
                    .waterColor(14205695).waterFogColor(11103743)
                    .surfaceBuilder(HyperlaneDriftsSurfaceBuilder.DEFAULT,
                            new SurfaceBuilderConfig(
                                    RegistryHandler.VOIDEROUS_GRAVEL.get().getDefaultState(),
                                    RegistryHandler.VOIDEROUS_STONE.get().getDefaultState(),
                                    RegistryHandler.VOIDEROUS_STONE.get().getDefaultState()))
                    .category(Biome.Category.MESA)
                    .downfall(0.5f)
                    .depth(0.12f)
                    .parent(null)

            ));


    public static void registerBiomes(){

        registerBiome(CINDERBANE.get(), BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.OVERWORLD);
        registerBiome(HYPERLANE_DRIFTS.get(), BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.OVERWORLD);
    }

    public static void registerBiome(Biome biome, BiomeDictionary.Type... types) {
        if (biome == RegistryHandler.HYPERLANE_DRIFTS.get() ) {
            BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(biome, 100));
        }
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }

    //dimensions
    public static final DeferredRegister<ModDimension> MOD_DIMENSIONS = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, Hyperlane.MOD_ID);
    public static final RegistryObject<ModDimension> CINDERBANE_DIM = MOD_DIMENSIONS.register("cinderbane_dim", () -> new CinderbaneModDimension());

    public static final RegistryObject<ModDimension> HYPERLANE_DIM = MOD_DIMENSIONS.register("hyperlane_dim", () -> new HyperlaneModDimension());

    public static final RegistryObject<ModDimension> HYPHINITY_DIM = MOD_DIMENSIONS.register("hyphinity_dim", () -> new HyphinityModDimension());
    public static final RegistryObject<ModDimension> VEOMESHED_DIM = MOD_DIMENSIONS.register("veomeshed_dim", () -> new VeomeshedModDimension());
    public static final RegistryObject<ModDimension> VOIDEROUS_DIM = MOD_DIMENSIONS.register("voiderous_dim", () -> new VoiderousModDimension());



////effects
//public static final RegistryObject<Effect> CINDERBANED_EFFECT = POTIONS.register("cinderbaned_effect",
//        () -> new CinderbanedEffect(EffectType.HARMFUL, 37848743).addAttributesModifier(
//                SharedMonsterAttributes.ATTACK_SPEED, "AF8B6E3F-3328-4C0A-AA36-5BA2BB9DBEF3", 1.0D,
//                AttributeModifier.Operation.ADDITION));

    //particles


//    public static final RegistryObject<ParticleType<ColouredParticle.ColouredParticleData>> COLOURED_PARTICLE = PARTICLE_TYPES.register(
//            "coloured_particle",
//            () -> new ParticleType<ColouredParticle.ColouredParticleData>(false, ColouredParticle.ColouredParticleData.DESERIALIZER));
//
//    @SuppressWarnings("resource")
//    @SubscribeEvent
//    public static void registerParticleFactory(ParticleFactoryRegisterEvent event) {
//        Minecraft.getInstance().particles.registerFactory(RegistryHandler.COLOURED_PARTICLE.get(),
//                ColouredParticle.Factory::new);
//    }
}


