package net.mhanak.render.entity;

import net.mhanak.LCEnemiesMod;
import net.mhanak.LCEnemiesModClient;
import net.mhanak.entity.CoilheadEntity;
import net.mhanak.render.entity.model.CoilheadEntityModel;
import net.mhanak.render.entity.state.CoilheadEntityRenderState;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

public class CoilheadEntityRenderer extends LCEntityRenderer<CoilheadEntity, CoilheadEntityRenderState, CoilheadEntityModel> {


    public CoilheadEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new CoilheadEntityModel(context.getPart(LCEnemiesModClient.MODEL_COILHEAD_LAYER)), 0.5f);
    }

    @Override
    public CoilheadEntityRenderState createRenderState() {
        return new CoilheadEntityRenderState();
    }

    @Override
    public Identifier getTexture(CoilheadEntityRenderState state) {
        return LCEnemiesMod.path("textures/entity/coilhead.png");
    }

    @Override
    public void updateRenderState(CoilheadEntity livingEntity, CoilheadEntityRenderState state, float f) {
        super.updateRenderState(livingEntity, state, f);
        state.is_frozen = livingEntity.isFrozen;
        if (livingEntity.isRecharging) {
            if (!state.rechargeAnimationState.isRunning()){
                state.rechargeAnimationState.start(livingEntity.age);
            }
        }
        else {
            state.rechargeAnimationState.stop();
            if (state.is_frozen) {
                if (!state.boioioioingAnimationState.isRunning()){
                    state.boioioioingAnimationState.start(livingEntity.age);
                }
            }
            else {
                state.boioioioingAnimationState.stop();
            }
        }
    }
}
