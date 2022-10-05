package pages;

import configuration.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AbstractPage {

    protected WebElement waitVisibilityOf(By element) {
        return DriverProvider.getWait().until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
