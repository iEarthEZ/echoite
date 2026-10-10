
package com.iearth60.echoite.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EchoiteBowItem extends BowItem {

    public EchoiteBowItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(
            World world, net.minecraft.entity.player.PlayerEntity user, Hand hand) {

        ItemStack stack = user.getStackInHand(hand);
        user.setCurrentHand(hand);

        return TypedActionResult.success(stack, world.isClient);
    }

    @Override
    public void onStoppedUsing(
            ItemStack stack, World world, LivingEntity user,
            int remainingUseTicks) {

        if (world.isClient) {
            return;
        }

        int charge = this.getMaxUseTime(stack, user) - remainingUseTicks;
        float pull = BowItem.getPullProgress(charge);

        if (pull < 0.1F) {
            return;
        }

        Vec3d direction = user.getRotationVec(1.0F);

        FireballEntity fireball = new FireballEntity(
                world,
                user,
                direction.multiply(0.1),
                1
        );

        fireball.setPosition(
                user.getX() + direction.x * 1.5,
                user.getEyeY() + direction.y * 1.5,
                user.getZ() + direction.z * 1.5
        );

        fireball.setVelocity(
                direction.x * 1.5,
                direction.y * 1.5,
                direction.z * 1.5
        );

        world.spawnEntity(fireball);

        user.addVelocity(
                -direction.x * 0.35,
                0.08,
                -direction.z * 0.35
        );

        user.velocityModified = true;
    }
}
