package jaggwagg.my_mod_id.entity;

import jaggwagg.my_mod_id.entity.mob.MyHostileEntity;
import jaggwagg.my_mod_id.entity.passive.MyPassiveEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.mob.MobEntity;

import java.util.Locale;

public enum ModMobEntityTypes {
    MY_HOSTILE(MyHostileEntity.createCreeperAttributes(), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MyHostileEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()),
    MY_PASSIVE(MyPassiveEntity.createPigAttributes(), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MyPassiveEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build());

    private final String id;
    private final DefaultAttributeContainer.Builder entityAttributes;
    private final EntityType<? extends MobEntity> entityType;

    ModMobEntityTypes(DefaultAttributeContainer.Builder entityAttributes, EntityType<? extends MobEntity> entityType) {
        this.id = this.toString().toLowerCase(Locale.ROOT);
        this.entityAttributes = entityAttributes;
        this.entityType = entityType;
    }

    public String getId() {
        return this.id;
    }

    public DefaultAttributeContainer getEntityAttributes() {
        return this.entityAttributes.build();
    }

    public EntityType<? extends MobEntity> getEntityType() {
        return this.entityType;
    }
}
