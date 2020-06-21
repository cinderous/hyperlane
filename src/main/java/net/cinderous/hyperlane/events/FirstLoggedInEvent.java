package net.cinderous.hyperlane.events;

import net.cinderous.hyperlane.Hyperlane;
import net.cinderous.hyperlane.world.WaterTeleporter;
import net.minecraft.advancements.Advancement;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Hyperlane.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FirstLoggedInEvent {

    @SubscribeEvent
    public static void FirstLoggedInEvent(PlayerEvent.PlayerLoggedInEvent event) {
      if (event.getEntityLiving() != null && event != null) {



            LivingEntity livingEntity = event.getEntityLiving();
            World world = livingEntity.getEntityWorld();



            if (!world.isRemote && livingEntity instanceof ServerPlayerEntity && world.getDimension().getType() == DimensionType.OVERWORLD) {
                Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) livingEntity).server).getAdvancementManager()
                        .getAdvancement(new ResourceLocation("hyperl:root"));
                ServerPlayerEntity player = (ServerPlayerEntity) livingEntity;
                if (!((ServerPlayerEntity) livingEntity).getAdvancements().getProgress(_adv).isDone()) {
                    Hyperlane.LOGGER.info(_adv);
                    Hyperlane.LOGGER.info("ADVANCEMENT NOT COMPLETE, TELEPORTING TO CINDERBANE");
                    //WaterTeleporter tp = new WaterTeleporter(livingEntity.getPosition());
                    if(livingEntity instanceof ServerPlayerEntity) {

                        //((ServerPlayerEntity) livingEntity).changeDimension(DimensionType.THE_END);
                        if (player.connection.getNetworkManager() != null) {
                            Hyperlane.LOGGER.info(player.connection.getNetworkManager());
                            WaterTeleporter tp = new WaterTeleporter(livingEntity.getPosition());
                            player.changeDimension(DimensionType.byName(Hyperlane.CINDERBANE_DIM_TYPE), tp);
                        }

                    }
                }
            }

        }
    }
}



