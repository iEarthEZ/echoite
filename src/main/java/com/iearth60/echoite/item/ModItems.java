package com.iearth60.echoite.item;

import com.iearth60.echoite.Echoite;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    //Items
    public static final Item ECHOITE = registerItem("echoite", new Item(new Item.Settings()));
    public static final Item RAW_ECHOITE = registerItem("raw_echoite", new Item(new Item.Settings()));

    //Tools
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


    // Armor
    public static final Item ECHOITE_HELMET = registerItem("echoite_helmet",
            new ArmorItem(ModArmorMaterials.ECHOITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(37))));
    public static final Item ECHOITE_CHESTPLATE = registerItem("echoite_chestplate",
            new ArmorItem(ModArmorMaterials.ECHOITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(37))));
    public static final Item ECHOITE_LEGGINGS = registerItem("echoite_leggings",
            new ArmorItem(ModArmorMaterials.ECHOITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(37))));
    public static final Item ECHOITE_BOOTS = registerItem("echoite_boots",
            new ArmorItem(ModArmorMaterials.ECHOITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(37))));



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
