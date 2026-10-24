package xyz.slothy.client.recipe;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import org.jspecify.annotations.NonNull;
import xyz.slothy.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class SimpleTophatRecipeProvider extends FabricRecipeProvider {
    public SimpleTophatRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected @NonNull RecipeProvider createRecipeProvider(
            HolderLookup.@NonNull Provider registries,
            @NonNull BootstrapContext<Recipe<?>> recipes,
            @NonNull BootstrapContext<Advancement> advancements
    ) {
        return new RecipeProvider(recipes, advancements) {
            @Override
            public void buildRecipes() {
                this.dyedItem(ModItems.TOPHAT, "dyed_tophat");

                this.shaped(RecipeCategory.COMBAT, ModItems.TOPHAT)
                      .unlockedBy("has_wool", this.has(ItemTags.WOOL))
                      .define('#', Items.WOOL.black())
                      .define('C', Items.WOOL.white())
                      .define('S', Items.WOOL_SLAB.black())
                      .group("tophat_dye")
                      .pattern(" # ")
                      .pattern(" C ")
                      .pattern("SSS")
                      .save(this.output);
            }
        };
    }

    @Override
    public @NonNull String getName() {
        return "SimpleTophatRecipeProvider";
    }
}
