package net.cinderous.hyperlane.events;

import net.cinderous.hyperlane.Hyperlane;
import net.cinderous.hyperlane.util.RegistryHandler;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Hyperlane.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class HyphinityChangeDimensionEvent {

    private static boolean isSickWithGravity = false;
    private static boolean isHyperlaned = false;


    @SubscribeEvent
    public static void HyphinityChangeDimensionEvent(PlayerEvent.PlayerChangedDimensionEvent event) {
        if (event.getEntityLiving() != null) {

            LivingEntity livingEntity = event.getEntityLiving();
            World world = livingEntity.getEntityWorld();
            if (!world.isRemote & livingEntity instanceof ServerPlayerEntity) {

                if(isHyperlaned) {
                    //&& livingEntity.getActivePotionEffect(RegistryHandler.HYPERLANE_EFFECT.get()) != null
                    if(world.getDimension().getType() != DimensionType.byName(Hyperlane.HYPERLANE_DIM_TYPE)) {
                        isHyperlaned = false;
                        livingEntity.removeActivePotionEffect(RegistryHandler.HYPERLANE_EFFECT.get());

                    }

                }
                if(!isHyperlaned) {
                    if(world.getDimension().getType() == DimensionType.byName(Hyperlane.HYPERLANE_DIM_TYPE)) {
                        isHyperlaned = true;
                        livingEntity.addPotionEffect(new EffectInstance(RegistryHandler.HYPERLANE_EFFECT.get().getEffect(), 1728000));

                    }
                }


                if(isSickWithGravity) {
                    if(world.getDimension().getType() != DimensionType.byName(Hyperlane.HYPHINITY_DIM_TYPE)) {
                        isSickWithGravity = false;
                        livingEntity.removeActivePotionEffect(RegistryHandler.HYPHINITY_SICKNESS_GRAVITY.get());

                    }
                }
                if(!isSickWithGravity) {
                    if(world.getDimension().getType() == DimensionType.byName(Hyperlane.HYPHINITY_DIM_TYPE)) {
                        isSickWithGravity = true;
                        livingEntity.addPotionEffect(new EffectInstance(RegistryHandler.HYPHINITY_SICKNESS_GRAVITY.get().getEffect(), 1728000 ));

                    }
                }









            }


        }
    }
}