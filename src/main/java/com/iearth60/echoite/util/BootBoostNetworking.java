package com.iearth60.echoite.util;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

public class BootBoostNetworking {

    public static void register() {
        PayloadTypeRegistry.playC2S().register(
                BootBoostPayload.ID,
                BootBoostPayload.CODEC
        );

        ServerPlayNetworking.registerGlobalReceiver(
                BootBoostPayload.ID,
                (payload, context) -> context.server().execute(() -> {
                    if (payload.boosting()) {
                        EchoiteEffects.startBoost(context.player());
                    } else {
                        EchoiteEffects.stopBoost(context.player());
                    }
                })
        );
    }
}
