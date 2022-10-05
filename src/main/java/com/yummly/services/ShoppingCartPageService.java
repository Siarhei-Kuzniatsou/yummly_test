package com.yummly.services;

import com.yummly.pages.ShoppingCardPage;


public class ShoppingCartPageService {
    private static final ShoppingCardPage shoppingCardPage = new ShoppingCardPage();

    public static void closePopUp() {
        shoppingCardPage.getAlertCloseButton().click();
    }

    public static void openIngredientMenu() {
        shoppingCardPage.getIngredientMenu().click();
    }

    public static void goToRecipe() {
        shoppingCardPage.getRecipeButton().click();
    }

}