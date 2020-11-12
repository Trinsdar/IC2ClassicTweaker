package trinsdar.ic2classictweaker;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import ic2.api.classic.recipe.ClassicRecipes;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenMethodStatic;

@ZenExpansion("mods.ic2.Extractor")
@ZenRegister
public class ExtractorSupport {
    @ZenMethodStatic
    public static void removeRecipe(IIngredient input){
        CraftTweakerActions.apply(new BasicRecipeRemoveManager(ClassicRecipes.extractor, IC2RecipeInputs.of(input)));
    }
}