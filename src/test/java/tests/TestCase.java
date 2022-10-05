package tests;

import configuration.DriverProvider;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class TestCase {

    @BeforeTest
    public void setUp()  {
        DriverProvider.startApp();
    }

    @AfterTest
    public void tearDown() {
        DriverProvider.getDriver().quit();
    }

}
