package net.mhanak.render.entity;

import net.mhanak.entity.LCEntity;
import net.mhanak.render.entity.state.LCEntityRenderState;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

public abstract class LCEntityRenderer<T extends LCEntity, S extends LCEntityRenderState, M extends EntityModel<? super S>> extends LivingEntityRenderer<T, S, M> {

    public LCEntityRenderer(EntityRendererFactory.Context ctx, M model, float shadowRadius) {
        super(ctx, model, shadowRadius);
    }

    @Override
    protected @Nullable Text getDisplayName(T entity) {
        //return Text.of(entity.getVisualState());
        return null;
    }

    @Override
    public void updateRenderState(T livingEntity, S livingEntityRenderState, float f) {
        super.updateRenderState(livingEntity, livingEntityRenderState, f);
        livingEntityRenderState.facingPlayer = livingEntity.facingPlayer;
        livingEntityRenderState.visualState = livingEntity.getVisualState();
    }
}
