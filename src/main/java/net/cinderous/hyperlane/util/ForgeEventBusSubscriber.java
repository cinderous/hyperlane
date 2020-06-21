package net.cinderous.hyperlane.util;

import net.cinderous.hyperlane.Hyperlane;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Hyperlane.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventBusSubscriber {

    @SubscribeEvent
    public static void registerDimensions(final RegisterDimensionsEvent event) {

        if (DimensionType.byName(Hyperlane.HYPERLANE_DIM_TYPE) == null) {
            DimensionManager.registerDimension(Hyperlane.HYPERLANE_DIM_TYPE, RegistryHandler.HYPERLANE_DIM.get(), null,
                    true);
        }
        if (DimensionType.byName(Hyperlane.HYPHINITY_DIM_TYPE) == null) {
            DimensionManager.registerDimension(Hyperlane.HYPHINITY_DIM_TYPE, RegistryHandler.HYPHINITY_DIM.get(), null,
                    true);
        }
        if (DimensionType.byName(Hyperlane.VEOMESHED_DIM_TYPE) == null) {
            DimensionManager.registerDimension(Hyperlane.VEOMESHED_DIM_TYPE, RegistryHandler.VEOMESHED_DIM.get(), null,
                    true);
        }
        if (DimensionType.byName(Hyperlane.VOIDEROUS_DIM_TYPE) == null) {
            DimensionManager.registerDimension(Hyperlane.VOIDEROUS_DIM_TYPE, RegistryHandler.VOIDEROUS_DIM.get(), null,
                    true);
        }
        Hyperlane.LOGGER.info("Dimensions Registered!");


    }
}