package com.teknoserval.arcanedustry.blocks;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class DeferredItemBlockPair<B extends Block, I extends Item> {
    private final DeferredBlock<B> block;
    private final DeferredItem<I> item;

    public DeferredItemBlockPair(DeferredBlock<B> block, DeferredItem<I> item) {
        this.block = block;
        this.item = item;
    }

    public DeferredBlock<B> getBlock() {
        return block;
    }

    public DeferredItem<I> getItem() {
        return item;
    }
}
