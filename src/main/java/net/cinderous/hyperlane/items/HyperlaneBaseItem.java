package net.cinderous.hyperlane.items;

import net.cinderous.hyperlane.Hyperlane;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class HyperlaneBaseItem extends Item {
    public HyperlaneBaseItem() {
        super(new Item.Properties().group(Hyperlane.HYPERLANE_TAB));
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return super.hasEffect(stack);
    }
}
