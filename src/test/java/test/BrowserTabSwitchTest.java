package test;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import test.helpers.Selector;
import test.pages.GoogleResultsPage;
import test.pages.GoogleSearchPage;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BrowserTabSwitchTest extends BaseRunner{
    @Test
    public void test1() {
        String searchLink="https://www.tinkoff.ru/mobile-operator/tariffs/";
        GoogleSearchPage googleSearchPage=app.getGoogleSearchPage();
        googleSearchPage.open();
        googleSearchPage.typeInSearchField("мобайл тинькофф");
        List<WebElement> elements= Selector.getSelectElementsInGoogleByXpath("//ul[@role='listbox']/li[@role='presentation' and .//*[@role='option']]");
        Selector.getSelectElementByText("мобайл тинькофф тарифы",elements).click();
        GoogleResultsPage googleResultsPage=app.getGoogleResultsPage();
        googleResultsPage.clickSearchResultsByLinkContains(searchLink);
        googleResultsPage.switchToTab("Тарифы Тинькофф Мобайла");
        googleResultsPage.isLoadedByTitleCheck("Тарифы Тинькофф Мобайла");
        assertEquals("Тарифы Тинькофф Мобайла",googleResultsPage.getCurrentTitle());
        googleResultsPage.switchToTab("Google");
        googleResultsPage.closeCurrentTab();
        googleResultsPage.switchToTab("Тарифы Тинькофф Мобайла");
        assertEquals(searchLink,googleResultsPage.getCurrentUrl());
    }

}
