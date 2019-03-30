package trinsdar.ic2classictweaker;

import crafttweaker.IAction;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ic2.api.classic.recipe.ClassicRecipes;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.Arrays;
import java.util.Locale;

@ModOnly("ic2")
@ZenClass("mods.ic2.RareEarthExtractor")
@ZenRegister
public class RareEarthExtractorSupport {

    @ZenMethod
    public static void addRareEarthEntries(float value, IItemStack... input) {
        CraftTweakerActions.apply(new RareEarthValueAdditionAction(value, CraftTweakerMC.getItemStacks(input)));
    }

    @ZenMethod
    public static void removeRareEarthEntries(IItemStack input) {
        CraftTweakerActions.apply(new RareEarthValueRemovalAction(CraftTweakerMC.getItemStack(input)));
    }

    private static final class RareEarthValueAdditionAction implements IAction {

        private final ItemStack[] input;
        private final float value;

        RareEarthValueAdditionAction(float value, ItemStack... input) {
            this.input = input;
            this.value = value;
        }

        @Override
        public void apply() {
            ClassicRecipes.earthExtractor.registerValue(value, input);
        }

        @Override
        public String describe() {
            return String.format(Locale.ENGLISH, "Add Entry[%s, %s] to %s", this.value, Arrays.deepToString(this.input), ClassicRecipes.earthExtractor);
        }
    }

    private static final class RareEarthValueRemovalAction implements IAction {

        private final ItemStack input;

        RareEarthValueRemovalAction(ItemStack input) {
            this.input = input;
        }

        @Override
        public void apply() {
            ClassicRecipes.earthExtractor.removeEntry(new ItemStack(input.getItem(), 1, input.getItem().getDamage(input)));
        }

        @Override
        public String describe() {
            return String.format(Locale.ENGLISH, "Remove Entry[%s] from %s", this.input, ClassicRecipes.earthExtractor);
        }
    }
}
