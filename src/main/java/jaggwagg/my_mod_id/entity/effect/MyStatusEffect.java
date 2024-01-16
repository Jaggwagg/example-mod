package jaggwagg.my_mod_id.entity.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class MyStatusEffect extends StatusEffect {
    public MyStatusEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0xffffff);
    }
}
