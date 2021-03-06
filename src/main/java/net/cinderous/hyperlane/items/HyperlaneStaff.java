package net.cinderous.hyperlane.items;

import net.cinderous.hyperlane.Hyperlane;
import net.cinderous.hyperlane.util.RegistryHandler;
import net.cinderous.hyperlane.world.HyperlaneTier1Teleport;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class HyperlaneStaff  extends Item {
    public HyperlaneStaff() {
        super(new Item.Properties().group(Hyperlane.HYPERLANE_TAB));
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return super.hasEffect(stack);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        //GroundFinderTeleporter tp = new GroundFinderTeleporter(playerIn.getPosition(), RegistryHandler.CINDIRT_GRASS.get().getDefaultState().getBlock());
        HyperlaneTier1Teleport tp = new HyperlaneTier1Teleport(playerIn.getPosition(), RegistryHandler.VOIDEROUS_MUCK.get().getDefaultState().getBlock());

        if (!worldIn.isRemote) {

            if (worldIn.dimension.getType() == DimensionType.byName(Hyperlane.HYPERLANE_DIM_TYPE)) {
                //playerIn.addPotionEffect(new EffectInstance(RegistryHandler.HYPERLANE_EFFECT.get()));
                playerIn.changeDimension(DimensionType.OVERWORLD, tp);
            } else {
                //playerIn.removePotionEffect(RegistryHandler.HYPERLANE_EFFECT.get());
                playerIn.changeDimension(DimensionType.byName(Hyperlane.HYPERLANE_DIM_TYPE), tp);
            }

        }   return super.onItemRightClick(worldIn, playerIn, handIn);
    }


}