package test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleResultsPage extends Page {
    public GoogleResultsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void clickSearchResultsByLinkContains(String link) {
        driverWait.until(webDriver -> searchElementsByTextContains(link).size() > 0);
        searchElementsByTextContains(link).get(0).click();
    }
}
