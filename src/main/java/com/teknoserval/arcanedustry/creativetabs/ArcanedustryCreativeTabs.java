package com.teknoserval.arcanedustry.creativetabs;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.teknoserval.arcanedustry.items.ArcanedustryItems;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.teknoserval.arcanedustry.Arcanedustry.MODID;
import static com.teknoserval.arcanedustry.Constants.EXAMPLE_TAB_ID;

public class ArcanedustryCreativeTabs {

    // Dictionary of Items and Tabs
    public static final Multimap<String, DeferredItem<? extends Item>> ARCANEDUSTRY_TAB_ITEM_LOCATIONS = ArrayListMultimap.create();

    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "arcanedustry" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    // Creates a creative tab with the id "arcanedustry:example_tab" for the example item, that is placed after the combat tab
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.arcanedustry")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ArcanedustryItems.EXAMPLE_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                for (DeferredItem<? extends Item> item : ARCANEDUSTRY_TAB_ITEM_LOCATIONS.get(EXAMPLE_TAB_ID)) {
                    output.accept(item.get()); // Add all items to the tab. For your own tabs, this method is preferred over the event
                }
            }).build());

    /** Registers Creative tab deferred register to the mod event bus **/
    public static void register(IEventBus modBus) {
        CREATIVE_MODE_TABS.register(modBus);
    }
}
