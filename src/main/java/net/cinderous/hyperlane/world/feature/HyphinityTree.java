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

public class HyphinityTree  extends Tree {

    public static final TreeFeatureConfig HYPHINITY_TREE_CONFIG = (new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegistryHandler.HYPHINITY_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(RegistryHandler.HYPHINITY_LEAVES.get().getDefaultState()),
            new BlobFoliagePlacer(2, 0))).baseHeight(5).heightRandA(8).foliageHeight(3).ignoreVines()
//new BlobFoliagePlacer(2, 0))).baseHeight(20).heightRandA(45).foliageHeight(15).ignoreVines()

            .setSapling((IPlantable) RegistryHandler.HYPHINITY_SAPLING.get()).build();

    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
        return Feature.NORMAL_TREE.withConfiguration(HYPHINITY_TREE_CONFIG);
    }
}