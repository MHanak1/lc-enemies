package net.mhanak.render.entity;

import net.mhanak.LCEnemiesMod;
import net.mhanak.LCEnemiesModClient;
import net.mhanak.entity.CoilheadEntity;
import net.mhanak.render.entity.model.CoilheadEntityModel;
import net.mhanak.render.entity.state.LCEntityRenderState;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

public class CoilheadEntityRenderer extends LCEntityRenderer<CoilheadEntity, LCEntityRenderState, CoilheadEntityModel> {

    public CoilheadEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new CoilheadEntityModel(context.getPart(LCEnemiesModClient.MODEL_COILHEAD_LAYER)), 0.5f);
    }

    @Override
    public LCEntityRenderState createRenderState() {
        return new LCEntityRenderState();
    }

    @Override
    public Identifier getTexture(LCEntityRenderState state) {
        return LCEnemiesMod.path("textures/entity/coilhead.png");
    }

    @Override
    public void updateRenderState(CoilheadEntity livingEntity, LCEntityRenderState livingEntityRenderState, float f) {
        super.updateRenderState(livingEntity, livingEntityRenderState, f);
    }
}
