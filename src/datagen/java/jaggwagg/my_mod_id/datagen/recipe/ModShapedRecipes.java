package jaggwagg.my_mod_id.datagen.recipe;

import jaggwagg.my_mod_id.block.ModBlocks;
import jaggwagg.my_mod_id.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.recipe.book.RecipeCategory;

public enum ModShapedRecipes {
    MY_BLOCK_WITH_BLOCK_ENTITY(ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MY_BLOCK_WITH_BLOCK_ENTITY.getBlock()).pattern("aaa").pattern("bbb")
            .input('a', ModItems.MY_ITEM.getItem())
            .input('b', ModBlocks.MY_BLOCK.getBlock())
            .criterion(FabricRecipeProvider.hasItem(ModItems.MY_ITEM.getItem()),
                    FabricRecipeProvider.conditionsFromItem(ModItems.MY_ITEM.getItem()))
            .criterion(FabricRecipeProvider.hasItem(ModBlocks.MY_BLOCK.getBlock()),
                    FabricRecipeProvider.conditionsFromItem(ModBlocks.MY_BLOCK.getBlock())));

    public final ShapedRecipeJsonBuilder shapedRecipeJsonBuilder;

    ModShapedRecipes(ShapedRecipeJsonBuilder shapedRecipeJsonBuilder) {
        this.shapedRecipeJsonBuilder = shapedRecipeJsonBuilder;
    }

    public ShapedRecipeJsonBuilder getShapedRecipeJsonBuilder() {
        return this.shapedRecipeJsonBuilder;
    }
}
