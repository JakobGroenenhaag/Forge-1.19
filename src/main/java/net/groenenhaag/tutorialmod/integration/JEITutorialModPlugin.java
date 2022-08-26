package net.groenenhaag.tutorialmod.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.groenenhaag.tutorialmod.TutorialMod;
import net.groenenhaag.tutorialmod.recipe.TutorialTableRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEITutorialModPlugin implements IModPlugin {
    public static RecipeType<TutorialTableRecipe> CRAFTING_TYPE =
            new RecipeType<>(TutorialTableRecipeCategory.UID, TutorialTableRecipe.class);
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(TutorialMod.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new TutorialTableRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        List<TutorialTableRecipe> recipesTutorialTableCrafting = rm.getAllRecipesFor(TutorialTableRecipe.Type.INSTANCE);
        registration.addRecipes(CRAFTING_TYPE, recipesTutorialTableCrafting);
    }
}
