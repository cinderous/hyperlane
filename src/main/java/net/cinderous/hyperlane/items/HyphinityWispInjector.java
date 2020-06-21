package net.cinderous.hyperlane.items;

import net.cinderous.hyperlane.Hyperlane;
import net.cinderous.hyperlane.entities.HyphinityWisp;
import net.cinderous.hyperlane.util.RegistryHandler;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class HyphinityWispInjector extends Item {
    public HyphinityWispInjector() {
        super(new Item.Properties().group(Hyperlane.HYPERLANE_TAB));
    }


    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

//        HyphinityWisp hyphinitywisp = RegistryHandler.HYPHINITY_WISP.get().create(worldIn);
//        BlockPos blockpos = playerIn.getPosition();
//        boolean ishyphinityore = false;
//
//
//        int x;
//        int y;
//        int z;
//        int howmanyblockschecked = 0;
//
//        for (x = 0; x <= 50 || ishyphinityore; x++) {
//            CrystalArchitect.LOGGER.info("X LOOP" + x );
//            for (y = 0; y <= 50; y++) {
//                CrystalArchitect.LOGGER.info("Y LOOP" + y );
//                for (z = 0; z <= 50; z++) {
//                    CrystalArchitect.LOGGER.info("Z LOOP" + z );
//                    BlockPos currentblockpos = new BlockPos(blockpos.getX() + x, blockpos.getY() + y, blockpos.getZ() + z);
//                    CrystalArchitect.LOGGER.info("CURRENT BLOCK POS " + currentblockpos );
//                    if (worldIn.getBlockState(currentblockpos).getBlock() != RegistryHandler.HYPHINITY_ORE.get()) {
//                        howmanyblockschecked++;
//                        CrystalArchitect.LOGGER.info("HOW MANY CHECKED" + howmanyblockschecked );
//                    }
//                    if (worldIn.getBlockState(currentblockpos).getBlock() == RegistryHandler.HYPHINITY_ORE.get()) {
//                        CrystalArchitect.LOGGER.info("FOUND ORE at " + currentblockpos);
//                        hyphinitywisp.setLocationAndAngles(currentblockpos.getX(), currentblockpos.getY(), currentblockpos.getZ(), 0.0F, 0.0F);
//
//                        ishyphinityore = true;
//                        worldIn.addEntity(hyphinitywisp);
//                    }
//                }
//
//
//            }
//
//        }

        HyphinityWisp hyphinitywisp = RegistryHandler.HYPHINITY_WISP.get().create(worldIn);
        BlockPos self = new BlockPos(playerIn.getPosition().getX(), playerIn.getPosition().getY(), playerIn.getPosition().getZ());
            //PlayerEntity closestplayer = worldIn.getClosestPlayer(self.getX(), self.getY(), self.getZ(), 500, true);
            hyphinitywisp.setLocationAndAngles(self.getX(), self.getY(), self.getZ(), 0.0F, 0.0F);
            EntityPredicate wisppredicate = new EntityPredicate().setDistance(200);
            AxisAlignedBB box = hyphinitywisp.getBoundingBox().grow(90000);
            List<HyphinityWisp> wisps = worldIn.getEntitiesWithinAABB(HyphinityWisp.class, box, null );
            //CrystalArchitect.LOGGER.info(wisps);
            //logger shows wisps so its how we are calling the next statement
            HyphinityWisp closestwisp = worldIn.getClosestEntity(wisps, wisppredicate, hyphinitywisp, self.getX(), self.getY(), self.getZ());
        Hyperlane.LOGGER.info(wisppredicate);
        Hyperlane.LOGGER.info(hyphinitywisp);
            if (closestwisp != null) {
                playerIn.setPosition(closestwisp.getPosX(),closestwisp.getPosY(), closestwisp.getPosZ());
                Hyperlane.LOGGER.info("CLOSEST WISP" + closestwisp);

            } else {
                Hyperlane.LOGGER.info("CLOSEST WISP IS NULL" );
            }


        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}




//
//
//        int zOffset;
//        int xOffset = 0;
//        int distance = 0;

//        boolean foundnothingonZ = false;
//
//        for (zOffset = 0; !ishyphinityore && !foundnothingonZ; zOffset++ ) {
//
//            if (worldIn.getBlockState(blockpos.north(zOffset)).getBlock() != RegistryHandler.HYPHINITY_ORE.get()) {
//                ++distance;
//                CrystalArchitect.LOGGER.info(distance);
//
//            }
//
//            if (worldIn.getBlockState(blockpos.north(zOffset)).getBlock() == RegistryHandler.HYPHINITY_ORE.get()) {
//                //hyphinitywisp.setLocationAndAngles((double)blockpos.getX() + 0.5D, (double)blockpos.getY() + 0.55D, (double)blockpos.getZ() + 0.5D, 0.0F, 0.0F);
//                hyphinitywisp.setLocationAndAngles(blockpos.getX(), blockpos.getY(), blockpos.north(zOffset).getZ(), 0.0F, 0.0F);
//
//                    ishyphinityore = true;
//                    worldIn.addEntity(hyphinitywisp);
//
//
//            }
//
//            if (zOffset == 50) {
//                foundnothingonZ = true;
//                xOffset = 1;
//                zOffset = 0;
//                blockpos = new BlockPos(blockpos.getX() +1, blockpos.getY(), blockpos.getZ());
//                if (xOffset == 1) {
//                    for (xOffset =1; worldIn.getBlockState(blockpos.north(zOffset)).getBlock() == RegistryHandler.HYPHINITY_ORE.get(); xOffset++);
//                    //hyphinitywisp.setLocationAndAngles((double)blockpos.getX() + 0.5D, (double)blockpos.getY() + 0.55D, (double)blockpos.getZ() + 0.5D, 0.0F, 0.0F);
//                    hyphinitywisp.setLocationAndAngles(blockpos.getX(), blockpos.getY(), blockpos.north(zOffset).getZ(), 0.0F, 0.0F);
//
//                    ishyphinityore = true;
//                    worldIn.addEntity(hyphinitywisp);
//                }
//            }

//                            if (worldIn.getBlockState(blockposore.add(0,y,z)).getBlock() != RegistryHandler.HYPHINITY_ORE.get()) {
//                            distanceblocks++;
//                            CrystalArchitect.LOGGER.info("not ore distance " + distanceblocks);
//                        }

//                        if (worldIn.getBlockState(blockposore.north(z)).getBlock() != RegistryHandler.HYPHINITY_ORE.get()) {
//                            hyphinitywisp.setLocationAndAngles(blockposore.getX(), blockposore.getY(), blockposore.north(zOffset).getZ(), 0.0F, 0.0F);
//
//                            ishyphinityore = true;
//                            worldIn.addEntity(hyphinitywisp);
//                            CrystalArchitect.LOGGER.info("SPAWNED IN WISP AT ORE " + blockposore);
//                        }
//                        if (z==50) {
//                            z = 1;
//                            distanceblocks
//                            blockposore = blockposore.add(0,0,z);
//                        }
//        }
//    }


//                if (worldIn.getBlockState(blockposore.up(y)).getBlock() != RegistryHandler.HYPHINITY_ORE.get()) {
//
//                    distanceblocks++;
//                    CrystalArchitect.LOGGER.info("not ore distance " + distanceblocks);
//                }

