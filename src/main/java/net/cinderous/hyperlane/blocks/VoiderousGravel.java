package net.cinderous.hyperlane.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class VoiderousGravel extends Block {
    public VoiderousGravel() {
        super(Block.Properties.create(Material.ROCK)
                .hardnessAndResistance(5.0f,6.0f)
                .sound(SoundType.GROUND)
        );
    }
}
