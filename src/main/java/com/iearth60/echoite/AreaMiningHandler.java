package com.iearth60.echoite;

import com.iearth60.echoite.item.ModItems;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.BlockState;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class AreaMiningHandler {

    private static final Set<UUID> ACTIVE_MINERS = new HashSet<>();

    public static void register() {
        PlayerBlockBreakEvents.AFTER.register(
                (world, player, pos, state, blockEntity) -> {

                    if (!(player instanceof ServerPlayerEntity serverPlayer)) {
                        return;
                    }

                    UUID playerId = player.getUuid();

                    if (ACTIVE_MINERS.contains(playerId)) {
                        return;
                    }

                    if (player.isSneaking()) {
                        return;
                    }

                    var tool = player.getStackInHand(Hand.MAIN_HAND);

                    if (!tool.isOf(ModItems.ECHOITE_PICKAXE)) {
                        return;
                    }

                    Vec3d look = player.getRotationVec(1.0F);

                    double x = Math.abs(look.x);
                    double y = Math.abs(look.y);
                    double z = Math.abs(look.z);

                    ACTIVE_MINERS.add(playerId);

                    try {
                        for (int a = -1; a <= 1; a++) {
                            for (int b = -1; b <= 1; b++) {

                                if (a == 0 && b == 0) {
                                    continue;
                                }

                                BlockPos target;

                                if (y >= x && y >= z) {
                                    target = pos.add(a, 0, b);
                                } else if (x >= z) {
                                    target = pos.add(0, a, b);
                                } else {
                                    target = pos.add(a, b, 0);
                                }

                                BlockState targetState =
                                        world.getBlockState(target);

                                if (targetState.isAir()) {
                                    continue;
                                }

                                if (!tool.isSuitableFor(targetState)) {
                                    continue;
                                }
                                serverPlayer.interactionManager
                                        .tryBreakBlock(target);
                            }
                        }
                    } finally {
                        ACTIVE_MINERS.remove(playerId);
                    }
                }
        );
    }
}
