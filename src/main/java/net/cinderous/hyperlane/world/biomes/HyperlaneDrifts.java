package net.cinderous.hyperlane.world.biomes;

import net.cinderous.hyperlane.util.RegistryHandler;
//.hyperlane.world.feature.*;
import net.cinderous.hyperlane.world.feature.*;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.*;

public class HyperlaneDrifts  extends Biome {

//    public static final BlockClusterFeatureConfig CINDERITE_ROCK_CONFIG = (new BlockClusterFeatureConfig.Builder(
//            new SimpleBlockStateProvider(RegistryHandler.CINDERITE_ROCK.get().getDefaultState()), new SimpleBlockPlacer())).tries(5).build();
    //  public static final BlockClusterFeatureConfig SNOWDONIA_FLOWER_CONFIG = (new BlockClusterFeatureConfig.Builder(new SnowdoniaFlowerBlockStateProvider(), new SimpleBlockPlacer())).tries(64).build();

    public static final BlockClusterFeatureConfig TALL_GRASS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RegistryHandler.HYPHINITY_TALL_GRASS.get().getDefaultState()), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();
    public static final BlockClusterFeatureConfig LARGE_FERN_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RegistryHandler.HYPHINITY_FERN.get().getDefaultState()), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();
    public static final BlockClusterFeatureConfig GRASS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RegistryHandler.HYPHINITY_GRASS.get().getDefaultState()), new SimpleBlockPlacer())).tries(32).build();
    public static final BlockClusterFeatureConfig DEFAULT_FLOWER_CONFIG = (new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider()).addWeightedBlockstate(RegistryHandler.HYPHINITY_FLOWER.get().getDefaultState(), 2).addWeightedBlockstate(RegistryHandler.HYPHINITY_FLOWER.get().getDefaultState(), 1), new SimpleBlockPlacer())).tries(64).build();
    //public static final Feature<SeaGrassConfig> SEAGRASS = register("seagrass", new SeaGrassFeature(SeaGrassConfig::deserialize));

    public HyperlaneDrifts(Biome.Builder biomeBuilder) {
        super(biomeBuilder);


        //broke
        //addSpawn(EntityClassification.CREATURE, new SpawnListEntry(RegistryHandler.CINDERLING.get(), 10,5,10));
        //addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.HELL_CAVE, new ProbabilityConfig(0.01f)));
        //addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.FOSSIL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(128))));

        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.NORMAL_TREE.withConfiguration(HyphinityTree.HYPHINITY_TREE_CONFIG).withPlacement(
                        Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(7, 0.1f, 1))));

//        DefaultBiomeFeatures.addOres(this);
    //DefaultBiomeFeatures.addSparseGrass(this);
    this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(TALL_GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(7))));

    this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(LARGE_FERN_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(11))));

    this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(20))));

    this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SIMPLE_BLOCK.withConfiguration(new BlockWithContextConfig(RegistryHandler.HYPHINITY_SEAGRASS.get().getDefaultState(), new BlockState[]{RegistryHandler.HYPERLANE_GEL_BLOCK.get().getDefaultState()}, new BlockState[]{Blocks.WATER.getDefaultState()}, new BlockState[]{Blocks.WATER.getDefaultState()})).withPlacement(Placement.CARVING_MASK.configure(new CaveEdgeConfig(GenerationStage.Carving.LIQUID, 0.1F))));
    this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SIMPLE_BLOCK.withConfiguration(new BlockWithContextConfig(RegistryHandler.HYPHINITY_SEAGRASS.get().getDefaultState(), new BlockState[]{RegistryHandler.HYPERLANE_GRAVEL.get().getDefaultState()}, new BlockState[]{Blocks.WATER.getDefaultState()}, new BlockState[]{Blocks.WATER.getDefaultState()})).withPlacement(Placement.CARVING_MASK.configure(new CaveEdgeConfig(GenerationStage.Carving.LIQUID, 0.1F))));
//    this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, RegistryHandler.HYPHINITY_SEAGRASS_FEATURE.get().withConfiguration(new HyphinitySeaGrassFeatureConfig(80, 0.8D)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));

    //this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, RegistryHandler.TEST_FEATURE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(7, 0, 0, 200))));

//        this.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES,
//                new ExampleFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
//                        .withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(50))));

//        this.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES,
//                new ExampleFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
//                        .withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(50))));

        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                new HyphinitySeaGrassFeature(HyphinitySeaGrassFeatureConfig::deserialize).withConfiguration(new HyphinitySeaGrassFeatureConfig(80, 0.8D))
                        .withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));


        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                new HyphinityKelpFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
                        .withPlacement(Placement.TOP_SOLID_HEIGHTMAP_NOISE_BIASED.configure(new TopSolidWithNoiseConfig(80, 80.0D, 0.0D, Heightmap.Type.OCEAN_FLOOR_WG))));


        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                new HyphinityFlowerFeature(BlockClusterFeatureConfig::deserialize).withConfiguration(DEFAULT_FLOWER_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(4))));



        //DefaultBiomeFeatures.addStructures();

        //HyphinityWisp hyphinitywisp = RegistryHandler.HYPHINITY_WISP.get().create();
        //this.addSpawn();
        //CrystalArchitect.LOGGER.info("IS MY ENTITY REGISTERED????" + RegistryHandler.HYPHINITY_WISP.get() );
        //this.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(RegistryHandler.HYPHINITY_WISP.get(), 100, 5, 5, RegistryHandler.HYPERLANE_DRIFTS.get()));


        //public static final BlockClusterFeatureConfig CINDERITE_ROCK_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RegistryHandler.CINDERITE_ROCK), new SimpleBlockPlacer())).tries(32).build();

        //this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(CINDERITE_ROCK_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(7, 0.1f, 1))));
        //this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DEAD_BUSH_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(20))));

    }
}