package net.cinderous.hyperlane.items;

import net.cinderous.hyperlane.Hyperlane;
import net.cinderous.hyperlane.util.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CinderDev  extends Item {
    private int tick = 0;
    public BlockPos down;
    public BlockPos up ;
    public BlockPos north ;
    public BlockPos south ;
    public  BlockPos west;
    public  BlockPos east;
    public BlockState downBlock;
    public  BlockState upBlock ;
    public  BlockState northBlock ;
    public  BlockState southBlock ;
    public  BlockState westBlock;
    public  BlockState eastBlock;
    public int randomdirection;
    public BlockState wormFood = RegistryHandler.HYPERLANE_GEL_BLOCK.get().getDefaultState();
    public BlockState wormBlock = RegistryHandler.BLOCKWORM.get().getDefaultState();
    public BlockState wormyBlock = RegistryHandler.BLOCKWORMY.get().getDefaultState();
    boolean wormyPlaced = false;

    public CinderDev() {
        super(new Item.Properties().group(Hyperlane.TAB));
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return super.hasEffect(stack);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        Hyperlane.LOGGER.info(playerIn.getSpawnDimension());
        Hyperlane.LOGGER.info(playerIn.getScore());
        //playerIn.setSpawnDimenion();

     return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}