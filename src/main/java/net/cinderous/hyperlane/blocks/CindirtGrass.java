package net.cinderous.hyperlane.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.IPlantable;

public class CindirtGrass extends BushBlock implements IPlantable {
    public CindirtGrass() {
        super(Block.Properties.create(Material.EARTH)
                .hardnessAndResistance(1.0f,1.0f)
                .sound(SoundType.GROUND)
        );

    }

//    @Override
//    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
//        Block block = state.getBlock();
//        return block == RegistryHandler.CINDIRT.get() || block == RegistryHandler.CINDIRT_GRASS.get();
//    }
}
