package net.cinderous.hyperlane.events;

import net.cinderous.hyperlane.Hyperlane;
import net.cinderous.hyperlane.util.RegistryHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.PotionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Hyperlane.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class HyperlanePotionLivingEvent {

    @SubscribeEvent
    public static void HyperlanePotionLivingEvent(PotionEvent.PotionExpiryEvent event) {
        LivingEntity livingEntity = event.getEntityLiving();
        World world = livingEntity.getEntityWorld();
        if(event.getPotionEffect() == livingEntity.getActivePotionEffect(RegistryHandler.HYPERLANE_EFFECT.get())) {
            Hyperlane.LOGGER.info("SET GLOWING TO FALSE");
            livingEntity.setGlowing(false);

            ;

//        if (livingEntity.getActivePotionEffect(RegistryHandler.HYPERLANE_EFFECT.get()) != null && world.getDimension().getType() == DimensionType.OVERWORLD) {
//            livingEntity.setGlowing(true);
//            world.setBlockState(livingEntity.getPosition(), RegistryHandler.HYPERLANE_GEL_SLAB.get().getDefaultState());
//
//        }
//        if (livingEntity.getActivePotionEffect(RegistryHandler.HYPERLANE_EFFECT.get()) != null && world.getDimension().getType() == DimensionType.byName(CrystalArchitect.CINDERBANE_DIM_TYPE)) {
//            livingEntity.setGlowing(true);
//            world.setBlockState(livingEntity.getPosition(), RegistryHandler.HYPERLANE_GEL_SLAB.get().getDefaultState());
//
//        }
//        if (livingEntity.(RegistryHandler.HYPERLANE_EFFECT.get()) == null) {
//            //needs to be when the event for potion wears off.
//            // livingEntity.setGlowing(false);
        };
//        if (world.getDimension().getType() == RegistryHandler.HYPERLANE_DIM.get().getFactory() ) {
//            //livingEntity.setGlowing(true);
//        }
    }





}