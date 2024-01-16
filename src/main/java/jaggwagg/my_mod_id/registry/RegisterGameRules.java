package jaggwagg.my_mod_id.registry;

import jaggwagg.my_mod_id.MyMod;
import jaggwagg.my_mod_id.world.ModBooleanGameRules;
import jaggwagg.my_mod_id.world.ModIntegerGameRules;
import net.fabricmc.fabric.api.gamerule.v1.CustomGameRuleCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.Arrays;

public class RegisterGameRules {
    public static final CustomGameRuleCategory MY_MOD_GAMERULE_CATEGORY = new CustomGameRuleCategory(new Identifier(MyMod.MOD_ID, MyMod.MOD_ID), Text.translatable("gamerule.category." + MyMod.MOD_ID).formatted(Formatting.YELLOW, Formatting.BOLD));

    public static void init() {
        Arrays.stream(ModBooleanGameRules.values()).forEach(Enum::describeConstable);
        Arrays.stream(ModIntegerGameRules.values()).forEach(Enum::describeConstable);
    }
}
