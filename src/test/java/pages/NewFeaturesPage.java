package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NewFeaturesPage extends AbstractPage{
    private final By closeButton = By.id("com.yummly.android:id/closeButton");
    private final By title = By.id("com.yummly.android:id/titleTextView");

    public WebElement getCloseButton() {
        return waitVisibilityOf(closeButton);
    }

    public WebElement getTitle() {
        return waitVisibilityOf(title);
    }

}
