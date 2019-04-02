package test.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.BrowserFactory;
import test.pages.GoogleResultsPage;
import test.pages.GoogleSearchPage;
import test.pages.TinkoffMobilePage;

import java.util.concurrent.TimeUnit;

public class Application {
    private static WebDriver webDriver;
    private final GoogleSearchPage googleSearchPage;
    private final GoogleResultsPage googleResultsPage;
    private final TinkoffMobilePage tinkoffMobilePage;
    private final String browserName = "chrome";
    public Application() {
        webDriver = BrowserFactory.valueOf(browserName).create();
        WebDriverWait driverWait = new WebDriverWait(webDriver, 10);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        googleSearchPage = new GoogleSearchPage(webDriver);
        googleResultsPage = new GoogleResultsPage(webDriver);
        tinkoffMobilePage = new TinkoffMobilePage(webDriver);
    }
    public void quit() {
        webDriver.quit();
        webDriver = null;
    }

    public GoogleSearchPage getGoogleSearchPage() {
        return googleSearchPage;
    }

    public GoogleResultsPage getGoogleResultsPage() {
        return googleResultsPage;
    }

    public TinkoffMobilePage getTinkoffMobilePage() {
        return tinkoffMobilePage;
    }

    public String getBrowserName() {
        return browserName;
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }
}
