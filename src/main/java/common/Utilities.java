package common;

import org.apache.tools.ant.taskdefs.Java;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Utilities {

    public static void setBrowser(String browser) {
        if(browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "Executables/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            Constant.WEBDRIVER = new ChromeDriver(options);
        }
            Constant.js = (JavascriptExecutor) Constant.WEBDRIVER;

        if(browser.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "Executables/geckodriver.exe");
            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(true);
            Constant.WEBDRIVER = new FirefoxDriver(options);

            Constant.js = (JavascriptExecutor) Constant.WEBDRIVER;
        }
    }

}
