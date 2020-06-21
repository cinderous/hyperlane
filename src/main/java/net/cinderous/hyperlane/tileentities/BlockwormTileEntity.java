package net.cinderous.hyperlane.tileentities;

import net.cinderous.hyperlane.util.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

public class BlockwormTileEntity extends TileEntity implements ITickableTileEntity {

    private int tick = 0;
    private int timesRan = 0;
    private int missedPlacement = 0;
    private int crawlingPotential = 0;
    private boolean justCrawled = false;
    public BlockPos down;
    public BlockPos up;
    public BlockPos north;
    public BlockPos south;
    public BlockPos west;
    public BlockPos east;
    public BlockState downBlock;
    public BlockState upBlock;
    public BlockState northBlock;
    public BlockState southBlock;
    public BlockState westBlock;
    public BlockState eastBlock;
    public int randomdirection;
    public int randomdirection2;
    public int randomdirection3;
    private int currentDirection = 0;
    public BlockState wormFood = RegistryHandler.HYPERLANE_GEL_BLOCK.get().getDefaultState();
    public BlockState wormBlock = RegistryHandler.BLOCKWORM.get().getDefaultState();
    public BlockState wormyBlock = RegistryHandler.BLOCKWORMY.get().getDefaultState();
    private boolean wormyPlaced = false;

    private int manaCost = 1;

    public BlockwormTileEntity(TileEntityType<?> typeIn) {
        super(typeIn);
    }

    public BlockwormTileEntity() {
        this(RegistryHandler.BLOCKWORM_TILE_ENTITY.get());

    }


    @Override
    public void tick() {
          //we know that this is only running once so why is it duplicating the worm block?
        if (!world.isRemote) {
            tick++;

            if (tick == 5 && !wormyPlaced) {

                ///////////////////








                ////////////////////

                BlockPos currentPos = this.getPos();
                BlockPos directions[] = {
                        down = this.pos.down(),
                        up = this.pos.up(),
                        north = this.pos.north(),
                        south = this.pos.south(),
                        west = this.pos.west(),
                        east = this.pos.east(),
                };

                Random rand = new Random();
                randomdirection = rand.nextInt(5);
                //this will check for air or any wormblock in a random direction, and then place its main worm there, setting its former block to its tail version.
                //if (world.getBlockState(directions[randomdirection]) != Blocks.AIR.getDefaultState() && wormBlock.getBlockState().isValidPosition(world, directions[randomdirection])) {

                //CHECK FOR AIR

                if (world.getBlockState(directions[randomdirection]) != Blocks.AIR.getDefaultState() && world.getBlockState(directions[randomdirection]) != wormBlock && world.getBlockState(directions[randomdirection]) != wormyBlock) {

                    world.setBlockState(directions[randomdirection], wormBlock);

                    world.setBlockState(this.pos, wormyBlock);

                    wormyPlaced = true;
                    tick = 0;



//AND IF IT IS AIR THEN RESET THE TICK
                } else {

                    tick = 0;
                    missedPlacement++;

                }

            }


//        if (missedPlacement == 10 && crawlingPotential==0) {
//            CrystalArchitect.LOGGER.info("STARTING MISSED PLACEMENT");
//            //block is stuck ininfinate loop because nothing is valid around it, so we must climb into the air and find more
//            BlockPos currentLoopPos = this.getPos();
//            BlockPos directionsLoop[] = {
//                    down = this.pos.down(),
//                    up = this.pos.up(),
//                    north = this.pos.north(),
//                    south = this.pos.south(),
//                    west = this.pos.west(),
//                    east = this.pos.east(),
//            };
//
//            Random rand2 = new Random();
//            randomdirection2 = rand2.nextInt(6);
//            //this will check for air or any wormblock in a random direction, and then place its main worm there, setting its former block to its tail version.
//            //if (world.getBlockState(directions[randomdirection]) != Blocks.AIR.getDefaultState() && wormBlock.getBlockState().isValidPosition(world, directions[randomdirection])) {
//
//            //CHECK FOR AIR
//            if (world.getBlockState(this.pos.up()) == Blocks.AIR.getDefaultState()) {
//
//                BlockPos offsetPos = new BlockPos (this.pos.up());
//
//                world.setBlockState(this.pos.up(), wormBlock);
//
//                world.setBlockState(this.pos, wormyBlock);
//
//                wormyPlaced = true;
//                tick = 0;
//                crawlingPotential++;
//                missedPlacement = 0;
//
////                if (world.getBlockState(offsetPos.offset(Direction.WEST)) == Blocks.AIR.getDefaultState())
////                {
////                    BlockPos offsetInnerPos = new BlockPos (offsetPos.offset(Direction.WEST));
////
////                    if (world.getBlockState(offsetInnerPos.offset(Direction.DOWN)) != Blocks.AIR.getDefaultState()) {
////                        world.setBlockState(offsetPos.offset(Direction.WEST), wormBlock);
////
////
////                    }
////                }
//            }
//
//        }

        if (missedPlacement ==10) {
            //block is stuck ininfinate loop because nothing is valid around it, so we must climb into the air and find more
            BlockPos currentLoopPos = this.getPos();
            BlockPos crawlingDirection[] = {
//                    down = this.pos.down(),
//                    up = this.pos.up(),
                    north = this.pos.north(),
                    south = this.pos.south(),
                    west = this.pos.west(),
                    east = this.pos.east(),
            };

            Random rand3 = new Random();
            randomdirection3 = rand3.nextInt(4);
            //this will check for air or any wormblock in a random direction, and then place its main worm there, setting its former block to its tail version.
            //if (world.getBlockState(directions[randomdirection]) != Blocks.AIR.getDefaultState() && wormBlock.getBlockState().isValidPosition(world, directions[randomdirection]))

            //WORM MUST EAT ITSELF TO FIND VALID GROUND
            if (world.getBlockState(crawlingDirection[randomdirection3]) == wormyBlock) {

                world.setBlockState(crawlingDirection[randomdirection3], wormBlock);

                world.setBlockState(this.pos, Blocks.AIR.getDefaultState());

                wormyPlaced = true;

                //missedPlacement = 0;
                justCrawled=true;

                tick = 0;

//                if (world.getBlockState(offsetPos.offset(Direction.WEST)) == Blocks.AIR.getDefaultState())
//                {
//                    BlockPos offsetInnerPos = new BlockPos (offsetPos.offset(Direction.WEST));
//
//                    if (world.getBlockState(offsetInnerPos.offset(Direction.DOWN)) != Blocks.AIR.getDefaultState()) {
//                        world.setBlockState(offsetPos.offset(Direction.WEST), wormBlock);
//
//
//                    }
//                }
            }
        }


//        //GG!!! it still couldnt find anything around it even with the block crawled horizontally so we need to eat ourself to get back.
//
//            if (missedPlacement ==20 && justCrawled) {
//                //block is stuck ininfinate loop because nothing is valid around it, so we must climb into the air and find more
//                BlockPos currentLoopPos = this.getPos();
//                BlockPos crawlingDirection[] = {
//                        down = this.pos.down(),
//                        up = this.pos.up(),
//                        north = this.pos.north(),
//                        south = this.pos.south(),
//                        west = this.pos.west(),
//                        east = this.pos.east(),
//                };
//
//                Random rand3 = new Random();
//                randomdirection3 = rand3.nextInt(6);
//                //this will check for air or any wormblock in a random direction, and then place its main worm there, setting its former block to its tail version.
//                //if (world.getBlockState(directions[randomdirection]) != Blocks.AIR.getDefaultState() && wormBlock.getBlockState().isValidPosition(world, directions[randomdirection]))
//
//
//                if (world.getBlockState(crawlingDirection[randomdirection3]) == wormyBlock) {
//
//                    world.setBlockState(crawlingDirection[randomdirection3], wormBlock);
//
//                    world.setBlockState(this.pos, wormyBlock);
//
//                    wormyPlaced = true;
//                    tick = 0;
//                    missedPlacement = 0;
//                    justCrawled=false;
//
//
////                if (world.getBlockState(offsetPos.offset(Direction.WEST)) == Blocks.AIR.getDefaultState())
////                {
////                    BlockPos offsetInnerPos = new BlockPos (offsetPos.offset(Direction.WEST));
////
////                    if (world.getBlockState(offsetInnerPos.offset(Direction.DOWN)) != Blocks.AIR.getDefaultState()) {
////                        world.setBlockState(offsetPos.offset(Direction.WEST), wormBlock);
////
////
////                    }
////                }
//                }
//            }

        }
    }

}



//    public void tick() {
//        tick++;
//
//        if(tick==20 && !wormyPlaced) {
//
//            BlockPos currentPos = this.getPos();
//            BlockPos directions[] = {
//                    down = this.pos.down(),
//                    up = this.pos.up(),
//                    north = this.pos.north(),
//                    south = this.pos.south(),
//                    west = this.pos.west(),
//                    east = this.pos.east(),
//            };
//
//            Random rand = new Random();
//            randomdirection = rand.nextInt(5);
//            world.setBlockState(directions[randomdirection], wormBlock, 80);
//
//            world.setBlockState(this.pos, wormyBlock, 80);
//            wormyPlaced = true;
//            tick=0;
//        }
//    }
//}
//        //CrystalArchitect.LOGGER.info("START OF TICK");
//        tick++;
//
//       if (tick == 50 && !wormyPlaced) {
//
////CrystalArchitect.LOGGER.info("WE AT 20 TICKS!");
//            //array of all directions around the worm
//            BlockPos currentPos = this.getPos();
//            BlockPos directions[] = {
//                    down = this.pos.down(),
//                    up = this.pos.up(),
//                    north = this.pos.north(),
//                    south = this.pos.south(),
//                    west = this.pos.west(),
//                    east = this.pos.east(),
//            };
//
//            //array of the blockstates around the worm
//            BlockState directionsBlock[] = {
//                    downBlock = world.getBlockState(currentPos.down()),
//                    upBlock = world.getBlockState(currentPos.up()),
//                    northBlock = world.getBlockState(currentPos.north()),
//                    southBlock = world.getBlockState(currentPos.south()),
//                    westBlock = world.getBlockState(currentPos.west()),
//                    eastBlock = world.getBlockState(currentPos.east()),
//            };
//
//            Random rand = new Random();
//            randomdirection = rand.nextInt(5);
//
////            //should randomly pick an index and try that direction for if any block exists...
//            if (world.getBlockState(directions[randomdirection]) != wormFood && wormBlock.getBlockState().isValidPosition(world, directions[randomdirection])) {
////
//                world.setBlockState(directions[randomdirection], wormBlock, 80);
//                wormyPlaced = true;
//                tick = 0;
//
//            }
////            if (world.getBlockState(directions[0]) == wormBlock ||
////                    world.getBlockState(directions[1]) == wormBlock ||
////                    world.getBlockState(directions[2]) == wormBlock ||
////                    world.getBlockState(directions[3]) == wormBlock ||
////                    world.getBlockState(directions[4]) == wormBlock ||
////                    world.getBlockState(directions[5]) == wormBlock ); {
////
////                        wormyPlaced = true;
////
////                     };
//
////                wormyPlaced = true;
////                CrystalArchitect.LOGGER.info("FIRST STEP IS TO PLACE THIS BLOCK! WHICH IVE NOW DONE ONCE! RIGHT?   " +wormyPlaced);
//
//
//                //neccessary to prevent the new block from setting itself to a normal block before placing a block (because it randomly checks a direction which might not have a block it can eat)
////            if (wormyPlaced == 1) {
////
////
//                //checks for any block around itself which is a source worm
//
//
//
//            } else {
//
//                BlockPos newPos = this.getPos();
//                BlockPos directionsPreCheck[] = {
//                    down = this.pos.down(),
//                    up = this.pos.up(),
//                    north = this.pos.north(),
//                    south = this.pos.south(),
//                    west = this.pos.west(),
//                    east = this.pos.east(),
//            };
//
//            Random rand2 = new Random();
//            randomdirection2 = rand2.nextInt(5);
//
//                if (world.getBlockState(directionsPreCheck[0]) == wormBlock ||
//                    world.getBlockState(directionsPreCheck[1]) == wormBlock ||
//                    world.getBlockState(directionsPreCheck[2]) == wormBlock ||
//                    world.getBlockState(directionsPreCheck[3]) == wormBlock ||
//                    world.getBlockState(directionsPreCheck[4]) == wormBlock ||
//                    world.getBlockState(directionsPreCheck[5]) == wormBlock );
//                        {
//                            if (world.getBlockState(directionsPreCheck[randomdirection2]) == wormBlock) {
//                                world.setBlockState(this.getPos(), wormyBlock, 80);
//                                tick=0;
//                            }
//
//                            if (world.getBlockState(this.getPos()) == wormBlock) {
//                                world.setBlockState(this.getPos(), wormyBlock, 80);
//                                tick=0;
//                            }
//
//
//                        }
//
//
//                }
//
//



//             }
//    }







