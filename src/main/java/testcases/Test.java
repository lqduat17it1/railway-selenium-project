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
        System.out.println(Constant.NEW_USERNAME);
        Utilities.setBrowser("Firefox");
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
        Constant.js.executeScript("window.scrollBy(0,2000)");

        String actualMsg = loginPage.login(Constant.NEW_USERNAME, Constant.NEW_PASSWORD).getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.NEW_USERNAME;

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

    @org.testng.annotations.Test
    public void TC03() {
        System.out.println("TC03 - User can book ticket with valid info");
        HomePage homePage = new HomePage();

        BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();
        Constant.js.executeScript("window.scrollBy(0,2000)");
        bookTicketPage.bookTicket(Constant.DEPART_DATE, Constant.DEPART_STATION, Constant.ARRIVE_STATION, Constant.SEAT_TYPE, Constant.AMOUNT).checkTicket(Constant.DEPART_STATION, Constant.ARRIVE_STATION, Constant.SEAT_TYPE, Constant.DEPART_DATE, Constant.AMOUNT);

        MyTicketPage myTicketPage = homePage.gotoMyTicketPage();
        myTicketPage.checkTicketExists(Constant.DEPART_STATION, Constant.ARRIVE_STATION, Constant.SEAT_TYPE, Constant.DEPART_DATE, Constant.AMOUNT);

    }

    @org.testng.annotations.Test
    public void TC04() {
        System.out.println("TC04 - User can cancel ticket that they have booked");
        HomePage homePage = new HomePage();

        MyTicketPage myTicketPage = new MyTicketPage();
        Constant.js.executeScript("window.scrollBy(0,2000)");
        myTicketPage.deleteTicket(Constant.DEPART_STATION, Constant.ARRIVE_STATION);

        myTicketPage.checkTicketNotExists(Constant.DEPART_STATION, Constant.ARRIVE_STATION, Constant.SEAT_TYPE, Constant.DEPART_DATE, Constant.AMOUNT);

    }

    @org.testng.annotations.Test
    public void TC05() {
        System.out.println("TC05 - User can navigate book ticket from train timetable");
        HomePage homePage = new HomePage();

        TimetablePage timetablePage = homePage.gotoTimetablePage();
        Constant.js.executeScript("window.scrollBy(0,2000)");
        timetablePage.bookTicket(Constant.DEPART_STATION, Constant.ARRIVE_STATION).checkStation(Constant.DEPART_STATION, Constant.ARRIVE_STATION);

    }

}
