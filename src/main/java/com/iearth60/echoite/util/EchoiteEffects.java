package com.iearth60.echoite.util;

import com.iearth60.echoite.item.ModItems;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Vec3d;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EchoiteEffects {

    private static final Map<UUID, Double> BOOST_START_Y =
            new HashMap<>();

    public static void register() {
        ServerTickEvents.END_WORLD_TICK.register(world -> {
            for (ServerPlayerEntity player : world.getPlayers()) {

                boolean hasBoots = player
                        .getEquippedStack(EquipmentSlot.FEET)
                        .isOf(ModItems.ECHOITE_BOOTS);

                UUID id = player.getUuid();
                Double startY = BOOST_START_Y.get(id);

                if (!hasBoots) {
                    stopBoost(player);
                    continue;
                }

                Vec3d velocity = player.getVelocity();

                if (player.age % 3 == 0
                        && player.isOnGround()
                        && velocity.horizontalLengthSquared() > 0.0025) {

                    double trailX = player.getX() - velocity.x * 1.5;
                    double trailZ = player.getZ() - velocity.z * 1.5;

                    world.spawnParticles(
                            ParticleTypes.SOUL,
                            trailX,
                            player.getY() + 0.12,
                            trailZ,
                            3,
                            0.12, 0.04, 0.12,
                            0.01
                    );
                }

                if (startY == null) {
                    continue;
                }

                if (player.getY() >= startY + 3.0) {
                    stopBoost(player);
                    continue;
                }

                player.setVelocity(
                        velocity.x,
                        0.23,
                        velocity.z
                );
                player.velocityModified = true;

                world.spawnParticles(
                        ParticleTypes.SOUL,
                        player.getX(),
                        player.getY() + 0.15,
                        player.getZ(),
                        4,
                        0.18, 0.08, 0.18,
                        0.02
                );
            }
        });
    }

    public static void startBoost(ServerPlayerEntity player) {
        if (!player.getEquippedStack(EquipmentSlot.FEET)
                .isOf(ModItems.ECHOITE_BOOTS)) {
            return;
        }

        BOOST_START_Y.putIfAbsent(
                player.getUuid(),
                player.getY()
        );
    }

    public static void stopBoost(ServerPlayerEntity player) {
        Double startY = BOOST_START_Y.remove(player.getUuid());

        if (startY != null) {
            Vec3d velocity = player.getVelocity();

            player.setVelocity(velocity.x, 0.0, velocity.z);
            player.velocityModified = true;
        }
    }
}
