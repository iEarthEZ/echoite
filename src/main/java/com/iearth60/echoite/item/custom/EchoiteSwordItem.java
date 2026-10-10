package com.iearth60.echoite.item.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.particle.ParticleTypes;

public class EchoiteSwordItem extends SwordItem {

    public EchoiteSwordItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    @Override
    public boolean postHit(
            ItemStack stack,
            LivingEntity target,
            LivingEntity attacker) {

        if (attacker.getWorld() instanceof ServerWorld world) {

            strikeWithLightning(world, target);

            target.damage(world.getDamageSources().magic(), 3.0F);

            var nearbyEntities = world.getEntitiesByClass(
                    LivingEntity.class,
                    target.getBoundingBox().expand(4.0),
                    entity -> entity.isAlive()
                            && entity != target
                            && entity != attacker
            );

            for (LivingEntity nearby : nearbyEntities) {
                strikeWithLightning(world, nearby);
                nearby.damage(world.getDamageSources().magic(), 3.0F);
            }
            if (target.isDead()) {
                world.spawnParticles(
                        ParticleTypes.END_ROD,
                        target.getX(),
                        target.getBodyY(0.5),
                        target.getZ(),
                        25,
                        0.35, 0.4, 0.35,
                        0.08
                );
            }

        }

        return super.postHit(stack, target, attacker);
    }

    private void strikeWithLightning(
            ServerWorld world,
            LivingEntity target) {

        LightningEntity lightning =
                EntityType.LIGHTNING_BOLT.create(world);

        if (lightning != null) {
            lightning.refreshPositionAfterTeleport(
                    target.getX(),
                    target.getY(),
                    target.getZ()
            );

            lightning.setCosmetic(true);
            world.spawnEntity(lightning);
        }
    }
}
