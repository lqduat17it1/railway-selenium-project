package common;

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

public class Driver {

    public static ThreadLocal<WebDriver> webdriver = new ThreadLocal<>();
    public static WebDriverWait wait;

    public static void setDriver(String browser, String mode) throws Exception {
        switch (browser.toUpperCase()) {
            case "CHROME": {
                System.setProperty("webdriver.chrome.driver", "Executables/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("headless");
                if (mode.equals("headless"))
                    webdriver.set(new ChromeDriver(options));
                else
                    webdriver.set(new ChromeDriver());
                break;
            }
            case "FIREFOX": {
                System.setProperty("webdriver.gecko.driver", "Executables/geckodriver.exe");
                FirefoxOptions options = new FirefoxOptions();
                options.setHeadless(true);
                if (mode.equals("headless"))
                    webdriver.set(new FirefoxDriver(options));
                else
                    webdriver.set(new FirefoxDriver());
                break;
            }
            case "EDGE": {
                System.setProperty("webdriver.edge.driver", "Executables/msedgedriver.exe");
                EdgeOptions options = new EdgeOptions();
                options.addArguments("headless");
                if (mode.equals("headless"))
                    webdriver.set(new EdgeDriver(options));
                else
                    webdriver.set(new EdgeDriver());
                break;
            }
            case "IE":
                System.setProperty("webdriver.ie.driver", "Executables/IEDriverServer.exe");
                webdriver.set(new InternetExplorerDriver());
                break;
            default:
                throw new Exception("Browser is not available");
        }
        wait = new WebDriverWait(webdriver.get(), Duration.ofSeconds(10));
    }

    public static WebDriver getDriver() {
        return webdriver.get();
    }

    public static void closeDriver() {
        webdriver.get().close();
        webdriver.remove();
    }


}
