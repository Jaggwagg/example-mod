package jaggwagg.my_mod_id.entity;

import jaggwagg.my_mod_id.entity.projectile.MyHostileProjectileEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.projectile.ProjectileEntity;

import java.util.Locale;

public enum ModProjectileEntityTypes {
    MY_HOSTILE_PROJECTILE(createArrowEntityType(((MyHostileProjectileEntity::new))));

    private final String id;
    private final EntityType<? extends ProjectileEntity> entityType;

    ModProjectileEntityTypes(EntityType<? extends ProjectileEntity> entityType) {
        this.id = this.toString().toLowerCase(Locale.ROOT);
        this.entityType = entityType;
    }

    private static <T extends ProjectileEntity> EntityType<T> createArrowEntityType(EntityType.EntityFactory<T> factory) {
        return FabricEntityTypeBuilder.create(SpawnGroup.MISC, factory).dimensions(EntityDimensions.fixed(0.5f, 0.5f)).trackRangeBlocks(4).trackedUpdateRate(20).build();
    }

    public String getId() {
        return this.id;
    }

    public EntityType<? extends ProjectileEntity> getEntityType() {
        return this.entityType;
    }
}
