package common;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utilities {

//    public static void setBrowser(String browser) throws Exception {
//        switch (browser) {
//            case "Chrome":
//                System.setProperty("webdriver.chrome.driver", "Executables/chromedriver.exe");
//                Constant.webdriver.get() = new ChromeDriver();
//                break;
//            case "Firefox":
//                System.setProperty("webdriver.gecko.driver", "Executables/geckodriver.exe");
//                Constant.webdriver.get() = new FirefoxDriver();
//                break;
//            case "Edge":
//                System.setProperty("webdriver.edge.driver", "Executables/msedgedriver.exe");
//                Constant.webdriver.get() = new EdgeDriver();
//                break;
//            case "IE":
//                System.setProperty("webdriver.ie.driver", "Executables/IEDriverServer.exe");
//                Constant.webdriver.get() = new InternetExplorerDriver();
//                break;
//            default:
//                throw new Exception("Browser is not available");
//        }
//
//        Constant.js = (JavascriptExecutor) Constant.webdriver.get();
//    }
//
//    public static void setBrowser(String browser, String mode) throws Exception {
//        switch (browser) {
//            case "Chrome": {
//                System.setProperty("webdriver.chrome.driver", "Executables/chromedriver.exe");
//                ChromeOptions options = new ChromeOptions();
//                options.addArguments("headless");
//                if (mode.equals("headless"))
//                    Constant.webdriver.get() = new ChromeDriver(options);
//                else
//                    Constant.webdriver.get() = new ChromeDriver();
//                break;
//            }
//            case "Firefox": {
//                System.setProperty("webdriver.gecko.driver", "Executables/geckodriver.exe");
//                FirefoxOptions options = new FirefoxOptions();
//                options.setHeadless(true);
//                if (mode.equals("headless"))
//                    Constant.webdriver.get() = new FirefoxDriver(options);
//                else
//                    Constant.webdriver.get() = new FirefoxDriver();
//                break;
//            }
//            case "Edge": {
//                System.setProperty("webdriver.edge.driver", "Executables/msedgedriver.exe");
//                EdgeOptions options = new EdgeOptions();
//                options.addArguments("headless");
//                if (mode.equals("headless"))
//                    Constant.webdriver.get() = new EdgeDriver(options);
//                else
//                    Constant.webdriver.get() = new EdgeDriver();
//                break;
//            }
//            case "IE":
//                System.setProperty("webdriver.ie.driver", "Executables/IEDriverServer.exe");
//                Constant.webdriver.get() = new InternetExplorerDriver();
//                break;
//            default:
//                throw new Exception("Browser is not available");
//        }
//
//        Constant.js = (JavascriptExecutor) Constant.webdriver.get();
//    }

    public static String getScreenshotName(String methodName) {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
        String strDate = dateFormat.format(date);

        return methodName + "_" + strDate.replace(" ", "_") + ".png";
    }

    public static String takeScreenshot(String methodName) {
        String fileName = getScreenshotName(methodName);
        String directory = System.getProperty("user.dir") + "/Report/Screenshots/";
        new File(directory).mkdirs();
        String path = directory + fileName;

        try {
            File screenshot = ((TakesScreenshot)Constant.webdriver.get()).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(screenshot, new File(path));
            System.out.println(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    public static void clearTextInput(WebElement element) {
        element.clear();
    }

    public static void stopForShortTime() throws InterruptedException {
        Thread.sleep(2000);
    }

}