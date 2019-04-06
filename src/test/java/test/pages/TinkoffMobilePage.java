package test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import test.helpers.Checkbox;
import test.helpers.Selector;

import java.util.List;

public class TinkoffMobilePage extends Page {
    public TinkoffMobilePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public void open() {
        webDriver.get("https://www.tinkoff.ru/mobile-operator/tariffs/");
        isLoadedByTitleCheck("Тарифы Тинькофф Мобайла");
    }

    private int getTotalPrice() {
        return Integer.parseInt(searchElementsByTextContains("Общая цена").get(0).getText().replaceAll("[^0-9]+", ""));
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
        List<WebElement> selectElements = Selector.getElementsFromSelectorByXpath("//div[@class='ui-dropdown-field-list ui-dropdown-field-list__opened']//span[@class='ui-dropdown-field-list__item-text']");
        selectElements.get(selectElements.size() - 1).click();//макс выбор для интернета
        getElementByXpath(".//span[contains(text(),'Звонки')]/following-sibling::div").click();
        selectElements = Selector.getElementsFromSelectorByXpath("//div[@class='ui-dropdown-field-list ui-dropdown-field-list__opened']//span[@class='ui-dropdown-field-list__item-text']");
        selectElements.get(selectElements.size() - 1).click();//макс выбор для звонков
        Checkbox.markAll(Checkbox.getByXpath(".//div[contains(@class,'CheckboxWithDescription')]/div"));
        return getTotalPrice();
    }

    public int getZeroPrice() {
        getElementByXpath(".//span[contains(text(),'Интернет')]/following-sibling::div").click();
        driverWait.until(webDriver -> Selector.getElementsFromSelectorByXpath("//div[@class='ui-dropdown-field-list ui-dropdown-field-list__opened']//span[@class='ui-dropdown-field-list__item-text']").get(0).isDisplayed());
        List<WebElement> selectElements = Selector.getElementsFromSelectorByXpath("//div[@class='ui-dropdown-field-list ui-dropdown-field-list__opened']//span[@class='ui-dropdown-field-list__item-text']");
        selectElements.get(0).click();//мин выбор для интернета
        getElementByXpath(".//span[contains(text(),'Звонки')]/following-sibling::div").click();
        selectElements = Selector.getElementsFromSelectorByXpath("//div[@class='ui-dropdown-field-list ui-dropdown-field-list__opened']//span[@class='ui-dropdown-field-list__item-text']");
        List<WebElement> finalSelectElements1 = selectElements;
        driverWait.until(webDriver -> finalSelectElements1.get(0).isDisplayed());
        selectElements.get(0).click();//мин выбор для звонков
        Checkbox.unmarkAll(Checkbox.getByXpath(".//div[contains(@class,'CheckboxWithDescription')]/div"));
        return getTotalPrice();
    }
}
