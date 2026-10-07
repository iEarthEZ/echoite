package com.iearth60.echoite.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import com.iearth60.echoite.Echoite;
import com.iearth60.echoite.block.ModBlocks;
import com.iearth60.echoite.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> ECHOITE_SMELTABLES = List.of(ModItems.RAW_ECHOITE, ModBlocks.ECHOITE_ORE);

        offerSmelting(exporter, ECHOITE_SMELTABLES, RecipeCategory.MISC, ModItems.ECHOITE, 0.25f, 200, "echoite");
        offerBlasting(exporter, ECHOITE_SMELTABLES, RecipeCategory.MISC, ModItems.ECHOITE, 0.25f, 100, "echoite");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.ECHOITE, RecipeCategory.DECORATIONS, ModBlocks.ECHOITE_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ECHOITE_ORE)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.RAW_ECHOITE)
                .criterion(hasItem(ModItems.RAW_ECHOITE), conditionsFromItem(ModItems.RAW_ECHOITE))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_ECHOITE, 9)
                .input(ModBlocks.ECHOITE_ORE)
                .criterion(hasItem(ModBlocks.ECHOITE_ORE), conditionsFromItem(ModBlocks.ECHOITE_ORE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ECHOITE_SWORD)
                .pattern(" R ")
                .pattern(" R ")
                .pattern(" S ")
                .input('R', ModItems.ECHOITE)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.ECHOITE), conditionsFromItem(ModItems.ECHOITE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ECHOITE_PICKAXE)
                .pattern("RRR")
                .pattern(" S ")
                .pattern(" S ")
                .input('R', ModItems.ECHOITE)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.ECHOITE), conditionsFromItem(ModItems.ECHOITE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ECHOITE_AXE)
                .pattern(" RR")
                .pattern(" SR")
                .pattern(" S ")
                .input('R', ModItems.ECHOITE)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.ECHOITE), conditionsFromItem(ModItems.ECHOITE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ECHOITE_HOE)
                .pattern(" RR")
                .pattern(" S ")
                .pattern(" S ")
                .input('R', ModItems.ECHOITE)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.ECHOITE), conditionsFromItem(ModItems.ECHOITE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ECHOITE_SHOVEL)
                .pattern(" R ")
                .pattern(" S ")
                .pattern(" S ")
                .input('R', ModItems.ECHOITE)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.ECHOITE), conditionsFromItem(ModItems.ECHOITE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ECHOITE_HELMET)
                .pattern("RRR")
                .pattern("R R")
                .pattern("   ")
                .input('R', ModItems.ECHOITE)
                .criterion(hasItem(ModItems.ECHOITE), conditionsFromItem(ModItems.ECHOITE))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ECHOITE_CHESTPLATE)
                .pattern("R R")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.ECHOITE)
                .criterion(hasItem(ModItems.ECHOITE), conditionsFromItem(ModItems.ECHOITE))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ECHOITE_LEGGINGS)
                .pattern("RRR")
                .pattern("R R")
                .pattern("R R")
                .input('R', ModItems.ECHOITE)
                .criterion(hasItem(ModItems.ECHOITE), conditionsFromItem(ModItems.ECHOITE))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ECHOITE_BOOTS)
                .pattern("   ")
                .pattern("R R")
                .pattern("R R")
                .input('R', ModItems.ECHOITE)
                .criterion(hasItem(ModItems.ECHOITE), conditionsFromItem(ModItems.ECHOITE))
                .offerTo(exporter);
    }
}