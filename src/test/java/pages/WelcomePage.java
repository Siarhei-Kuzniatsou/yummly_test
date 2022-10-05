package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WelcomePage extends AbstractPage {
    private final By skipToTryYummlyWithoutPersonalization = By.id("com.yummly.android:id/skip_view");

    public WebElement getSkipToTryYummlyWithoutPersonalization() {
        return waitVisibilityOf(skipToTryYummlyWithoutPersonalization);
    }
}