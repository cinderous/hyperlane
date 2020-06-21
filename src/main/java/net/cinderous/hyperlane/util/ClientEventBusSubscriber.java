package net.cinderous.hyperlane.util;

import net.cinderous.hyperlane.Hyperlane;
import net.cinderous.hyperlane.client.entity.model.render.CinderlingRender;
import net.cinderous.hyperlane.client.entity.model.render.HyperlanePhantomRender;
import net.cinderous.hyperlane.client.entity.model.render.HyphinitySwoopRender;
import net.cinderous.hyperlane.client.entity.model.render.HyphinityWispRender;
import net.cinderous.hyperlane.tileentities.HyperlaneStaffPedestalRenderer;
import net.cinderous.hyperlane.client.gui.ExperimentBoxScreen;
import net.cinderous.hyperlane.client.gui.HyperlaneFurnaceScreen;
import net.cinderous.hyperlane.client.gui.HyperlaneStaffPedastalScreen;
import net.cinderous.hyperlane.client.gui.MultiboxChestScreen;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Hyperlane.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {

        RenderTypeLookup.setRenderLayer(RegistryHandler.CINDERWOOD_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.HYPHINITY_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.HYPHINITY_FERN.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.HYPHINITY_GRASS.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.HYPHINITY_TALL_GRASS.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.HYPHINITY_SEAGRASS.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.HYPHINITY_TALL_SEAGRASS.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.HYPHINITY_KELP.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.HYPHINITY_KELP_PLANT.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.HYPHINITY_FLOWER.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.CINDERFERN.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.CINDERBANE_GRASS.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.CINDERBANE_TALL_GRASS.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(RegistryHandler.CINDERFLAME_TORCH.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(RegistryHandler.COBBLESTONE_SOLUTION_FLUID.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(RegistryHandler.COBBLESTONE_SOLUTION_FLOWING.get(), RenderType.getTranslucent());


        ScreenManager.registerFactory(RegistryHandler.EXPERIMENT_BOX_CONTAINER.get(), ExperimentBoxScreen::new);
        ScreenManager.registerFactory(RegistryHandler.MULTIBOX_CHEST_CONTAINER.get(), MultiboxChestScreen::new);
//        ScreenManager.registerFactory(RegistryHandler.DIMENSIONAL_BRIDGE_BUILDER_CONTAINER.get(), DimensionalBridgeBuilderScreen::new);
        //ScreenManager.registerFactory(CrystalArchitect.container, DimensionalBridgeBuilderScreen::new);

        ScreenManager.registerFactory(RegistryHandler.HYPERLANE_FURNACE_CONTAINER.get(), HyperlaneFurnaceScreen::new);

        ScreenManager.registerFactory(RegistryHandler.HYPERLANE_STAFF_PEDESTAL_CONTAINER.get(), HyperlaneStaffPedastalScreen::new);


        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.CINDERLING.get(), CinderlingRender::new);
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.HYPERLANE_PHANTOM.get(), HyperlanePhantomRender::new);
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.HYPHINITY_WISP.get(), HyphinityWispRender::new);
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.HYPHINITY_SWOOP.get(), HyphinitySwoopRender::new);

        ClientRegistry.bindTileEntityRenderer(RegistryHandler.HYPERLANE_STAFF_PEDESTAL_TILE_ENTITY.get(),
                HyperlaneStaffPedestalRenderer::new);
    }
}
