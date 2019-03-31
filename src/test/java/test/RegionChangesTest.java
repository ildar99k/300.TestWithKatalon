package test;

import org.junit.Test;
import org.openqa.selenium.By;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class RegionChangesTest extends BaseRunner {
    @Test
    public void test() {
        driver.get("https://www.tinkoff.ru/mobile-operator/tariffs/");
        driver.findElement(By.xpath(".//*[contains(text(),'Нет')]")).click();
        driver.findElement(By.xpath(".//div[contains(text(),'Москва и Московская обл.')]")).click();
        assertEquals("Москва и Московская область", driver.findElement(By.xpath(".//div[contains(@class,'RegionConfirmation__title')]")).getText());
        driver.navigate().refresh();
        assertEquals("Москва и Московская область", driver.findElement(By.xpath(".//div[contains(@class,'RegionConfirmation__title')]")).getText());
        int priceInMoscow= Integer.parseInt(driver.findElement(By.xpath(".//*[contains(text(),'Общая цена')]")).getText().replaceAll("[^0-9]+",""));
        driver.findElement(By.xpath(".//*[contains(text(),'Москва')]")).click();
        driver.findElement(By.xpath(".//*[contains(text(),'Краснодарский')]")).click();
        assertEquals("Краснодарский край", driver.findElement(By.xpath(".//div[contains(@class,'RegionConfirmation__title')]")).getText());
        int priceInKrasnodar= Integer.parseInt(driver.findElement(By.xpath(".//*[contains(text(),'Общая цена')]")).getText().replaceAll("[^0-9]+",""));
        assertNotEquals(priceInMoscow,priceInKrasnodar);
        driver.findElement(By.xpath(".//span[contains(text(),'Интернет')]"));
        int moscowMaxSum;
        int krasnodarMaxSum;
        //driver.findElement(By.xpath(".//*[contains(text(),'Интернет')]")).click();
    }
}