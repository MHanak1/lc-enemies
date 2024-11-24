package net.mhanak.registry;

import net.mhanak.LCEnemiesMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSoundEvents {
    public static final SoundEvent ENTITY_BRACKEN_SEEN = register("entity.bracken.seen");
    public static final SoundEvent ENTITY_BRACKEN_KILL = register("entity.bracken.kill");
    public static final SoundEvent ENTITY_BRACKEN_STUN = register("entity.bracken.stun");
    public static final SoundEvent ENTITY_BRACKEN_ANGRY = register("entity.bracken.angry");

    public static final SoundEvent ENTITY_COILHEAD_KILL = register("entity.coilhead.kill");
    public static final SoundEvent ENTITY_COILHEAD_MOVE = register("entity.coilhead.move");
    public static final SoundEvent ENTITY_COILHEAD_STOP = register("entity.coilhead.stop");


    private static SoundEvent register(String id) {
        Identifier identifier = LCEnemiesMod.path(id);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void registerSoundEvents() {
        LCEnemiesMod.LOGGER.info("Registering Sound Events");
    }
}
