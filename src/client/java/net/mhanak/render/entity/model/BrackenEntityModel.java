package net.mhanak.render.entity.model;

import net.mhanak.render.entity.state.LCEntityRenderState;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.util.math.Vec3d;
import org.joml.Vector3f;

// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class BrackenEntityModel extends EntityModel<LCEntityRenderState> {
	private final ModelPart bb_main;
	public BrackenEntityModel(ModelPart root) {
		super(root);
        this.bb_main = root.getChild("bb_main");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(-4, -4).cuboid(-8.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F))
		.uv(-4, -4).cuboid(2.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F))
		.uv(-4, -4).cuboid(-3.0F, -18.0F, -3.0F, 6.0F, 12.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		return TexturedModelData.of(modelData, 16, 16);
	}

	@Override
	public void setAngles(LCEntityRenderState state) {
		super.setAngles(state);
		if (state.visualState.equals("fleeing") || state.visualState.equals("chasing")) {
			bb_main.translate(new Vector3f(0.0F, 1 + (float) Math.sin(state.age), 0.0F));
		}else{
			state.positionOffset = new Vec3d(0.0F, 0, 0.0F);
		}
	}
}