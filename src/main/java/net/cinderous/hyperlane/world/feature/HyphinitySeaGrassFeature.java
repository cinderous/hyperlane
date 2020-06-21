package net.cinderous.hyperlane.world.feature;

import net.cinderous.hyperlane.blocks.HyphinityTallSeaGrass;
import net.cinderous.hyperlane.util.RegistryHandler;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.*;

import java.util.Random;
import java.util.function.Function;

public class HyphinitySeaGrassFeature  extends Feature<HyphinitySeaGrassFeatureConfig>
{
    public HyphinitySeaGrassFeature(Function<Dynamic<?>, ? extends HyphinitySeaGrassFeatureConfig> configFactoryIn)
    {
        super(configFactoryIn);
    }
    // ArrayList<BlockState> blocks = new ArrayList<BlockState>();

    @Override
    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos position, HyphinitySeaGrassFeatureConfig config) {
        int i = 0;

        for(int j = 0; j < config.count; ++j) {
            int k = rand.nextInt(8) - rand.nextInt(8);
            int l = rand.nextInt(8) - rand.nextInt(8);
            int i1 = worldIn.getHeight(Heightmap.Type.OCEAN_FLOOR, position.getX() + k, position.getZ() + l);
            BlockPos blockpos = new BlockPos(position.getX() + k, i1, position.getZ() + l);
            if (worldIn.getBlockState(blockpos).getBlock() == Blocks.WATER) {
                boolean flag = rand.nextDouble() < config.tallProbability;
                BlockState blockstate = flag ? RegistryHandler.HYPHINITY_TALL_SEAGRASS.get().getDefaultState() : RegistryHandler.HYPHINITY_SEAGRASS.get().getDefaultState();
                if (blockstate.isValidPosition(worldIn, blockpos)) {
                    if (flag) {
                        BlockState blockstate1 = blockstate.with(HyphinityTallSeaGrass.field_208065_c, DoubleBlockHalf.UPPER);
                        BlockPos blockpos1 = blockpos.up();
                        if (worldIn.getBlockState(blockpos1).getBlock() == Blocks.WATER) {
                            worldIn.setBlockState(blockpos, blockstate, 2);
                            worldIn.setBlockState(blockpos1, blockstate1, 2);
                        }
                    } else {
                        worldIn.setBlockState(blockpos, blockstate, 2);
                    }

                    ++i;
                }
            }
        }

        return i > 0;
    }
}

