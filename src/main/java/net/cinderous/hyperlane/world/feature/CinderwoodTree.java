package net.cinderous.hyperlane.world.feature;

import net.cinderous.hyperlane.util.RegistryHandler;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

public class CinderwoodTree extends Tree {

    public static final TreeFeatureConfig CINDERWOOD_TREE_CONFIG = (new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegistryHandler.CINDERWOOD_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(RegistryHandler.CINDERWOOD_LEAVES.get().getDefaultState()),
            new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(8).foliageHeight(3).ignoreVines()
            .setSapling((IPlantable) RegistryHandler.CINDERWOOD_SAPLING.get()).build();

    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
        return Feature.NORMAL_TREE.withConfiguration(CINDERWOOD_TREE_CONFIG);
    }
}
