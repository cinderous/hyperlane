package net.cinderous.hyperlane.world.dimensions;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.GenerationSettings;

public class CinderousGenSettings  extends GenerationSettings {
    private BlockPos spawnPos;

    public CinderousGenSettings setSpawnPos(BlockPos pos) {
        this.spawnPos = pos;
        return this;
    }

    public BlockPos getSpawnPos() {
        return this.spawnPos;
    }
}
