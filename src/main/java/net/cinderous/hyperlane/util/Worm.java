package net.cinderous.hyperlane.util;

public class Worm implements IWorm{

    private int manaAmount;
    private int capacity;

    public Worm(){
        manaAmount = 100;
        capacity = 100;
    }

    @Override
    public void consume(int amountToConsume) {
        manaAmount = Math.max(0, manaAmount - amountToConsume);
    }

    @Override
    public void add(int amountToAdd) {
        manaAmount = Math.min(capacity, manaAmount + amountToAdd);
    }

    @Override
    public void setMana(int amount) {
        manaAmount = Math.min(capacity, amount);
    }

    @Override
    public int getMana() {
        return manaAmount;
    }

//code that calls the capability used for other classes
//            this.getCapability(WormProvider.WORM_CAP).ifPresent(m -> {
//              m.add(manaCost);
//
//    });
}
