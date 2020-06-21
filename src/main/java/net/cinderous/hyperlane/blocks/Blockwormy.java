package net.cinderous.hyperlane.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;

public class Blockwormy extends Block {
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    public Blockwormy() {
        super(Block.Properties.create(Material.ROCK)
                .hardnessAndResistance(5.0f, 6.0f)
                .sound(SoundType.GROUND)
        );
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
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

