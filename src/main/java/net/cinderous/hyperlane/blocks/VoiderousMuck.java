package net.cinderous.hyperlane.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class VoiderousMuck  extends Block {
    public VoiderousMuck() {
        super(Block.Properties.create(Material.SAND)
                .hardnessAndResistance(0.7f,2.0f)
                .sound(SoundType.SAND)
        );
    }
}
