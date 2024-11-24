package net.mhanak.entity.ai.goal;

import net.mhanak.entity.LCEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EnumSet;

public class FollowPlayerGoal extends Goal {
    private static final Logger log = LoggerFactory.getLogger(FollowPlayerGoal.class);
    private final TargetPredicate predicate;
    protected final LCEntity mob;
    private final double speed;
    @Nullable
    protected PlayerEntity closestPlayer;
    private boolean shouldStop = false;
    @Nullable
    private boolean active;
    private final float range;
    private final float stopRange;

    public FollowPlayerGoal(LCEntity mob, double speed, float range, float stopRange, boolean needsToSeePlayer) {
        this.mob = mob;
        this.speed = speed;
        this.range = range;
        this.stopRange = stopRange;
        this.setControls(EnumSet.of(Goal.Control.MOVE, Goal.Control.LOOK));
        this.predicate = (needsToSeePlayer? TargetPredicate.createNonAttackable() : TargetPredicate.createNonAttackable().ignoreVisibility()).copy().setPredicate((entity, world) -> true);
    }

    @Override
    public boolean canStart() {
        System.out.println(this.shouldStop);
        this.closestPlayer = getServerWorld(this.mob)
                .getClosestPlayer(this.predicate.setBaseMaxDistance(range), this.mob);
        if (this.closestPlayer != null) {
            shouldStop = false;
        }
        //System.out.println((this.closestPlayer == null ? "null" : "good") + " " + (lastKnownPlayerPos == null ? "null" : "good") + " " + this.lastKnownPlayerPos);
        return this.closestPlayer != null || (mob.lastKnownPlayerPos != null && !shouldStop);
    }

    @Override
    public void start() {
        mob.setVisualState("following");
        this.active = true;
    }

    @Override
    public void stop() {
        this.closestPlayer = null;
        //this.lastKnownPlayerPos = null;
        this.mob.getNavigation().stop();
        this.active = false;
    }

    @Override
    public void tick() {
        if (closestPlayer != null) {
            mob.lastKnownPlayerPos = closestPlayer.getPos();
            shouldStop = false;
            this.mob.getLookControl().lookAt(this.closestPlayer, (float) (this.mob.getMaxHeadRotation() + 20), (float) this.mob.getMaxLookPitchChange());
            if (this.mob.squaredDistanceTo(this.closestPlayer) < stopRange * stopRange) {
                this.mob.getNavigation().stop();
            } else {
                this.mob.getNavigation().startMovingTo(closestPlayer.getX(), closestPlayer.getY(), closestPlayer.getZ(), 0, this.speed);
            }
        }
        else if (mob.lastKnownPlayerPos != null) {
            this.mob.getNavigation().startMovingTo(mob.lastKnownPlayerPos.getX(), mob.lastKnownPlayerPos.getY(), mob.lastKnownPlayerPos.getZ(), 0, this.speed);
            if (this.mob.squaredDistanceTo(mob.lastKnownPlayerPos) < 1) {
                shouldStop = true;
            }
        }
    }

    public boolean isActive() {
        return this.active;
        }

}
