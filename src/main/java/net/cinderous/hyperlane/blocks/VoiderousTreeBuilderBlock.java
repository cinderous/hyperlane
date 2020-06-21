package net.cinderous.hyperlane.blocks;

import net.cinderous.hyperlane.util.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;

public class VoiderousTreeBuilderBlock  extends Block {

    public VoiderousTreeBuilderBlock() {
        super(Block.Properties.create(Material.ROCK)
                .hardnessAndResistance(5.0f, 6.0f)
                .sound(SoundType.GROUND)
        );

    }

    @Override

    public boolean hasTileEntity(BlockState state) {

        return true;

    }


    @Override

    public TileEntity createTileEntity(BlockState state, IBlockReader world) {

        return RegistryHandler.VOIDEROUS_TREE_BUILDER_BLOCK_TILE_ENTITY.get().create();

    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {

        if (worldIn.getBlockState(pos.down()) == RegistryHandler.VOIDEROUS_GRAVEL.get().getDefaultState()) {
            return true;
        };

        return false;
    }
}