package net.cinderous.hyperlane.blocks;

import net.cinderous.hyperlane.util.RegistryHandler;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

import java.util.stream.Stream;

public class CobblestoneCrystal  extends Block implements ILiquidContainer {

    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(7, 0, 7, 9, 16, 9),
            Block.makeCuboidShape(7, 2, 2, 9, 17, 4),
            Block.makeCuboidShape(7, 2, 12, 9, 17, 14),
            Block.makeCuboidShape(11, -4, 7, 13, 11, 9),
            Block.makeCuboidShape(13, -6, 8, 15, -1, 10),
            Block.makeCuboidShape(3, -6, 5, 5, -1, 7),
            Block.makeCuboidShape(8, -1, 6, 10, 4, 8),
            Block.makeCuboidShape(6, -1, 8, 8, 4, 10),
            Block.makeCuboidShape(3, -4, 7, 5, 11, 9)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(7, 0, 7, 9, 16, 9),
            Block.makeCuboidShape(7, 2, 2, 9, 17, 4),
            Block.makeCuboidShape(7, 2, 12, 9, 17, 14),
            Block.makeCuboidShape(11, -4, 7, 13, 11, 9),
            Block.makeCuboidShape(13, -6, 8, 15, -1, 10),
            Block.makeCuboidShape(3, -6, 5, 5, -1, 7),
            Block.makeCuboidShape(8, -1, 6, 10, 4, 8),
            Block.makeCuboidShape(6, -1, 8, 8, 4, 10),
            Block.makeCuboidShape(3, -4, 7, 5, 11, 9)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(7, 0, 7, 9, 16, 9),
            Block.makeCuboidShape(7, 2, 2, 9, 17, 4),
            Block.makeCuboidShape(7, 2, 12, 9, 17, 14),
            Block.makeCuboidShape(11, -4, 7, 13, 11, 9),
            Block.makeCuboidShape(13, -6, 8, 15, -1, 10),
            Block.makeCuboidShape(3, -6, 5, 5, -1, 7),
            Block.makeCuboidShape(8, -1, 6, 10, 4, 8),
            Block.makeCuboidShape(6, -1, 8, 8, 4, 10),
            Block.makeCuboidShape(3, -4, 7, 5, 11, 9)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(7, 0, 7, 9, 16, 9),
            Block.makeCuboidShape(7, 2, 2, 9, 17, 4),
            Block.makeCuboidShape(7, 2, 12, 9, 17, 14),
            Block.makeCuboidShape(11, -4, 7, 13, 11, 9),
            Block.makeCuboidShape(13, -6, 8, 15, -1, 10),
            Block.makeCuboidShape(3, -6, 5, 5, -1, 7),
            Block.makeCuboidShape(8, -1, 6, 10, 4, 8),
            Block.makeCuboidShape(6, -1, 8, 8, 4, 10),
            Block.makeCuboidShape(3, -4, 7, 5, 11, 9)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public CobblestoneCrystal() {
        super(Block.Properties.create(Material.ROCK)
                .hardnessAndResistance(5.0f,6.0f)
                .sound(SoundType.GROUND)

        );
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
    }


    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case EAST:
                return SHAPE_E;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    //    /**
//     * Returns the blockstate with the given rotation from the passed blockstate. If
//     * inapplicable, returns the passed blockstate.
//     *
//     * @deprecated call via {@link IBlockState#withRotation(Rotation)} whenever
//     *             possible. Implementing/overriding is fine.
//     */
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    //    /**
//     * Returns the blockstate with the given mirror of the passed blockstate. If
//     * inapplicable, returns the passed blockstate.
//     *
//    // * @deprecated call via {@link IBlockState#withMirror(Mirror)} whenever
//     *             possible. Implementing/overriding is fine.
//     */
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);

    }

    public IFluidState getFluidState(BlockState state) {
        return RegistryHandler.COBBLESTONE_SOLUTION_FLUID.get().getStillFluidState(false);
    }

    @Override
    public boolean canContainFluid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
        return false;
    }

    @Override
    public boolean receiveFluid(IWorld worldIn, BlockPos pos, BlockState state, IFluidState fluidStateIn) {
        return false;
    }

    @Override

    public boolean hasTileEntity(BlockState state) {

        return true;

    }



    @Override

    public TileEntity createTileEntity(BlockState state, IBlockReader world) {

        return RegistryHandler.COBBLESTONE_CRYSTAL_TILE_ENTITY.get().create();

    }


//    @Override
//    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
//                                             Hand handIn, BlockRayTraceResult result) {
//        /*
//         * if (!worldIn.isRemote()) { ServerWorld serverWorld = (ServerWorld) worldIn;
//         * LightningBoltEntity entity = new LightningBoltEntity(worldIn, pos.getX(),
//         * pos.getY(), pos.getZ(), false); serverWorld.addLightningBolt(entity); }
//         */
//        worldIn.addParticle(new ColouredParticle.ColouredParticleData(0.0f, 1.0f, 0.0f, 1.0f), pos.getX() + 0.5f,
//                pos.getY() + 0.5f, pos.getZ() + 0.5f, 0.0f, 0.0f, 0.0f);
//        return ActionResultType.SUCCESS;
//    }
}