package net.cinderous.hyperlane.items;

import net.cinderous.hyperlane.Hyperlane;
import net.cinderous.hyperlane.util.RegistryHandler;
import net.cinderous.hyperlane.world.GroundFinderTeleporter;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.potion.*;
import net.minecraft.util.NonNullList;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.util.ITeleporter;

public class CinderbanePoisonPotion extends PotionItem implements ITeleporter {

    public CinderbanePoisonPotion() {
        super(new Item.Properties().group(Hyperlane.TAB));
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return super.hasEffect(stack);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        GroundFinderTeleporter tp = new GroundFinderTeleporter(entityLiving.getPosition(), RegistryHandler.CINDIRT_GRASS.get().getDefaultState().getBlock());
        if (!worldIn.isRemote) {

            if (worldIn.dimension.getType() == DimensionType.byName(Hyperlane.CINDERBANE_DIM_TYPE)) {
                entityLiving.addPotionEffect(new EffectInstance(RegistryHandler.HYPERLANE_EFFECT.get()));
                entityLiving.changeDimension(DimensionType.OVERWORLD, tp);
            } else {
                entityLiving.removePotionEffect(RegistryHandler.HYPERLANE_EFFECT.get());
                entityLiving.changeDimension(DimensionType.byName(Hyperlane.CINDERBANE_DIM_TYPE), tp);
            }

        }
//        return new ActionResult<>(ActionResultType.SUCCESS, entityLiving.getHeldItem(entityLiving.hand));
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }

//    @Override
//    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
//        CinderbaneTeleporter tp = new CinderbaneTeleporter(playerIn.getPosition());
//        if (!worldIn.isRemote) {
//
//                if (worldIn.dimension.getType() == DimensionType.byName(CrystalArchitect.CINDERBANE_DIM_TYPE)) {
//                    playerIn.changeDimension(DimensionType.OVERWORLD, tp);
//                } else {
//                    playerIn.changeDimension(DimensionType.byName(CrystalArchitect.CINDERBANE_DIM_TYPE), tp);
//                }
//
//        }
//        return new ActionResult<>(ActionResultType.SUCCESS, playerIn.getHeldItem(handIn));
//    }


    public UseAction getUseAction(ItemStack stack) {
        if (this.isInGroup(group)) {
            for (Potion potion : Registry.POTION) {
                if (potion == Potions.WATER) {
                    return UseAction.DRINK;
                }
            }
        } return null;
    }


    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
//        if (this.isInGroup(group)) {
//            for(Potion potion : Registry.POTION) {
//                if (potion != Potions.EMPTY) {
//                    items.add(PotionUtils.addPotionToItemStack(new ItemStack(this), potion));
//                }
//            }
//        }
        if (this.isInGroup(group)) {
            for(Potion potion : Registry.POTION) {
                if (potion == RegistryHandler.CINDERBANE_POTION.get() || potion == Potions.EMPTY || potion == Potions.WATER) {
                    items.add(PotionUtils.addPotionToItemStack(new ItemStack(this), potion));
                }
            }
        }

    }

}

