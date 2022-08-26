package net.groenenhaag.tutorialmod.integration;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.groenenhaag.tutorialmod.TutorialMod;
import net.groenenhaag.tutorialmod.block.ModBlocks;
import net.groenenhaag.tutorialmod.recipe.TutorialTableRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class TutorialTableRecipeCategory implements IRecipeCategory<TutorialTableRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(TutorialMod.MOD_ID, "tutorial_table_crafting");
    public static final ResourceLocation TEXTURE = new ResourceLocation(TutorialMod.MOD_ID, "textures/gui/tutorial_table_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public TutorialTableRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.TUTORIAL_TABLE.get()));
    }

    @Override
    public RecipeType<TutorialTableRecipe> getRecipeType() {
        return JEITutorialModPlugin.CRAFTING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.tutorialmod.tutorial_table");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, TutorialTableRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 86, 15).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 86, 60).addItemStack(recipe.getResultItem());
    }
}
