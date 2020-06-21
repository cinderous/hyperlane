package net.cinderous.hyperlane.world.biomes;

import net.cinderous.hyperlane.util.RegistryHandler;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.*;

public class VoiderousNightmare  extends Biome {

    public static final BlockClusterFeatureConfig GRASS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RegistryHandler.VOIDEROUS_TREE_BUILDER_BLOCK.get().getDefaultState()), new SimpleBlockPlacer())).tries(5).build();

    public VoiderousNightmare(Biome.Builder biomeBuilder) {
        super(biomeBuilder);

        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(5))));

    }
}