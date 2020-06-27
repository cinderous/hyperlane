package net.cinderous.hyperlane.items;

import net.cinderous.hyperlane.Hyperlane;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
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

    public BlockPos targetblockPos = null;
    public BlockState targetblock = null;
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

//            BlockRayTraceResult rayblockback = worldIn.rayTraceBlocks();
//            RayTraceResult rayback = rayTrace(playerIn.getEntityWorld(), playerIn, RayTraceContext.FluidMode.NONE);
//
//
//            if (rayback.getHitVec() != null) {
//                rayvec = rayback.getHitVec();
//
//
//
//                BlockPos rayblock = new BlockPos(rayvec);
//                if (rayback.getType() == RayTraceResult.Type.BLOCK) {
//                    targetblock = worldIn.getBlockState(rayblock).getBlock();
//                    Hyperlane.LOGGER.info(targetblock);
//                }
//            }


            final RayTraceResult hit = rayTrace(playerIn.getEntityWorld(), playerIn, RayTraceContext.FluidMode.NONE);

            if (hit instanceof BlockRayTraceResult) {

                targetblockPos = ((BlockRayTraceResult) hit).getPos();
                targetblock = worldIn.getBlockState(targetblockPos);



                Hyperlane.LOGGER.info(worldIn.getBlockState(targetblockPos));

            }


        }

        if (playerdirection == Direction.NORTH && targetblock != null && !playerIn.isSneaking()) {

            BlockPos belowplayerpos = playerIn.getPosition().offset(Direction.DOWN, 1);

            if (playerworld.getBlockState(belowplayerpos.north()) == Blocks.AIR.getDefaultState()) {

                int invsize = playerIn.inventory.getSizeInventory();
                for (int x = 1; invsize >= x; x++) {

                    if (playerIn.inventory.getStackInSlot(x).getItem() == targetblock.getBlock().getItem(worldIn, targetblockPos , targetblock.getBlock().getDefaultState()).getItem()){
                        playerIn.inventory.getStackInSlot(x).shrink(1);
                        playerworld.setBlockState(belowplayerpos.north(), targetblock.getBlock().getDefaultState());
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

        }

        if (playerdirection == Direction.SOUTH && targetblock != null && !playerIn.isSneaking()) {

            BlockPos belowplayerpos = playerIn.getPosition().offset(Direction.DOWN, 1);

            if (playerworld.getBlockState(belowplayerpos.south()) == Blocks.AIR.getDefaultState()) {

                int invsize = playerIn.inventory.getSizeInventory();
                for (int x = 1; invsize >= x; x++) {

                    if (playerIn.inventory.getStackInSlot(x).getItem() == targetblock.getBlock().getItem(worldIn, targetblockPos , targetblock.getBlock().getDefaultState()).getItem()){
                        playerIn.inventory.getStackInSlot(x).shrink(1);
                        playerworld.setBlockState(belowplayerpos.south(), targetblock.getBlock().getDefaultState());
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

        }

        if (playerdirection == Direction.WEST && targetblock != null && !playerIn.isSneaking()) {

            BlockPos belowplayerpos = playerIn.getPosition().offset(Direction.DOWN, 1);

            if (playerworld.getBlockState(belowplayerpos.west()) == Blocks.AIR.getDefaultState()) {

                int invsize = playerIn.inventory.getSizeInventory();
                for (int x = 1; invsize >= x; x++) {

                    if (playerIn.inventory.getStackInSlot(x).getItem() == targetblock.getBlock().getItem(worldIn, targetblockPos , targetblock.getBlock().getDefaultState()).getItem()){
                        playerIn.inventory.getStackInSlot(x).shrink(1);
                        playerworld.setBlockState(belowplayerpos.west(), targetblock.getBlock().getDefaultState());
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

        }

        if (playerdirection == Direction.EAST && targetblock != null && !playerIn.isSneaking()) {

            BlockPos belowplayerpos = playerIn.getPosition().offset(Direction.DOWN, 1);

            if (playerworld.getBlockState(belowplayerpos.east()) == Blocks.AIR.getDefaultState()) {

                int invsize = playerIn.inventory.getSizeInventory();
                for (int x = 1; invsize >= x; x++) {

                    if (playerIn.inventory.getStackInSlot(x).getItem() == targetblock.getBlock().getItem(worldIn, targetblockPos , targetblock.getBlock().getDefaultState()).getItem()){
                        playerIn.inventory.getStackInSlot(x).shrink(1);
                        playerworld.setBlockState(belowplayerpos.east(), targetblock.getBlock().getDefaultState());
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

        }

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    protected static RayTraceResult rayTrace(World worldIn, PlayerEntity player, RayTraceContext.FluidMode fluidMode) {
        float f = player.rotationPitch;
        float f1 = player.rotationYaw;
        Vec3d vec3d = player.getEyePosition(1.0F);
        float f2 = MathHelper.cos(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f3 = MathHelper.sin(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f4 = -MathHelper.cos(-f * ((float)Math.PI / 180F));
        float f5 = MathHelper.sin(-f * ((float)Math.PI / 180F));
        float f6 = f3 * f4;
        float f7 = f2 * f4;
        double d0 = player.getAttribute(PlayerEntity.REACH_DISTANCE).getValue();;
        Vec3d vec3d1 = vec3d.add((double)f6 * d0, (double)f5 * d0, (double)f7 * d0);
        return worldIn.rayTraceBlocks(new RayTraceContext(vec3d, vec3d1, RayTraceContext.BlockMode.OUTLINE, fluidMode, player));
    }



}

