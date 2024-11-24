package net.mhanak.sound;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.sound.MovingSoundInstance;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.random.Random;


@Environment(EnvType.CLIENT)
public class MovingWithEntitySoundInstance extends MovingSoundInstance {
    public final Entity entity;

    public MovingWithEntitySoundInstance(SoundEvent soundEvent, Entity entity, float volume, float pitch) {
        super(soundEvent, (entity instanceof LivingEntity ? ((LivingEntity) entity).getSoundCategory() : SoundCategory.NEUTRAL), Random.create());
        this.entity = entity;
        this.attenuationType = AttenuationType.LINEAR;
    }

    @Override
    public boolean canPlay() {
        return !this.entity.isSilent();
    }

    @Override
    public void tick() {
        if (this.entity.isRemoved()) {
            this.setDone();
            return;
        }
        this.x = (float)this.entity.getX();
        this.y = (float)this.entity.getY();
        this.z = (float)this.entity.getZ();
    }
}
