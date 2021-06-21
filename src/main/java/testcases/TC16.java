package testcases;

import common.Constant;
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
            loginPage.login(Constant.USERNAME, Constant.PASSWORD);
            step(2, "Login with a valid account ");
            node = test.createNode("Login info details (Step 2)");
            node.info("Username: " + Constant.USERNAME);
            node.info("Password: " + Constant.PASSWORD);

            BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();
            bookTicketPage.bookTicket(DataTestSet1.DEPART_DATE_2, DataTestSet1.DEPART_STATION_2, DataTestSet1.ARRIVE_STATION_2, DataTestSet1.SEAT_TYPE_2, DataTestSet1.AMOUNT_2);
            step(3, "Book a ticket");
            node = test.createNode("Ticket booked details (Step 3)");
            node.info("Depart date: " + DataTestSet1.DEPART_DATE_2);
            node.info("Depart from: " + DataTestSet1.DEPART_STATION_2);
            node.info("Arrive at: " + DataTestSet1.ARRIVE_STATION_2);
            node.info("Seat type: " + DataTestSet1.SEAT_TYPE_2);
            node.info("Ticket amount: " + DataTestSet1.AMOUNT_2);

            MyTicketPage myTicketPage = homePage.gotoMyTicketPage();
            step(4, "Click on \"My ticket\" tab");

            myTicketPage.deleteTicket(DataTestSet1.DEPART_STATION_2, DataTestSet1.ARRIVE_STATION_2);
            step(5, "Cancel ticket with depart station \"" + DataTestSet1.DEPART_STATION_2 + "\" and arrive station \"" + DataTestSet1.ARRIVE_STATION_2 + "\"");
            step(6, "Click on \"OK\" button on Confirmation message \"Are you sure?\"");

            boolean result = myTicketPage.checkTicketNotExists(DataTestSet1.DEPART_STATION, DataTestSet1.ARRIVE_STATION, DataTestSet1.SEAT_TYPE, DataTestSet1.DEPART_DATE, DataTestSet1.AMOUNT);
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
