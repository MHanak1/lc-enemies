package net.mhanak.entity;

import net.mhanak.entity.ai.goal.FollowPlayerGoal;
import net.mhanak.entity.ai.goal.RoamGoal;
import net.mhanak.entity.ai.goal.WalkThroughDoorsGoal;
import net.mhanak.entity.ai.goal.coilhead.CoilheadDamagePlayerGoal;
import net.mhanak.registry.ModSoundEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.pathing.MobNavigation;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;

public class CoilheadEntity extends LCEntity {
    private boolean isFrozen = false;
    public int lastSeen = 0;

    public CoilheadEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world, true);
        ((MobNavigation)this.getNavigation()).setCanPathThroughDoors(true);
    }

    protected void initGoals() {
        viewRange = 50;
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(1, new WalkThroughDoorsGoal(this, 333) ); //333 ticks are around 16.67 seconds
        this.goalSelector.add(2, new CoilheadDamagePlayerGoal(this, 0.1f, 18, null));
        this.goalSelector.add(3, new FollowPlayerGoal(this, 0.8, 30, 0, true));
        this.goalSelector.add(5, new RoamGoal(this, 0.4));
    }

    @Override
    public boolean isCollidable() {
        return true;
    }

    @Override
    public SoundEvent getKillSound() {
        return ModSoundEvents.ENTITY_COILHEAD_KILL;
    }

    @Override
    public SoundEvent getStepSound() {
        return ModSoundEvents.ENTITY_COILHEAD_MOVE;
    }

    @Override
    public SoundEvent getStopSound() {
        return ModSoundEvents.ENTITY_COILHEAD_STOP;
    }

    @Override
    String getDefaultVisualState() {
        return "roaming";
    }

    @Override
    public void tickMovement() {
        lastSeen++;
        PlayerEntity entity = isBeingLookedAtBy(50);
        if (entity != null) {
            if (lastSeen >= 3) {
                refreshPosition(); //sync the position between client and server
            }
            lastKnownPlayerPos = entity.getPos();
            lastSeen = 0;
        }
        if (lastSeen <= 3){
            if (!isFrozen) {
                playStopSound();
                /*
                for (Goal goal : this.goalSelector.getGoals()) {
                    if (goal instanceof FollowPlayerGoal followPlayerGoal) {
                        followPlayerGoal.canStart();
                    }
                }*/ //so there's this bug where if a coilhead sees a player, the player disappears, the coilhead reaches the place where the player was, and the player reappears the coilhead will not follow the player unless they look away
                    //this did not fix this bug
            }
            isFrozen = true;
            return;
        } else isFrozen = false;
        super.tickMovement();
    }

    @Override
    public boolean damage(ServerWorld world, DamageSource source, float amount) {
        return false;
    }
}
