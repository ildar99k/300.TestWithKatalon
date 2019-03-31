package test;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;

public class FirstTest extends BaseRunner {
    @Test
    public void test1() {
        driver.get("https://www.tinkoff.ru/career/vacancies/");

        driver.findElement(By.xpath(".//div[@class='ui-suggest']//input")).click();
        driver.findElement(By.xpath(".//div[@class='ui-inputdate']//input")).click();
        driver.findElement(By.xpath(".//div[@class='ui-dropdown-field']//input")).click();
        driver.findElement(By.xpath(".//div[@class='ui-form__field']//input[@type='email']")).click();
        driver.findElement(By.xpath(".//div[@class='ui-input ui-input_changed']//input")).click();
        driver.findElement(By.xpath(".//input[@name='socialLink0']")).click();
        driver.findElement(By.xpath(".//button[@type='submit']")).click();
        //////////////////////////////////////////////////////////////////div[@class='ui-form__row ui-form__row_default-error-view-visible']/div[@class='ui-form__field' and 1]/div[@class='ui-form-field-error-message ui-form-field-error-message_ui-form' and 2]
        assertEquals("Поле обязательное", driver.findElement(By.xpath(".//div[@class='ui-suggest']/following-sibling::div")).getText());
        assertEquals("Поле обязательное", driver.findElement(By.xpath(".//div[@class='ui-inputdate']/following-sibling::div")).getText());
        assertEquals("Поле обязательное", driver.findElement(By.xpath(".//div[@class='ui-dropdown-field']/following-sibling::div")).getText());
        assertEquals("Поле обязательное", driver.findElement(By.xpath(".//div[@class='ui-input ui-input_error']/following-sibling::div")).getText());
        assertEquals("Поле обязательное", driver.findElement(By.xpath(".//div[@class='ui-input ui-input_changed ui-input_error']/following-sibling::div")).getText());
        assertEquals("Поле обязательное",driver.findElement(By.xpath(".//div[@data-qa-file='UIUploadImage']//following-sibling::div[@data-qa-file='UIFormRowError']")).getText());
    }

    @Test
    public void testInvalidData() {
        driver.get("https://www.tinkoff.ru/career/vacancies/");
        driver.findElement(By.xpath(".//div[@class='ui-suggest']//input")).click();
        driver.findElement(By.xpath(".//div[@class='ui-suggest ui-suggest_opened']//input")).clear();
        driver.findElement(By.xpath(".//div[@class='ui-suggest ui-suggest_opened']//input")).sendKeys("bbuiib");
        driver.findElement(By.xpath(".//div[@class='ui-inputdate']//input")).click();
        driver.findElement(By.xpath(".//div[@class='ui-inputdate']//input")).clear();
        driver.findElement(By.xpath(".//div[@class='ui-inputdate']//input")).sendKeys("69.40.3200");
        driver.findElement(By.xpath(".//div[@class='ui-dropdown-field']//input")).click();
        driver.findElement(By.xpath(".//div[@class='ui-dropdown-field']//input")).clear();
        driver.findElement(By.xpath(".//div[@class='ui-dropdown-field']//input")).sendKeys("чкас879ээ.");
        driver.findElement(By.xpath(".//div[@class='ui-form__field']//input[@type='email']")).click();
        driver.findElement(By.xpath(".//div[@class='ui-form__field']//input[@type='email']")).clear();
        driver.findElement(By.xpath(".//div[@class='ui-form__field']//input[@type='email']")).sendKeys("cgvjh");
        driver.findElement(By.xpath(".//div[@class='ui-input ui-input_changed']//input")).click();
        driver.findElement(By.xpath(".//div[@class='ui-input ui-input_focused ui-input_changed']//input")).clear();
        driver.findElement(By.xpath(".//div[@class='ui-input ui-input_changed']//input")).sendKeys("+7(156) 798-97-65");
        driver.findElement(By.xpath(".//button[@type='submit']")).click();
        assertEquals("Допустимо использовать только буквы русского алфавита и дефис", driver.findElement(By.xpath(".//div[@class='ui-suggest']/following-sibling::div")).getText());
        assertEquals("Поле заполнено некорректно", driver.findElement(By.xpath(".//div[@class='ui-inputdate']/following-sibling::div")).getText());
        assertEquals("Введите корректный адрес эл. почты", driver.findElement(By.xpath(".//div[contains(text(),'адрес')]")).getText());
        assertEquals("Код города/оператора должен начинаться с цифры 3, 4, 5, 6, 8, 9", driver.findElement(By.xpath(".//div[contains(text(),'цифры')]")).getText());
    }


}
