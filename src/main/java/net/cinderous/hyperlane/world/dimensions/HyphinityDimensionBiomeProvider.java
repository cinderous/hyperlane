package net.cinderous.hyperlane.world.dimensions;

import net.cinderous.hyperlane.util.RegistryHandler;
import com.google.common.collect.ImmutableSet;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

import java.util.Random;
import java.util.Set;

public class HyphinityDimensionBiomeProvider extends BiomeProvider {

    private Random rand;

    public HyphinityDimensionBiomeProvider() {
        super(biomeList);
        rand = new Random();
    }

    private static final Set<Biome> biomeList = ImmutableSet.of(RegistryHandler.HYPHINITY_LIMBO.get());

    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return RegistryHandler.HYPHINITY_LIMBO.get();
    }

}