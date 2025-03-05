package com.teknoserval.arcanedustry.blocks;

import com.teknoserval.arcanedustry.items.ArcanedustryItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.teknoserval.arcanedustry.Arcanedustry.MODID;
import static com.teknoserval.arcanedustry.Constants.EXAMPLE_TAB_ID;

public class ArcanedustryBlocks {

    // Create a Deferred Register to hold Blocks which will all be registered under the "arcanedustry" namespace
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);

    // Block and BlockItem pair
    public static final DeferredItemBlockPair<Block, BlockItem> EXAMPLE_BLOCK_PAIR = registerSimpleItemBlockPair("example_block", BlockBehaviour.Properties.of().mapColor(MapColor.STONE), EXAMPLE_TAB_ID);

    public static DeferredItemBlockPair<Block, BlockItem> registerSimpleItemBlockPair(String name, BlockBehaviour.Properties props, String creativeTab) {
        DeferredBlock<Block> block = BLOCKS.registerSimpleBlock(name, props);

        DeferredItem<BlockItem> item = ArcanedustryItems.registerSimpleBlockItem(name, block, creativeTab);
        return new DeferredItemBlockPair<>(block, item);
    }

    /** Registers Block and BlockItem deferred registers to the mod event bus **/
    public static void register(IEventBus modBus) {
        BLOCKS.register(modBus);
    }
}
