package net.mhanak.entity.ai.goal;

import net.mhanak.entity.LCEntity;
import net.minecraft.entity.ai.goal.Goal;

public class StopWhenSeenGoal extends Goal {
    private final LCEntity mob;
    private int ticksSeen = 0;

    public StopWhenSeenGoal(LCEntity mob) {
        this.mob = mob;
    }

    @Override
    public boolean canStart() {
        if (mob.isBeingLookedAt(50)){
            return ticksSeen++ < 3;
        }
        return false;
    }

    @Override
    public void start() {
        mob.setVisualState("stopped");
        this.mob.stopMovement();
        this.mob.getNavigation().stop();
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
    }
}
