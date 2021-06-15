package common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class Constant {

    public static WebDriver WEBDRIVER;
    public static JavascriptExecutor js;
    public static final String RAILWAY_URL = "http://railway2.somee.com/";
    public static final String USERNAME = "selenium@webdriver.com";
    public static final String PASSWORD = "1234567890";

    public static Random rd = new Random();

    public static final String NEW_USERNAME = "lqduat".concat(String.valueOf(rd.nextInt(100000))).concat("@logigear.com");
    public static final String NEW_PASSWORD = "123456789";
    public static final String NEW_PID = "123456789";

}
