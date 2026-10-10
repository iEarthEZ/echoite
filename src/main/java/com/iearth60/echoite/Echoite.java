package com.iearth60.echoite;

import com.iearth60.echoite.block.ModBlocks;
import com.iearth60.echoite.item.ModItemGroups;
import com.iearth60.echoite.item.ModItems;
import com.iearth60.echoite.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Echoite implements ModInitializer {
	public static final String MOD_ID = "echoite";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModWorldGeneration.generateModWorldGen();

		FuelRegistry.INSTANCE.add(ModItems.ECOALHITE, 2600);

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		CompostingChanceRegistry.INSTANCE.add(ModItems.ECHOI_BERRIES, 0.15f);
	}
}
