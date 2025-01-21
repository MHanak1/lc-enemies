package net.mhanak.render.entity.animation;// Save this class in your mod and generate all required imports

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

/**
 * @author CaveManMan :3
 */
public class CoilheadAnimation {
	public static final Animation WALK_CYCLE = Animation.Builder.create(0.6F).looping()
		.addBoneAnimation("torso", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(10.0093F, 2.462F, 0.4344F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3F, AnimationHelper.createRotationalVector(10.0234F, 3.6929F, 0.6523F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6F, AnimationHelper.createRotationalVector(10.0093F, 2.462F, 0.4344F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("torso", new Transformation(Transformation.Targets.TRANSLATE,
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, -2.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, -2.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, -2.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.4F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, -2.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, -2.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("pelvis", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(2.5095F, -4.9952F, -0.2187F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3F, AnimationHelper.createRotationalVector(2.5215F, 7.4928F, 0.329F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6F, AnimationHelper.createRotationalVector(2.5095F, -4.9952F, -0.2187F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("thighR", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3F, AnimationHelper.createRotationalVector(-35.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("lowerlegR", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-10.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6F, AnimationHelper.createRotationalVector(-10.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("footR", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1F, AnimationHelper.createRotationalVector(-10.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(11.49F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("thighL", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-35.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6F, AnimationHelper.createRotationalVector(-35.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("lowerlegL", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("footL", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("stubR", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-38.5625F, -9.2513F, 4.8003F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3F, AnimationHelper.createRotationalVector(28.2188F, -4.6257F, 2.4002F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6F, AnimationHelper.createRotationalVector(-38.5625F, -9.2513F, 4.8003F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("armR", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3F, AnimationHelper.createRotationalVector(-13.75F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("stubL", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3F, AnimationHelper.createRotationalVector(-37.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("armL", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("spring1", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(2.4933F, 2.7155F, -4.8865F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3F, AnimationHelper.createRotationalVector(2.4967F, -2.661F, 3.6376F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6F, AnimationHelper.createRotationalVector(2.4933F, 2.7155F, -4.8865F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("spring1", new Transformation(Transformation.Targets.TRANSLATE,
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("spring1", new Transformation(Transformation.Targets.SCALE,
			new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("spring2", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(7.5019F, 2.8048F, -2.1523F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3F, AnimationHelper.createRotationalVector(7.0581F, -2.5153F, 7.0386F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6F, AnimationHelper.createRotationalVector(7.5019F, 2.8048F, -2.1523F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("spring3", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(2.5002F, 2.6066F, -2.3886F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3F, AnimationHelper.createRotationalVector(2.5013F, -2.5521F, 1.1397F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6F, AnimationHelper.createRotationalVector(2.5002F, 2.6066F, -2.3886F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("spring4", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(10.0033F, 2.896F, -2.0279F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3F, AnimationHelper.createRotationalVector(9.9909F, -3.1127F, 3.2596F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6F, AnimationHelper.createRotationalVector(10.0033F, 2.896F, -2.0279F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(2.4571F, 7.4713F, -0.6574F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.1F, AnimationHelper.createRotationalVector(-5.0421F, 2.9055F, -0.2558F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3F, AnimationHelper.createRotationalVector(2.4594F, -6.226F, 0.5474F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.4F, AnimationHelper.createRotationalVector(-5.0526F, -0.8302F, 0.0714F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6F, AnimationHelper.createRotationalVector(2.4233F, 9.9616F, -0.8804F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE,
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.3F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(0.6F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.build();

	public static final Animation RECHARGE = Animation.Builder.create(0.25F)
			.addBoneAnimation("spring1", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(0.125F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("spring2", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(0.125F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("spring3", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(0.125F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("spring4", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(0.125F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("spring4", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(0.125F, AnimationHelper.createTranslationalVector(0.0F, -0.25F, 0.0F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
					new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(0.125F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
			))
			.addBoneAnimation("head", new Transformation(Transformation.Targets.TRANSLATE,
					new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
					new Keyframe(0.125F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.LINEAR)
			))
			.build();

	public static final Animation BOIOIOIOING = Animation.Builder.create(5.0f)
			.addBoneAnimation("spring1", boioioioingTransformation())
			.addBoneAnimation("spring2", boioioioingTransformation())
			.addBoneAnimation("spring3", boioioioingTransformation())
			.addBoneAnimation("spring4", boioioioingTransformation())
			.addBoneAnimation("head",    boioioioingTransformation())
			.build();

	private static Transformation boioioioingTransformation() {
		return new Transformation(Transformation.Targets.ROTATE,
			boioioioingKeyframe(0.0f),
			boioioioingKeyframe(0.1f),
			boioioioingKeyframe(0.2f),
			boioioioingKeyframe(0.3f),
			boioioioingKeyframe(0.4f),
			boioioioingKeyframe(0.5f),
			boioioioingKeyframe(0.6f),
			boioioioingKeyframe(0.7f),
			boioioioingKeyframe(0.8f),
			boioioioingKeyframe(0.9f),
			boioioioingKeyframe(1.0f),
			boioioioingKeyframe(1.1f),
			boioioioingKeyframe(1.2f),
			boioioioingKeyframe(1.3f),
			boioioioingKeyframe(1.4f),
			boioioioingKeyframe(1.5f),
			boioioioingKeyframe(1.6f),
			boioioioingKeyframe(1.7f),
			boioioioingKeyframe(1.8f),
			boioioioingKeyframe(1.9f),
			boioioioingKeyframe(2.0f),
			boioioioingKeyframe(2.1f),
			boioioioingKeyframe(2.2f),
			boioioioingKeyframe(2.3f),
			boioioioingKeyframe(2.4f),
			boioioioingKeyframe(2.5f),
			boioioioingKeyframe(2.6f),
			boioioioingKeyframe(2.7f),
			boioioioingKeyframe(2.8f),
			boioioioingKeyframe(2.9f),
			boioioioingKeyframe(3.0f)
		);
	}
	private static Keyframe boioioioingKeyframe(float t) {
	//	return new Keyframe(t, AnimationHelper.createRotationalVector( (float) Math.sin(t) / 5 / Math.max(1.0f, t) * Math.clamp(2.0f - t / 5, 0.0f, 1.0f), 0, 0), Transformation.Interpolations.LINEAR);
		return new Keyframe(t, AnimationHelper.createRotationalVector( (float) Math.sin(t * 16) * 10 / Math.max(1.0f, t * 4) * Math.clamp(3.0f - t, 0.0f, 1.0f), 0, 0), Transformation.Interpolations.CUBIC);
	}
}