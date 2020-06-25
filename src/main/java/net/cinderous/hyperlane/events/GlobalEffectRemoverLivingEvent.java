package net.cinderous.hyperlane.events;

import net.cinderous.hyperlane.Hyperlane;
import net.cinderous.hyperlane.util.RegistryHandler;
import net.cinderous.hyperlane.util.packethandler.MyMessage;
import net.cinderous.hyperlane.world.HyperlaneTier1Teleport;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Hyperlane.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class GlobalEffectRemoverLivingEvent {

    @SubscribeEvent
    public static void GlobalEffectRemoverLivingEvent(LivingEvent event) {

        if (event.getEntityLiving() != null && event.getEntityLiving() instanceof PlayerEntity) {
            LivingEntity livingEntity = event.getEntityLiving();
            World world = livingEntity.getEntityWorld();
            if(livingEntity.getActivePotionEffect(RegistryHandler.HYPHINITY_SICKNESS_GRAVITY.get()) != null && world.getDimension().getType() != DimensionType.byName(Hyperlane.HYPHINITY_DIM_TYPE) ) {
                livingEntity.removeActivePotionEffect(RegistryHandler.HYPHINITY_SICKNESS_GRAVITY.get());
            }
            if(livingEntity.getActivePotionEffect(RegistryHandler.HYPERLANE_EFFECT.get()) != null && world.getDimension().getType() != DimensionType.byName(Hyperlane.HYPERLANE_DIM_TYPE) ) {
                livingEntity.removeActivePotionEffect(RegistryHandler.HYPERLANE_EFFECT.get());
                livingEntity.setGlowing(false);
            }
        }
    }


}

