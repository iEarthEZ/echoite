package com.iearth60.echoite.item;

import com.iearth60.echoite.Echoite;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ECHOITE = registerItem("echoite", new Item(new Item.Settings()));
    public static final Item RAW_ECHOITE = registerItem("raw_echoite", new Item(new Item.Settings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Echoite.MOD_ID, name), item);
    }


    public static void registerModItems()
    {
        Echoite.LOGGER.info("Registering Mod Items for " + Echoite.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ECHOITE);
            entries.add(RAW_ECHOITE);
        });
    }
}
