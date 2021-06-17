package testcases;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import common.Constant;
import common.Utilities;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pageObjects.*;

public class Test extends BaseTest {

    @org.testng.annotations.Test
    public void TC01() {
        System.out.println("TC01 - User can register Railway account with valid info");

        homePage.open();

        RegisterPage registerPage = homePage.gotoRegisterPage();

        String actualMsg = registerPage.register(Constant.NEW_USERNAME, Constant.NEW_PASSWORD, Constant.NEW_PASSWORD, Constant.NEW_PID).getMessage();
        String expectedMsg = "You're here";

        try {
            Assert.assertEquals(actualMsg, expectedMsg);
            test.log(LogStatus.PASS, "Register successfully");
        }
        catch (Exception e) {
            test.log(LogStatus.FAIL,"Failed to register");
        }

    }

    @org.testng.annotations.Test
    public void TC02() {
        System.out.println("TC02 - User can log into Railway with valid username and password");

        LoginPage loginPage = homePage.gotoLoginPage();
        Constant.js.executeScript("window.scrollBy(0,2000)");

        String actualMsg = loginPage.login(Constant.NEW_USERNAME, Constant.NEW_PASSWORD).getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.NEW_USERNAME;

        try {
            Assert.assertEquals(actualMsg, expectedMsg);
            test.log(LogStatus.PASS, "Login successfully");
        }
        catch (Exception e) {
            test.log(LogStatus.FAIL, "Welcome message is not displayed as expected");
        }
    }

    @org.testng.annotations.Test
    public void TC03() {
        System.out.println("TC03 - User can book ticket with valid info");

        BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();
        Constant.js.executeScript("window.scrollBy(0,2000)");
        bookTicketPage.bookTicket(Constant.DEPART_DATE, Constant.DEPART_STATION, Constant.ARRIVE_STATION, Constant.SEAT_TYPE, Constant.AMOUNT).checkTicket(Constant.DEPART_STATION, Constant.ARRIVE_STATION, Constant.SEAT_TYPE, Constant.DEPART_DATE, Constant.AMOUNT);

        MyTicketPage myTicketPage = homePage.gotoMyTicketPage();
        myTicketPage.checkTicketExists(Constant.DEPART_STATION, Constant.ARRIVE_STATION, Constant.SEAT_TYPE, Constant.DEPART_DATE, Constant.AMOUNT);

    }

    @org.testng.annotations.Test
    public void TC04() {
        System.out.println("TC04 - User can cancel ticket that they have booked");

        MyTicketPage myTicketPage = new MyTicketPage();
        Constant.js.executeScript("window.scrollBy(0,2000)");
        myTicketPage.deleteTicket(Constant.DEPART_STATION, Constant.ARRIVE_STATION);

        myTicketPage.checkTicketNotExists(Constant.DEPART_STATION, Constant.ARRIVE_STATION, Constant.SEAT_TYPE, Constant.DEPART_DATE, Constant.AMOUNT);

    }

    @org.testng.annotations.Test
    public void TC05() {
        System.out.println("TC05 - User can navigate book ticket from train timetable");

        TimetablePage timetablePage = homePage.gotoTimetablePage();
        Constant.js.executeScript("window.scrollBy(0,2000)");
        timetablePage.bookTicket(Constant.DEPART_STATION, Constant.ARRIVE_STATION).checkStation(Constant.DEPART_STATION, Constant.ARRIVE_STATION);

    }

    @org.testng.annotations.Test
    public void TC06() {
        System.out.println("TC06 - User can check price from train timetable");

//        TODO
    }

    @org.testng.annotations.Test
    public void TC07() {
        System.out.println("TC07 - User can book ticket with seat type from ticket price page");

//        TODO
    }

    @org.testng.annotations.Test
    public void TC08() {
        System.out.println("TC08 - User can change password with valid info");

//        TODO
    }


}
