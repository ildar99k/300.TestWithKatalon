package test;

import org.junit.Test;
import test.pages.TinkoffMobilePage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class RegionChangesTest extends BaseRunner {
    @Test
    public void testSaveRegionAfterRefresh() {
        TinkoffMobilePage tinkoffMobilePage = app.getTinkoffMobilePage();
        tinkoffMobilePage.open();
        tinkoffMobilePage.searchElementsByTextContains("Нет").get(0).click();
        tinkoffMobilePage.searchElementsByTextContains("Москва и Московская обл.").get(0).click();
        assertEquals("Москва и Московская область", tinkoffMobilePage.getElementByXpath(".//div[contains(@class,'RegionConfirmation__title')]").getText());
        tinkoffMobilePage.refreshTab();
        assertEquals("Москва и Московская область", tinkoffMobilePage.getElementByXpath(".//div[contains(@class,'RegionConfirmation__title')]").getText());
    }

    @Test
    public void testForDefaultPrice() {
        TinkoffMobilePage tinkoffMobilePage = app.getTinkoffMobilePage();
        tinkoffMobilePage.open();
        tinkoffMobilePage.searchElementsByTextContains("Нет").get(0).click();
        tinkoffMobilePage.searchElementsByTextContains("Москва и Московская обл.").get(0).click();
        assertNotEquals(tinkoffMobilePage.getDefaultPriceForRegion("Москва и Московская обл."), tinkoffMobilePage.getDefaultPriceForRegion("Краснодарский кр."));
    }

    @Test
    public void testForMaxPrice() {
        TinkoffMobilePage tinkoffMobilePage = app.getTinkoffMobilePage();
        tinkoffMobilePage.open();
        tinkoffMobilePage.searchElementsByTextContains("Нет").get(0).click();
        tinkoffMobilePage.searchElementsByTextContains("Москва и Московская обл.").get(0).click();
        assertEquals(tinkoffMobilePage.getMaxPriceForRegion("Москва и Московская обл."), tinkoffMobilePage.getMaxPriceForRegion("Краснодарский кр."));
    }

}