package com.iearth60.echoite;

import com.iearth60.echoite.util.ModModelPredicates;
import net.fabricmc.api.ClientModInitializer;

public class EchoiteClientClass implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModModelPredicates.registerModelPredicates();
    }
}
