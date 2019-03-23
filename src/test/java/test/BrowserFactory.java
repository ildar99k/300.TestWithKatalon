package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum BrowserFactory {
    chrome {
        public WebDriver create() {
            updateBrowserProp("chrome");
            return new ChromeDriver();
        }
    },
    firefox {
        public WebDriver create() {
            updateBrowserProp("firefox");
            return new FirefoxDriver();
        }
    };

    public WebDriver create() {
        return null;
    }

    void updateBrowserProp(String name) {
        if (System.getProperty("browser") == null) System.setProperty("browser", name);
        System.out.println("Use " + name);
    }
}

