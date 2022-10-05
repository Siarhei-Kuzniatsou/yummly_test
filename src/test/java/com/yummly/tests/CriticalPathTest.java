package com.yummly.tests;

import com.yummly.entity.Ingredient;
import com.yummly.services.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CriticalPathTest extends TestCase {

    String testRecipe = "tiramisu";

    @Test(description = "Verify that last ingredient has 'minus' toggle button beside it after it has been added to the shopping cart")
    public void checkMinusToggleTest() {
        WelcomePageService.skipToTryYummlyWithoutPersonalization();
        NewFeaturesPageService.goToLastFeature();
        NewFeaturesPageService.closeNewFeatures();
        HomePageService.goToSearch();
        SearchPageService.search(testRecipe);
        SearchPageService.chooseFirstSearchResult();
        Ingredient ingredient = RecipePageService.getLastIngredient();

        Assert.assertTrue(ingredient.hasPlusToggle(), "The last ingredient already has minus toggle");
        String testIngredient = ingredient.getDescription();

        RecipePageService.addLastIngredientToShoppingList();
        ingredient = RecipePageService.getLastIngredient();

        Assert.assertTrue(ingredient.hasMinusToggle(), "The toggle of ingredient has not been changed");

        RecipePageService.goToShoppingCart();
        ShoppingCartPageService.closePopUp();
        ShoppingCartPageService.openIngredientMenu();
        ShoppingCartPageService.goToRecipe();
        ingredient = RecipePageService.getLastIngredient();

        Assert.assertTrue(ingredient.hasMinusToggle(), "The toggle of ingredient doesn't have minus toggle");
        Assert.assertEquals(ingredient.getDescription(), testIngredient, "The last ingredient is not equal to the expected");
    }
}
