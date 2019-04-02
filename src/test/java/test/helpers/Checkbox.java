package test.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.app.Application;

import java.util.List;

public class Checkbox {
    private static void markCheckBox(WebElement element){
        if ( !isMarked(element) )
        {
            element.click();
        }
    }
    private static void unmarkCheckBox(WebElement element){
        if (isMarked(element))
        { element.click();
        }
    }
    private static boolean isMarked(WebElement element){
        return element.isSelected();
    }
    public static List<WebElement> getCheckBoxesByXpath(String xpath){
        List<WebElement> elements = null;
        try {
            elements=(Application.getWebDriver().findElements(By.xpath(xpath)));
        }
        catch (Exception e){
        }
        finally {
            return elements;
        }
    }
    public static void markAllCheckBoxes(List<WebElement> elements){
        for (WebElement element:elements){
            Checkbox.markCheckBox(element);
        }
    }
    public static void unmarkAllCheckBoxes(List<WebElement> elements){
        for (WebElement element:elements){
            Checkbox.unmarkCheckBox(element);
        }
    }
}
