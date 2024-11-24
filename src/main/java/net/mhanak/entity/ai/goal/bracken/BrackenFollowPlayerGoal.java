package net.mhanak.entity.ai.goal.bracken;

import net.mhanak.entity.BrackenEntity;
import net.mhanak.entity.ai.goal.FollowPlayerGoal;

public class BrackenFollowPlayerGoal extends FollowPlayerGoal {
    public BrackenFollowPlayerGoal(BrackenEntity entity, double speed, float range, float stopRange, boolean needsToSeePlayer) {
        super(entity, speed, range, stopRange, needsToSeePlayer);
    }

    @Override
    public boolean canStart() {
        if (((BrackenEntity) mob).runningTimer > 0 || ((BrackenEntity) mob).isStaredown || ((BrackenEntity) mob).isAngry) return false;
        return super.canStart();
    }

    @Override
    public void start() {
        //System.out.println("BrackenFollowPlayerGoal start");
        super.start();
    }

    @Override
    public void stop() {
        //System.out.println("BrackenFollowPlayerGoal stop");
        super.stop();
    }

    @Override
    public void tick() {
        super.tick();
    }
}
