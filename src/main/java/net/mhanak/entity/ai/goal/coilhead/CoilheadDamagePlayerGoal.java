package net.mhanak.entity.ai.goal.coilhead;

import net.mhanak.entity.CoilheadEntity;
import net.mhanak.entity.ai.goal.DamagePlayerGoal;
import net.minecraft.entity.damage.DamageSource;
import org.jetbrains.annotations.Nullable;

public class CoilheadDamagePlayerGoal extends DamagePlayerGoal {
    public CoilheadDamagePlayerGoal(CoilheadEntity mob, float range, float damage, @Nullable DamageSource damageSource) {
        super(mob, range, damage, damageSource);
    }

    @Override
    public boolean canStart() {
        if (((CoilheadEntity) this.mob).lastSeen < 3) return false;
        return super.canStart();
    }
}
