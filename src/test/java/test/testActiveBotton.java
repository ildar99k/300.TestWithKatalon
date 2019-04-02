package test;

import org.junit.Test;
import test.pages.TinkoffMobilePage;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class testActiveBotton extends BaseRunner {
    @Test
    public void test1(){
        TinkoffMobilePage tinkoffMobilePage = app.getTinkoffMobilePage();
        tinkoffMobilePage.open();
        tinkoffMobilePage.searchElementsByTextContains("Нет").get(0).click();
        tinkoffMobilePage.searchElementsByTextContains("Москва и Московская обл.").get(0).click();
        assertEquals(0,tinkoffMobilePage.getZeroPrice());
        assertTrue(tinkoffMobilePage.getElementByXpath(".//button[contains(@class,'relative')]").isEnabled());
    }
}
