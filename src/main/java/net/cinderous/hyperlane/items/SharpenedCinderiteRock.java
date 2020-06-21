
package net.cinderous.hyperlane.items;

        import net.cinderous.hyperlane.Hyperlane;
        import net.cinderous.hyperlane.util.RegistryHandler;
        import net.minecraft.item.Item;
        import net.minecraft.item.ItemStack;

public class SharpenedCinderiteRock extends Item {

    public SharpenedCinderiteRock() {
        super(new Item.Properties().group(Hyperlane.TAB));
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack stack = ItemStack.EMPTY;
        if (itemStack.getDamage() < itemStack.getMaxDamage() - 1) {
            stack = new ItemStack(RegistryHandler.SHARPENED_CINDERITE_ROCK.get()); // replace with item registry and item
            stack.setDamage(itemStack.getDamage() + 1);
        }
        return stack;
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return 30; // REPLACE WITH MAX NUMBER OF USES
    }

//throw rock later...
//    @Override
//    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
//        playerIn.addPotionEffect(new EffectInstance(Effects.ABSORPTION,500,255));
//        worldIn.setRainStrength(1.0f);
//        return super.onItemRightClick(worldIn, playerIn, handIn);
//    }
}
