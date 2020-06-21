package net.cinderous.hyperlane.tileentities;

import net.cinderous.hyperlane.Hyperlane;
import net.cinderous.hyperlane.util.RegistryHandler;
import net.cinderous.hyperlane.util.TickHandler;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

public class VoiderousTreeBuilderBlockTileEntity extends TileEntity implements ITickableTileEntity {

    private TickHandler handler;
    public BlockState log = RegistryHandler.VOIDEROUS_LOG.get().getDefaultState();
    public BlockState leaves = RegistryHandler.VOIDEROUS_MUCK.get().getDefaultState();

    public Random rand = new Random();
    int firstHeight = rand.nextInt(9) + 5;
    public Random rand2 = new Random();
    int firstLength = rand2.nextInt(5) + 3;
    int secondLength = rand2.nextInt(9) + 6;

    public VoiderousTreeBuilderBlockTileEntity(TileEntityType<?> typeIn) {
        super(typeIn);
        Hyperlane.LOGGER.info("This should be the constructor");

       //
        handler = new TickHandler();
        handler.addMethod("initialize", (timesRun) -> initialize());
        //handler.addRepeatedMethod("oldloop", rand.nextInt(8) +1, (timesRun) -> doFirstLoop(timesRun));
        Direction horizontalDirection[] = {
//                Direction.UP,
//                Direction.DOWN,
                Direction.NORTH,
                Direction.WEST,
                Direction.SOUTH,
                Direction.EAST,
        };
        Direction verticalDirection[] = {
                Direction.UP,
                Direction.DOWN,
//                Direction.NORTH,
//                Direction.WEST,
//                Direction.SOUTH,
//                Direction.EAST,
        };

        handler.addRepeatedDelayedMethod("firstLoop",firstHeight, 10, (timesRun) -> doFirstLoop(verticalDirection[0]));
        handler.addMethod("everythingElse", (timesRun) -> doEverythingElse());
        handler.addRepeatedDelayedMethod("test",firstLength , 10, (timesRun) -> thisIsAwesome(horizontalDirection[rand.nextInt(4)]));
        handler.addMethod("doLeaves", (timesRun) -> doLeaves());
        handler.addMethod("finalizeTree", (timesRun) -> finalizeTree());
        handler.addRepeatedDelayedMethod("doMoreTree", rand.nextInt(9) + 5, 10, (timesRun) -> doMoreTree(verticalDirection[0]));
        handler.addRepeatedDelayedMethod("doMoreBranches", secondLength, 10, (timesRun) -> doMoreBranches(horizontalDirection[rand.nextInt(4)]));
    }

    public VoiderousTreeBuilderBlockTileEntity() {
        this(RegistryHandler.VOIDEROUS_TREE_BUILDER_BLOCK_TILE_ENTITY.get());

    }

    @Override
    public void tick() {
        if (!world.isRemote) {
            handler.tick();

        }
    }

    //When the status is PLANTED the first tick afterwards runs the initialization code.
    public String initialize() {
        Hyperlane.LOGGER.info("THIS SHOULD START");
        handler.addVariable("currentPos", this.getPos());
        handler.addVariable("startPos", this.getPos());
        handler.addVariable("stemPos1", this.getPos().offset(Direction.UP, firstHeight));
        //handler.addVariable("stemPos2", this.getPos().offset(Direction.UP, firstHeight+ secondHeight));

        BlockPos currentPos = (BlockPos) handler.getVariable("currentPos").get();
//            world.setBlockState(currentPos.offset(Direction.WEST, 1), log);
//            world.setBlockState(currentPos.offset(Direction.NORTH, 1), log);
//            world.setBlockState(currentPos.offset(Direction.EAST, 1), log);
//            world.setBlockState(currentPos.offset(Direction.SOUTH, 1), log);
        return "firstLoop";
    }

    //When the status is FIRSTLOOP it runs this code
    public String doFirstLoop(Direction x) {
        //CrystalArchitect.LOGGER.info("THIS SHOULD BE FIRST LOOP");
        BlockPos currentPos = (BlockPos) handler.getVariable("currentPos").get();
        world.setBlockState(currentPos.offset(x), log);
        handler.setVariable("currentPos", currentPos.offset(x));
        //handler.addVariable("stemPos", currentPos.offset(x));
        return "everythingElse";
    }

    public String doEverythingElse() {
        Hyperlane.LOGGER.info("THIS SHOULD BE EVERYTHTN LOOP");
        return "test";
    }

    public String thisIsAwesome(Direction x) {
        Hyperlane.LOGGER.info("THIS SHOULD BE AWESOME LOOP");
        BlockPos currentPos = (BlockPos) handler.getVariable("currentPos").get();
        world.setBlockState(currentPos.offset(x), log);
        handler.setVariable("currentPos", currentPos.offset(x));
        return "doLeaves";
    }

    public String doLeaves() {
        Hyperlane.LOGGER.info("THIS SHOULD BE LEAVES");
        BlockPos currentPos = (BlockPos) handler.getVariable("currentPos").get();
        if(world.getBlockState(currentPos.offset(Direction.NORTH)) != log) {
            world.setBlockState(currentPos.offset(Direction.NORTH), leaves);
        }
        if(world.getBlockState(currentPos.offset(Direction.SOUTH)) != log) {
            world.setBlockState(currentPos.offset(Direction.SOUTH), leaves);
        }
        if(world.getBlockState(currentPos.offset(Direction.EAST)) != log) {
            world.setBlockState(currentPos.offset(Direction.EAST), leaves);
        }
        if(world.getBlockState(currentPos.offset(Direction.WEST)) != log) {
            world.setBlockState(currentPos.offset(Direction.WEST), leaves);
        }
        if(world.getBlockState(currentPos.offset(Direction.UP)) != log) {
            world.setBlockState(currentPos.offset(Direction.UP), leaves);
        }
        if(world.getBlockState(currentPos.offset(Direction.DOWN)) != log) {
            world.setBlockState(currentPos.offset(Direction.DOWN), leaves);
        }
        //handler.setVariable("currentPos", currentPos.offset(x));
        return "doMoreTree";
    }

    public String finalizeTree() {
//        CrystalArchitect.LOGGER.info("THIS SHOULD FINALIZE AND REPLACE ITSELF");
//        BlockPos startPos = (BlockPos) handler.getVariable("startPos").get();
//        world.setBlockState(startPos, log);


        return "finalizeTree";
    }

    public String doMoreTree(Direction x) {
        Hyperlane.LOGGER.info("THIS SHOULD BE MORE TREE LOOP");
        BlockPos stemPos1 = (BlockPos) handler.getVariable("stemPos1").get();
        world.setBlockState(stemPos1.offset(x), log);
        handler.addVariable("stemPos1", stemPos1.offset(x));

        return "doMoreBranches";
    }

    public String doMoreBranches(Direction x) {
        Hyperlane.LOGGER.info("THIS SHOULD BE DO MORE BRANCHES LOOP");
        BlockPos stemPos1 = (BlockPos) handler.getVariable("stemPos1").get();
        //BlockPos currentPos = (BlockPos) handler.getVariable("currentPos").get();
        world.setBlockState(stemPos1.offset(x), log);
        handler.setVariable("currentPos", stemPos1.offset(x));

        return "doLeaves";
    }


}

//    @Override
//    public void tick() {
//        if (!world.isRemote) {
//            handler.tick();
//        }
//    }
//
//    //When the status is PLANTED the first tick afterwards runs the initialization code.
//    public String initialize() {
//        CrystalArchitect.LOGGER.info("THIS SHOULD START");
//        handler.addVariable("currentPos", this.getPos());
//        BlockPos currentPos = (BlockPos) handler.getVariable("currentPos").get();
////            world.setBlockState(currentPos.offset(Direction.WEST, 1), log);
////            world.setBlockState(currentPos.offset(Direction.NORTH, 1), log);
////            world.setBlockState(currentPos.offset(Direction.EAST, 1), log);
////            world.setBlockState(currentPos.offset(Direction.SOUTH, 1), log);
//        return "firstLoop";
//    }
//
//    //When the status is FIRSTLOOP it runs this code
//    public String doFirstLoop(int x) {
//        CrystalArchitect.LOGGER.info("THIS SHOULD BE FIRST LOOP");
//        BlockPos currentPos = (BlockPos) handler.getVariable("currentPos").get();
//        world.setBlockState(currentPos.offset(Direction.UP, x), log);
//        handler.setVariable("currentPos", currentPos.add(0, 1, 0));
//        return "everythingElse";
//    }
//
//    public String doEverythingElse(int x) {
//        CrystalArchitect.LOGGER.info("THIS SHOULD BE FIRST LOOP");
//        CrystalArchitect.LOGGER.info("THIS SHOULD BE FIRST LOOP");
//        BlockPos currentPos = (BlockPos) handler.getVariable("currentPos").get();
//        world.setBlockState(currentPos.offset(Direction.NORTH, x), log);
//        handler.setVariable("currentPos", currentPos.add(0, 1, 0));
//        return "everythingElse";
//    }
//
//    public String thisIsAwesome(int x) {
//        CrystalArchitect.LOGGER.info("THIS SHOULD BE AWESOME");
//        BlockPos currentPos = (BlockPos) handler.getVariable("currentPos").get();
//        world.setBlockState(currentPos.offset(Direction.UP, x), log);
//        handler.setVariable("currentPos", currentPos.add(0, 1, 0));
//        return "everythingElse";
//    }
//
//
//}



