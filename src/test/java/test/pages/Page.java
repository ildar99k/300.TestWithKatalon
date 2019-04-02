package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Page {
    final WebDriver webDriver;
    final WebDriverWait driverWait;
    Page(WebDriver webDriver) {
        this.webDriver = webDriver;
        driverWait = new WebDriverWait(webDriver, 10);
    }

    public void isLoadedByTitleCheck(String substring) {
        driverWait.until(webDriver -> webDriver.getTitle().contains(substring));
    }

    public void switchToTab(String windowName){
        driverWait.until(webDriver -> {
            boolean check = false;
            for (String title : webDriver.getWindowHandles()) {
                webDriver.switchTo().window(title);
                if (webDriver.getTitle().contains(windowName)){
                    return true;
                }
            }
            return false;
        });
    }

    public List<WebElement> searchElementsByTextContains(String searchText) {
        String xpath = String.format("//*[contains(text(),'%s')]", searchText);
        return webDriver.findElements(By.xpath(xpath));
    }
    public void closeCurrentTab(){
        webDriver.close();
    }
    public void checkTitle(String title){
    if (!webDriver.getTitle().equals(title)){
        System.out.println("Не тот title");
        System.exit(-1);
    }
    }

    public void open(){

    }

    public void checkLink(String link){
        if (!webDriver.getCurrentUrl().equals(link)){
            System.out.println("не та link");
            System.exit(-1);
        }
    }
    public String getCurrentTitle(){
        return webDriver.getTitle();
    }
    public  String getCurrentUrl(){
        return webDriver.getCurrentUrl();
    }
    public WebElement getElementByXpath(String xpath){
        return webDriver.findElement(By.xpath(xpath));
    }
    public void refreshTab(){
        webDriver.navigate().refresh();
    }
}