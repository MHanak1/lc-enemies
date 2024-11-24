package net.mhanak.networking;

import net.mhanak.registry.ModPackets;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.sound.SoundEvent;

public record StopMovingSoundPayload(SoundEvent sound, int entityId) implements CustomPayload {
    public static final Id<StopMovingSoundPayload> ID = new Id<>(ModPackets.MOVING_SOUND_STOP_ID);
    public static final PacketCodec<RegistryByteBuf, StopMovingSoundPayload> CODEC = PacketCodec.tuple(
            SoundEvent.PACKET_CODEC, StopMovingSoundPayload::sound,
            PacketCodecs.INTEGER, StopMovingSoundPayload::entityId,
            StopMovingSoundPayload::new);
    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
