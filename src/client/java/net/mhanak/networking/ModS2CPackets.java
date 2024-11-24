package net.mhanak.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.mhanak.LCEnemiesMod;
import net.mhanak.entity.LCEntity;
import net.mhanak.sound.ClientMovingEntitySounds;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;

public class ModS2CPackets {
    public static void initialiseRecievers() {
        LCEnemiesMod.LOGGER.info("Initialising Receivers (Client Side)");
        ClientPlayNetworking.registerGlobalReceiver(StartMovingSoundPayload.ID, (payload, context) -> context.client().execute(() -> ClientMovingEntitySounds.startSound(payload.sound(), payload.entityId(), payload.volume(), payload.pitch())));
        ClientPlayNetworking.registerGlobalReceiver(StopMovingSoundPayload.ID, (payload, context) -> context.client().execute(() -> ClientMovingEntitySounds.stopSound(payload.sound(), payload.entityId())));

        ClientPlayNetworking.registerGlobalReceiver(SetEntityFacingPayload.ID, (payload, context) -> context.client().execute(() -> {
            assert MinecraftClient.getInstance().world != null;
            Entity bracken = MinecraftClient.getInstance().world.getEntityById(payload.entityID());
            Entity player = MinecraftClient.getInstance().world.getEntityById(payload.playerID());

            if (bracken instanceof LCEntity) {
                if (payload.playerID() == -1){
                    ((LCEntity) bracken).facingPlayer = null;
                } else if (player instanceof PlayerEntity) {
                    ((LCEntity) bracken).facingPlayer = (PlayerEntity) player;
                }
            }
        }));
        ClientPlayNetworking.registerGlobalReceiver(SetEntityVisualStatePayload.ID, (payload, context) -> context.client().execute(() -> {
            assert MinecraftClient.getInstance().world != null;
            Entity entity = MinecraftClient.getInstance().world.getEntityById(payload.entityID());
            if (entity instanceof LCEntity lcEntity) {
                lcEntity.setVisualState(payload.state());
            }
        }));
    }
}
