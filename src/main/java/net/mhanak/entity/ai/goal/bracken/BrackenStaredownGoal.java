package net.mhanak.entity.ai.goal.bracken;

import net.mhanak.entity.BrackenEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;

public class BrackenStaredownGoal extends Goal {

    private final BrackenEntity mob;
    private int staringTicks;
    private PlayerEntity player;

    public BrackenStaredownGoal(BrackenEntity mob) {
        this.mob = mob;
    }

    @Override
    public void start() {
        //System.out.println("BrackenStaredownGoal start");
        this.mob.isStaredown = true;
        ((BrackenEntity) mob).setVisualState("staring");
        super.start();
    }

    @Override
    public void stop() {
        //System.out.println("BrackenStaredownGoal stop");
        this.mob.isStaredown = false;
        staringTicks = 0;
        if (mob.isBeingLookedAt(mob.viewRange)) {
            this.mob.tryBecomeAngry();
        }
        super.stop();
    }

    @Override
    public boolean canStart() {
        staringTicks = 0;
        if (mob.isAngry) return false;
        if (mob.runningTimer > 0 && mob.getRandom().nextInt(15) == 0) {
            player = this.mob.isBeingLookedAtBy(this.mob.viewRange);
            return player != null;
        }
        return false;
    }

    @Override
    public boolean shouldContinue() {
        if (mob.isAngry) return false;
        return staringTicks < 20;
    }

    @Override
    public void tick() {
        this.mob.getNavigation().stop();
        this.mob.rotate(mob.getHeadYaw(), 0);
        this.staringTicks++;
        if (!mob.isAngry && mob.isBeingLookedAt(mob.viewRange)) this.mob.anger++;
        super.tick();
    }
}
