package jaggwagg.my_mod_id.datagen;

import jaggwagg.my_mod_id.datagen.language.ModLanguageEnglishProvider;
import jaggwagg.my_mod_id.datagen.model.ModModelGenerator;
import jaggwagg.my_mod_id.datagen.recipe.ModRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class MyModDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModLanguageEnglishProvider::new);
        pack.addProvider(ModModelGenerator::new);
        pack.addProvider(ModRecipeProvider::new);
    }
}
