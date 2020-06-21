package net.cinderous.hyperlane.world.biomes;

import net.cinderous.hyperlane.util.RegistryHandler;
import net.cinderous.hyperlane.world.feature.CinderwoodTree;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.*;

public class CinderbaneBiome extends Biome {


    private static final BlockState WATER = Blocks.WATER.getDefaultState();
    public static final BlockClusterFeatureConfig TALL_GRASS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RegistryHandler.CINDERBANE_TALL_GRASS.get().getDefaultState()), new DoublePlantBlockPlacer())).tries(32).func_227317_b_().build();
    public static final BlockClusterFeatureConfig LARGE_FERN_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RegistryHandler.CINDERFERN.get().getDefaultState()), new DoublePlantBlockPlacer())).tries(32).func_227317_b_().build();
    public static final BlockClusterFeatureConfig GRASS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RegistryHandler.CINDERBANE_GRASS.get().getDefaultState()), new SimpleBlockPlacer())).tries(32).build();
    public static final BlockClusterFeatureConfig CINDERITE_ROCK_CONFIG = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegistryHandler.CINDERITE_ROCK.get().getDefaultState()), new SimpleBlockPlacer())).tries(32).build();
  //  public static final BlockClusterFeatureConfig SNOWDONIA_FLOWER_CONFIG = (new BlockClusterFeatureConfig.Builder(new SnowdoniaFlowerBlockStateProvider(), new SimpleBlockPlacer())).tries(64).build();

    public CinderbaneBiome(Builder biomeBuilder) {
        super(biomeBuilder);






        //broke
        //addSpawn(EntityClassification.CREATURE, new SpawnListEntry(RegistryHandler.CINDERLING.get(), 10,5,10));
        addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.HELL_CAVE, new ProbabilityConfig(0.07f)));
        //addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.FOSSIL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(128))));

        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.NORMAL_TREE.withConfiguration(CinderwoodTree.CINDERWOOD_TREE_CONFIG).withPlacement(
                        Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.1f, 1))));

        DefaultBiomeFeatures.addOres(this);
        //DefaultBiomeFeatures.addSparseGrass(this);
        //DefaultBiomeFeatures.addStructures();
        this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(WATER)).withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(2))));

        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(TALL_GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(4))));

        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(LARGE_FERN_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(5))));

        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(8))));

        //public static final BlockClusterFeatureConfig CINDERITE_ROCK_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RegistryHandler.CINDERITE_ROCK), new SimpleBlockPlacer())).tries(32).build();

        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(CINDERITE_ROCK_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.1f, 1))));
        //this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DEAD_BUSH_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(20))));



    }
}
