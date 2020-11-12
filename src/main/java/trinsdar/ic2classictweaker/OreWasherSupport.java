package trinsdar.ic2classictweaker;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenMethodStatic;
import trinsdar.ic2c_extras.recipes.Ic2cExtrasRecipes;

@ModOnly("ic2c_extras")
@ZenExpansion("mods.ic2.OreWasher")
@ZenRegister
public class OreWasherSupport {
    @ZenMethodStatic
    public static void removeRecipe(IIngredient input){
        CraftTweakerActions.apply(new BasicRecipeRemoveManager(Ic2cExtrasRecipes.oreWashingPlant, IC2RecipeInputs.of(input)));
    }
}