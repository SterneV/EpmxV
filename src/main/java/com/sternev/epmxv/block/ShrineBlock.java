//package com.sternev.epmxv.block;
//
//import net.minecraft.block.AbstractBlock;
//import net.minecraft.block.Block;
//import net.minecraft.block.BlockState;
//import net.minecraft.state.StateManager;
//import net.minecraft.state.property.BooleanProperty;
//
//
//public class ShrineBlock extends Block {
//    public static final BooleanProperty ACTIVATED = BooleanProperty.of("activated");
//
//    @Override
//    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
//        builder.add(ACTIVATED);
//    }
//
//    public ShrineBlock(Settings settings) {
//        super(settings);
//
//        // Set the default state of the block to be deactivated.
//        setDefaultState(getDefaultState().with(ACTIVATED, false));
//    }
//}