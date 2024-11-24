package net.mhanak;

import net.mhanak.registry.ModPackets;
import net.mhanak.registry.ModEntities;
import net.mhanak.registry.ModSoundEvents;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LCEnemiesMod implements ModInitializer {


	public static final String MOD_ID = "lc-enemies";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("LCEnemies");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModEntities.registerEntityAttributes();
		ModSoundEvents.registerSoundEvents();
		ModPackets.initialiseRecievers();
	}

	public static Identifier path(String path) {
		return Identifier.of(MOD_ID, path);
	}
}