package com.iearth60.echoite.item;

import com.iearth60.echoite.Echoite;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ECHOITE = registerItem("echoite", new Item(new Item.Settings()));
    public static final Item RAW_ECHOITE = registerItem("raw_echoite", new Item(new Item.Settings()));


    public static final Item ECHOITE_SWORD = registerItem("echoite_sword",
            new SwordItem(ModToolMaterials.ECHOITE, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ECHOITE, 9, -1.4f))));
    public static final Item ECHOITE_PICKAXE = registerItem("echoite_pickaxe",
            new PickaxeItem(ModToolMaterials.ECHOITE, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.ECHOITE, 1, -2.8f))));
    public static final Item ECHOITE_SHOVEL = registerItem("echoite_shovel",
            new ShovelItem(ModToolMaterials.ECHOITE, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.ECHOITE, 1.5f, -3.0f))));
    public static final Item ECHOITE_AXE = registerItem("echoite_axe",
            new AxeItem(ModToolMaterials.ECHOITE, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.ECHOITE, 6, -2.2f))));
    public static final Item ECHOITE_HOE = registerItem("echoite_hoe",
            new HoeItem(ModToolMaterials.ECHOITE, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.ECHOITE, 0, -3f))));



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
