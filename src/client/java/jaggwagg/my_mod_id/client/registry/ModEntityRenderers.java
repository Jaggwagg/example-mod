package jaggwagg.my_mod_id.client.registry;

import jaggwagg.my_mod_id.MyMod;
import jaggwagg.my_mod_id.client.render.entity.MyHostileEntityProjectileEntityRenderer;
import jaggwagg.my_mod_id.client.render.entity.MyHostileEntityRenderer;
import jaggwagg.my_mod_id.client.render.entity.MyPassiveEntityRenderer;
import jaggwagg.my_mod_id.entity.ModMobEntityTypes;
import jaggwagg.my_mod_id.entity.ModProjectileEntityTypes;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;

import java.util.Arrays;

public class ModEntityRenderers {
    public static void init() {
        Arrays.stream(MyEntityRenderers.values()).forEach(value -> registerEntityRenderers(value.getEntityType(), value.getEntityRendererFactory()));

        MyMod.loggerInfo("Initialized entity types");
    }

    /*
    * Suppressing multiple warnings here.
    * Must be done in order to allow multiple entity types within enums.
    * Works every time, even on Forgified Fabric API with Sinytra Connector.
    * Why must Java not have generic enums :(
    */
    @SuppressWarnings({"rawtypes", "unchecked"})
    private static void registerEntityRenderers(EntityType entityType, EntityRendererFactory entityRendererFactory) {
        EntityRendererRegistry.register(entityType, entityRendererFactory);
    }

    public enum MyEntityRenderers {
        MY_HOSTILE_ENTITY(ModMobEntityTypes.MY_HOSTILE.getEntityType(), MyHostileEntityRenderer::new),
        MY_HOSTILE_PROJECTILE_ENTITY(ModProjectileEntityTypes.MY_HOSTILE_PROJECTILE.getEntityType(), MyHostileEntityProjectileEntityRenderer::new),
        MY_PASSIVE_ENTITY(ModMobEntityTypes.MY_PASSIVE.getEntityType(), MyPassiveEntityRenderer::new);

        private final EntityType<?> entityType;
        private final EntityRendererFactory<?> entityRendererFactory;

        <T extends Entity> MyEntityRenderers(EntityType<?> entityType, EntityRendererFactory<T> entityRendererFactory) {
            this.entityType = entityType;
            this.entityRendererFactory = entityRendererFactory;
        }

        public EntityType<?> getEntityType() {
            return this.entityType;
        }

        public EntityRendererFactory<?> getEntityRendererFactory() {
            return this.entityRendererFactory;
        }
    }
}
