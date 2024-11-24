package net.mhanak.networking;

import net.mhanak.registry.ModPackets;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.sound.SoundEvent;

public record StartMovingSoundPayload(SoundEvent sound, int entityId, float volume, float pitch) implements CustomPayload {
    public static final CustomPayload.Id<StartMovingSoundPayload> ID = new CustomPayload.Id<>(ModPackets.MOVING_SOUND_START_ID);
    public static final PacketCodec<RegistryByteBuf, StartMovingSoundPayload> CODEC = PacketCodec.tuple(
            SoundEvent.PACKET_CODEC, StartMovingSoundPayload::sound,
            PacketCodecs.INTEGER, StartMovingSoundPayload::entityId,
            PacketCodecs.FLOAT, StartMovingSoundPayload::volume,
            PacketCodecs.FLOAT, StartMovingSoundPayload::pitch,
            StartMovingSoundPayload::new);
    @Override
    public CustomPayload.Id<? extends CustomPayload> getId() {
        return ID;
    }
}
