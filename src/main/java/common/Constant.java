package common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Constant {

    public static WebDriverWait wait;
    public static final String RAILWAY_URL = "http://railway2.somee.com/";

    public static ThreadLocal<WebDriver> webdriver = new ThreadLocal<>();

    private WebDriver WEBDRIVER;

    public void setDriver(String browser, String mode) throws Exception {
        switch (browser) {
            case "Chrome": {
                System.setProperty("webdriver.chrome.driver", "Executables/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("headless");
                if (mode.equals("headless"))
                    WEBDRIVER = new ChromeDriver(options);
                else
                    WEBDRIVER = new ChromeDriver();
                break;
            }
            case "Firefox": {
                System.setProperty("webdriver.gecko.driver", "Executables/geckodriver.exe");
                FirefoxOptions options = new FirefoxOptions();
                options.setHeadless(true);
                if (mode.equals("headless"))
                    WEBDRIVER = new FirefoxDriver(options);
                else
                    WEBDRIVER = new FirefoxDriver();
                break;
            }
            case "Edge": {
                System.setProperty("webdriver.edge.driver", "Executables/msedgedriver.exe");
                EdgeOptions options = new EdgeOptions();
                options.addArguments("headless");
                if (mode.equals("headless"))
                    WEBDRIVER = new EdgeDriver(options);
                else
                    WEBDRIVER = new EdgeDriver();
                break;
            }
            case "IE":
                System.setProperty("webdriver.ie.driver", "Executables/IEDriverServer.exe");
                WEBDRIVER = new InternetExplorerDriver();
                break;
            default:
                throw new Exception("Browser is not available");
        }
        wait = new WebDriverWait(WEBDRIVER, Duration.ofSeconds(10));
    }

    public WebDriver getDriver() {
        return WEBDRIVER;
    }

    public static void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) webdriver.get() ;
        js.executeScript("window.scrollBy(0,2000)");
    }

}
