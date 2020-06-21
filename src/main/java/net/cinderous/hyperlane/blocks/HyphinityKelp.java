package net.cinderous.hyperlane.blocks;

import net.cinderous.hyperlane.util.RegistryHandler;
import net.minecraft.block.*;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

import javax.annotation.Nullable;

public class HyphinityKelp  extends Block implements ILiquidContainer {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_0_25;
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 9.0D, 16.0D);

    public HyphinityKelp(Block.Properties builder) {
        super(builder);
        this.setDefaultState(this.stateContainer.getBaseState());//.with(AGE, Integer.valueOf(0)));
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        IFluidState ifluidstate = context.getWorld().getFluidState(context.getPos());
        return ifluidstate.isTagged(FluidTags.WATER) && ifluidstate.getLevel() == 8 ? this.getBlock().getDefaultState() : null;
    }

//    public BlockState randomAge(IWorld p_209906_1_) {
//        return this.getDefaultState().with(AGE, Integer.valueOf(p_209906_1_.getRandom().nextInt(25)));
//    }

    public IFluidState getFluidState(BlockState state) {
        return Fluids.WATER.getStillFluidState(false);
    }

//    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
//        if (!state.isValidPosition(worldIn, pos)) {
//            worldIn.destroyBlock(pos, true);
//        } else {
//            BlockPos blockpos = pos.up();
//            BlockState blockstate = worldIn.getBlockState(blockpos);
//            if (blockstate.getBlock() == Blocks.WATER && state.get(AGE) < 25 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, blockpos, state, rand.nextDouble() < 0.14D)) {
//                worldIn.setBlockState(blockpos, state.cycle(AGE));
//                net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, blockpos, state);
//            }
//
//        }
//    }

    @Override
    public boolean canContainFluid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
        return false;
    }

    @Override
    public boolean receiveFluid(IWorld worldIn, BlockPos pos, BlockState state, IFluidState fluidStateIn) {
        return false;
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return isValidGround(state, worldIn, pos);
    }


    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        //Block block = state.getBlock();
        BlockState blockcheck = worldIn.getBlockState(pos.down());
        return blockcheck == RegistryHandler.HYPERLANE_GRAVEL.get().getDefaultState() || blockcheck == RegistryHandler.HYPERLANE_GEL_BLOCK.get().getDefaultState() || blockcheck == RegistryHandler.HYPHINITY_KELP_PLANT.get().getDefaultState();
    }
}