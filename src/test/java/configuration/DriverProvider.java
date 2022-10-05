package configuration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import static configuration.PropertyLoader.Property.*;

public class DriverProvider {

    private static AppiumDriver<MobileElement> driver;
    private static WebDriverWait  wait;
    public static void startApp() {
        DesiredCapabilities capabilities = initCapabilities();
        try {
            driver = new AppiumDriver<>(new URL(PropertyLoader.get(DEVICE_ADDRESS)), capabilities);
            long timeOutInSeconds = Long.parseLong(PropertyLoader.get(WAIT));
            wait = new WebDriverWait(driver, timeOutInSeconds);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private static DesiredCapabilities initCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PropertyLoader.get(PLATFORM_NAME));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PropertyLoader.get(PLATFORM_VERSION));
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, PropertyLoader.get(DEVICE_NAME));
        capabilities.setCapability("appActivity", PropertyLoader.get(APP_ACTIVITY));
        capabilities.setCapability("appPackage", PropertyLoader.get(APP_PACKAGE));
        return capabilities;
    }

    public static AppiumDriver<MobileElement> getDriver() {
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

}
