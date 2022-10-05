package com.yummly.services;

import org.openqa.selenium.WebElement;
import com.yummly.pages.NewFeaturesPage;

import static com.yummly.services.MobileActions.Direction.LEFT;

public class NewFeaturesPageService {
    private final static NewFeaturesPage newFeaturesPage = new NewFeaturesPage();

    public static void closeNewFeatures() {
        newFeaturesPage.getCloseButton().click();
    }

    public static void goToLastFeature() {
        WebElement title = newFeaturesPage.getTitle();
        MobileActions.swipe(LEFT);
        WebElement titleAfterSwipe = newFeaturesPage.getTitle();
        while (!title.equals(titleAfterSwipe)) {
            title = titleAfterSwipe;
            MobileActions.swipe(LEFT);
            titleAfterSwipe = newFeaturesPage.getTitle();
        }
    }
}
