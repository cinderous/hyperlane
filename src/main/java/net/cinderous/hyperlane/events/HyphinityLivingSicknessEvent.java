package net.cinderous.hyperlane.events;

import net.cinderous.hyperlane.Hyperlane;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Hyperlane.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class HyphinityLivingSicknessEvent {
    private static int tick;
    private static boolean isSickWithGravity = false;


    @SubscribeEvent
    public static void HyphinityLivingSicknessEvent(LivingEvent event) {
        if (event.getEntityLiving() != null && !event.getEntityLiving().getEntityWorld().isRemote) {

            LivingEntity livingEntity = event.getEntityLiving();
            World world = livingEntity.getEntityWorld();
            //livingEntity.addPotionEffect(new EffectInstance(RegistryHandler.HYPHINITY_SICKNESS_GRAVITY.get().getEffect(), 200, 1));
        }

    }
}



