package net.mhanak.entity.ai.goal.bracken;

import net.mhanak.entity.BrackenEntity;
import net.mhanak.entity.ai.goal.FollowPlayerGoal;

public class BrackenChasePlayerGoal extends FollowPlayerGoal {

    public BrackenChasePlayerGoal(BrackenEntity entity, double speed, float range, boolean needsToSeePlayer) {
        super(entity, speed, range, 0, needsToSeePlayer);
    }

    @Override
    public boolean canStart() {
        if (!((BrackenEntity)mob).isAngry) return false;
        return super.canStart();
    }

    @Override
    public boolean shouldContinue() {
        return ((BrackenEntity) mob).anger > 0;
    }

    @Override
    public void start() {
        ((BrackenEntity) mob).setVisualState("chasing");
        ((BrackenEntity) mob).startAngrySound();
        ((BrackenEntity) mob).timesSeen = 1;
        //System.out.println("BrackenChasePlayerGoal start");
        if (((BrackenEntity) mob).anger > 100) {
            ((BrackenEntity) mob).anger = 100;
        }
        super.start();
    }

    @Override
    public void stop() {
        //System.out.println("BrackenChasePlayerGoal stop");
        //((AbstractBrackenEntity) mob).anger = 0;
        if (((BrackenEntity) mob).anger <= 0 ) {
            ((BrackenEntity) mob).isAngry = false;
            ((BrackenEntity)mob).stopAngrySound();
        }
        super.stop();
    }

    @Override
    public void tick() {
        ((BrackenEntity) mob).anger -= 1;
        super.tick();
    }
}
