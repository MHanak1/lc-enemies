package net.mhanak.networking;

import net.mhanak.registry.ModPackets;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;

public record SetEntityFacingPayload(int entityID, int playerID) implements CustomPayload {
    public static final Id<SetEntityFacingPayload> ID = new Id<>(ModPackets.SET_BRACKEN_FACING_ID);
    public static final PacketCodec<RegistryByteBuf, SetEntityFacingPayload> CODEC = PacketCodec.tuple(
            PacketCodecs.INTEGER, SetEntityFacingPayload::entityID,
            PacketCodecs.INTEGER, SetEntityFacingPayload::playerID,
            SetEntityFacingPayload::new);
    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
