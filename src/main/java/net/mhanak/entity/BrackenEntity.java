package net.mhanak.entity;

import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.mhanak.entity.ai.goal.DamagePlayerGoal;
import net.mhanak.entity.ai.goal.WalkThroughDoorsGoal;
import net.mhanak.entity.ai.goal.bracken.BrackenChasePlayerGoal;
import net.mhanak.entity.ai.goal.bracken.BrackenFleeWhenSeenGoal;
import net.mhanak.entity.ai.goal.bracken.BrackenFollowPlayerGoal;
import net.mhanak.entity.ai.goal.bracken.BrackenStaredownGoal;
import net.mhanak.networking.StartMovingSoundPayload;
import net.mhanak.networking.StopMovingSoundPayload;
import net.mhanak.registry.ModSoundEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.pathing.MobNavigation;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;

public class BrackenEntity extends LCEntity {
    public int runningTimer = 0;
    public int anger = 0;
    public int timesSeen = 0;
    public boolean isStaredown = false;
    public boolean isAngry = false;

    public BrackenEntity(EntityType<? extends LCEntity> entityType, World world) {
        super(entityType, world, false);
        ((MobNavigation)this.getNavigation()).setCanPathThroughDoors(true);

    }

    protected void initGoals() {
        viewRange = 50;
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(0, new WalkThroughDoorsGoal(this, 20) );
        this.goalSelector.add(0, new DamagePlayerGoal(this, 0.1f, 9999f, null));
        this.goalSelector.add(1, new BrackenChasePlayerGoal(this, 0.6, viewRange, false));
        this.goalSelector.add(2, new BrackenStaredownGoal(this));
        this.goalSelector.add(3, new BrackenFleeWhenSeenGoal(this, viewRange, 0.5f));
        this.goalSelector.add(4, new BrackenFollowPlayerGoal(this, 0.5, 400, 0, false));
        //this.goalSelector.add(5, new WanderAroundGoal(this, 0.4, 1));
    }


    @Override
    public int getMaxLookPitchChange() {
        return 180;
    }

    @Override
    public int getMaxLookYawChange() {
        return 180;
    }

    public SoundEvent getKillSound() {
        return ModSoundEvents.ENTITY_BRACKEN_KILL;
    }

    @Override
    public SoundEvent getStunSound() {
        return ModSoundEvents.ENTITY_BRACKEN_STUN;
    }

    @Override
    String getDefaultVisualState() {
        return "following";
    }

    public void playSeenSound() {
        playSeenSound(1, 1);
    }

    public void playSeenSound(float volume, float pitch){
        this.playSound(ModSoundEvents.ENTITY_BRACKEN_SEEN, volume, pitch);
    }

    public void startAngrySound() {
        if (getWorld().isClient) return;

        for (ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) getWorld(), this.getChunkPos())) {
            ServerPlayNetworking.send(player, new StartMovingSoundPayload(ModSoundEvents.ENTITY_BRACKEN_ANGRY, this.getId(), 1, 1));
        }
    }

    public void stopAngrySound() {
        if (getWorld().isClient) return;

        for (ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) getWorld(), this.getChunkPos())) {
            ServerPlayNetworking.send(player, new StopMovingSoundPayload(ModSoundEvents.ENTITY_BRACKEN_ANGRY, this.getId()));
        }
    }


    public void setAnger(int anger) {
        this.anger = anger;
    }

    public int getAnger() {
        return this.anger;
    }

    public void setRunningTimer(int runningTimer) {
        this.runningTimer = runningTimer;
    }

    public int getRunningTimer() {
        return this.runningTimer;
    }

    public boolean tryBecomeAngry(){
        if (this.random.nextInt(100) < anger){
            this.isAngry = true;
            return true;
        }
        return false;
    }

    public boolean decrementRunningTimer(){
        if (this.runningTimer > 0){
            runningTimer--;
            return true;
        }
        return false;
    }

    @Override
    public boolean damage(ServerWorld world, DamageSource source, float amount) {
        if (source.getAttacker() instanceof PlayerEntity) {
            this.anger = 100;
            this.isAngry = true;
        }
        return super.damage(world, source, amount);
    }

    @Override
    public void tick() {
        if (this.getWorld().isClient && facingPlayer != null) {
            setYaw(0);
        }
        decrementRunningTimer();
        super.tick();
    }
}
