package net.mhanak.entity.ai.goal;

import net.mhanak.entity.LCEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DamagePlayerGoal extends Goal {
    protected Entity mob;
    private float range;
    private float damage;
    private DamageSource damageSource;

    public DamagePlayerGoal(Entity mob, float range, float damage, @Nullable DamageSource damageSource) {
        this.mob = mob;
        this.range = range;
        this.damage = damage;
        this.damageSource = (damageSource == null ? mob.getDamageSources().generic() : damageSource);
    }

    @Override
    public boolean canStart() {
        List<Entity> entities = mob.getWorld().getOtherEntities(this.mob, this.mob.getBoundingBox().expand(range));
        for (Entity entity : entities) {
            if (entity instanceof PlayerEntity && entity.isAlive() && !((PlayerEntity) entity).isCreative() && !this.mob.getWorld().isClient) {
                entity.damage((ServerWorld) this.mob.getWorld(), damageSource, damage);
                if (((PlayerEntity) entity).getHealth() > 0) {
                    ((LCEntity)mob).playAttackSound();
                }
                else {
                    ((LCEntity)mob).playKillSound();
                }
            }
        }
        return false;
    }
}
