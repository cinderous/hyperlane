package net.cinderous.hyperlane.blocks;

import net.cinderous.hyperlane.util.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import java.util.stream.Stream;

public class Blockwormold extends Block {
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(4, 0, 0, 12, 8, 16)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();
    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(0, 0, 4, 16, 8, 12)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();
    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(4, 0, 0, 12, 8, 16)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();
    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(0, 0, 4, 16, 8, 12)
    ).reduce((v1, v2) -> {
        return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
    }).get();

    public Blockwormold() {
        super(Block.Properties.create(Material.ROCK)
                .hardnessAndResistance(5.0f, 6.0f)
                .sound(SoundType.GROUND)
        );
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
    }

    @Override

    public boolean hasTileEntity(BlockState state) {

        return true;

    }


    @Override

    public TileEntity createTileEntity(BlockState state, IBlockReader world) {

        return RegistryHandler.BLOCKWORM_TILE_ENTITY.get().create();

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

}
