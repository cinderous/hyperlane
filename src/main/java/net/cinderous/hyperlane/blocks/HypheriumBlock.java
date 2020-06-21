package net.cinderous.hyperlane.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class HypheriumBlock extends Block {
    public HypheriumBlock() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(5.0f,6.0f)
                .sound(SoundType.METAL)
        );
    }
}
