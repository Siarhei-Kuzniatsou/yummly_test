package services;

import com.google.common.collect.ImmutableMap;
import configuration.DriverProvider;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;
public class MobileActions {

    public enum Direction {
        UP,
        DOWN,
        RIGHT,
        LEFT
    }

    public static void scroll(Point from, Direction direction) {
        AppiumDriver<?> driver = DriverProvider.getDriver();
        from.x = from.getX() / 2;
        from.y = from.getY() / 2;
        new TouchAction<>(DriverProvider.getDriver())
                .longPress(PointOption.point(from))
                .moveTo(switch (direction) {
                    case UP -> PointOption.point(from.getX(), 0);
                    case DOWN -> PointOption.point(from.getX(), driver.manage().window().getSize().getHeight());
                    case LEFT -> PointOption.point(0, from.getY());
                    case RIGHT -> PointOption.point(driver.manage().window().getSize().getWidth(), from.getY());
                })
                .release()
                .perform();

    }

    public static void swipe(Direction direction) {
        AppiumDriver<?> driver = DriverProvider.getDriver();
        scroll(new Point(driver.manage().window().getSize().getHeight(), driver.manage().window().getSize().getWidth()), direction);
    }

    public static void clickSearchButtonFromKeyboard() {
        DriverProvider.getDriver().executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
    }
}
