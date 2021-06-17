package testcases;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import common.Constant;
import common.Utilities;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import pageObjects.HomePage;

import java.awt.*;
import java.io.File;
import java.lang.reflect.Method;

public class BaseTest {

    ExtentReports report;
    ExtentTest test;
    HomePage homePage = new HomePage();
    private String filePath = "D:\\d\\report.html";

    @BeforeSuite
    public void beforeSuite() {
        report = new ExtentReports(filePath);
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println(Constant.NEW_USERNAME);
        Utilities.setBrowser("Chrome");
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        Test t = method.getAnnotation(org.testng.annotations.Test.class);
        test = report.startTest(t.description());
    }

    @AfterMethod
    public void afterMethod() {
        report.endTest(test);
    }

    @AfterClass
    public void afterClass() {
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


}
