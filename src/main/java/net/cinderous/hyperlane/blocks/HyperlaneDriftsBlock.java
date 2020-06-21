package net.cinderous.hyperlane.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class HyperlaneDriftsBlock extends Block {

    public HyperlaneDriftsBlock() {
        super(Block.Properties.create(Material.EARTH)
                .hardnessAndResistance(5.0f, 6.0f)
                .sound(SoundType.SNOW)
                .doesNotBlockMovement()
                .slipperiness(2.0f)
                .speedFactor(2.0f)
                .jumpFactor(1.0f)
        );
    }
}