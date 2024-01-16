package jaggwagg.my_mod_id.world;

import com.google.common.base.CaseFormat;
import jaggwagg.my_mod_id.registry.RegisterGameRules;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

import java.util.Locale;

public enum ModBooleanGameRules {
    MY_MOD_MY_BOOLEAN_GAMERULE(GameRuleFactory.createBooleanRule(true), "A boolean gamerule for my mod");

    private final String id;
    private final String description;
    private final GameRules.Key<GameRules.BooleanRule> key;

    ModBooleanGameRules(GameRules.Type<GameRules.BooleanRule> type, String description) {
        this.id = this.toString().toLowerCase(Locale.ROOT);
        this.description = description;
        this.key = GameRuleRegistry.register(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, this.toString()), RegisterGameRules.MY_MOD_GAMERULE_CATEGORY, type);
    }

    public String getId() {
        return this.id;
    }

    public String getDescription() {
        return this .description;
    }

    public GameRules.Key<GameRules.BooleanRule> getKey() {
        return this.key;
    }
}
