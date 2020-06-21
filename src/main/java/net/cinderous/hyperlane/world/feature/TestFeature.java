package net.cinderous.hyperlane.world.feature;

import net.cinderous.hyperlane.util.RegistryHandler;
import com.mojang.datafixers.Dynamic;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class TestFeature<T extends NoFeatureConfig> extends Feature<T> {

    public TestFeature(Function<Dynamic<?>, T> config) {
        super(config);
    }

    @Override
    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, T config) {
        if (!worldIn.isAirBlock(pos)) {
            return false;
        } else if (worldIn.getBlockState(pos.up()).getBlock() != RegistryHandler.CINDERIUM_BLOCK.get() && worldIn.getBlockState(pos.down()).getBlock() != RegistryHandler.CINDERIUM_BLOCK.get()) {
            return false;
        } else {
            if (pos.getY() > worldIn.getSeaLevel() || pos.getY() < 15)
                return false;

            worldIn.setBlockState(pos, RegistryHandler.CINDERIUM_BLOCK.get().getDefaultState(), 2);

            for(int i = 0; i < 1500; ++i) {
                BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), -rand.nextInt(12), rand.nextInt(8) - rand.nextInt(8));
                if (worldIn.getBlockState(blockpos).isAir(worldIn, blockpos)) {
                    int j = 0;

                    for(Direction direction : Direction.values()) {
                        if (worldIn.getBlockState(blockpos.offset(direction)).getBlock() == RegistryHandler.CINDERIUM_BLOCK.get()) {
                            ++j;
                        }

                        if (j > 1) {
                            break;
                        }
                    }

                    if (j == 1) {
                        worldIn.setBlockState(blockpos, RegistryHandler.CINDERIUM_BLOCK.get().getDefaultState(), 2);
                    }
                }
            }

            return true;
        }
    }
}
