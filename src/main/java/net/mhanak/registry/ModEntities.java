package net.mhanak.registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.mhanak.LCEnemiesMod;
import net.mhanak.entity.BrackenEntity;
import net.mhanak.entity.CoilheadEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class ModEntities {

    public static final EntityType<BrackenEntity> BRACKEN = register(
            "bracken",
            EntityType.Builder.create(BrackenEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f, 1.8f)
    );

    public static final EntityType<CoilheadEntity> COILHEAD = register(
            "coilhead",
            EntityType.Builder.create(CoilheadEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f, 1.8f)
    );

    //entity attributes
    public static void registerEntityAttributes() {
        LCEnemiesMod.LOGGER.info("Registering Entity Attributes");
        FabricDefaultAttributeRegistry.register(BRACKEN, BrackenEntity.createMobAttributes().add(EntityAttributes.MAX_HEALTH, 3f));
        FabricDefaultAttributeRegistry.register(COILHEAD, BrackenEntity.createMobAttributes());
    }

    //helper functions
    private static <T extends Entity> EntityType<T> register(RegistryKey<EntityType<?>> key, EntityType.Builder<T> type) {
        return Registry.register(Registries.ENTITY_TYPE, key, type.build(key));
    }

    private static RegistryKey<EntityType<?>> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.ENTITY_TYPE, LCEnemiesMod.path(id));
    }

    private static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> type) {
        return register(keyOf(id), type);
    }
}
