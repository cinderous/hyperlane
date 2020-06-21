package net.cinderous.hyperlane.util;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;

public class WormProvider implements ICapabilitySerializable<INBT> {
    @CapabilityInject(IWorm.class)
    public static final Capability<IWorm> WORM_CAP = null;

    private LazyOptional<IWorm> instance = LazyOptional.of(WORM_CAP::getDefaultInstance);

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, Direction side) {
        return cap == WORM_CAP ? instance.cast() : LazyOptional.empty();
    }

    @Override
    public INBT serializeNBT() {
        return WORM_CAP.getStorage().writeNBT(WORM_CAP, instance.orElseThrow( () -> new NullPointerException("Lazy Optional was empty")), null);
    }

    @Override
    public void deserializeNBT(INBT nbt) {
        WORM_CAP.getStorage().readNBT(WORM_CAP, instance.orElseThrow( () -> new NullPointerException("Lazy Optional was empty")), null, nbt);
    }
}