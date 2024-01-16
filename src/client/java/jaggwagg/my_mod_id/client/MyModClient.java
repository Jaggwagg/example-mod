package jaggwagg.my_mod_id.client;

import jaggwagg.my_mod_id.MyMod;
import jaggwagg.my_mod_id.client.registry.ModEntityRenderers;
import net.fabricmc.api.ClientModInitializer;

public class MyModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModEntityRenderers.init();

        MyMod.loggerInfo("Initialized client");
    }
}
