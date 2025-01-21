package net.mhanak.render.entity;

import net.mhanak.LCEnemiesMod;
import net.mhanak.LCEnemiesModClient;
import net.mhanak.entity.BrackenEntity;
import net.mhanak.render.entity.model.BrackenEntityModel;
import net.mhanak.render.entity.state.BrackenEntityRenderState;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class BrackenEntityRenderer extends LCEntityRenderer<BrackenEntity, BrackenEntityRenderState, BrackenEntityModel> {

    public BrackenEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new BrackenEntityModel(context.getPart(LCEnemiesModClient.MODEL_BRACKEN_LAYER)), 0.5f);
    }

    @Override
    public BrackenEntityRenderState createRenderState() {
        return new BrackenEntityRenderState();
    }

    @Override
    public Identifier getTexture(BrackenEntityRenderState state) {
        return LCEnemiesMod.path("textures/entity/bracken.png");
    }

    @Override
    public void updateRenderState(BrackenEntity livingEntity, BrackenEntityRenderState state, float f) {
        super.updateRenderState(livingEntity, state, f);
        //state.isChasing = livingEntity.isAngry;

        state.idleAnimationState.startIfNotRunning(livingEntity.age);
        if (state.visualState.equals("fleeing")) {
            //animateWalking(BrackenAnimation.RETREAT, state.limbFrequency, state.limbAmplitudeMultiplier, 1, 1);
            state.fleeAnimationState.startIfNotRunning(livingEntity.age);
        }
        else {
            state.fleeAnimationState.stop();
        }
        /*
        if (state.visualState.equals("fleeing")) {
            if (!state.leafShakeAnimationState.isRunning()) {
                state.leafShakeAnimationState.start(livingEntity.age);
            }
        }
        else {state.leafShakeAnimationState.stop();}
         */
    }

    @Override
    public void render(BrackenEntityRenderState livingEntityRenderState, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(livingEntityRenderState, matrixStack, vertexConsumerProvider, i);
    }
}
