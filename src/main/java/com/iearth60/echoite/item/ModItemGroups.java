package com.iearth60.echoite.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import com.iearth60.echoite.Echoite;
import com.iearth60.echoite.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup ECHOITE_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Echoite.MOD_ID, "echoite_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.ECHOITE))
                    .displayName(Text.translatable("itemgroup.echoite.echoite_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.ECHOITE);
                        entries.add(ModItems.RAW_ECHOITE);

                        entries.add(ModItems.ECHOITE_SWORD);
                        entries.add(ModItems.ECHOITE_PICKAXE);
                        entries.add(ModItems.ECHOITE_SHOVEL);
                        entries.add(ModItems.ECHOITE_AXE);
                        entries.add(ModItems.ECHOITE_HOE);

                    }).build());

    public static final ItemGroup ECHOITE_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Echoite.MOD_ID, "echoite_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.ECHOITE_BLOCK))
                    .displayName(Text.translatable("itemgroup.echoite.echoite_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.ECHOITE_BLOCK);
                        entries.add(ModBlocks.ECHOITE_ORE);
                    }).build());


    public static void registerItemGroups() {
        Echoite.LOGGER.info("Registering Item Groups for " + Echoite.MOD_ID);
    }
}