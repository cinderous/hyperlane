package net.cinderous.hyperlane.world;

import net.cinderous.hyperlane.Hyperlane;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;

import java.util.function.Function;

public class GroundFinderTeleporter implements ITeleporter {


    Block safeblock;
    BlockPos pos;

    public GroundFinderTeleporter(BlockPos pos, Block safeblock) {

        this.pos = pos;
        this.safeblock = safeblock;


    }
    @Override
    public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
        Hyperlane.LOGGER.info("ATTEMPTING TO FIND GROUND");
        groundFinder(destWorld, pos, entity, safeblock);
        return repositionEntity.apply(false);
    }

    public static BlockPos groundFinder(World world, BlockPos pos, Entity entity, Block safeblock) {
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
                entity.setPosition(startpos.getX(), startpos.down(yOffset).getY() +2, startpos.getZ());
            }



        }return pos.up(yOffset);
    }

}
