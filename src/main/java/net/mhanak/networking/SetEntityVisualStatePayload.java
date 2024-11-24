package net.mhanak.networking;

import net.mhanak.registry.ModPackets;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;

public record SetEntityVisualStatePayload(int entityID, String state) implements CustomPayload {
    public static final Id<SetEntityVisualStatePayload> ID = new Id<>(ModPackets.SET_ENTITY_VISUAL_STATE);
    public static final PacketCodec<RegistryByteBuf, SetEntityVisualStatePayload> CODEC = PacketCodec.tuple(
            PacketCodecs.INTEGER, SetEntityVisualStatePayload::entityID,
            PacketCodecs.STRING, SetEntityVisualStatePayload::state,
            SetEntityVisualStatePayload::new);
    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
