package test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage extends Page {
    public GoogleSearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {
        webDriver.get("https://www.google.ru/");
        isLoadedByTitleCheck("Google");
    }

    public void typeInSearchField(String text) {
        getElementByXpath("//input[@class='gLFyf gsfi']").click();
        getElementByXpath("//input[@class='gLFyf gsfi']").clear();
        getElementByXpath("//input[@class='gLFyf gsfi']").sendKeys(text);
    }
}
