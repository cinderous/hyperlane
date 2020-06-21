package net.cinderous.hyperlane.world.feature;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class HyphinitySeaGrassFeatureConfig implements IFeatureConfig {
    public final int count;
    public final double tallProbability;

    public HyphinitySeaGrassFeatureConfig(int count, double tallProbability) {
        this.count = count;
        this.tallProbability = tallProbability;
    }

    public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
        return new Dynamic<>(ops, ops.createMap(ImmutableMap.of(ops.createString("count"), ops.createInt(this.count), ops.createString("tall_seagrass_probability"), ops.createDouble(this.tallProbability))));
    }


    public static <T> HyphinitySeaGrassFeatureConfig deserialize(Dynamic<T> p_214659_0_) {
        int i = p_214659_0_.get("count").asInt(0);
        double d0 = p_214659_0_.get("tall_seagrass_probability").asDouble(0.0D);
        return new HyphinitySeaGrassFeatureConfig(i, d0);
    }
}