package test.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.app.Application;

import java.util.List;

public class Checkbox {
    private static void mark(WebElement element) {
        if (!isMarked(element)) {
            element.click();
        }
    }

    private static void unmark(WebElement element) {
        if (isMarked(element)) {
            element.click();
        }
    }

    private static boolean isMarked(WebElement element) {
        return element.getAttribute("class").contains("checked");
    }

    public static List<WebElement> getByXpath(String xpath) {
        List<WebElement> elements = null;
        try {
            elements = (Application.getWebDriver().findElements(By.xpath(xpath)));
        } catch (Exception e) {
        } finally {
            return elements;
        }
    }

    public static void markAll(List<WebElement> elements) {
        for (WebElement element : elements) {
            Checkbox.mark(element);
        }
    }

    public static void unmarkAll(List<WebElement> elements) {
        for (WebElement element : elements) {
            Checkbox.unmark(element);
        }
    }
}
