package jaggwagg.my_mod_id.entity.mob;

import jaggwagg.my_mod_id.entity.projectile.MyHostileProjectileEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.ProjectileAttackGoal;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class MyHostileEntity extends CreeperEntity implements RangedAttackMob {
    public MyHostileEntity(EntityType<? extends MyHostileEntity> entityType, World world) {
        super(entityType, world);
    }

    private void spitAt(LivingEntity target) {
        MyHostileProjectileEntity myHostileProjectileEntity = new MyHostileProjectileEntity(this.getWorld(), this);
        double d = target.getX() - this.getX();
        double e = target.getBodyY(0.3333333333333333) - myHostileProjectileEntity.getY();
        double f = target.getZ() - this.getZ();
        double g = Math.sqrt(d * d + f * f) * (double) 0.2f;
        myHostileProjectileEntity.setVelocity(d, e + g, f, 1.5f, 10.0f);
        if (!this.isSilent()) {
            this.getWorld().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_LLAMA_SPIT, this.getSoundCategory(), 1.0f, 1.0f + (this.random.nextFloat() - this.random.nextFloat()) * 0.2f);
        }
        this.getWorld().spawnEntity(myHostileProjectileEntity);
    }

    @Override
    protected void initGoals() {
        super.initGoals();

        this.goalSelector.add(3, new ProjectileAttackGoal(this, 1.25, 1, 20.0f));
    }

    @Override
    public void attack(LivingEntity target, float pullProgress) {
        this.spitAt(target);
    }
}
