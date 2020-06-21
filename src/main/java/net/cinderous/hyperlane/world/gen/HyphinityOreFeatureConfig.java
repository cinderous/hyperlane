package net.cinderous.hyperlane.world.gen;

import net.cinderous.hyperlane.util.RegistryHandler;
import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HyphinityOreFeatureConfig extends OreFeatureConfig implements IFeatureConfig {
    //public static final AbstractTrafficShapingHandler HYPHINITY = ;
    public final HyphinityOreFeatureConfig.FillerBlockType target;
    public final int size;
    public final BlockState state;


    public HyphinityOreFeatureConfig(HyphinityOreFeatureConfig.FillerBlockType target, BlockState state, int size) {
        super(OreFeatureConfig.FillerBlockType.NATURAL_STONE, state, size);
        this.size = size;
        this.state = state;
        this.target = target;
    }



    public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
        return new Dynamic<>(ops, ops.createMap(ImmutableMap.of(ops.createString("size"), ops.createInt(this.size), ops.createString("target"), ops.createString(this.target.getName()), ops.createString("state"), BlockState.serialize(ops, this.state).getValue())));
    }

    public static HyphinityOreFeatureConfig deserialize(Dynamic<?> in) {
        int i = in.get("size").asInt(0);
        HyphinityOreFeatureConfig.FillerBlockType hyphinityorefeatureconfig$fillerblocktype = HyphinityOreFeatureConfig.FillerBlockType.byName(in.get("target").asString(""));
        BlockState blockstate = in.get("state").map(BlockState::deserialize).orElse(Blocks.AIR.getDefaultState());
        return new HyphinityOreFeatureConfig(hyphinityorefeatureconfig$fillerblocktype, blockstate, i);
    }

    public static enum FillerBlockType implements net.minecraftforge.common.IExtensibleEnum {
        NATURAL_STONE("natural_stone", (p_214739_0_) -> {
            if (p_214739_0_ == null) {
                return false;
            } else {
                Block block = p_214739_0_.getBlock();
                return block == Blocks.STONE || block == Blocks.GRANITE || block == Blocks.DIORITE || block == Blocks.ANDESITE;
            }
        }),
        HYPHINITY("hyphinity_gravel", new BlockMatcher(RegistryHandler.HYPERLANE_GRAVEL.get()));

        /** maps the filler block type name to the corresponding enum value. */
        private static final Map<String, HyphinityOreFeatureConfig.FillerBlockType> VALUES_MAP = Arrays.stream(values()).collect(Collectors.toMap(HyphinityOreFeatureConfig.FillerBlockType::getName, (p_214740_0_) -> {
            return p_214740_0_;
        }));
        /** the filler block type name. */
        private final String name;
        /** the predicate to match the target block to fill */
        private final Predicate<BlockState> targetBlockPredicate;

        private FillerBlockType(String nameIn, Predicate<BlockState> predicateIn) {
            this.name = nameIn;
            this.targetBlockPredicate = predicateIn;
        }

        /**
         * returns the name of the filler block type.
         */
        public String getName() {
            return this.name;
        }

        /**
         * returns the filler block type with the given name.
         *
         * @param nameIn the filler block type name
         */
        public static HyphinityOreFeatureConfig.FillerBlockType byName(String nameIn) {
            return VALUES_MAP.get(nameIn);
        }

        /**
         * returns the target block state predicate
         */
        public Predicate<BlockState> getTargetBlockPredicate() {
            return this.targetBlockPredicate;
        }

        public static HyphinityOreFeatureConfig.FillerBlockType create(String enumName, String nameIn, Predicate<BlockState> predicateIn) {
            throw new IllegalStateException("Enum not extended");
        }

        @Override
        @Deprecated
        public void init() {
            VALUES_MAP.put(getName(), this);
        }
    }
}
