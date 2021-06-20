package testcases;

import common.Constant;
import org.testng.annotations.Test;
import pageObjects.BookTicketPage;
import pageObjects.LoginPage;
import pageObjects.TimetablePage;

public class TC15 extends BaseTest {

    @Test(description = "TC15 - User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page")
    public void TC15() {
        homePage.open();
        test.info("Navigate to QA Railway Website");

        LoginPage loginPage = homePage.gotoLoginPage();
        test.info("Click on \"Login\" tab");

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        test.info("Login to Railway website");
        test.info(" - Enter Username: "+Constant.USERNAME);
        test.info(" - Enter Password: "+Constant.PASSWORD);


        TimetablePage timetablePage = homePage.gotoTimetablePage();
        test.info("Click on \"Timetable\" tab");

        BookTicketPage bookTicketPage = timetablePage.clickBookTicket("Huế", "Sài Gòn");
        Constant.js.executeScript("window.scrollBy(0,2000)");
        test.info("Click book ticket link with depart station \"Huế\" and arrive station \"Sài Gòn\"");

        if (bookTicketPage.getSelectDepartFrom().getFirstSelectedOption().getText().equals("Huế"))
            test.pass("Depart from is loaded correctly");
        else
            test.fail("Depart from is not loaded correctly");

        if (bookTicketPage.getSelectArriveAt().getFirstSelectedOption().getText().equals("Sài Gòn"))
            test.pass("Arrive at is loaded correctly");
        else
            test.fail("Arrive at is not loaded correctly");
    }

}
