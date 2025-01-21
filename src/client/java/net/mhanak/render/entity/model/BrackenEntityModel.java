package net.mhanak.render.entity.model;

import net.mhanak.render.entity.animation.BrackenAnimation;
import net.mhanak.render.entity.state.BrackenEntityRenderState;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;

// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class BrackenEntityModel extends EntityModel<BrackenEntityRenderState> {
	private final ModelPart mainBody;
	private final ModelPart torso;
	private final ModelPart neck;
	private final ModelPart head;

	public BrackenEntityModel(ModelPart root) {
		super(root);
		this.mainBody = root.getChild("mainBody");
		this.torso = mainBody.getChild("torso");
		this.neck = torso.getChild("neck");
		this.head = neck.getChild("head");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData mainBody = modelPartData.addChild("mainBody", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 1.0F, 0.0F));

		ModelPartData torso = mainBody.addChild("torso", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, -5.5F, -3.0F, 10.0F, 11.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.5F, 0.0F));

		ModelPartData pelvis = torso.addChild("pelvis", ModelPartBuilder.create().uv(30, 17).cuboid(-4.0F, -1.0F, -2.0F, 8.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 5.5F, 0.0F));

		ModelPartData legL = pelvis.addChild("legL", ModelPartBuilder.create(), ModelTransform.pivot(2.0F, 5.0F, 0.0F));

		ModelPartData highLegL = legL.addChild("highLegL", ModelPartBuilder.create().uv(52, 26).mirrored().cuboid(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.5F, 0.0F, 0.5F));

		ModelPartData lowLegL = highLegL.addChild("lowLegL", ModelPartBuilder.create().uv(46, 0).cuboid(-1.5F, -0.5F, -1.5F, 3.0F, 9.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.5F, 0.0F));

		ModelPartData footL = lowLegL.addChild("footL", ModelPartBuilder.create().uv(1, 32).mirrored().cuboid(-1.5F, -0.5F, -1.0F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 8.0F, -1.5F));

		ModelPartData legR = pelvis.addChild("legR", ModelPartBuilder.create(), ModelTransform.pivot(-2.0F, 5.0F, 0.0F));

		ModelPartData highLegR = legR.addChild("highLegR", ModelPartBuilder.create().uv(52, 26).cuboid(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.5F, 0.0F, 0.5F));

		ModelPartData lowlegR = highLegR.addChild("lowlegR", ModelPartBuilder.create().uv(46, 0).mirrored().cuboid(-1.5F, -0.5F, -1.5F, 3.0F, 9.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 6.5F, 0.0F));

		ModelPartData footR = lowlegR.addChild("footR", ModelPartBuilder.create().uv(0, 32).cuboid(-1.5F, -0.5F, -1.0F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 8.0575F, -1.1442F));

		ModelPartData neck = torso.addChild("neck", ModelPartBuilder.create().uv(32, 12).cuboid(-2.0F, -3.0F, -1.0F, 4.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -5.5F, 0.0F));

		ModelPartData head = neck.addChild("head", ModelPartBuilder.create().uv(0, 17).cuboid(-4.0F, -8.0F, -3.5F, 8.0F, 8.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.0F, -0.5F));

		ModelPartData armR = torso.addChild("armR", ModelPartBuilder.create(), ModelTransform.pivot(-7.0F, -4.5F, 0.0F));

		ModelPartData higherArmR = armR.addChild("higherArmR", ModelPartBuilder.create().uv(30, 27).cuboid(-3.0F, -1.0F, -3.0F, 4.0F, 5.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, 0.0F, 0.0F));

		ModelPartData highArmR = higherArmR.addChild("highArmR", ModelPartBuilder.create().uv(50, 53).mirrored().cuboid(-1.5F, 1.5F, -2.0F, 3.0F, 6.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-1.5F, 2.5F, 0.0F));

		ModelPartData lowArmR = highArmR.addChild("lowArmR", ModelPartBuilder.create().uv(33, 1).mirrored().cuboid(-1.5F, 1.0F, -2.0F, 3.0F, 5.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 6.5F, 0.0F));

		ModelPartData handR = lowArmR.addChild("handR", ModelPartBuilder.create().uv(48, 41).mirrored().cuboid(-2.5F, -1.5F, -2.0F, 5.0F, 6.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 6.5F, 0.0F));

		ModelPartData armL = torso.addChild("armL", ModelPartBuilder.create(), ModelTransform.pivot(7.0F, -4.5F, 0.0F));

		ModelPartData higherArmL = armL.addChild("higherArmL", ModelPartBuilder.create().uv(32, 27).cuboid(-1.0F, -1.0F, -3.0F, 4.0F, 5.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, 0.0F, 0.0F));

		ModelPartData highArmL = higherArmL.addChild("highArmL", ModelPartBuilder.create().uv(50, 53).cuboid(-1.5F, 1.5F, -2.0F, 3.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(1.5F, 2.5F, 0.0F));

		ModelPartData lowArmL = highArmL.addChild("lowArmL", ModelPartBuilder.create().uv(33, 1).cuboid(-1.5F, 1.0F, -2.0F, 3.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.5F, 0.0F));

		ModelPartData handL = lowArmL.addChild("handL", ModelPartBuilder.create().uv(48, 41).cuboid(-2.5F, -1.5F, -2.0F, 5.0F, 6.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.5F, 0.0F));

		ModelPartData leaves = torso.addChild("leaves", ModelPartBuilder.create().uv(0, 43).cuboid(-12.0F, -15.0F, 0.0F, 24.0F, 22.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.5F, 3.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(BrackenEntityRenderState state) {
		super.setAngles(state);
		//if (state.visualState.equals("fleeing") || state.visualState.equals("chasing")) {
		//	mainBody.translate(new Vector3f(0.0F, 1 + (float) Math.sin(state.age), 0.0F));
		//}else{
		//	state.positionOffset = new Vec3d(0.0F, 0, 0.0F);
		//}

		animate(state.idleAnimationState, BrackenAnimation.IDLE, state.age);
		animate(state.leafShakeAnimationState, BrackenAnimation.LEAF_SHAKE, state.age);
		animate(state.fleeAnimationState, BrackenAnimation.FLEE, state.age);

		if (state.visualState.equals("chasing")) {
			animateWalking(BrackenAnimation.CHASE, state.limbFrequency, state.limbAmplitudeMultiplier, 1, 1);
		}
		else if(state.visualState.equals("following")) {
			animateWalking(BrackenAnimation.CROUCH_WALK, state.limbFrequency, state.limbAmplitudeMultiplier, 1, 1);
		}
		else {
			animateWalking(BrackenAnimation.WALK, state.limbFrequency, state.limbAmplitudeMultiplier, 1, 1);
		}


	}
}
