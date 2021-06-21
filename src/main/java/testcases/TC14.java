package testcases;

import common.Constant;
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
            loginPage.login(Constant.USERNAME, Constant.PASSWORD);
            step(2, "Login with a valid account ");
            node = test.createNode("Login info details (Step 2)");
            node.info("Username: " + Constant.USERNAME);
            node.info("Password: " + Constant.PASSWORD);

            BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();
            step(3, "Click on \"Book ticket\" tab");


            boolean result = bookTicketPage.bookTicket(DataTestSet1.DEPART_DATE, DataTestSet1.DEPART_STATION, DataTestSet1.ARRIVE_STATION, DataTestSet1.SEAT_TYPE, DataTestSet1.AMOUNT).checkTicket(DataTestSet1.DEPART_STATION, DataTestSet1.ARRIVE_STATION, DataTestSet1.SEAT_TYPE, DataTestSet1.DEPART_DATE, DataTestSet1.AMOUNT);
            step(4, "Select depart date: " + DataTestSet1.DEPART_DATE);
            step(5, "Select depart from: " + DataTestSet1.DEPART_STATION + " and " + DataTestSet1.ARRIVE_STATION + "for Arrive at");
            step(6, "Select seat type: "+ DataTestSet1.SEAT_TYPE);
            step(7, "Select ticket amount: "+ DataTestSet1.AMOUNT);
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
