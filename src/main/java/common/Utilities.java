package common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

    public static void setBrowser(String browser, String mode) throws Exception {
        if(browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "Executables/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            if (mode.equals("headless"))
                Constant.WEBDRIVER = new ChromeDriver(options);
            else
                Constant.WEBDRIVER = new ChromeDriver();

            Constant.js = (JavascriptExecutor) Constant.WEBDRIVER;
        }
        else if(browser.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "Executables/geckodriver.exe");
            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(true);
            if (mode.equals("headless"))
                Constant.WEBDRIVER = new FirefoxDriver(options);
            else
                Constant.WEBDRIVER = new FirefoxDriver();

            Constant.js = (JavascriptExecutor) Constant.WEBDRIVER;
        }
        else
            throw new Exception("Browser is not available");
    }

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
            File screenshot = ((TakesScreenshot)Constant.WEBDRIVER).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(screenshot, new File(path));
            System.out.println(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

}
