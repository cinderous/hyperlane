package net.cinderous.hyperlane.events;

import net.cinderous.hyperlane.Hyperlane;
import net.cinderous.hyperlane.util.RegistryHandler;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Hyperlane.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class HyperlaneLivingEvent {

    @SubscribeEvent
    public static void HyperlaneLivingEvent(LivingEvent event) {
        if (event.getEntityLiving() != null) {
            LivingEntity livingEntity = event.getEntityLiving();
            World world = livingEntity.getEntityWorld();
            if (livingEntity.getActivePotionEffect(RegistryHandler.HYPERLANE_EFFECT.get()) != null) {
                livingEntity.setGlowing(true);

                if (world.getBlockState(livingEntity.getPosition()) == Blocks.AIR.getDefaultState() || world.getBlockState(livingEntity.getPosition()) == Blocks.WATER.getDefaultState()) {
                    //checking to ensure they are not submerged under water
                    if (world.getBlockState(livingEntity.getPosition().up(2)) != Blocks.WATER.getDefaultState()) {
                        Hyperlane.LOGGER.info("HYPERLANE GEL BEING ADDED BELOW PLAYER");
                        world.setBlockState(livingEntity.getPosition(), RegistryHandler.HYPERLANE_GEL_SLAB.get().getDefaultState());
                    }

                }

                if (livingEntity.isWet() && world.getDimension().getType() == DimensionType.byName(Hyperlane.HYPERLANE_DIM_TYPE)) {
                    livingEntity.setGlowing(true);
                    Hyperlane.LOGGER.info("ENITY IS WET>>>>" + livingEntity);

                }


                if (world.getDimension().getType() == DimensionType.byName(Hyperlane.HYPERLANE_DIM_TYPE)) {
                    livingEntity.setGlowing(true);
                    Hyperlane.LOGGER.info("ENTITY IS IN DIMENSION HYPERLANE>>>" + livingEntity);

                }
            }

            if (livingEntity.getType() == RegistryHandler.HYPERLANE_PHANTOM.get() && world.getDimension().getType() == DimensionType.byName(Hyperlane.HYPERLANE_DIM_TYPE)) {
                livingEntity.setGlowing(true);
                Hyperlane.LOGGER.info("ENTITY IS PHANTOM" + livingEntity);

            }
            if (livingEntity.getType() == RegistryHandler.HYPHINITY_WISP.get() && world.getDimension().getType() == DimensionType.byName(Hyperlane.HYPERLANE_DIM_TYPE)) {
                //Entity closetplayer = livingEntity.world.getClosestPlayer(livingEntity, 100);
                //if (livingEntity.getPosition().getX() <= closetplayer.getPosition().getX()) {
                //    CrystalArchitect.LOGGER.info("WISP IS LESS THAN 1000x away")
                livingEntity.setGlowing(true);
                //CrystalArchitect.LOGGER.info("ENTITY IS WISP" + livingEntity);

                //  }
//            if (closetplayer != null) {
//                livingEntity.setGlowing(true);
//                CrystalArchitect.LOGGER.info("WISP IS LESS THAN 20 away");
//            } else {
//                livingEntity.setGlowing(false);
//            }


            }
//        if (livingEntity.getActivePotionEffect(RegistryHandler.HYPERLANE_EFFECT.get()) != null && world.getDimension().getType() == DimensionType.OVERWORLD) {
//            CrystalArchitect.LOGGER.info("THIS EVENT IS FIRING OFF BECAUSE HYPERLANE EFFECT ISNT NULL AND THE DIMENSIONTYPE IS OVERWORLD");
//            livingEntity.setGlowing(true);
//            world.setBlockState(livingEntity.getPosition(), RegistryHandler.HYPERLANE_GEL_SLAB.get().getDefaultState());
//
//        }
//        if (livingEntity.getActivePotionEffect(RegistryHandler.HYPERLANE_EFFECT.get()) != null && world.getDimension() == RegistryHandler.HYPERLANE_DIM.get().getFactory()) {
//            CrystalArchitect.LOGGER.info("THIS EVENT IS FIRING OFF BECAUSE HYPERLANE EFFECT ISNT NULL AND THE DIMENSIONTYPE IS HYPERLANE");
//            livingEntity.setGlowing(true);
//            world.setBlockState(livingEntity.getPosition(), RegistryHandler.HYPERLANE_GEL_SLAB.get().getDefaultState());
//
//        }
//        if(world.getDimension().getType() == DimensionType.byName(CrystalArchitect.CINDERBANE_DIM_TYPE)) {
//            CrystalArchitect.LOGGER.info("THIS EVENT IS FIRING OFF!!!");
//            world.setBlockState(livingEntity.getPosition(), RegistryHandler.HYPERLANE_GEL_SLAB.get().getDefaultState());
//        }


//        if (world.getDimension().getType() == RegistryHandler.HYPERLANE_DIM.get().getFactory() ) {
//            //livingEntity.setGlowing(true);
//        }
        }
    }
}