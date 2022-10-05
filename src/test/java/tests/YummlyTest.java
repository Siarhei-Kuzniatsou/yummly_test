package tests;

import entity.Ingredient;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.*;

public class YummlyTest extends TestCase {

    String testRecipe = "tiramisu";

    @Test
    public void criticalPathTest() {
        WelcomePageService.skipToTryYummlyWithoutPersonalization();
        NewFeaturesPageService.goToLastFeature();
        NewFeaturesPageService.closeNewFeatures();
        HomePageService.goToSearch();
        SearchPageService.search(testRecipe);
        SearchPageService.chooseFirstSearchResult();
        Ingredient ingredient = RecipePageService.getLastIngredient();

        Assert.assertTrue(ingredient.hasPlusToggle(), "The last ingredient already has minus toggle");

        RecipePageService.addLastIngredientToShoppingList();
        ingredient = RecipePageService.getLastIngredient();

        Assert.assertTrue(ingredient.hasMinusToggle(), "The toggle of ingredient has not been changed");

        RecipePageService.goToShoppingCart();
        ShoppingCartPageService.closePopUp();
        ShoppingCartPageService.openIngredientMenu();
        ShoppingCartPageService.goToRecipe();
        ingredient = RecipePageService.getLastIngredient();

        Assert.assertTrue(ingredient.hasMinusToggle(), "The toggle of ingredient doesn't have minus toggle");

    }

}
