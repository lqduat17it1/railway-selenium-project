package testcases;

import common.Utilities;
import dataObjects.DataTestSet1;
import org.testng.annotations.Test;
import pageObjects.BookTicketPage;
import pageObjects.LoginPage;
import pageObjects.TimetablePage;

public class TC15 extends BaseTest {

    @Test(description = "TC15 - User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page", testName = "Book Ticket")
    public void tc15() {
        homePage.open();
        step(1, "Navigate to QA Railway Website");

        try {
            LoginPage loginPage = homePage.gotoLoginPage();
            loginPage.login(DataTestSet1.USERNAME, DataTestSet1.PASSWORD);
            step(2, "Login with a valid account");
            node = test.createNode("Login info details (Step 2)");
            node.info("Username: " + DataTestSet1.USERNAME);
            node.info("Password: " + DataTestSet1.PASSWORD);


            TimetablePage timetablePage = homePage.gotoTimetablePage();
            step(3, "Click on \"Timetable\" tab");

            BookTicketPage bookTicketPage = timetablePage.clickBookTicket("Huế", "Sài Gòn");
            Utilities.scrollDown();
            step(4, "Click book ticket link with depart station \"Huế\" and arrive station \"Sài Gòn\"");

            if (bookTicketPage.getSelectDepartFrom().getFirstSelectedOption().getText().equals("Huế"))
                pass("Depart from is loaded correctly");
            else
                fail("Depart from is not loaded correctly");

            if (bookTicketPage.getSelectArriveAt().getFirstSelectedOption().getText().equals("Sài Gòn"))
                pass("Arrive at is loaded correctly");
            else
                fail("Arrive at is not loaded correctly");
        }
        catch (Exception e) {
            test.fail(e);
        }
    }

}
