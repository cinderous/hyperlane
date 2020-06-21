package net.cinderous.hyperlane.items;

import net.cinderous.hyperlane.Hyperlane;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class RoughCobblestoneCrystal extends Item {


    public RoughCobblestoneCrystal( ) {
        super(new Item.Properties().group(Hyperlane.TAB));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }


}
