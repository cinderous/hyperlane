package net.cinderous.hyperlane.events;

import net.cinderous.hyperlane.Hyperlane;
import net.cinderous.hyperlane.util.RegistryHandler;
import net.cinderous.hyperlane.util.packethandler.MyMessage;
import net.cinderous.hyperlane.world.HyperlaneTier1Teleport;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Hyperlane.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class HyperlaneLivingEvent {

    public static int tick = 0;
    public static boolean speedAchieved = false;



    @SubscribeEvent
    public static void HyperlaneLivingEvent(LivingEvent event) {



        if (event.getEntityLiving() != null) {
            LivingEntity livingEntity = event.getEntityLiving();
            World world = livingEntity.getEntityWorld();
            if (livingEntity.getActivePotionEffect(RegistryHandler.HYPERLANE_EFFECT.get()) != null) {

                if (world.getBlockState(livingEntity.getPosition()) == Blocks.AIR.getDefaultState() || world.getBlockState(livingEntity.getPosition()) == Blocks.WATER.getDefaultState()) {
                    //checking to ensure they are not submerged under water
                    if (world.getBlockState(livingEntity.getPosition().up(2)) != Blocks.WATER.getDefaultState()) {

                        world.setBlockState(livingEntity.getPosition(), RegistryHandler.HYPERLANE_GEL_SLAB.get().getDefaultState());
                    }

                }

                if (livingEntity.isWet() && world.getDimension().getType() == DimensionType.byName(Hyperlane.HYPERLANE_DIM_TYPE)) {
                    livingEntity.setGlowing(true);


                }


                if (world.getDimension().getType() == DimensionType.byName(Hyperlane.HYPERLANE_DIM_TYPE)) {
                    livingEntity.setGlowing(true);


                }
            }

            if (livingEntity.getType() == RegistryHandler.HYPERLANE_PHANTOM.get() && world.getDimension().getType() == DimensionType.byName(Hyperlane.HYPERLANE_DIM_TYPE)) {
                livingEntity.setGlowing(true);


            }


            //
            //livingEntity.setMotion(10,0,0);

//                if (livingEntity.getMotion().getX() > 5 || livingEntity.getMotion().getZ() > 5 || livingEntity.getMotion().getX() < -5 || livingEntity.getMotion().getZ() < -5) {
//                    if (world.getBlockState(livingEntity.getPosition().down()) == Blocks.WATER.getDefaultState()) {
//                        tick++;
//                        Hyperlane.LOGGER.info(tick);
//                        if (tick == 75) {
//
//                            if(!world.isRemote) {
//                                HyperlaneTier1Teleport tp = new HyperlaneTier1Teleport(livingEntity.getPosition(), RegistryHandler.VOIDEROUS_MUCK.get().getDefaultState().getBlock());
//                                livingEntity.changeDimension(DimensionType.byName(Hyperlane.HYPHINITY_DIM_TYPE), tp);
//                            }
//
//                        }
//                    }
//                }
//thanks jojo2357 for helping me with the speed detection in any horizontal direction.
            if (Math.sqrt(Math.pow(livingEntity.getMotion().getX(), 2) + Math.pow(livingEntity.getMotion().getZ(), 2)) > 5 ) {
                if (world.getBlockState(livingEntity.getPosition().down()) == Blocks.WATER.getDefaultState()) {
                    tick++;
                    Hyperlane.LOGGER.info(tick);
                    if (tick == 50) {
                        speedAchieved = true;
                        BlockPos playerPos = livingEntity.getPosition();
                        MyMessage message = (new MyMessage(playerPos ,speedAchieved));

                        Hyperlane.INSTANCE.sendToServer(message);
                        tick=0;

                    }
                }
            }

        }
    }

    public static boolean teleportToHyphinity(LivingEntity livingEntity, Boolean speedAchieved) {
        World world = livingEntity.getEntityWorld();

        if (speedAchieved && !world.isRemote) {
            HyperlaneTier1Teleport tp = new HyperlaneTier1Teleport(livingEntity.getPosition(), RegistryHandler.VOIDEROUS_MUCK.get().getDefaultState().getBlock());
            livingEntity.changeDimension(DimensionType.byName(Hyperlane.HYPHINITY_DIM_TYPE), tp);
        }
        return true;
    }

}

