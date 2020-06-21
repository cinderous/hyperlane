package net.cinderous.hyperlane.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class HyphinitySoil  extends Block {


    //protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

    public HyphinitySoil(Block.Properties properties) {
        super(Block.Properties.create(Material.TALL_PLANTS, MaterialColor.BLACK)
                .hardnessAndResistance(5.0f, 6.0f)
                .sound(SoundType.GROUND));
    }

//    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
//        return SHAPE;
//    }

//    /**
//     * Whether this IGrowable can grow
//     */
//    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
//        return true;
//    }
//
//    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
//        return true;
//    }
//
//    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
//        DoublePlantBlock doubleplantblock = (DoublePlantBlock) (this == Blocks.FERN ? Blocks.LARGE_FERN : RegistryHandler.HYPHINITY_TALL_GRASS.get());
//        if (doubleplantblock.getDefaultState().isValidPosition(worldIn, pos) && worldIn.isAirBlock(pos.up())) {
//            doubleplantblock.placeAt(worldIn, pos, 2);
//        }
//        if (doubleplantblock.getDefaultState().isValidPosition(worldIn, pos) && worldIn.getBlockState(pos.up()) == Blocks.WATER.getDefaultState()) {
//            doubleplantblock.placeAt(worldIn, pos, 2);
//        }
//
//
//    }

//    @Override
//    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
//        BlockPos blockpos = pos.down();
//        if (state.getBlock() == this) //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
//            return this.isValidGround(worldIn.getBlockState(blockpos), worldIn, blockpos);
//        return this.isValidGround(worldIn.getBlockState(blockpos), worldIn, blockpos);
//    }
//
//    @Override
//    public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing, net.minecraftforge.common.IPlantable plantable) {
//        //BlockState plant = plantable.getPlant(world, pos.offset(facing));
//        //net.minecraftforge.common.PlantType type = plantable.getPlantType(world, pos.offset(facing));
//        //doesnt need to check for air because grass turns into tall grass after grow
//        BlockState blockstate = world.getBlockState(pos.down());
//        if (blockstate == RegistryHandler.HYPERLANE_GEL_BLOCK.get().getDefaultState()) {
//            return true;
//        }return false;
//    }
//
//    @Override
//    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
//
//        Block block = state.getBlock();
//        return block == RegistryHandler.HYPERLANE_GEL_BLOCK.get();

    }

