package net.mhanak.render.entity.state;

import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.player.PlayerEntity;

public class LCEntityRenderState extends LivingEntityRenderState {
    public PlayerEntity facingPlayer;
    public String visualState = "";

}
