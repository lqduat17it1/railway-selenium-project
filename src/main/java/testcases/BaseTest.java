package testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import common.Driver;
import common.Utilities;
import org.openqa.selenium.Dimension;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import pageObjects.HomePage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BaseTest {

    public static ExtentReports report = new ExtentReports();
    public static ExtentSparkReporter spark;
    public ExtentTest test;
    public ExtentTest node;
    HomePage homePage = new HomePage();

    Date date = Calendar.getInstance().getTime();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
    String strDate = dateFormat.format(date);

    private String filePath = "Report\\";

    @Parameters("browser")
    @BeforeTest
    public void beforeTest(String browser) {
        filePath = filePath + browser + " - " + "Report " + strDate + ".html";
        spark = new ExtentSparkReporter(filePath);
        spark.config().setDocumentTitle("Le Quang Duat - Report");
        report.attachReporter(spark);
    }

    @AfterTest
    public void afterTest() throws IOException {
        report.flush();
        File file = new File(filePath);
        Desktop.getDesktop().open(file);
    }

    @Parameters({"browser", "mode"})
    @BeforeMethod
    public void beforeMethod(Method method, String browser, String mode) throws Exception {
        System.out.println(Thread.currentThread().getId());
        Driver.setDriver(browser, mode);
        Driver.webdriver.set(Driver.getDriver());
        if (mode.equalsIgnoreCase("headless"))
            Driver.getDriver().manage().window().setSize(new Dimension(Utilities.getScreenWidth(), Utilities.getScreenHeight()));
        else
            Driver.getDriver().manage().window().maximize();
        Test t = method.getAnnotation(Test.class);
        test = report.createTest(t.description());
        test.assignDevice(browser);
        test.assignCategory(t.testName());
    }

    @AfterMethod
    public void afterMethod() {
        Driver.closeDriver();
    }

    public ExtentTest pass(String msg) {
        return test.pass("<b><font color=green>" + msg + "</font></b>");
    }

    public ExtentTest fail(String msg) {
        return test.fail("<b><font color=red>" + msg + "</font></b>", MediaEntityBuilder.createScreenCaptureFromPath(Utilities.takeScreenshot(this.getClass().getSimpleName())).build());
    }

    public ExtentTest skip(String msg) {
        return test.skip("<b><font color=gray>" + msg + "</font></b>");
    }

    public ExtentTest step(int step, String msg) {
        return test.info("<b>Step " + step + ":&emsp;</b>" + msg);
    }

    public void checkMsgNodePass(String nodeName, String actualMsg, String expectedMsg) {
        String name = passFormat(nodeName);
        node = test.createNode(name).pass("Actual message: " + actualMsg).info("Expected message: " + expectedMsg);
    }

    public void checkMsgNodeFail(String nodeName, String actualMsg, String expectedMsg) {
        String name = failFormat(nodeName);
        node = test.createNode(name).fail("Actual message: " + actualMsg).info("Expected message: " + expectedMsg);
    }

    public String passFormat(String str) {
        return "<b><font color=green>" + str + "</font></b>";
    }

    public String failFormat(String str) {
        return "<b><font color=red>" + str + "</font></b>";
    }

}
