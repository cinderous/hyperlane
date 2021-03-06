package net.cinderous.hyperlane.world.dimensions;

import net.cinderous.hyperlane.util.RegistryHandler;
import com.google.common.collect.ImmutableSet;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

import java.util.Random;
import java.util.Set;

public class VoiderousDimensionBiomeProvider  extends BiomeProvider {

    private Random rand;

    public VoiderousDimensionBiomeProvider() {
        super(biomeList);
        rand = new Random();
    }

    private static final Set<Biome> biomeList = ImmutableSet.of(RegistryHandler.VOIDEROUS_NIGHTMARE.get(),
            RegistryHandler.VOIDEROUS_HELL.get());

    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return RegistryHandler.VOIDEROUS_NIGHTMARE.get();
    }

}