package jaggwagg.my_mod_id.entity.passive;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.world.World;

public class MyPassiveEntity extends PigEntity {
    public MyPassiveEntity(EntityType<? extends MyPassiveEntity> entityType, World world) {
        super(entityType, world);
    }
}
