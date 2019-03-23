package test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

class BaseRunner {
    WebDriver driver;
    private String browserName = System.getProperty("browser");

    private WebDriver getWebDriver() {
        try {
            BrowserFactory.valueOf(System.getProperty("browser"));
        } catch (NullPointerException | IllegalArgumentException e) {
            browserName = getRandomBrowser();
            System.setProperty("browser", browserName);
        }

        return BrowserFactory.valueOf(browserName).create();
    }

    private String getRandomBrowser() {
        System.out.println("Driver not found. Running a random browser...");
        return BrowserFactory.values()[(int) (Math.random() * BrowserFactory.values().length)].toString();
    }

    @Before
    public void setUp() {
        driver = getWebDriver();
        driver.manage().window().maximize();
        String baseUrl = "https://www.tinkoff.ru/career/vacancies/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
