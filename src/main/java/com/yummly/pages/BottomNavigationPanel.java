package com.yummly.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BottomNavigationPanel extends AbstractPage {
    private final By searchButton = By.id("com.yummly.android:id/nav_graph_search");

    public WebElement getSearchButton() {
        return waitVisibilityOf(searchButton);
    }
}
