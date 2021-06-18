package common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Utilities {

    public static void setBrowser(String browser) throws Exception {
        if(browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "Executables/chromedriver.exe");
            Constant.WEBDRIVER = new ChromeDriver();

            Constant.js = (JavascriptExecutor) Constant.WEBDRIVER;
        }
        else if(browser.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "Executables/geckodriver.exe");
            Constant.WEBDRIVER = new FirefoxDriver();

            Constant.js = (JavascriptExecutor) Constant.WEBDRIVER;
        }
        else
            throw new Exception("Browser is not available");

    }

    public static void setBrowserHeadless(String browser) throws Exception {
        if(browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "Executables/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            Constant.WEBDRIVER = new ChromeDriver(options);

            Constant.js = (JavascriptExecutor) Constant.WEBDRIVER;
        }
        else if(browser.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "Executables/geckodriver.exe");
            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(true);
            Constant.WEBDRIVER = new FirefoxDriver(options);

            Constant.js = (JavascriptExecutor) Constant.WEBDRIVER;
        }
        else
            throw new Exception("Browser is not available");
    }

}
