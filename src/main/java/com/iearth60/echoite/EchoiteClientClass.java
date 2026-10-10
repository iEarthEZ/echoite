package com.iearth60.echoite;

import com.iearth60.echoite.block.ModBlocks;
import com.iearth60.echoite.item.ModItems;
import com.iearth60.echoite.util.BootBoostPayload;
import com.iearth60.echoite.util.ModModelPredicates;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.EquipmentSlot;

public class EchoiteClientClass implements ClientModInitializer {

    private static boolean lastBoosting = false;

    @Override
    public void onInitializeClient() {
        ModModelPredicates.registerModelPredicates();

        BlockRenderLayerMap.INSTANCE.putBlock(
                ModBlocks.ECHOI_BERRY_BUSH,
                RenderLayer.getCutout()
        );

        // Echoite Boots: hold Space to boost upward.
        ClientTickEvents.END_CLIENT_TICK.register(client -> {

            if (client.player == null
                    || client.getNetworkHandler() == null) {
                lastBoosting = false;
                return;
            }

            boolean hasBoots = client.player
                    .getEquippedStack(EquipmentSlot.FEET)
                    .isOf(ModItems.ECHOITE_BOOTS);

            boolean jumpHeld = client.options.jumpKey.isPressed();

            boolean shouldBoost = hasBoots
                    && jumpHeld
                    && (lastBoosting || client.player.isOnGround());

            if (shouldBoost != lastBoosting) {
                ClientPlayNetworking.send(
                        new BootBoostPayload(shouldBoost)
                );

                lastBoosting = shouldBoost;
            }
        });
    }
}