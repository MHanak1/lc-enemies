package net.mhanak.render.entity;

import net.mhanak.LCEnemiesMod;
import net.mhanak.LCEnemiesModClient;
import net.mhanak.entity.BrackenEntity;
import net.mhanak.render.entity.model.BrackenEntityModel;
import net.mhanak.render.entity.state.LCEntityRenderState;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class BrackenEntityRenderer  extends LCEntityRenderer<BrackenEntity, LCEntityRenderState, BrackenEntityModel> {

    public BrackenEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new BrackenEntityModel(context.getPart(LCEnemiesModClient.MODEL_BRACKEN_LAYER)), 0.5f);
    }

    @Override
    public LCEntityRenderState createRenderState() {
        return new LCEntityRenderState();
    }

    @Override
    public Identifier getTexture(LCEntityRenderState state) {
        return LCEnemiesMod.path("textures/entity/bracken.png");
    }


    @Override
    public void render(LCEntityRenderState livingEntityRenderState, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(livingEntityRenderState, matrixStack, vertexConsumerProvider, i);
    }
}
