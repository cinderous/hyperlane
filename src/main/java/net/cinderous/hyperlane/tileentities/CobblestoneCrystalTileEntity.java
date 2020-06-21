package net.cinderous.hyperlane.tileentities;

import net.cinderous.hyperlane.Hyperlane;
import net.cinderous.hyperlane.util.RegistryHandler;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class CobblestoneCrystalTileEntity extends TileEntity implements ITickableTileEntity {

    public int tick;


    public CobblestoneCrystalTileEntity(TileEntityType<?> typeIn) {
        super(typeIn);

    }



    public CobblestoneCrystalTileEntity() {
        this(RegistryHandler.COBBLESTONE_CRYSTAL_TILE_ENTITY.get());
    }


    @Override
    public void tick() {
        tick++;
        //CrystalArchitect.LOGGER.info(tick);
        Hyperlane.LOGGER.info(world.getFluidState(this.getPos().up()));
        Hyperlane.LOGGER.info(RegistryHandler.COBBLESTONE_SOLUTION_FLUID.get().getFlowingFluidState(1,false));
        if (tick==200 && world.getFluidState(this.getPos().up()) == RegistryHandler.COBBLESTONE_SOLUTION_FLUID.get().getFlowingFluidState(8,false)) {
            world.setBlockState(this.getPos().up(), RegistryHandler.COBBLESTONE_CRYSTAL.get().getDefaultState());
        }
    }
}