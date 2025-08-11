package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
    public WebDriver getWebDriver(String browserName) {
        switch (browserName) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "driver/chromedriver/chromedriver");
                return new ChromeDriver();
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "driver/yandexdriver/yandexdriver");
                return new ChromeDriver();
            default:
                return new ChromeDriver();
        }
    }
}
