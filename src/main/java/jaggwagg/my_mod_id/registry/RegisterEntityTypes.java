package jaggwagg.my_mod_id.registry;

import jaggwagg.my_mod_id.MyMod;
import jaggwagg.my_mod_id.entity.ModMobEntityTypes;
import jaggwagg.my_mod_id.entity.ModProjectileEntityTypes;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.Arrays;

public class RegisterEntityTypes {
    public static void init() {
        Arrays.stream(ModMobEntityTypes.values()).forEach(value -> registerEntity(value.getId(), value.getEntityType(), value.getEntityAttributes()));
        Arrays.stream(ModProjectileEntityTypes.values()).forEach(value -> registerEntity(value.getId(), value.getEntityType()));
    }

    private static void registerEntity(String id, EntityType<?> entityType) {
        Registry.register(Registries.ENTITY_TYPE, new Identifier(MyMod.MOD_ID, id), entityType);
    }

    private static void registerEntity(String id, EntityType<? extends LivingEntity> entityType, DefaultAttributeContainer attributes) {
        Registry.register(Registries.ENTITY_TYPE, new Identifier(MyMod.MOD_ID, id), entityType);
        FabricDefaultAttributeRegistry.register(entityType, attributes);
    }
}
