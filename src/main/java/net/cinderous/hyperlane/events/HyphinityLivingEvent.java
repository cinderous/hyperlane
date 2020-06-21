package net.cinderous.hyperlane.events;

import net.cinderous.hyperlane.Hyperlane;
import net.cinderous.hyperlane.util.RegistryHandler;
import net.cinderous.hyperlane.world.WaterTeleporter;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Hyperlane.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class HyphinityLivingEvent {
    private static int tick;
    private static boolean isSickWithGravity = false;


    @SubscribeEvent
    public static void HyphinityLivingEvent(LivingEvent event) {
        if (event.getEntityLiving() != null) {
            LivingEntity livingEntity = event.getEntityLiving();
            World world = livingEntity.getEntityWorld();

            if (world.getDimension().getType() == DimensionType.byName(Hyperlane.HYPHINITY_DIM_TYPE)) {
                if (livingEntity.getActivePotionEffect(RegistryHandler.HYPHINITY_SICKNESS_GRAVITY.get()) != null) {

                    if (livingEntity.getActivePotionEffect(RegistryHandler.HYPHINITY_SICKNESS_GRAVITY.get()) != null) {
                        tick++;
                        if (tick == 2) {
                            BlockPos pos = livingEntity.getPosition();
                            if (world.getBlockState(pos.up()) == Blocks.AIR.getDefaultState()) {
                                livingEntity.addVelocity(0, 0.001D, 0);
                            }
                            tick = 0;
                        }
//
                    }
                } else if (!livingEntity.isPotionActive(RegistryHandler.HYPHINITY_SICKNESS_GRAVITY.get()) && !world.isRemote && !isSickWithGravity) {
                    //the following line works in other items/blocks to apply the effect, why doesnt it work in this event?

                  //livingEntity.addPotionEffect(new EffectInstance(RegistryHandler.HYPHINITY_SICKNESS_GRAVITY.get().getEffect(), 200, 1));
                    //livingEntity.addPotionEffect(new EffectInstance(Effects.SPEED, 200, 1));
                   //isSickWithGravity = true;
                }

                if(livingEntity.getPosition().getY() == 1) {

                    if (!world.isRemote) {
                        WaterTeleporter tp = new WaterTeleporter(livingEntity.getPosition());
                            livingEntity.changeDimension(DimensionType.byName(Hyperlane.VOIDEROUS_DIM_TYPE), tp);
                        }

                    }
                }
            }


        }

    }



