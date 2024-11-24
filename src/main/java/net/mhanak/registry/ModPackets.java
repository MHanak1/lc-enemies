package net.mhanak.registry;

import net.mhanak.LCEnemiesMod;
import net.mhanak.networking.SetEntityFacingPayload;
import net.mhanak.networking.SetEntityVisualStatePayload;
import net.mhanak.networking.StartMovingSoundPayload;
import net.mhanak.networking.StopMovingSoundPayload;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.minecraft.util.Identifier;

public class ModPackets {
    //S2C
    public static final Identifier MOVING_SOUND_START_ID = LCEnemiesMod.path("moving_sound_start");
    public static final Identifier MOVING_SOUND_STOP_ID = LCEnemiesMod.path("moving_sound_stop");
    public static final Identifier SET_BRACKEN_FACING_ID = LCEnemiesMod.path("set_bracken_facing");
    public static final Identifier SET_ENTITY_VISUAL_STATE = LCEnemiesMod.path("set_entity_visual_state");

    public static void initialiseRecievers() {
        LCEnemiesMod.LOGGER.info("Initialising Recievers (Common Side)");
        PayloadTypeRegistry.playS2C().register(StartMovingSoundPayload.ID, StartMovingSoundPayload.CODEC);
        PayloadTypeRegistry.playS2C().register(StopMovingSoundPayload.ID, StopMovingSoundPayload.CODEC);
        PayloadTypeRegistry.playS2C().register(SetEntityFacingPayload.ID, SetEntityFacingPayload.CODEC);
        PayloadTypeRegistry.playS2C().register(SetEntityVisualStatePayload.ID, SetEntityVisualStatePayload.CODEC);
    }
}
