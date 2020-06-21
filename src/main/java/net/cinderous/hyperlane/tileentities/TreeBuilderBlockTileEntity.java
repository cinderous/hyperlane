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

public class TreeBuilderBlockTileEntity extends TileEntity implements ITickableTileEntity {

        //CREDIT TO : Xevinaly for helping me with this.
        //

        private TickHandler handler;
        public BlockState log = RegistryHandler.VOIDEROUS_LOG.get().getDefaultState();


        //private GrowthStatus status = GrowthStatus.PLANTED;
        private int randomLength = 0, currentLength = 0;
        private BlockPos currentPos = null;

        public TreeBuilderBlockTileEntity(TileEntityType<?> typeIn) {
            super(typeIn);

            Hyperlane.LOGGER.info("This should be the constructor");

            Random rand = new Random();
            handler = new TickHandler();
            handler.addMethod("initialize", (timesRun) -> initialize());
            //handler.addRepeatedMethod("oldloop", rand.nextInt(8) +1, (timesRun) -> doFirstLoop(timesRun));
            handler.addRepeatedDelayedMethod("firstLoop", rand.nextInt(20) + 1, 10, (timesRun) -> doFirstLoop(1));
            handler.addMethod("everythingElse", (timesRun) -> doEverythingElse());
            handler.addDelayedMethod("test", 20, (timesRun) -> thisIsAwesome());

        }

        public TreeBuilderBlockTileEntity() {
            this(RegistryHandler.TREE_BUILDER_BLOCK_TILE_ENTITY.get());

        }

        @Override
        public void tick() {
            if (!world.isRemote) {
                Hyperlane.LOGGER.info("THIS SHOULD START TICKING!");
                handler.tick();
            }
        }

        //When the status is PLANTED the first tick afterwards runs the initialization code.
        public String initialize() {
            Hyperlane.LOGGER.info("THIS SHOULD START");
            handler.addVariable("currentPos", this.getPos());
            BlockPos currentPos = (BlockPos) handler.getVariable("currentPos").get();
//            world.setBlockState(currentPos.offset(Direction.WEST, 1), log);
//            world.setBlockState(currentPos.offset(Direction.NORTH, 1), log);
//            world.setBlockState(currentPos.offset(Direction.EAST, 1), log);
//            world.setBlockState(currentPos.offset(Direction.SOUTH, 1), log);
            return "firstLoop";
        }

        //When the status is FIRSTLOOP it runs this code
        public String doFirstLoop(int x) {
            Hyperlane.LOGGER.info("THIS SHOULD BE FIRST LOOP");
            BlockPos currentPos = (BlockPos) handler.getVariable("currentPos").get();
            world.setBlockState(currentPos.offset(Direction.UP, x), log);
            handler.setVariable("currentPos", currentPos.add(0, 1, 0));
            return "everythingElse";
        }

        public String doEverythingElse() {
            //Whatever code you decide to run next.
            return "everythingElse";
        }

        public String thisIsAwesome() {
            //Whatever code you decide to run next.
            return "everythingElse";
        }


    }



