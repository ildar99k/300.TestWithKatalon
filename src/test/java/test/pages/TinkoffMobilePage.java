package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import test.helpers.Checkbox;
import test.helpers.Selector;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TinkoffMobilePage extends Page {
    public TinkoffMobilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {
        webDriver.get("https://www.tinkoff.ru/mobile-operator/tariffs/");
        isLoadedByTitleCheck("Тарифы Тинькофф Мобайла");
    }

    private int getTotalPrice() {
        return Integer.parseInt(webDriver.findElement(By.xpath(".//*[contains(text(),'Общая цена')]")).getText().replaceAll("[^0-9]+", ""));
    }

    public int getDefaultPriceForRegion(String region) {
        getElementByXpath(".//div[contains(@class,'RegionConfirmation__title')]").click();
        searchElementsByTextContains(region).get(0).click();
        return getTotalPrice();
    }

    public int getMaxPriceForRegion(String region) {
        getElementByXpath(".//div[contains(@class,'RegionConfirmation__title')]").click();
        searchElementsByTextContains(region).get(0).click();
        getElementByXpath(".//span[contains(text(),'Интернет')]/following-sibling::div").click();
        List<WebElement> selectElements = Selector.getElementsFromSelectorByXpath(".//div[contains(@class, 'ui-form__row')][1]//span[@class='ui-dropdown-field-list__item-text']");
        webDriver.manage().timeouts().setScriptTimeout(1, TimeUnit.SECONDS); //Лучше ничего не придумал(
        selectElements.get(selectElements.size() - 1).click();//макс выбор для интернета
        getElementByXpath(".//span[contains(text(),'Звонки')]/following-sibling::div").click();
        webDriver.manage().timeouts().setScriptTimeout(1, TimeUnit.SECONDS);
        selectElements = Selector.getElementsFromSelectorByXpath(".//div[contains(@class, 'ui-form__row')][2]//span[@class='ui-dropdown-field-list__item-text']");
        selectElements.get(selectElements.size() - 1).click();//макс выбор для звонков
        Checkbox.markAllCheckBoxes(Checkbox.getCheckBoxesByXpath(".//div[contains(@class,'CheckboxWithDescription')]/div"));
        return getTotalPrice();
    }

    public int getZeroPrice() {
        getElementByXpath(".//span[contains(text(),'Интернет')]/following-sibling::div").click();
        List<WebElement> selectElements = Selector.getElementsFromSelectorByXpath(".//div[contains(@class, 'ui-form__row')][1]//span[@class='ui-dropdown-field-list__item-text']");
        webDriver.manage().timeouts().setScriptTimeout(2, TimeUnit.SECONDS); //Лучше ничего не придумал(
        selectElements.get(0).click();//мин выбор для интернета
        getElementByXpath(".//span[contains(text(),'Звонки')]/following-sibling::div").click();
        webDriver.manage().timeouts().setScriptTimeout(2, TimeUnit.SECONDS);
        selectElements = Selector.getElementsFromSelectorByXpath(".//div[contains(@class, 'ui-form__row')][2]//span[@class='ui-dropdown-field-list__item-text']");
        selectElements.get(0).click();//мин выбор для звонков
        Checkbox.unmarkAllCheckBoxes(Checkbox.getCheckBoxesByXpath(".//div[contains(@class,'CheckboxWithDescription')]/div"));
        return getTotalPrice();
    }
}
