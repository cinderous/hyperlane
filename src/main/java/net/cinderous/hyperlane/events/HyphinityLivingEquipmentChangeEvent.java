package net.cinderous.hyperlane.events;

import net.cinderous.hyperlane.Hyperlane;
import net.cinderous.hyperlane.util.RegistryHandler;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Mod.EventBusSubscriber(modid = Hyperlane.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class HyphinityLivingEquipmentChangeEvent {

    @SubscribeEvent
    public static void HyphinityLivingEquipmentChangeEvent(LivingEvent event) {
        if (event.getEntityLiving() != null) {
            LivingEntity livingEntity = event.getEntityLiving();
            World world = livingEntity.getEntityWorld();

            //Iterable<ItemStack> stacks =

            for (ItemStack armor : livingEntity.getArmorInventoryList()) {
                //Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(armor);
                if (armor.getItem() == RegistryHandler.HYPHINITY_BOOTS.get()) {
                    livingEntity.removeActivePotionEffect(RegistryHandler.HYPHINITY_SICKNESS_GRAVITY.get());
                }



            }
        }
    }
}

