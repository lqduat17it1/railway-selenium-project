package testcases;

import common.Constant;
import dataObjects.DataTestSet1;
import org.testng.annotations.Test;
import pageObjects.BookTicketPage;
import pageObjects.LoginPage;

public class TC14 extends BaseTest {

    @Test(description = "TC14 - User can book 1 ticket at a time")
    public void TC14() {
        homePage.open();
        test.info("Navigate to QA Railway Website");

        LoginPage loginPage = homePage.gotoLoginPage();
        test.info("Click on \"Login\" tab");

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        test.info("Login to Railway website");
        test.info(" - Enter Username: "+Constant.USERNAME);
        test.info(" - Enter Password: "+Constant.PASSWORD);

        BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();
        test.info("Click on \"Book ticket\" tab");

        try {
            boolean result = bookTicketPage.bookTicket(DataTestSet1.DEPART_DATE, DataTestSet1.DEPART_STATION, DataTestSet1.ARRIVE_STATION, DataTestSet1.SEAT_TYPE, DataTestSet1.AMOUNT).checkTicket(DataTestSet1.DEPART_STATION, DataTestSet1.ARRIVE_STATION, DataTestSet1.SEAT_TYPE, DataTestSet1.DEPART_DATE, DataTestSet1.AMOUNT);
            test.info("Book ticket");
            test.info(" - Select depart date: "+ DataTestSet1.DEPART_DATE);
            test.info(" - Select depart from: "+ DataTestSet1.DEPART_STATION);
            test.info(" - Select arrive at: "+ DataTestSet1.ARRIVE_STATION);
            test.info(" - Select seat type: "+ DataTestSet1.SEAT_TYPE);
            test.info(" - Select ticket amount: "+ DataTestSet1.AMOUNT);

            if (result) {
                test.pass("User book ticket successfully");
            } else
                test.fail("Ticket information is not correctly");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
