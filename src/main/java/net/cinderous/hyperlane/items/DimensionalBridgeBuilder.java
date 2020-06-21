package net.cinderous.hyperlane.items;

import net.cinderous.hyperlane.Hyperlane;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.*;
import net.minecraft.world.World;

public class DimensionalBridgeBuilder extends Item {

    public Block targetblock = null;
    public Vec3d rayvec = null;

    public DimensionalBridgeBuilder() {
        super(new Item.Properties().group(Hyperlane.HYPERLANE_TAB));
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return super.hasEffect(stack);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {


        Hyperlane.LOGGER.info(playerIn.getHorizontalFacing());

        BlockPos playerpos = playerIn.getPosition();
        World playerworld = playerIn.getEntityWorld();
        Direction playerdirection = playerIn.getHorizontalFacing();

        if (playerIn.isSneaking()) {

            // Vec3d oldPos = new Vec3d(player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
//            Vec3d newPos = new Vec3d(player.getPosition().getX() + player.motion.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            //RayTraceResult rayback = player.getEntityWorld().rayTraceBlocks(oldPos, oldPos, false, true, false);
            RayTraceResult rayback = rayTrace(playerIn.getEntityWorld(), playerIn, RayTraceContext.FluidMode.NONE);
            if (rayback.getHitVec() != null)
                rayvec = rayback.getHitVec();
                BlockPos rayblock = new BlockPos(rayvec);
                    if (worldIn.getBlockState(rayblock).getBlock() instanceof Block) {
                        targetblock = worldIn.getBlockState(rayblock).getBlock();
                    }

        }

        if (playerdirection == Direction.NORTH && targetblock != null && !targetblock.isAir(targetblock.getDefaultState())) {

            BlockPos belowplayerpos = playerIn.getPosition().offset(Direction.DOWN, 1);

            if (playerworld.getBlockState(belowplayerpos.north()) == Blocks.AIR.getDefaultState()) {

                int invsize = playerIn.inventory.getSizeInventory();
                for (int x = 1; invsize >= x; x++) {

                    if (playerIn.inventory.getStackInSlot(x).getItem() == targetblock.getItem(worldIn, new BlockPos(rayvec), targetblock.getDefaultState()).getItem()){
                        playerIn.inventory.getStackInSlot(x).shrink(1);
                        playerworld.setBlockState(belowplayerpos.north(), targetblock.getDefaultState());
                        x=invsize+1;
                    }
                }
//                for (int xx = 0; invsize >= xx; xx++) {
//                    if (playerIn.inventory.getStackInSlot(xx) == new ItemStack(RegistryHandler.CINDERIUM_BLOCK.get())) {
//                        playerworld.setBlockState(belowplayerpos.north(), RegistryHandler.CINDERIUM_BLOCK.get().getDefaultState());
//                        playerIn.inventory.getStackInSlot(xx).shrink(1);
//                    }
//                }
            }

        }return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}

