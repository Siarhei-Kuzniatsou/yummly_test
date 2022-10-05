package com.yummly.pages;

import com.yummly.configuration.DriverProvider;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends BottomNavigationPanel {
    private final By searchField = By.id("com.yummly.android:id/search_src_text");
    private final By searchResult = By.id("com.yummly.android:id/grid_item_container");

    public WebElement getSearchField() {
        return waitVisibilityOf(searchField);
    }

    public List<MobileElement> getSearchResults() {
        waitVisibilityOf(searchResult);
        return DriverProvider.getDriver().findElements(searchResult);
    }
}
