package testcases;

import common.Utilities;
import dataObjects.DataTestSet1;
import org.testng.annotations.Test;
import pageObjects.BookTicketPage;
import pageObjects.LoginPage;
import pageObjects.MyTicketPage;

public class TC16 extends BaseTest {

    @Test(description = "TC16 - User can cancel a ticket", testName = "Book Ticket")
    public void tc16() {
        homePage.open();
        step(1, "Navigate to QA Railway Website");

        try {
            LoginPage loginPage = homePage.gotoLoginPage();
            loginPage.login(DataTestSet1.USERNAME, DataTestSet1.PASSWORD);
            step(2, "Login with a valid account ");
            node = test.createNode("Login info details (Step 2)");
            node.info("Username: " + DataTestSet1.USERNAME);
            node.info("Password: " + DataTestSet1.PASSWORD);

            BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();
            bookTicketPage.bookTicket(DataTestSet1.DEPART_DATE_TC16, DataTestSet1.DEPART_STATION_TC16, DataTestSet1.ARRIVE_STATION_TC16, DataTestSet1.SEAT_TYPE_TC16, DataTestSet1.AMOUNT_TC16);
            step(3, "Book a ticket");
            node = test.createNode("Ticket booked details (Step 3)");
            node.info("Depart date: " + DataTestSet1.DEPART_DATE_TC16);
            node.info("Depart from: " + DataTestSet1.DEPART_STATION_TC16);
            node.info("Arrive at: " + DataTestSet1.ARRIVE_STATION_TC16);
            node.info("Seat type: " + DataTestSet1.SEAT_TYPE_TC16);
            node.info("Ticket amount: " + DataTestSet1.AMOUNT_TC16);

            MyTicketPage myTicketPage = homePage.gotoMyTicketPage();
            step(4, "Click on \"My ticket\" tab");

            myTicketPage.deleteTicket(DataTestSet1.DEPART_STATION_TC16, DataTestSet1.ARRIVE_STATION_TC16);
            step(5, "Cancel ticket with depart station \"" + DataTestSet1.DEPART_STATION_TC16 + "\" and arrive station \"" + DataTestSet1.ARRIVE_STATION_TC16 + "\"");
            step(6, "Click on \"OK\" button on Confirmation message \"Are you sure?\"");
            Utilities.stopForShortTime();

            boolean result = myTicketPage.checkTicketExists(DataTestSet1.DEPART_STATION_TC16, DataTestSet1.ARRIVE_STATION_TC16, DataTestSet1.SEAT_TYPE_TC16, DataTestSet1.DEPART_DATE_TC16, DataTestSet1.AMOUNT_TC16);
            if (!result)
                pass("The canceled ticket is disappeared.");
            else
                fail("The canceled ticket is not disappeared.");
        }
        catch (Exception e) {
            test.fail(e);
        }
    }

}
