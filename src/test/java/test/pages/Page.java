package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Page {
    private final Logger logger = LoggerFactory.getLogger(Page.class);
    final WebDriver webDriver;
    final WebDriverWait driverWait;

    Page(WebDriver webDriver) {
        this.webDriver = webDriver;
        driverWait = new WebDriverWait(webDriver, 10);
    }

    public void isLoadedByTitleCheck(String substring) {
        driverWait.until(webDriver -> webDriver.getTitle().contains(substring));
    }

    public void switchToTab(String windowName) {
        driverWait.until(webDriver -> {
            boolean check = false;
            for (String title : webDriver.getWindowHandles()) {
                webDriver.switchTo().window(title);
                if (webDriver.getTitle().contains(windowName)) {
                    return true;
                }
            }
            return false;
        });
    }

    public List<WebElement> searchElementsByTextContains(String searchText) {
        String xpath = String.format("//*[contains(text(),'%s')]", searchText);
        driverWait.until(webDriver -> webDriver.findElements(By.xpath(xpath)).size() > 0);
        return webDriver.findElements(By.xpath(xpath));
    }

    public void closeCurrentTab() {
        webDriver.close();
        logger.info("Закрыта активная вкладка");
    }


    public void open() {

    }


    public String getCurrentTitle() {
        return webDriver.getTitle();
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public WebElement getElementByXpath(String xpath) {
        driverWait.until(webDriver -> webDriver.findElement(By.xpath(xpath)).isDisplayed());
        return webDriver.findElement(By.xpath(xpath));
    }

    public void refreshTab() {
        webDriver.navigate().refresh();
    }
}