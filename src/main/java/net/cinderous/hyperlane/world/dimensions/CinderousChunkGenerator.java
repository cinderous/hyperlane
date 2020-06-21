package net.cinderous.hyperlane.world.dimensions;

import net.minecraft.world.IWorld;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.NoiseChunkGenerator;

public class CinderousChunkGenerator extends NoiseChunkGenerator<CinderousGenSettings> {


    public CinderousChunkGenerator(IWorld worldIn, BiomeProvider biomeProviderIn, int horizontalNoiseGranularityIn, int verticalNoiseGranularityIn, int p_i49931_5_, CinderousGenSettings settingsIn, boolean usePerlin) {
        super(worldIn, biomeProviderIn, horizontalNoiseGranularityIn, verticalNoiseGranularityIn, p_i49931_5_, settingsIn, usePerlin);
    }

    @Override
    protected double[] getBiomeNoiseColumn(int noiseX, int noiseZ) {
        return new double[0];
    }

    @Override
    protected double func_222545_a(double p_222545_1_, double p_222545_3_, int p_222545_5_) {
        return 0;
    }

    @Override
    protected void fillNoiseColumn(double[] noiseColumn, int noiseX, int noiseZ) {

    }

    @Override
    public int getGroundHeight() {
        return 0;
    }
}
