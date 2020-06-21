package net.cinderous.hyperlane.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class HyphinityOre  extends Block {
    public HyphinityOre() {
        super(Block.Properties.create(Material.ROCK)
                .hardnessAndResistance(5.0f,6.0f)
                .sound(SoundType.GROUND)
                .doesNotBlockMovement()
        );
    }

//    @Override
//    public boolean hasTileEntity(BlockState state) {
//        return true;
//    }
//
//
//
//
//    @Override
//
//    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
//
//        return RegistryHandler.HYPHINITY_ORE_TILE_ENTITY.get().create();
//
//    }
}

