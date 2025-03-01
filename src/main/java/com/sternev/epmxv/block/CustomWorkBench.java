package com.sternev.epmxv.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;

public class CustomWorkBench extends Block {


    public CustomWorkBench(Settings settings) {
        super(AbstractBlock.Settings.create().strength(2.5f).requiresTool());
    }
}
