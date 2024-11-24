package net.mhanak.entity.ai.goal.bracken;

import net.mhanak.entity.BrackenEntity;
import net.mhanak.entity.ai.goal.FleeWhenSeenGoal;

public class BrackenFleeWhenSeenGoal extends FleeWhenSeenGoal {
    public BrackenFleeWhenSeenGoal(BrackenEntity mob, float distance, float speed) {
        super(mob, distance, speed);
    }

    @Override
    public boolean canStart() {
        if (((BrackenEntity) mob).isStaredown || ((BrackenEntity) mob).isAngry) return false;
        if (((BrackenEntity) mob).getRunningTimer() > 0){
            return startFleeing();
        }
        entityToFleeFrom = this.mob.isBeingLookedAtBy(distance);
        return startFleeing();
    }

    @Override
    public boolean shouldContinue() {
        if (((BrackenEntity) mob).isStaredown || ((BrackenEntity) mob).isAngry || ((BrackenEntity)mob).runningTimer <= 0) return false;
        return super.shouldContinue();
    }

    @Override
    protected boolean startFleeing() {
        return super.startFleeing();
    }

    @Override
    public void start() {
        //System.out.println("BrackenFleeWhenSeenGoal start");
        mob.setFacingPlayer(entityToFleeFrom);
        if (((BrackenEntity) mob).getRunningTimer() == 0) {
            ((BrackenEntity) mob).playSeenSound();
            ((BrackenEntity) mob).setAnger(((BrackenEntity) mob).getAnger() + 20 * ((BrackenEntity) mob).timesSeen);
            ((BrackenEntity) mob).timesSeen++;
        }
        super.start();
    }

    @Override
    public void stop() {
        //System.out.println("BrackenFleeWhenSeenGoal stop");
        if (!((BrackenEntity) mob).isStaredown) {
            (mob).setFacingPlayer(null);
        }
        super.stop();
    }

    @Override
    public void tick() {
        //System.out.println("flee timer: " + ((BrackenEntity) mob).getRunningTimer());
        if (mob.isBeingLookedAt(distance)){
            ((BrackenEntity) mob).setRunningTimer(23*20);
        }
        super.tick();
        mob.lookAtEntity(entityToFleeFrom, mob.getMaxLookYawChange(), mob.getMaxLookPitchChange());
    }
}
