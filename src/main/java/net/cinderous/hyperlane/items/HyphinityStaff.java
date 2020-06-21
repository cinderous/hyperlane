package net.cinderous.hyperlane.items;

import net.cinderous.hyperlane.Hyperlane;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HyphinityStaff   extends Item {

    public BlockPos pastPos;
    public Hand hand = null;

    public HyphinityStaff() {
        super(new Item.Properties().group(Hyperlane.HYPERLANE_TAB).maxDamage(1000));

    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return super.hasEffect(stack);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);

        if (entityIn instanceof PlayerEntity) {
            PlayerEntity player = ((PlayerEntity) entityIn);




//get current pos and compare positions
            BlockPos currentPos = player.getPosition();
            if (!currentPos.equals(this.pastPos)) {
                stack.setDamage(stack.getDamage() + -1);
            }

//make pastPos = to currentPos for the next time tick() runs
            this.pastPos = currentPos;
        }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

                    ItemStack mainhanditem = playerIn.getHeldItemMainhand();
            ItemStack offhanditem = playerIn.getHeldItemOffhand();




            ItemStack itemstack = new ItemStack(this);
            if (mainhanditem == itemstack ) {
                hand = Hand.MAIN_HAND;
            }
            if (offhanditem == itemstack) {
                hand = Hand.OFF_HAND;
            }


        damageItem(mainhanditem, 100, playerIn, e -> e.sendBreakAnimation(hand));
        playerIn.addVelocity(0,1,0);

          return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}