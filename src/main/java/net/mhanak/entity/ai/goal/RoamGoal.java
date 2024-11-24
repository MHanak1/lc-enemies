package net.mhanak.entity.ai.goal;

import net.mhanak.entity.LCEntity;
import net.minecraft.entity.ai.goal.WanderAroundGoal;

public class RoamGoal extends WanderAroundGoal {

    public RoamGoal(LCEntity mob, double speed) {
        super(mob, speed, 1);
    }

    @Override
    public void start() {
        ((LCEntity) mob).setVisualState("roaming");
        super.start();
    }
}
