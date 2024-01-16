package jaggwagg.my_mod_id;

import jaggwagg.my_mod_id.config.ModConfig;
import jaggwagg.my_mod_id.config.ModConfigManager;
import jaggwagg.my_mod_id.registry.*;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class MyMod implements ModInitializer {
    public static final String MOD_ID = "my_mod_id";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final String CONFIG_FILE_PATH = System.getProperty("user.dir") + File.separator + "/config/" + MOD_ID + ".json";
    public static final ModConfig CONFIG = ModConfigManager.loadConfig(CONFIG_FILE_PATH);

    public static void loggerInfo(String message) {
        LOGGER.info(MOD_ID + ": " + message);
    }

    @Override
    public void onInitialize() {
        RegisterBlocks.init();
        RegisterBlockEntityTypes.init();
        RegisterGameRules.init();
        RegisterItems.init();
        RegisterItemGroups.init();
        RegisterEntityTypes.init();
        RegisterStatusEffects.init();
    }
}
