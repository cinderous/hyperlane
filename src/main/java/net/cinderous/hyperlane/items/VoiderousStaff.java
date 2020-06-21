package net.cinderous.hyperlane.items;

import net.cinderous.hyperlane.Hyperlane;
import net.cinderous.hyperlane.util.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class VoiderousStaff   extends Item {
    public VoiderousStaff() {
        super(new Item.Properties().group(Hyperlane.HYPERLANE_TAB));
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return super.hasEffect(stack);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        BlockPos pos = playerIn.getPosition();
        groundFinder(worldIn, pos, playerIn, RegistryHandler.VOIDEROUS_GRAVEL.get());

        return super.onItemRightClick(worldIn, playerIn, handIn);

    }


    public static boolean groundFinder(World world, BlockPos pos, Entity entity, Block safeblock) {
        BlockPos startpos = new BlockPos(pos.getX(), world.getHeight(), pos.getZ());
        int yOffset;
        int air = 0;
        boolean isGround = false;
        for (yOffset = 0; !isGround; ++yOffset) {
            Hyperlane.LOGGER.info("THIS IS THE START OF GROUNDFINDER STARTING FOR yoffset " + yOffset + "isGround " + isGround);
            if (world.getBlockState(startpos.down(yOffset)).getBlock() == Blocks.AIR.getDefaultState().getBlock()) {
                Hyperlane.LOGGER.info("Current Air Found" + air);
                ++air;
                Hyperlane.LOGGER.info(world.getBlockState(startpos.down(yOffset)).getBlock());
            } else if (world.getBlockState(startpos.down(yOffset)).getBlock() == safeblock) {
                isGround = true;
            } else if (world.getBlockState(startpos.down(yOffset)).getBlock() == Blocks.VOID_AIR.getDefaultState().getBlock()) {
                ++air;

            } else if (world.getBlockState(startpos.down(yOffset)).getBlock() != safeblock) {
                Hyperlane.LOGGER.info("DIDNT FIND THE SAFE BLOCK BUT FOUND SOMETHING BESIDES AIR AND VOID");
                isGround = true;
                Hyperlane.LOGGER.info(world.getBlockState(startpos.down(yOffset)).getBlock());
            }
//            } else if (world.getBlockState(startpos.down(yOffset)).getBlock() == safeblock) {
//                isGround = true;
//                CrystalArchitect.LOGGER.info(isGround);
//
//            } else if (world.getBlockState(startpos.down(yOffset)).getBlock() != safeblock && (world.getBlockState(startpos.down(yOffset)).getBlock() != Blocks.AIR.getDefaultState().getBlock())) {
//                //can either pretend block is air with ++air or consider this valid ground
//                //pretending to be air will get you stuck in trees and any other block that isnt the safe block..
//                isGround = true;
//                CrystalArchitect.LOGGER.info(isGround);
//            } else if (world.getBlockState(startpos.down(yOffset)).getBlock() != Blocks.AIR.getDefaultState().getBlock()) {
//                isGround = true;
//                CrystalArchitect.LOGGER.info(isGround);
//            }

            if (isGround) {
                Hyperlane.LOGGER.info("Ground Found yOffset is" + yOffset);
                Hyperlane.LOGGER.info("PRE POSITIONING X =" + pos.getX());
                Hyperlane.LOGGER.info("PRE POSITIONING z =" + pos.getZ());
                entity.setPosition(pos.getX(), startpos.down(yOffset).getY() +2, pos.getZ());
            }



        }return false;
    }
}
