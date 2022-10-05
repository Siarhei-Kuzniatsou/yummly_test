package services;

import entity.Ingredient;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import pages.RecipePage;

import java.util.List;

import static services.MobileActions.Direction.*;

public class RecipePageService {
    private static final RecipePage recipePage = new RecipePage();

    private static void goToLastIngredient() {
        List<MobileElement> ingredients = recipePage.getIngredients();
        MobileElement lastIngredient = ingredients.get(ingredients.size() - 1);
        String lastIngredientValue = getIngredientContentDescription(lastIngredient);
        MobileActions.scroll(lastIngredient.getLocation(), UP);
        ingredients = recipePage.getIngredients();
        String lastIngredientValueAfterScroll = getIngredientContentDescription(ingredients.get(ingredients.size() - 1));

        while (!lastIngredientValue.equals(lastIngredientValueAfterScroll)) {
            ingredients = recipePage.getIngredients();
            lastIngredient = ingredients.get(ingredients.size() - 1);
            lastIngredientValue = lastIngredientValueAfterScroll;
            MobileActions.scroll(lastIngredient.getLocation(), UP);
            lastIngredientValueAfterScroll = getIngredientContentDescription(lastIngredient);
        }
    }

    public static void addLastIngredientToShoppingList() {
        List<MobileElement> ingredients = recipePage.getIngredients();
        WebElement lastIngredients = ingredients.get(ingredients.size() - 1);
        lastIngredients.click();
    }

    public static void goToShoppingCart() {
        MobileActions.scroll(recipePage.getNutritionHeader().getLocation(), DOWN);
        while (!recipePage.isIngredientsHeaderDisplayed()) {
            List<MobileElement> ingredients = recipePage.getIngredients();
            MobileElement lastIngredient = ingredients.get(ingredients.size() - 1);
            MobileActions.scroll(lastIngredient.getLocation(), DOWN);
        }
        recipePage.getShoppingCartButton().click();
    }

    public static Ingredient getLastIngredient() {
        goToLastIngredient();
        List<MobileElement> ingredients = recipePage.getIngredients();
        MobileElement lastIngredientElement = ingredients.get(ingredients.size() - 1);
        return new Ingredient(getIngredientContentDescription(lastIngredientElement));
    }

    private static String getIngredientContentDescription(MobileElement ingredient) {
        return ingredient.getAttribute("content-desc");
    }

}