package testcases;

import common.Constant;
import common.Utilities;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pageObjects.*;

public class Test {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Pre-condition");
        Utilities.setBrowser("Chrome");
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }

    @org.testng.annotations.Test
    public void TC01() {
        System.out.println("TC01 - User can register Railway account with valid info");
        HomePage homePage = new HomePage();
        homePage.open();

        RegisterPage registerPage = homePage.gotoRegisterPage();

        String actualMsg = registerPage.register(Constant.NEW_USERNAME, Constant.NEW_PASSWORD, Constant.NEW_PASSWORD, Constant.NEW_PID).getMessage();
        String expectedMsg = "You're here";

        Assert.assertEquals(actualMsg, expectedMsg, "Cannot register with valid info");

    }

    @org.testng.annotations.Test
    public void TC02() {
        System.out.println("TC02 - User can log into Railway with valid username and password");
        HomePage homePage = new HomePage();

        LoginPage loginPage = homePage.gotoLoginPage();

        String actualMsg = loginPage.login(Constant.NEW_USERNAME, Constant.NEW_PASSWORD).getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.NEW_USERNAME;

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

    @org.testng.annotations.Test
    public void TC03() {
        System.out.println("TC03 - User can book ticket with valid info");
        HomePage homePage = new HomePage();

        String departDate = "6/20/2021";
        String departFrom = "Sài Gòn";
        String arriveAt = "Đà Nẵng";
        String seatType = "Soft bed";
        String ticketAmount = "2";

        BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();
        bookTicketPage.bookTicket(departDate, departFrom, arriveAt, seatType, ticketAmount).checkTicket(departFrom, arriveAt, seatType, departDate, ticketAmount);

        MyTicketPage myTicketPage = homePage.gotoMyTicketPage();
        myTicketPage.checkTicket(departFrom, arriveAt, seatType, departDate, ticketAmount);

    }

    @org.testng.annotations.Test
    public void TC04() {
        System.out.println("TC04 - User can navigate book ticket from train timetable");
        HomePage homePage = new HomePage();

        String departStation = "Đà Nẵng";
        String arriveStation = "Nha Trang";

        TimetablePage timetablePage = homePage.gotoTimetablePage();
        Constant.js.executeScript("window.scrollBy(0,2000)");
        timetablePage.bookTicket(departStation, arriveStation).checkStation(departStation, arriveStation);

    }

}
