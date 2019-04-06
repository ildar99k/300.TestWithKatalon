package test.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.BrowserFactory;
import test.pages.GoogleResultsPage;
import test.pages.GoogleSearchPage;
import test.pages.TinkoffMobilePage;

import java.util.concurrent.TimeUnit;

public class Application {
    private WebDriverWait wait;
    private static WebDriver webDriver;
    private final GoogleSearchPage googleSearchPage;
    private final GoogleResultsPage googleResultsPage;
    private final TinkoffMobilePage tinkoffMobilePage;

    public Application() {
        webDriver = new EventFiringWebDriver(createWebDriver());
        ((EventFiringWebDriver) webDriver).register(new BrowserFactory.MyListener());
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(webDriver, 10);

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


    private WebDriver createWebDriver() {
        return BrowserFactory.create();
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

}
