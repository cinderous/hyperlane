package net.cinderous.hyperlane.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class HyperlaneGelBlock extends Block {

    public HyperlaneGelBlock() {
        super(Block.Properties.create(Material.EARTH)
                .hardnessAndResistance(0.5f,0.5f)
                .sound(SoundType.SNOW)
                .doesNotBlockMovement()
                .slipperiness(5.0f)
                .speedFactor(10.0f)
                .jumpFactor(2.0f)
                .harvestTool(ToolType.SHOVEL)
        );
    }


//    @Override
//    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
//        return super.allowsMovement(state, worldIn, pos, type);
//    }
}