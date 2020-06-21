package net.cinderous.hyperlane.events;

import net.cinderous.hyperlane.Hyperlane;
import net.cinderous.hyperlane.world.WaterTeleporter;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Hyperlane.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class VoiderousLivingEvent {

    @SubscribeEvent
    public static void VoiderousLivingEvent(LivingEvent event) {
        if (event.getEntityLiving() != null) {
            LivingEntity livingEntity = event.getEntityLiving();
            World world = livingEntity.getEntityWorld();
            if (world.getDimension().getType() == DimensionType.byName(Hyperlane.VOIDEROUS_DIM_TYPE)) {
                if(livingEntity.getPosition().getY() == 1) {

                    if (!world.isRemote) {
                        WaterTeleporter tp = new WaterTeleporter(livingEntity.getPosition());
                        livingEntity.changeDimension(DimensionType.byName(Hyperlane.HYPHINITY_DIM_TYPE), tp);
                    }

                }
            }
            }


        }

    }