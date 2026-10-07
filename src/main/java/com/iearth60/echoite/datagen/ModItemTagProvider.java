package com.iearth60.echoite.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import com.iearth60.echoite.item.ModItems;
import com.iearth60.echoite.util.ModTags;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.ECHOITE)
                .add(ModItems.RAW_ECHOITE);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.ECHOITE_SWORD);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.ECHOITE_AXE);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.ECHOITE_PICKAXE);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.ECHOITE_HOE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.ECHOITE_SHOVEL);


        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ECHOITE_HELMET)
                .add(ModItems.ECHOITE_CHESTPLATE)
                .add(ModItems.ECHOITE_LEGGINGS)
                .add(ModItems.ECHOITE_BOOTS);
    }
}