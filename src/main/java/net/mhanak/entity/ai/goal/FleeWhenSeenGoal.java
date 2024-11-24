package net.mhanak.entity.ai.goal;

import net.mhanak.entity.LCEntity;
import net.minecraft.entity.ai.NoPenaltyTargeting;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class FleeWhenSeenGoal extends Goal {

    protected final LCEntity mob;
    protected final float distance;
    @Nullable
    protected Path fleePath;
    protected final EntityNavigation fleeingEntityNavigation;
    private final float speed;
    protected PlayerEntity entityToFleeFrom;

    public FleeWhenSeenGoal(
            LCEntity mob,
            float distance,
            float speed
    ) {
        this.mob = mob;
        this.distance = distance;
        this.speed = speed;
        this.fleeingEntityNavigation = mob.getNavigation();
        this.setControls(EnumSet.of(Goal.Control.MOVE));
    }

    @Override
    public boolean canStart() {
        entityToFleeFrom = this.mob.isBeingLookedAtBy(distance);
        return startFleeing();
    }

    protected boolean startFleeing() {

        if (entityToFleeFrom != null) {
            Vec3d vec3d = NoPenaltyTargeting.findFrom(this.mob, 16, 7, entityToFleeFrom.getPos());
            if (vec3d == null) {
                return false;
            } else if (entityToFleeFrom.squaredDistanceTo(vec3d.x, vec3d.y, vec3d.z) < entityToFleeFrom.squaredDistanceTo(this.mob)) {
                return false;
            } else {
                this.fleePath = this.fleeingEntityNavigation.findPathTo(vec3d.x, vec3d.y, vec3d.z, 1);
                return this.fleePath != null;
            }
        }
        return false;
    }

    @Override
    public boolean shouldContinue() {
        return !this.fleeingEntityNavigation.isIdle();
    }

    @Override
    public void start() {
        mob.setVisualState("fleeing");
        this.fleeingEntityNavigation.startMovingAlong(this.fleePath, this.speed);
    }

    @Override
    public void tick() {
        this.mob.getNavigation().setSpeed(this.speed);
    }
}
