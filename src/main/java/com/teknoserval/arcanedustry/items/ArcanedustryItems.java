package com.teknoserval.arcanedustry.items;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.teknoserval.arcanedustry.Arcanedustry.MODID;

public class ArcanedustryItems {

    // Create a Deferred Register to hold Items which will all be registered under the "arcanedustry" namespace
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    // Creates a new food item with the id "arcanedustry:example_id", nutrition 1 and saturation 2
    public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.registerSimpleItem("example_item", new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(1).saturationModifier(2f).build()));

    /** Registers Item deferred register to the mod event bus **/
    public static void register(IEventBus modBus) {
        ITEMS.register(modBus);
    }
}
