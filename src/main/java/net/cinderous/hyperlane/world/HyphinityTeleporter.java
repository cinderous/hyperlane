package net.cinderous.hyperlane.world;

import net.cinderous.hyperlane.Hyperlane;
import net.cinderous.hyperlane.util.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;

import java.util.function.Function;

public class HyphinityTeleporter   implements ITeleporter {

//this teleporter handlers a teleport back into the Overworld at 100 times the distance traveled, allowing for quick setups for interdimensional travel between two points.


    Block safeblock;
    BlockPos pos;

    public HyphinityTeleporter(BlockPos pos, Block safeblock) {

        this.pos = pos;
        this.safeblock = safeblock;


    }

    @Override
    public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
        groundFinder(destWorld, pos, entity, safeblock);
        return repositionEntity.apply(false);
    }

    public static boolean groundFinder(World world, BlockPos pos, Entity entity, Block safeblock) {
        BlockPos startpos = new BlockPos(pos.getX(), world.getHeight(), pos.getZ());
        int yOffset;
        int air = 0;
        boolean isGround = false;


        int x;
        int startx = pos.getX();
        int sizex = 1000;
        for (x = startx; x < sizex; x++) {
            Hyperlane.LOGGER.info("STARTING X " + x);

            int z;
            int startz = pos.getZ();
            int sizez = 1000;
            for (z = startz; z < sizez; z++) {
                Hyperlane.LOGGER.info("STARTING Z " + z);
                int y;
                int starty = 256;
                int sizey = 0;
                for (y = starty; y > sizey; y--) {
                    Hyperlane.LOGGER.info("STARTING Y " + y);
                    BlockPos checkPos = new BlockPos(x, y, z);
                    if (world.getBlockState(checkPos) != Blocks.AIR.getDefaultState() && world.getBlockState(checkPos) != Blocks.VOID_AIR.getDefaultState() && world.getBlockState(checkPos) != Blocks.WATER.getDefaultState()) {
                        isGround = true;
                    }

                    if (isGround) {
                        entity.setPosition(checkPos.getX(), checkPos.getY() + 2, checkPos.getZ());
                        return true;
                    }


                }
            }
        }
        return false;
    }
}



