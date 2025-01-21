// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package net.mhanak.render.entity.model;

import net.mhanak.render.entity.animation.CoilheadAnimation;
import net.mhanak.render.entity.state.CoilheadEntityRenderState;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;

public class CoilheadEntityModel extends EntityModel<CoilheadEntityRenderState> {
	private final ModelPart mainbody;
	private final ModelPart torso;
	private final ModelPart spring1;
	private final ModelPart spring2;
	private final ModelPart spring3;
	private final ModelPart spring4;
	private final ModelPart head;
	/*
	private final ModelPart pelvis;
	private final ModelPart thighR;
	private final ModelPart lowerlegR;
	private final ModelPart footR;
	private final ModelPart nail3;
	private final ModelPart thighL;
	private final ModelPart lowerlegL;
	private final ModelPart footL;
	private final ModelPart nail4;
	private final ModelPart nail1;
	private final ModelPart nail6;
	private final ModelPart stubR;
	private final ModelPart armR;
	private final ModelPart stubL;
	private final ModelPart armL;
	private final ModelPart nail2;
	private final ModelPart nail5;
	 */

	public CoilheadEntityModel(ModelPart root) {
        super(root);
        this.mainbody = root.getChild("mainbody");
		this.torso = mainbody.getChild("torso");
		this.spring1 = torso.getChild("spring1");
		this.spring2 = spring1.getChild("spring2");
		this.spring3 = spring2.getChild("spring3");
		this.spring4 = spring3.getChild("spring4");
		this.head = spring4.getChild("head");
		/*
		this.pelvis = torso.getChild("pelvis");
		this.thighR = pelvis.getChild("thighR");
		this.lowerlegR = thighR.getChild("lowerlegR");
		this.footR = lowerlegR.getChild("footR");
		this.nail3 = lowerlegR.getChild("nail3");
		this.thighL = pelvis.getChild("thighL");
		this.lowerlegL = thighL.getChild("lowerlegL");
		this.footL = lowerlegL.getChild("footL");
		this.nail4 = thighL.getChild("nail4");
		this.nail1 = pelvis.getChild("nail1");
		this.nail6 = pelvis.getChild("nail6");
		this.stubR = torso.getChild("stubR");
		this.armR = stubR.getChild("armR");
		this.stubL = torso.getChild("stubL");
		this.armL = stubL.getChild("armL");
		this.nail2 = torso.getChild("nail2");
		this.nail5 = torso.getChild("nail5");
		 */
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData mainbody = modelPartData.addChild("mainbody", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -5.5F, 0.0F));

		ModelPartData torso = mainbody.addChild("torso", ModelPartBuilder.create().uv(8, 0).cuboid(-5.0F, -3.5F, -3.0F, 10.0F, 7.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 1.0F));

		ModelPartData pelvis = torso.addChild("pelvis", ModelPartBuilder.create().uv(8, 13).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 8.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 3.5F, 0.0F));

		ModelPartData thighR = pelvis.addChild("thighR", ModelPartBuilder.create().uv(28, 25).cuboid(-2.5F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.5F, 8.0F, 0.0F));

		ModelPartData lowerlegR = thighR.addChild("lowerlegR", ModelPartBuilder.create().uv(8, 36).cuboid(-1.5F, 0.0F, -1.5F, 3.0F, 9.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.5F, 8.0F, 0.0F));

		ModelPartData footR = lowerlegR.addChild("footR", ModelPartBuilder.create().uv(32, 37).cuboid(-1.5F, -0.5F, -2.5F, 3.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 9.5F, -0.5F));

		ModelPartData nail3 = lowerlegR.addChild("nail3", ModelPartBuilder.create().uv(35, 49).cuboid(-3.0F, -3.5F, -3.6667F, 6.0F, 7.0F, 8.0F, new Dilation(-3.0F))
				.uv(37, 51).cuboid(-3.5F, -3.5F, -3.6667F, 7.0F, 7.0F, 6.0F, new Dilation(-3.0F)), ModelTransform.of(-1.0F, 4.0F, -1.3333F, -0.4558F, 0.4417F, -0.6595F));

		ModelPartData nail2_r1 = nail3.addChild("nail2_r1", ModelPartBuilder.create().uv(35, 49).cuboid(-3.0F, -3.5F, -4.0F, 6.0F, 7.0F, 8.0F, new Dilation(-3.0F)), ModelTransform.of(0.0F, 0.0F, 0.3333F, 0.0F, 0.0F, -1.5708F));

		ModelPartData thighL = pelvis.addChild("thighL", ModelPartBuilder.create().uv(32, 13).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, 8.0F, 0.0F));

		ModelPartData lowerlegL = thighL.addChild("lowerlegL", ModelPartBuilder.create().uv(20, 37).cuboid(-1.5F, -0.5F, -1.5F, 3.0F, 9.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 8.5F, 0.0F));

		ModelPartData footL = lowerlegL.addChild("footL", ModelPartBuilder.create().uv(40, 0).cuboid(-1.5F, -0.5F, -2.5F, 3.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 9.0F, -0.5F));

		ModelPartData nail4 = thighL.addChild("nail4", ModelPartBuilder.create().uv(35, 49).cuboid(-3.0F, -3.5F, -3.6667F, 6.0F, 7.0F, 8.0F, new Dilation(-3.0F))
				.uv(37, 51).cuboid(-3.5F, -3.5F, -3.6667F, 7.0F, 7.0F, 6.0F, new Dilation(-3.0F)), ModelTransform.of(2.0F, 4.0F, 0.6667F, -2.0946F, -0.2431F, 1.712F));

		ModelPartData nail2_r2 = nail4.addChild("nail2_r2", ModelPartBuilder.create().uv(35, 49).cuboid(-3.0F, -3.5F, -4.0F, 6.0F, 7.0F, 8.0F, new Dilation(-3.0F)), ModelTransform.of(0.0F, 0.0F, 0.3333F, 0.0F, 0.0F, -1.5708F));

		ModelPartData nail1 = pelvis.addChild("nail1", ModelPartBuilder.create().uv(35, 49).cuboid(-3.0F, -3.5F, -3.6667F, 6.0F, 7.0F, 8.0F, new Dilation(-3.0F))
				.uv(37, 51).cuboid(-3.5F, -3.5F, -3.6667F, 7.0F, 7.0F, 6.0F, new Dilation(-3.0F)), ModelTransform.pivot(3.0F, 2.0F, -2.3333F));

		ModelPartData nail2_r3 = nail1.addChild("nail2_r3", ModelPartBuilder.create().uv(35, 49).cuboid(-3.0F, -3.5F, -4.0F, 6.0F, 7.0F, 8.0F, new Dilation(-3.0F)), ModelTransform.of(0.0F, 0.0F, 0.3333F, 0.0F, 0.0F, -1.5708F));

		ModelPartData nail6 = pelvis.addChild("nail6", ModelPartBuilder.create().uv(35, 49).cuboid(-3.0F, -3.5F, -3.6667F, 6.0F, 7.0F, 8.0F, new Dilation(-3.0F)), ModelTransform.of(-3.0F, 6.0F, 1.6667F, 2.7146F, -0.2229F, 1.6599F));

		ModelPartData nail3_r1 = nail6.addChild("nail3_r1", ModelPartBuilder.create().uv(37, 51).cuboid(-3.5F, -3.5F, -3.0F, 7.0F, 7.0F, 6.0F, new Dilation(-3.0F)), ModelTransform.of(0.0F, 0.0F, -0.6667F, 0.3491F, 0.0F, 0.0F));

		ModelPartData nail2_r4 = nail6.addChild("nail2_r4", ModelPartBuilder.create().uv(35, 49).cuboid(-3.0F, -3.5F, -4.0F, 6.0F, 7.0F, 8.0F, new Dilation(-3.0F)), ModelTransform.of(0.0F, 0.0F, 0.3333F, 0.0F, 0.0F, -1.5708F));

		ModelPartData stubR = torso.addChild("stubR", ModelPartBuilder.create().uv(48, 12).cuboid(-2.0F, -2.0F, -2.0F, 2.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, -0.5F, 0.0F));

		ModelPartData armR = stubR.addChild("armR", ModelPartBuilder.create().uv(48, 37).cuboid(-1.0F, -1.5F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 0.5F, 0.0F));

		ModelPartData stubL = torso.addChild("stubL", ModelPartBuilder.create().uv(8, 48).cuboid(0.0F, -2.0F, -2.0F, 2.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, -0.5F, 0.0F));

		ModelPartData armL = stubL.addChild("armL", ModelPartBuilder.create().uv(20, 49).cuboid(-1.0F, -1.5F, -1.0F, 2.0F, 9.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 0.5F, 0.0F));

		ModelPartData spring1 = torso.addChild("spring1", ModelPartBuilder.create().uv(40, 6).cuboid(-2.0F, -2.0F, -2.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.5F, 0.0F));

		ModelPartData spring2 = spring1.addChild("spring2", ModelPartBuilder.create().uv(32, 43).cuboid(-2.0F, -2.0F, -2.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

		ModelPartData spring3 = spring2.addChild("spring3", ModelPartBuilder.create().uv(44, 25).cuboid(-2.0F, -2.0F, -2.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

		ModelPartData spring4 = spring3.addChild("spring4", ModelPartBuilder.create().uv(44, 31).cuboid(-2.0F, -2.0F, -2.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

		ModelPartData head = spring4.addChild("head", ModelPartBuilder.create().uv(8, 25).cuboid(-2.5F, -6.0F, -2.5F, 5.0F, 6.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

		ModelPartData nail2 = torso.addChild("nail2", ModelPartBuilder.create().uv(35, 49).cuboid(-3.0F, -3.5F, -3.6667F, 6.0F, 7.0F, 8.0F, new Dilation(-3.0F))
				.uv(37, 51).cuboid(-3.5F, -3.5F, -3.6667F, 7.0F, 7.0F, 6.0F, new Dilation(-3.0F)), ModelTransform.of(-4.0F, -3.5F, -1.3333F, -1.5305F, 0.0167F, -0.3924F));

		ModelPartData nail2_r5 = nail2.addChild("nail2_r5", ModelPartBuilder.create().uv(35, 49).cuboid(-3.0F, -3.5F, -4.0F, 6.0F, 7.0F, 8.0F, new Dilation(-3.0F)), ModelTransform.of(0.0F, 0.0F, 0.3333F, 0.0F, 0.0F, -1.5708F));

		ModelPartData nail5 = torso.addChild("nail5", ModelPartBuilder.create().uv(35, 49).cuboid(-3.0F, -3.5F, -3.6667F, 6.0F, 7.0F, 8.0F, new Dilation(-3.0F))
				.uv(37, 51).cuboid(-3.5F, -3.5F, -3.6667F, 7.0F, 7.0F, 6.0F, new Dilation(-3.0F)), ModelTransform.of(5.0F, -0.5F, 2.6667F, -2.5746F, -0.2431F, 1.712F));

		ModelPartData nail2_r6 = nail5.addChild("nail2_r6", ModelPartBuilder.create().uv(35, 49).cuboid(-3.0F, -3.5F, -4.0F, 6.0F, 7.0F, 8.0F, new Dilation(-3.0F)), ModelTransform.of(0.0F, 0.0F, 0.3333F, 0.0F, 0.0F, -1.5708F));
		return TexturedModelData.of(modelData, 64, 64);
	}


	public ModelPart getHead() {
		return head;
	}

	@Override
	public void setAngles(CoilheadEntityRenderState state) {
		resetHeadPosition();
		if( state.rechargeAnimationState.isRunning()) {
			this.animate(state.rechargeAnimationState, CoilheadAnimation.RECHARGE, state.age);
			return;
		}
		if (state.is_frozen) {
			this.animate(state.boioioioingAnimationState, CoilheadAnimation.BOIOIOIOING, state.age);
			return;
		}

		super.setAngles(state);
		this.animateWalking(CoilheadAnimation.WALK_CYCLE, state.limbFrequency * 2, state.limbAmplitudeMultiplier, 1.0f, 1.0f);
		//this.animate(state.rechargeAnimationState, CoilheadAnimation.RECHARGE, state.retractTime);
		//this.animate(state.boioioioingAnimationState, CoilheadAnimation.BOIOIOIOING, state.boioioingTime);
	}

	void resetHeadPosition() {
		this.spring1.resetTransform();
		this.spring2.resetTransform();
		this.spring3.resetTransform();
		this.spring4.resetTransform();
		this.head.resetTransform();
	}

	void setHeadPartRotation(float rot) {
		this.spring1.pitch = rot;
		this.spring2.pitch = rot;
		this.spring3.pitch = rot;
		this.spring4.pitch = rot;
		this.head.pitch = rot;
	}
}
