package testcases;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import common.Constant;
import common.Utilities;
import dataObjects.DataTestSet1;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import pageObjects.HomePage;

import java.awt.*;
import java.io.File;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BaseTest {

    protected static ExtentReports report;
    protected static ExtentTest test;
    HomePage homePage = new HomePage();

    Date date = Calendar.getInstance().getTime();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
    public final String strDate = dateFormat.format(date);

    private String filePath = "D:\\d\\report\\";

    @Parameters("browser")
    @BeforeSuite
    public void beforeSuite(String browser) {
        filePath = filePath + browser + " - " + "Report" + strDate + ".html";
        report = new ExtentReports(filePath);
    }

//    @Parameters("browser")
//    @BeforeClass
//    public void beforeClass(String browser) {
//        filePath = filePath + browser + " - " + "Report" + strDate + ".html";
//        report = new ExtentReports(filePath);
//    }

    @Parameters("browser")
    @BeforeMethod
    public void beforeMethod(Method method, String browser) {
        System.out.println(DataTestSet1.NEW_USERNAME);
        try {
            Utilities.setBrowserHeadless(browser);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        Constant.WEBDRIVER.manage().window().maximize();
        Test t = method.getAnnotation(org.testng.annotations.Test.class);
        try {
            test = report.startTest(t.description());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void afterMethod() {
        report.endTest(test);
        Constant.WEBDRIVER.quit();
    }

//    @AfterClass
//    public void afterClass() {
//        report.flush();
//
//        try {
//            File file = new File(filePath);
//            Desktop.getDesktop().open(file);
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

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


}
