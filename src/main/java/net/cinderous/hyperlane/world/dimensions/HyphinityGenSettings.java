package net.cinderous.hyperlane.world.dimensions;

import net.cinderous.hyperlane.util.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.GenerationSettings;

public class HyphinityGenSettings extends GenerationSettings {
    private BlockPos spawnPos;

    public HyphinityGenSettings setSpawnPos(BlockPos pos) {
        this.spawnPos = pos;
        return this;
    }

    public BlockPos getSpawnPos() {
        return this.spawnPos;
    }

        @Override
    public BlockState getDefaultBlock() {
        setDefaultBlock(RegistryHandler.HYPHINITY_STONE.get().getDefaultState());
        return super.getDefaultBlock();
    }
}

