package net.mhanak.entity.ai.goal;

import net.mhanak.entity.LCEntity;
import net.minecraft.entity.ai.goal.Goal;

public class LookForPlayerWhereLastSeenGoal extends Goal {

    private LCEntity mob;

    public LookForPlayerWhereLastSeenGoal(LCEntity mob) {
        this.mob = mob;
    }
    @Override
    public boolean canStart() {
        return mob.lastKnownPlayerPos != null;
    }
}
