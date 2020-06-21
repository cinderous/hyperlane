package net.cinderous.hyperlane.blocks;

import net.cinderous.hyperlane.util.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.potion.Effect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;

public class HyphinityFlower extends BushBlock {
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);
    private final Effect stewEffect;
    private final int stewEffectDuration;

    public HyphinityFlower(Effect p_i49984_1_, int effectDuration, Block.Properties properties) {
        super(properties);
        this.stewEffect = p_i49984_1_;
        if (p_i49984_1_.isInstant()) {
            this.stewEffectDuration = effectDuration;
        } else {
            this.stewEffectDuration = effectDuration * 20;
        }

    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        Vec3d vec3d = state.getOffset(worldIn, pos);
        return SHAPE.withOffset(vec3d.x, vec3d.y, vec3d.z);
    }

    /**
     * Get the OffsetType for this Block. Determines if the model is rendered slightly offset.
     */
    public Block.OffsetType getOffsetType() {
        return Block.OffsetType.XZ;
    }

    /**
     * Gets the effect that is applied when making suspicious stew.
     */
    public Effect getStewEffect() {
        return this.stewEffect;
    }

    /**
     * The duration of the effect granted by a suspicious stew made with this item.
     */
    public int getStewEffectDuration() {
        return this.stewEffectDuration;
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.down();
//        if (state.getBlock() == this) //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
//            return worldIn.getBlockState(blockpos).canSustainPlant(worldIn, blockpos, Direction.UP, this);
        return this.isValidGround(worldIn.getBlockState(blockpos), worldIn, blockpos);
    }

    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        //Block block = state.getBlock();
        Block block = state.getBlock();
        return block == RegistryHandler.HYPERLANE_GRAVEL.get() || block == RegistryHandler.HYPERLANE_GEL_BLOCK.get();
    }
}