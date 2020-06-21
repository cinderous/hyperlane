package net.cinderous.hyperlane.util;

import net.minecraft.nbt.INBT;
import net.minecraft.nbt.IntNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

public class WormStorage implements Capability.IStorage<IWorm> {

    @Override
    public INBT writeNBT(Capability<IWorm> capability, IWorm instance, Direction side) {

        return IntNBT.valueOf(instance.getMana());

    }

    @Override
    public void readNBT(Capability<IWorm> capability, IWorm instance, Direction side, INBT nbt) {
        instance.setMana(((IntNBT) nbt).getInt());
    }

}
