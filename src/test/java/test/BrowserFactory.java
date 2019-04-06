package test;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public class BrowserFactory {
    public static WebDriver create() {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                LoggingPreferences logPrefs = new LoggingPreferences();
                logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
                options.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
                return new ChromeDriver(options);
        }

    public static class MyListener extends AbstractWebDriverEventListener {
        @Override
        public void beforeNavigateRefresh(WebDriver driver) {
            logger.info("Обновление страницы "+driver.getTitle());
        }


        @Override
        public void afterSwitchToWindow(String windowName, WebDriver driver) {
            logger.info("Успешное переключение на вкладку ");
        }

        @Override
        public void beforeSwitchToWindow(String windowName, WebDriver driver) {
            logger.info("Попытка переключения вкладки ");
        }

        Logger logger = LoggerFactory.getLogger(BrowserFactory.class);

        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
            logger.info("Обращение к элементу " + by);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            logger.info("Найден элемент " + by);
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {
            File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File file = new File("target", "screen-" + System.currentTimeMillis() + ".png");
            try {
                Files.copy(tmp, file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            logger.error(file.getAbsolutePath());
        }

    }
}

