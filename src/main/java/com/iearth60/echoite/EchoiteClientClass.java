package com.iearth60.echoite;

import com.iearth60.echoite.block.ModBlocks;
import com.iearth60.echoite.util.ModModelPredicates;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class EchoiteClientClass implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModModelPredicates.registerModelPredicates();

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ECHOI_BERRY_BUSH, RenderLayer.getCutout());
    }
}
