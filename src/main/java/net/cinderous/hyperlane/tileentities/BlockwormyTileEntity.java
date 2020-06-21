package net.cinderous.hyperlane.tileentities;

import net.cinderous.hyperlane.util.RegistryHandler;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;

public class BlockwormyTileEntity  extends TileEntity implements ITickableTileEntity {
    public BlockPos wormPos;

    public BlockwormyTileEntity(TileEntityType<?> typeIn) {
        super(typeIn);
    }

    public BlockwormyTileEntity() {
        this(RegistryHandler.BLOCKWORMY_TILE_ENTITY.get());

    }

    @Override
    public void tick() {


    }
}
