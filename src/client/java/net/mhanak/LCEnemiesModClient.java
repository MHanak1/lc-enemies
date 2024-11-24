package net.mhanak;

import net.mhanak.networking.ModS2CPackets;
import net.mhanak.registry.ModEntities;
import net.mhanak.render.entity.BrackenEntityRenderer;
import net.mhanak.render.entity.CoilheadEntityRenderer;
import net.mhanak.render.entity.model.BrackenEntityModel;
import net.mhanak.render.entity.model.CoilheadEntityModel;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class LCEnemiesModClient implements ClientModInitializer {
	public static final EntityModelLayer MODEL_BRACKEN_LAYER = new EntityModelLayer(LCEnemiesMod.path("bracken"), "bracken");
	public static final EntityModelLayer MODEL_COILHEAD_LAYER = new EntityModelLayer(LCEnemiesMod.path("coilhead"), "coilhead");
	@Override
	public void onInitializeClient() {
		ModS2CPackets.initialiseRecievers();

		EntityRendererRegistry.register(ModEntities.BRACKEN, BrackenEntityRenderer::new);
		EntityRendererRegistry.register(ModEntities.COILHEAD, CoilheadEntityRenderer::new);

		EntityModelLayerRegistry.registerModelLayer(MODEL_BRACKEN_LAYER, BrackenEntityModel::getTexturedModelData);
		EntityModelLayerRegistry.registerModelLayer(MODEL_COILHEAD_LAYER, CoilheadEntityModel::getTexturedModelData);
	}
}