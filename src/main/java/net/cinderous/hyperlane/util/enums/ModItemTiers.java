package net.cinderous.hyperlane.util.enums;

import net.cinderous.hyperlane.util.RegistryHandler;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import java.util.function.Supplier;

public enum ModItemTiers implements IItemTier {

    // int harvestLevel, int maxUses, float efficiency, float attackDamage, int
    // enchantability, Supplier<Ingredient> repairMaterial
    //same harvest tier as wood

    HYPHINITY_PICKAXE_CONFIG(3, 200, 100.0F, 0.0F, 15, () -> {
        return Ingredient.fromItems(RegistryHandler.HYPHINITY_PICKAXE.get());
    }),
    HYPHINITY_AXE_CONFIG(3, 750, 2.0F, 0.0F, 15, () -> {
        return Ingredient.fromItems(RegistryHandler.HYPHINITY_AXE.get());
    }),
    HYPHINITY_SHOVEL_CONFIG(3, 750, 2.0F, 0.0F, 15, () -> {
        return Ingredient.fromItems(RegistryHandler.HYPHINITY_SHOVEL.get());
    });
//    HYPHINITY_HOE_CONFIG(3, 750, 2.0F, 0.0F, 15, () -> {
//        return Ingredient.fromItems(RegistryHandler.HYPHINITY_HOE.get());
//    });




    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;

    private ModItemTiers(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability,
                         Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyValue<>(repairMaterial);
    }

    @Override
    public int getMaxUses() {
        return this.maxUses;
    }

    @Override
    public float getEfficiency() {
        return this.efficiency;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }
}