package net.mhanak.render.entity.state;

import net.minecraft.entity.AnimationState;

public class BrackenEntityRenderState extends LCEntityRenderState {
    public final AnimationState crouchAnimationState = new AnimationState();
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState walkAnimationState = new AnimationState();
    public final AnimationState crouchWalkAnimationState = new AnimationState();
    public final AnimationState leafShakeAnimationState = new AnimationState();
    public final AnimationState chaseAnimationState = new AnimationState();
    public final AnimationState preChaseAnimationState = new AnimationState();
    public final AnimationState fleeAnimationState = new AnimationState();
    public final AnimationState killAnimationState = new AnimationState();
}
