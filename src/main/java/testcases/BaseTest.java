package testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import common.Constant;
import common.Utilities;
import dataObjects.DataTestSet1;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import pageObjects.HomePage;

import java.awt.*;
import java.io.File;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class BaseTest {

    public static ExtentReports report = new ExtentReports();
    public static ExtentSparkReporter spark;
    public static ExtentTest test;
    public static ExtentTest node;
    HomePage homePage = new HomePage();

    Date date = Calendar.getInstance().getTime();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
    String strDate = dateFormat.format(date);

    private String filePath = "Report\\";

    @Parameters("browser")
    @BeforeSuite
    public void beforeSuite(String browser) {
        filePath = filePath + browser + " - " + "Report " + strDate + ".html";
        spark = new ExtentSparkReporter(filePath);
        spark.config().setDocumentTitle("Le Quang Duat - Report");
        report.attachReporter(spark);
    }

    @Parameters({"browser", "mode"})
    @BeforeMethod
    public void beforeMethod(Method method, String browser, String mode) throws Exception {
        System.out.println(DataTestSet1.NEW_USERNAME);
        Utilities.setBrowser(browser, mode);
        Constant.WEBDRIVER.manage().window().maximize();
        Test t = method.getAnnotation(Test.class);
        test = report.createTest(t.description());
        test.assignDevice(browser);
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        Constant.WEBDRIVER.quit();
    }

    @AfterSuite
    public void afterSuite() {
        report.flush();

        try {
            File file = new File(filePath);
            Desktop.getDesktop().open(file);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setCheckNode(String nodeName, String actualMsg, String expectedMsg, String type) {
        if (type.equals("pass")) {
            String name = "<b><font color=green>" + nodeName + "</font></b>";
            node = test.createNode(name).pass("Actual message: " + actualMsg).info("Expected message: " + expectedMsg);
        }
        else {
            String name = "<b><font color=red>" + nodeName + "</font></b>";
            node = test.createNode(name).fail("Actual message: " + actualMsg).info("Expected message: " + expectedMsg);
        }
    }

    public ExtentTest pass(String msg) {
        return test.pass("<b><font color=green>" + msg + "</font></b>");
    }

    public ExtentTest fail(String msg) {
        return test.fail("<b><font color=red>" + msg + "</font></b>", MediaEntityBuilder.createScreenCaptureFromPath(Utilities.takeScreenshot(this.getClass().getSimpleName())).build());
    }

    public ExtentTest step(int step, String msg) {
        return test.info("<b>Step " + step + ":&emsp;</b>" + msg);
    }

}
