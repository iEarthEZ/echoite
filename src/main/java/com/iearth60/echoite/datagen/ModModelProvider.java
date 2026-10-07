package com.iearth60.echoite.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import com.iearth60.echoite.block.ModBlocks;
import com.iearth60.echoite.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ECHOITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ECHOITE_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ECHOITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_ECHOITE, Models.GENERATED);


        itemModelGenerator.register(ModItems.ECHOITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ECHOITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ECHOITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ECHOITE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ECHOITE_SHOVEL, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ECHOITE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ECHOITE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ECHOITE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ECHOITE_BOOTS));
    }
}