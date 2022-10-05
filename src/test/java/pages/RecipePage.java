package pages;

import configuration.DriverProvider;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RecipePage extends AbstractPage {
    private final By ingredient = By.id("com.yummly.android:id/item_toggle");
    private final By shoppingCartButton = By.id("com.yummly.android:id/shopping_cart_shop_container");
    private final By ingredientsHeader = By.id("com.yummly.android:id/ingredients_header_container");
    private final By nutritionHeader = By.id("com.yummly.android:id/nutritionHeader");

    public List<MobileElement> getIngredients() {
        waitVisibilityOf(ingredient);
        return DriverProvider.getDriver().findElements(ingredient);
    }

    public WebElement getShoppingCartButton() {
        return waitVisibilityOf(shoppingCartButton);
    }

    public WebElement getNutritionHeader() {
        return DriverProvider.getDriver().findElement(nutritionHeader);
    }

    public boolean isIngredientsHeaderDisplayed() {
        try {
            return DriverProvider.getDriver().findElement(ingredientsHeader).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}