package trinsdar.ic2classictweaker;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ic2.api.classic.recipe.ClassicRecipes;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenMethodStatic;

@ZenExpansion("mods.ic2.Macerator")
@ZenRegister
public class MaceratorSupport {
    @ZenMethodStatic
    public static void addRecipe(IItemStack output, IIngredient input) {
        CraftTweakerActions.apply(new BasicRecipeAddManager(ClassicRecipes.macerator, IC2RecipeInputs.of(input),null, CraftTweakerMC.getItemStack(output)));
    }

    @ZenMethodStatic
    public static void removeRecipe(IIngredient input){
        CraftTweakerActions.apply(new BasicRecipeRemoveManager(ClassicRecipes.macerator, IC2RecipeInputs.of(input)));
    }
}
