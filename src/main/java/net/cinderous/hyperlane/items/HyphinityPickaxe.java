package net.cinderous.hyperlane.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class HyphinityPickaxe extends PickaxeItem {
    public Hand hand = null;
    public int tick;
    public Vec3d pastmotion;
    boolean isreadytogo = false;
    public BlockPos pastPos;

    public HyphinityPickaxe(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);

    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);

        if (entityIn instanceof PlayerEntity) {
            PlayerEntity player = ((PlayerEntity)entityIn);

            ItemStack mainhanditem = player.getHeldItemMainhand();
            ItemStack offhanditem = player.getHeldItemOffhand();


            if (mainhanditem == stack) {
                hand = Hand.MAIN_HAND;
            }
            if (offhanditem == stack) {
                hand = Hand.OFF_HAND;
            }



//get current pos and compare positions
            BlockPos currentPos = player.getPosition();
            if (!currentPos.equals(this.pastPos)) {
                stack.setDamage(stack.getDamage() + -1);
            }

//make pastPos = to currentPos for the next time tick() runs
            this.pastPos = currentPos;


            //stack.damageItem(1, player, e -> e.sendBreakAnimation(hand));
//            if(!isreadytogo) pastmotion = player.getMotion();
//            isreadytogo = true;
//
//            tick++;
//
//
//            if(tick == 60) {
//                Vec3d currentmotion = player.getMotion();
//                if(pastmotion != currentmotion) {
//                    CrystalArchitect.LOGGER.info("PAST: " +pastmotion +"CURRENT:" + currentmotion);
//                    CrystalArchitect.LOGGER.info("SHOULD BE ADDING DURABILITY");
//                    stack.setDamage(stack.getDamage() + 1);
//                    tick = 0;
//                    isreadytogo = false;
//
//                }
//            }






        }






        }

    }

