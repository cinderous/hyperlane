//package com.cinderous.hyperl.events;
//
////.hyperl.CrystalArchitect;
////.hyperl.world.WaterTeleporter;
//import net.minecraft.advancements.Advancement;
//import net.minecraft.advancements.CriteriaTriggers;
//import net.minecraft.block.Blocks;
//import net.minecraft.entity.LivingEntity;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.entity.player.ServerPlayerEntity;
//import net.minecraft.item.crafting.RecipeBook;
//import net.minecraft.server.MinecraftServer;
//import net.minecraft.util.ResourceLocation;
//import net.minecraft.world.World;
//import net.minecraft.world.dimension.DimensionType;
//import net.minecraftforge.event.entity.living.LivingEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//import org.apache.logging.log4j.core.jmx.Server;
//
//@Mod.EventBusSubscriber(modid = CrystalArchitect.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
//public class FirstSpawnEvent {
//
//    @SubscribeEvent
//    public static void FirstSpawnEvent(LivingEvent event) {
//        if (event.getEntityLiving() != null && event != null) {
//
//
//
//            LivingEntity livingEntity = event.getEntityLiving();
//            World world = livingEntity.getEntityWorld();
//
//
//
//            if (!world.isRemote && livingEntity instanceof ServerPlayerEntity && world.getDimension().getType() == DimensionType.OVERWORLD) {
//                Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) livingEntity).server).getAdvancementManager()
//                        .getAdvancement(new ResourceLocation("hyperl:root"));
//                ServerPlayerEntity player = (ServerPlayerEntity) livingEntity;
//                if (!((ServerPlayerEntity) livingEntity).getAdvancements().getProgress(_adv).isDone()) {
//                    CrystalArchitect.LOGGER.info(_adv);
//                    CrystalArchitect.LOGGER.info("ADVANCEMENT NOT COMPLETE, TELEPORTING TO CINDERBANE");
//                    //WaterTeleporter tp = new WaterTeleporter(livingEntity.getPosition());
//                    if(livingEntity instanceof PlayerEntity && livingEntity.getPosition().getY() >= 0) {
//
//                        ((ServerPlayerEntity) livingEntity).changeDimension(DimensionType.THE_END);
//                            //WaterTeleporter tp = new WaterTeleporter(livingEntity.getPosition());
//                            //livingEntity.changeDimension(DimensionType.byName(CrystalArchitect.CINDERBANE_DIM_TYPE), tp);
//
//                        }
//                    }
//                }
//
//            }
//        }
//    }
//
//
//
