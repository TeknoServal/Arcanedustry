package com.teknoserval.arcanedustry.datagen.models;

import com.teknoserval.arcanedustry.blocks.ArcanedustryBlocks;
import com.teknoserval.arcanedustry.item.ArcanedustryItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import static com.teknoserval.arcanedustry.Arcanedustry.MODID;
import static com.teknoserval.arcanedustry.Constants.SIMPLE_CUBE_BLOCK_TYPE;
import static com.teknoserval.arcanedustry.Constants.SIMPLE_FLAT_ITEM_TYPE;

public class ArcanedustryModelProvider extends ModelProvider {

    public ArcanedustryModelProvider(PackOutput output) {
        super(output, MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

        // Blocks
        for (DeferredBlock<? extends Block> deferredBlock : ArcanedustryBlocks.BLOCK_TYPE_MAP.get(SIMPLE_CUBE_BLOCK_TYPE)) {
            blockModels.createTrivialCube(deferredBlock.get());
        }

        // Items
        for (DeferredItem<? extends Item> deferredItem : ArcanedustryItems.ITEM_TYPE_MAP.get(SIMPLE_FLAT_ITEM_TYPE)) {
            itemModels.generateFlatItem(deferredItem.get(), ModelTemplates.FLAT_ITEM);
        }
    }
}
