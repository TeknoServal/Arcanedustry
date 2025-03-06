package com.teknoserval.arcanedustry.datagen.loottables;

import com.teknoserval.arcanedustry.blocks.ArcanedustryBlocks;
import com.teknoserval.arcanedustry.items.ArcanedustryItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.Set;

import static com.teknoserval.arcanedustry.Constants.DROP_SELF_LOOT_TYPE;

public class ArcanedustryBlockLootSubProvider extends BlockLootSubProvider {

    public ArcanedustryBlockLootSubProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.DEFAULT_FLAGS, registries);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ArcanedustryBlocks.BLOCKS.getEntries().stream().map(e -> (Block) e.value()).toList();
    }

    @Override
    protected void generate() {
        for (DeferredBlock<? extends Block> deferredBlock : ArcanedustryBlocks.BLOCK_LOOT_TYPE_MAP.get(DROP_SELF_LOOT_TYPE)) {
            this.dropSelf(deferredBlock.get());
        }

        createMultiOreDropLootTable(ArcanedustryBlocks.MAGIC_ORE_PAIR.getBlock().get(), ArcanedustryItems.MAGIC_GOO.get(), 3.0F, 6.0F);
    }

    private void createMultiOreDropLootTable(Block block, Item item, float min, float max) {
        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        this.add(block, this.createSilkTouchDispatchTable(block,
                applyExplosionDecay(block, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                        .apply(ApplyBonusCount.addOreBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE))))));
    }
}
