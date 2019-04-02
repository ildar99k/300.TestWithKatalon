package test.pages;

import org.openqa.selenium.By;
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
    public void typeInSearchField(String text){
        webDriver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).click();
        webDriver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).clear();
        webDriver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys(text);
    }
}
