package test.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import test.app.Application;

import java.util.List;

public class Selector {
    public static WebElement getSelectElementByText(String optionStr, List<WebElement> elementsToSearch) {
        for (WebElement el : elementsToSearch) {
            if (el.getText().contains(optionStr)) {
                return el;
            }
        }
        return null;
    }

    public static List<WebElement> getSelectElementsInGoogleByXpath(String xpath) {
        By listItems = By.xpath(xpath);
        return Application.getWebDriver().findElements(listItems);
    }

    public static List<WebElement> getSelectOptions(String xpath) {
        WebElement selectElem = Application.getWebDriver().findElement(By.tagName("select"));
        Select select = new Select(selectElem);
        return select.getOptions();
    }

    public static WebElement getCurrentValueOfSelect(String nameWhatSelect) {
        return Application.getWebDriver().findElement(By.xpath(".//span[contains(text(),'" + nameWhatSelect + "')]/following-sibling::div"));
    }

    public static List<WebElement> getElementsFromSelectorByXpath(String xpath) {
        List<WebElement> elements = null;
        try {
            elements = (Application.getWebDriver().findElements(By.xpath(xpath)));
        } catch (Exception e) {

        } finally {
            return elements;
        }
    }
}
