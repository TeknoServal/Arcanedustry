package com.teknoserval.arcanedustry.item;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.teknoserval.arcanedustry.item.component.ArcanedustryConsumables;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.teknoserval.arcanedustry.Arcanedustry.MODID;
import static com.teknoserval.arcanedustry.Constants.SIMPLE_FLAT_ITEM_TYPE;
import static com.teknoserval.arcanedustry.creativetabs.ArcanedustryCreativeTabs.EXAMPLE_TAB;
import static com.teknoserval.arcanedustry.creativetabs.ArcanedustryCreativeTabs.TAB_ITEM_LOCATIONS;

public class ArcanedustryItems {

    // Create a Deferred Register to hold Items which will all be registered under the "arcanedustry" namespace
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    public static final Multimap<String, DeferredItem<? extends Item>> ITEM_TYPE_MAP = ArrayListMultimap.create();

    public static final DeferredItem<Item> EXAMPLE_ITEM = registerSimpleItem("example_item", new Item.Properties(), EXAMPLE_TAB);
    public static final DeferredItem<Item> MAGIC_GOO = registerSimpleItem("magic_goo", new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(1).saturationModifier(2f).build(), ArcanedustryConsumables.MAGIC_GOO), EXAMPLE_TAB);

    public static final DeferredItem<Item> TEST_SPELL = registerSimpleItem("test_spell", ArcanedustrySpellItem::new, new Item.Properties().stacksTo(1), EXAMPLE_TAB);

    public static DeferredItem<Item> registerSimpleItem(String name, Item.Properties props, DeferredHolder<CreativeModeTab, CreativeModeTab> creativeTab) {
        return registerSimpleItem(name, Item::new, props, creativeTab);
    }

    public static DeferredItem<Item> registerSimpleItem(String name, Function<Item.Properties, ? extends Item> func, Item.Properties props, DeferredHolder<CreativeModeTab, CreativeModeTab> creativeTab) {
        DeferredItem<Item> item = ITEMS.registerItem(name, func, props);

        ITEM_TYPE_MAP.put(SIMPLE_FLAT_ITEM_TYPE, item);
        TAB_ITEM_LOCATIONS.put(creativeTab.getId().getPath(), item);
        return item;
    }

    public static DeferredItem<BlockItem> registerSimpleBlockItem(String name, Supplier<? extends Block> block, String creativeTab) {
        DeferredItem<BlockItem> item = ITEMS.registerSimpleBlockItem(name, block);

        // No item type, block items generate item models automatically
        TAB_ITEM_LOCATIONS.put(creativeTab, item);
        return item;
    }

    /** Registers Item deferred register to the mod event bus **/
    public static void register(IEventBus modBus) {
        ITEMS.register(modBus);
    }
}
