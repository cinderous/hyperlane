package net.cinderous.hyperlane.world;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;

import java.util.function.Function;

public class WaterTeleporter  implements ITeleporter {

//this teleporter handlers a teleport back into the Overworld at 100 times the distance traveled, allowing for quick setups for interdimensional travel between two points.


    Block safeblock;
    BlockPos pos;

    public WaterTeleporter(BlockPos pos) {

        this.pos = pos;



    }
    @Override
    public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
        entity.setPosition(pos.getX(), 10, pos.getZ());
        return repositionEntity.apply(false);
    }

}
