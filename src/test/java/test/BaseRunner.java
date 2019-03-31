package test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

class BaseRunner {
    WebDriver driver;

    private WebDriver getWebDriver() {
        String browserName = "chrome";
            return BrowserFactory.valueOf(browserName).create();
    }

    /*private String getRandomBrowser() {
        System.out.println("Driver not found. Running a random browser...");
        return BrowserFactory.values()[(int) (Math.random() * BrowserFactory.values().length)].toString();
    }*/

    @Before
    public void setUp() {
        driver = getWebDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
