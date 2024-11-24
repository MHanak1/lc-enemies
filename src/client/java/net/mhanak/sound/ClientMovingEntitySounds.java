package net.mhanak.sound;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.sound.SoundEvent;

import java.util.ArrayList;
import java.util.List;

public class ClientMovingEntitySounds {
    private static final List<MovingWithEntitySoundInstance> soundEvents = new ArrayList<>();

    public static void startSound(SoundEvent sound, int entityID, float volume, float pitch) {
        assert MinecraftClient.getInstance().world != null;
        Entity entity = MinecraftClient.getInstance().world.getEntityById(entityID);

        MovingWithEntitySoundInstance newInstance = getEntitySoundInstance(entityID, sound);

        if (entity == null) {
            if (newInstance != null) {
                soundEvents.remove(newInstance);
            }
            return;
        }

        if (newInstance == null) {
            newInstance = new MovingWithEntitySoundInstance(sound, entity, volume, pitch);
            soundEvents.add(newInstance);
            MinecraftClient.getInstance().getSoundManager().play(newInstance);
        } else if (newInstance.isDone()){
            //hope this doesn't cause a memory leak
            soundEvents.remove(newInstance);
            newInstance = new MovingWithEntitySoundInstance(sound, entity, volume, pitch);
            soundEvents.add(newInstance);
            MinecraftClient.getInstance().getSoundManager().play(newInstance);
        }

        //System.out.println("Added sound with id:" + sound.id());
    }

    public static void stopSound(SoundEvent sound, int entityID) {
        //System.out.println("Removing sound with id:" + sound.id());
        MovingWithEntitySoundInstance instance = getEntitySoundInstance(entityID, sound);

        if (instance != null) {
            //System.out.println("Removed sound with id:" + sound.id());
            MinecraftClient.getInstance().getSoundManager().stop(instance);
            soundEvents.remove(instance);
        } else {
            //System.out.println("No sound with id: " + sound.id());
        }
    }

    private static MovingWithEntitySoundInstance getEntitySoundInstance(int entityID, SoundEvent sound) {
        //System.out.println("Sounds for this entity:");
        for (MovingWithEntitySoundInstance soundInstance : soundEvents) {
            if (soundInstance.entity.getId() == entityID) {
                //System.out.println("Entity: " + soundInstance.entity.getName() + ", ID: " + soundInstance.entity.getId() + ", SoundInstance ID: " + soundInstance.getId());
                if (soundInstance.getId().equals(sound.id())){
                    return soundInstance;
                }
            }
            if (soundInstance.isDone()) {
                soundEvents.remove(soundInstance);
            }
        }
        return null;
    }
}
