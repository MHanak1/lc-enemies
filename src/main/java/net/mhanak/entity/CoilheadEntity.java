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
    public boolean isFrozen = false;
    public boolean isRecharging = false;
    public float rechargeTimer = 0;
    public int timeVisible = 3;
    float rechargeTime = 15*20; //it takes following the player for 10 seconds

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
        return !this.isRecharging;
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
        if (rechargeTimer > rechargeTime || isRecharging) {
            if (!isRecharging){
                this.velocityDirty = true;
                this.resetPosition();
                isRecharging = true;
            }
            setVisualState("recharging");
            rechargeTimer -= rechargeTime/300; //15s * 20 ticks

            if (rechargeTimer <= 0) {
                isRecharging = false;
            }
            else if (!this.getWorld().isClient) {
                return;
            }
        }
        else {
            PlayerEntity entity = isBeingLookedAtBy(50);

            if (entity != null) {
                lastKnownPlayerPos = entity.getPos();
                timeVisible++;
            }
            else timeVisible = 0;
            if (timeVisible > 1) {
                if (!isFrozen) {
                    playStopSound();
                    this.velocityDirty = true;
                    this.resetPosition();
                }
                isFrozen = true;
                if (!this.getWorld().isClient) {
                    return;
                }
            } else {
                // /* //recharge phase is disabled for now since it desynchronises between client and server, and i'd have to write custom networking to fix that
                if (getVisualState().equals("following")) {
                    rechargeTimer++;
                }
                // */
                isFrozen = false;
            }
        }
        super.tickMovement();
    }

    @Override
    public boolean damage(ServerWorld world, DamageSource source, float amount) {
        return false;
    }
}
