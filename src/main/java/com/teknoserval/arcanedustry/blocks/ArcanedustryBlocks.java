package com.teknoserval.arcanedustry.blocks;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.teknoserval.arcanedustry.item.ArcanedustryItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.teknoserval.arcanedustry.Arcanedustry.MODID;
import static com.teknoserval.arcanedustry.Constants.*;

public class ArcanedustryBlocks {

    // Create a Deferred Register to hold Blocks which will all be registered under the "arcanedustry" namespace
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);

    public static final Multimap<String, DeferredBlock<? extends Block>> BLOCK_TYPE_MAP = ArrayListMultimap.create();
    public static final Multimap<String, DeferredBlock<? extends Block>> BLOCK_LOOT_TYPE_MAP = ArrayListMultimap.create();

    // Block and BlockItem pair
    public static final DeferredItemBlockPair<Block, BlockItem> EXAMPLE_BLOCK_PAIR = registerSimpleItemBlockPair("example_block", BlockBehaviour.Properties.of().mapColor(MapColor.STONE), EXAMPLE_TAB_ID);

    public static final DeferredItemBlockPair<Block, BlockItem> MAGIC_ORE_PAIR = registerSimpleItemBlockPair("magic_ore", BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(3.0F), EXAMPLE_TAB_ID, CUSTOM_LOOT_TYPE);

    private static DeferredItemBlockPair<Block, BlockItem> registerSimpleItemBlockPair(String name, BlockBehaviour.Properties props, String creativeTab) {
        return registerSimpleItemBlockPair(name, props, creativeTab, DROP_SELF_LOOT_TYPE);
    }

    public static DeferredItemBlockPair<Block, BlockItem> registerSimpleItemBlockPair(String name, BlockBehaviour.Properties props, String creativeTab, String lootType) {
        DeferredBlock<Block> block = BLOCKS.registerSimpleBlock(name, props);
        BLOCK_TYPE_MAP.put(SIMPLE_CUBE_BLOCK_TYPE, block);
        BLOCK_LOOT_TYPE_MAP.put(lootType, block);

        DeferredItem<BlockItem> item = ArcanedustryItems.registerSimpleBlockItem(name, block, creativeTab);
        return new DeferredItemBlockPair<>(block, item);
    }

    /** Registers Block and BlockItem deferred registers to the mod event bus **/
    public static void register(IEventBus modBus) {
        BLOCKS.register(modBus);
    }
}
