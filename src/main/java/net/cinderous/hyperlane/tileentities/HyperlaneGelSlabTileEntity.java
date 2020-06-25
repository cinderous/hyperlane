package net.cinderous.hyperlane.tileentities;

import net.cinderous.hyperlane.Hyperlane;
import net.cinderous.hyperlane.util.RegistryHandler;
import net.cinderous.hyperlane.util.TickHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

public class HyperlaneGelSlabTileEntity extends TileEntity implements ITickableTileEntity {
public static int tick = 0;

    public HyperlaneGelSlabTileEntity(TileEntityType<?> typeIn) {
        super(typeIn);

    }

    public HyperlaneGelSlabTileEntity() {
        this(RegistryHandler.HYPERLANE_GEL_SLAB_TILE_ENTITY.get());

    }

    @Override
    public void tick() {

        tick++;
        Hyperlane.LOGGER.info(tick);

        if(tick == 100) {
            world.setBlockState(this.getPos(), Blocks.AIR.getDefaultState());
            tick=0;
            this.remove();
        }
    }
}




