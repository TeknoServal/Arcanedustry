package com.teknoserval.arcanedustry.datagen;

import com.teknoserval.arcanedustry.datagen.loottables.ArcanedustryBlockLootSubProvider;
import com.teknoserval.arcanedustry.datagen.loottables.ArcanedustryLootTableProvider;
import com.teknoserval.arcanedustry.datagen.models.ArcanedustryModelProvider;
import com.teknoserval.arcanedustry.datagen.tags.ArcanedustryBlockTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import static com.teknoserval.arcanedustry.Arcanedustry.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
public class DatagenEventListener {

    @SubscribeEvent
    public static void gatherDataClient(GatherDataEvent.Client event) {

        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        event.addProvider(new ArcanedustryModelProvider(packOutput));
        event.addProvider(new ArcanedustryBlockTagsProvider(packOutput, lookupProvider));

        event.createProvider((output, provider) -> new ArcanedustryLootTableProvider(
                output,
                Set.of(),
                List.of(
                        new LootTableProvider.SubProviderEntry(ArcanedustryBlockLootSubProvider::new, LootContextParamSets.BLOCK)
                ),
                lookupProvider
        ));
    }
}
