package com.teknoserval.arcanedustry.datagen.tags;

import com.teknoserval.arcanedustry.blocks.ArcanedustryBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

import static com.teknoserval.arcanedustry.Arcanedustry.MODID;

public class ArcanedustryBlockTagsProvider extends BlockTagsProvider {

    public ArcanedustryBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.NEEDS_IRON_TOOL).add(ArcanedustryBlocks.MAGIC_ORE_PAIR.getBlock().get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ArcanedustryBlocks.MAGIC_ORE_PAIR.getBlock().get());
    }
}
