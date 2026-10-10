package com.iearth60.echoite.util;

import com.iearth60.echoite.Echoite;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record BootBoostPayload(boolean boosting)
        implements CustomPayload {

    public static final Id<BootBoostPayload> ID =
            new Id<>(Identifier.of(Echoite.MOD_ID, "boot_boost"));

    public static final PacketCodec<PacketByteBuf, BootBoostPayload> CODEC =
            PacketCodec.of((payload, buf) -> buf.writeBoolean(payload.boosting()), buf -> new BootBoostPayload(buf.readBoolean()));

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
