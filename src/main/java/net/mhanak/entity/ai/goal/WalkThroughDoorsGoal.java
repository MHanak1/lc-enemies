package net.mhanak.entity.ai.goal;

import net.minecraft.entity.ai.goal.DoorInteractGoal;
import net.minecraft.entity.mob.MobEntity;

public class WalkThroughDoorsGoal extends DoorInteractGoal {
    private final int delayTicks;
    private int openingTime;

    public WalkThroughDoorsGoal(MobEntity mob, int delayTicks) {
        super(mob);
        this.mob = mob;
        this.delayTicks = delayTicks;
    }

    @Override
    public void start() {
        this.openingTime = 0;
        super.start();
    }

    @Override
    public void stop() {
        setDoorOpen(true);
    }

    @Override
    public boolean shouldContinue() {
        return super.shouldContinue() && openingTime < delayTicks;
    }

    @Override
    public void tick() {
        openingTime++;
        super.tick();
    }
}
