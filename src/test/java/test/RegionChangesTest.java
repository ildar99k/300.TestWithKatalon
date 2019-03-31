package test;

import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class RegionChangesTest extends BaseRunner {
    @Test
    public void test() {
        driver.get("https://www.tinkoff.ru/mobile-operator/tariffs/");
        driver.findElement(By.xpath(".//div[contains(@class,'RegionConfirmation__title')]//span[@text()='Нет, изменить')]")).click();
        driver.findElement(By.xpath("//div[text()='Москва и Московская обл.']")).click();
        assertEquals("Москва и Московская область", driver.findElement(By.xpath(".//div[contains(@class,'RegionConfirmation__title')]")).getText());

    }
}