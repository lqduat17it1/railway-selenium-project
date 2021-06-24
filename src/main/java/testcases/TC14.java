package testcases;

import dataObjects.DataTestSet1;
import org.testng.annotations.Test;
import pageObjects.BookTicketPage;
import pageObjects.LoginPage;

public class TC14 extends BaseTest {

    @Test(description = "TC14 - User can book 1 ticket at a time", testName = "Book Ticket")
    public void tc14() {
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
            step(3, "Click on \"Book ticket\" tab");


            boolean result = bookTicketPage.bookTicket(DataTestSet1.DEPART_DATE_TC14, DataTestSet1.DEPART_STATION_TC14, DataTestSet1.ARRIVE_STATION_TC14, DataTestSet1.SEAT_TYPE_TC14, DataTestSet1.AMOUNT_TC14)
                    .checkTicket(DataTestSet1.DEPART_STATION_TC14, DataTestSet1.ARRIVE_STATION_TC14, DataTestSet1.SEAT_TYPE_TC14, DataTestSet1.DEPART_DATE_TC14, DataTestSet1.AMOUNT_TC14);
            step(4, "Select depart date: " + DataTestSet1.DEPART_DATE_TC14);
            step(5, "Select depart from: " + DataTestSet1.DEPART_STATION_TC14 + " and " + DataTestSet1.ARRIVE_STATION_TC14 + " for Arrive at");
            step(6, "Select seat type: "+ DataTestSet1.SEAT_TYPE_TC14);
            step(7, "Select ticket amount: "+ DataTestSet1.AMOUNT_TC14);
            step(8, "Click on \"Book ticket\" button");

            if (result) {
                pass("User book ticket successfully");
            } else
                fail("Ticket information is not correctly");
        }
        catch (Exception e) {
            test.fail(e);
        }

    }

}
