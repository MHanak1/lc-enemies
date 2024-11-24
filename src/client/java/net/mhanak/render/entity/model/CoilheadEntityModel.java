package net.mhanak.render.entity.model;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;

public class CoilheadEntityModel extends EntityModel<LivingEntityRenderState> {
	private final ModelPart bb_main;
	public CoilheadEntityModel(ModelPart root) {
        super(root);
        this.bb_main = root.getChild("bb_main");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(-3, -2).cuboid(3.0F, -18.0F, -2.0F, 4.0F, 18.0F, 4.0F, new Dilation(0.0F))
		.uv(-3, -2).cuboid(-7.0F, -18.0F, -2.0F, 4.0F, 18.0F, 4.0F, new Dilation(0.0F))
		.uv(-6, -2).cuboid(-5.0F, -36.0F, -2.0F, 10.0F, 18.0F, 4.0F, new Dilation(0.0F))
		.uv(-3, -2).cuboid(-2.0F, -46.0F, -2.0F, 4.0F, 10.0F, 4.0F, new Dilation(0.0F))
		.uv(-6, -4).cuboid(-3.0F, -52.0F, -3.0F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData cube_r1 = bb_main.addChild("cube_r1", ModelPartBuilder.create().uv(-3, -2).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-6.0F, -36.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

		ModelPartData cube_r2 = bb_main.addChild("cube_r2", ModelPartBuilder.create().uv(-3, -2).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(6.0F, -36.0F, 0.0F, 0.0F, 0.0F, -0.3491F));
		return TexturedModelData.of(modelData, 16, 16);
	}

	@Override
	public void setAngles(LivingEntityRenderState state) {
		super.setAngles(state);
	}
}