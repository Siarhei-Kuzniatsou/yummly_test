package com.yummly.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ShoppingCardPage extends AbstractPage {
    private final By alertCloseButton = By.id("com.yummly.android:id/alert_close_button");
    private final By ingredientMenu = By.id("com.yummly.android:id/expand_menu");
    private final By recipeButton = By.xpath("//android.widget.TextView[@text='RECIPE']");

    public WebElement getAlertCloseButton() {
        return waitVisibilityOf(alertCloseButton);
    }

    public WebElement getIngredientMenu() {
        return waitVisibilityOf(ingredientMenu);
    }

    public WebElement getRecipeButton() {
        return waitVisibilityOf(recipeButton);
    }
}