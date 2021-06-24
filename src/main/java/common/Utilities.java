package common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Utilities {

    public static Random rd = new Random();

    public static int getRandomNumber() {
        return rd.nextInt(1000000);
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
            File screenshot = ((TakesScreenshot) Driver.webdriver.get()).getScreenshotAs(OutputType.FILE);
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

    public static void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver() ;
        js.executeScript("window.scrollBy(0,2000)");
    }

    public static int getScreenWidth() {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        return (int)size.getWidth();
    }

    public static int getScreenHeight() {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        return (int)size.getHeight();
    }

    public static void stopForShortTime() throws InterruptedException {
        Thread.sleep(2000);
    }

}