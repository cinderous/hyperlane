package net.cinderous.hyperlane.world.gen;

import net.cinderous.hyperlane.Hyperlane;
import net.cinderous.hyperlane.util.RegistryHandler;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.registries.ForgeRegistries;

public class HyperlaneOreGen {
    public static void generateOre() {
        for (Biome biome : ForgeRegistries.BIOMES) {
            for (ModDimension dimension : ForgeRegistries.MOD_DIMENSIONS)
                if (dimension == RegistryHandler.HYPERLANE_DIM.get()) {
                    if (biome == RegistryHandler.HYPERLANE_DRIFTS.get())  {
                        ConfiguredPlacement customConfig = Placement.COUNT_RANGE
                                .configure(new CountRangeConfig(3, 5, 5, 150));
                        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                                .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.HYPHINITY_ORE.get().getDefaultState(), 50))
                                .withPlacement(customConfig));
                        Hyperlane.LOGGER.info("THIS SHOULD OF REGISTERED THE ORE GENERATION!");
                    }
                } else if (dimension == DimensionType.OVERWORLD.getModType() ) {
                    if (biome == RegistryHandler.HYPERLANE_DRIFTS.get())  {

                        Hyperlane.LOGGER.info("overworld hyperlane drifts");
                    }
                }


        }
    }
}


