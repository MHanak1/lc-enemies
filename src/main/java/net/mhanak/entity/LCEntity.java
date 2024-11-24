package net.mhanak.entity;

import net.mhanak.entity.ai.goal.item.LCItem;
import net.mhanak.networking.SetEntityFacingPayload;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.mhanak.networking.SetEntityVisualStatePayload;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ShovelItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.DoubleSupplier;
import java.util.function.Predicate;

public abstract class LCEntity extends PathAwareEntity {
    private final Predicate<LivingEntity> playerPredicate = PlayerEntity.NOT_WEARING_GAZE_DISGUISE_PREDICATE;
    public float viewRange;
    public final boolean isInvisible;
    public PlayerEntity facingPlayer;
    public Vec3d lastKnownPlayerPos;
    protected String visualState;
    @Environment(EnvType.CLIENT)

    protected LCEntity(EntityType<? extends PathAwareEntity> entityType, World world, boolean isInvincible) {
        super(entityType, world);
        this.isInvisible = isInvincible;
        this.visualState=getDefaultVisualState();
    }


    //A fairly hacky way to make the entity face the facingPlayer
    @Override
    public void setYaw(float yaw) {
        if (this.getWorld().isClient && facingPlayer != null) {
            Entity targetEntity = this.facingPlayer;
            double d = targetEntity.getX() - this.getX();
            double e = targetEntity.getZ() - this.getZ();

            double f = targetEntity.getEyeY() - this.getEyeY();

            double g = Math.sqrt(d * d + e * e);
            float h = (float)(MathHelper.atan2(e, d) * 180.0F / (float)Math.PI) - 90.0F;
            float i = (float)(-(MathHelper.atan2(f, g) * 180.0F / (float)Math.PI));
            super.setYaw(h);
            return;
        };
        super.setYaw(yaw);
    }

    @Override
    public boolean damage(ServerWorld world, DamageSource source, float amount) {
        if (source.getAttacker() instanceof PlayerEntity playerEntity) {
            if (playerEntity.getMainHandStack().getItem() instanceof ShovelItem)
                return super.damage(world, source, 1);
            else if (playerEntity.getMainHandStack().getItem() instanceof LCItem || source.isSourceCreativePlayer()) {
                return super.damage(world, source, amount);
            }
        }
        return false;
    }

    @Override
    public SoundCategory getSoundCategory() {
        return SoundCategory.HOSTILE;
    }

    public SoundEvent getAttackSound () {
        return null;
    }

    public SoundEvent getKillSound () {
        return null;
    }

    public SoundEvent getStunSound() {
        return null;
    }

    public SoundEvent getStepSound() {
        return null;
    }

    public SoundEvent getStopSound() {
        return null;
    }


    public void playAttackSound() {
        playAttackSound(1, 1);
    }

    public void playAttackSound(float volume, float pitch){
        if (this.getAttackSound() != null) {
            this.playSound(this.getAttackSound(), volume, pitch);
        }
    }

    public void playKillSound() {
        playKillSound(1, 1);
    }

    public void playKillSound(float volume, float pitch){
        if (this.getKillSound() != null) {
            this.playSound(this.getKillSound(), volume, pitch);
        } else {
            playAttackSound(volume, pitch);
        }
    }

    public void playStunSound() {
        playStunSound(1, 1);
    }

    public void playStunSound(float volume, float pitch){
        if (this.getStunSound() != null) {
            this.playSound(this.getStunSound(), volume, pitch);
        }
    }

    public void playStopSound() {
        this.playStopSound(1, 1);
    }

    public void playStopSound(float volume, float pitch){
        if (this.getStopSound() != null) {
            this.playSound(this.getStopSound(), volume, pitch);
        }
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        if (getStepSound() != null) {
            BlockSoundGroup blockSoundGroup = state.getSoundGroup();
            this.playSound(getStepSound(), blockSoundGroup.getVolume(), blockSoundGroup.getPitch());
        }
    }

    public boolean isBeingLookedAt(float range) {
        return isBeingLookedAtBy(range) != null;
    }

    @Override
    protected SoundEvent getSwimSound() {
        return super.getSwimSound();
    }

    @Override
    public boolean cannotDespawn() {
        return true;
    }

    public PlayerEntity isBeingLookedAtBy(float range){
        List<Entity> players = this.getWorld().getOtherEntities(this, Box.from(this.getPos()).expand(range));
        for (Entity entity : players) {
            if (entity instanceof PlayerEntity) {
                if (this.isEntityLookingAtMe(
                        (LivingEntity) entity, 0.5, false, true, playerPredicate, new DoubleSupplier[]{this::getEyeY, this::getY, () -> (this.getEyeY() + this.getY()) / 2.0}
                )) return (PlayerEntity) entity;
            }
        }
        return null;
    }

    public static DefaultAttributeContainer.Builder createMobAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.KNOCKBACK_RESISTANCE, 1000);
    }

    abstract String getDefaultVisualState();

    public String getVisualState() {
        return this.visualState;
    }

    public void setFacingPlayer(@Nullable PlayerEntity playerToLookAt){
        this.facingPlayer = playerToLookAt;

        if (getWorld().isClient) return;

        for (ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) getWorld(), this.getChunkPos())) {
            ServerPlayNetworking.send(player, new SetEntityFacingPayload(this.getId(), (playerToLookAt == null ? -1 : playerToLookAt.getId())));
        }
    }

    public void setVisualState(@Nullable String state) {
        if (state == null) state = getDefaultVisualState();
        this.visualState = state;

        if (this.getWorld().isClient) return;

        for (ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) getWorld(), this.getChunkPos())) {
                ServerPlayNetworking.send(player, new SetEntityVisualStatePayload(this.getId(), state));
        }
    }
}
