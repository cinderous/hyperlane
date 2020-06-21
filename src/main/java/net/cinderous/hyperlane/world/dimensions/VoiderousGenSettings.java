package net.cinderous.hyperlane.world.dimensions;

import net.cinderous.hyperlane.util.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.GenerationSettings;

public class VoiderousGenSettings extends GenerationSettings {
    private BlockPos spawnPos;

    public VoiderousGenSettings setSpawnPos(BlockPos pos) {
        this.spawnPos = pos;
        return this;
    }

    @Override
    public BlockState getDefaultBlock() {
        return RegistryHandler.VOIDEROUS_DENSE_STONE.get().getDefaultState();
    }

    public BlockPos getSpawnPos() {
        return this.spawnPos;
    }
}