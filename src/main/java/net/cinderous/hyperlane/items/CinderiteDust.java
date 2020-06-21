package net.cinderous.hyperlane.items;

import net.cinderous.hyperlane.Hyperlane;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class CinderiteDust extends Item {

    public CinderiteDust() {
        super(new Item.Properties().group(Hyperlane.TAB));
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return super.hasEffect(stack);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        playerIn.addPotionEffect(new EffectInstance(Effects.ABSORPTION,500,255));
        worldIn.setRainStrength(1.0f);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
