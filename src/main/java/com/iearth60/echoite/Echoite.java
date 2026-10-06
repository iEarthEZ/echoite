package com.iearth60.echoite;

import com.iearth60.echoite.block.ModBlocks;
import com.iearth60.echoite.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Echoite implements ModInitializer {
	public static final String MOD_ID = "echoite";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}
