package test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BrowserTabSwitchTest extends BaseRunner{
    @Test
    public void test1() {
        driver.get("https://www.google.ru/");
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).click();
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).clear();
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("мобайл тинькофф");
        By listItems = By.xpath("//ul[@role='listbox']/li[@role='presentation' and .//*[@role='option']]");
        List<WebElement> elements = driver.findElements(listItems);
        for (WebElement el : elements) {
            System.out.println(el);
            if (el.getText().contains("мобайл тинькофф тарифы")) {
                el.click();
                break;
            }
        }
        String oldTab = driver.getWindowHandle();
        String searchText="https://www.tinkoff.ru/mobile-operator/tariffs/";
        String title="Тарифы Тинькофф Мобайла";
        driver.findElement(By.xpath( String.format("//*[contains(text(),'%s')]", searchText))).click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        closeCurrentTab();
        driver.switchTo().window(tabs2.get(1));
        WebDriverWait wait=new WebDriverWait(driver,60);
        wait.until(driver->driver.getTitle().contains(title));
        if (!Objects.equals(driver.getCurrentUrl(), searchText)){
            System.out.println("Не ту вкладку закрыл");
        }
    }
    public void closeCurrentTab(){
        driver.close();
    }

}
