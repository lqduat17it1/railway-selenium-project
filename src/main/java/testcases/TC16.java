package testcases;

import common.Constant;
import dataObjects.DataTestSet1;
import org.testng.annotations.Test;
import pageObjects.BookTicketPage;
import pageObjects.LoginPage;
import pageObjects.MyTicketPage;

public class TC16 extends BaseTest {

    @Test(description = "TC16 - User can cancel a ticket")
    public void TC16() {
        homePage.open();
        test.info("Navigate to QA Railway Website");

        LoginPage loginPage = homePage.gotoLoginPage();
        test.info("Click on \"Login\" tab");

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        test.info("Login to Railway website");
        test.info(" - Enter Username: "+Constant.USERNAME);
        test.info(" - Enter Password: "+Constant.PASSWORD);

        BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();
        test.info("Click on \"Register\" tab");

        bookTicketPage.bookTicket(DataTestSet1.DEPART_DATE_2, DataTestSet1.DEPART_STATION_2, DataTestSet1.ARRIVE_STATION_2, DataTestSet1.SEAT_TYPE_2, DataTestSet1.AMOUNT_2);
        test.info("Book ticket");
        test.info(" - Select depart date: "+ DataTestSet1.DEPART_DATE_2);
        test.info(" - Select depart from: "+ DataTestSet1.DEPART_STATION_2);
        test.info(" - Select arrive at: "+ DataTestSet1.ARRIVE_STATION_2);
        test.info(" - Select seat type: "+ DataTestSet1.SEAT_TYPE_2);
        test.info(" - Select ticket amount: "+ DataTestSet1.AMOUNT_2);

        MyTicketPage myTicketPage = homePage.gotoMyTicketPage();
        test.info("Click on \"My ticket\" tab");

        myTicketPage.deleteTicket(DataTestSet1.DEPART_STATION_2, DataTestSet1.ARRIVE_STATION_2);
        test.info("Cancel ticket with depart station \""+ DataTestSet1.DEPART_STATION_2 +"\" and arrive station \""+ DataTestSet1.ARRIVE_STATION_2 +"\"");

        boolean result = myTicketPage.checkTicketNotExists(DataTestSet1.DEPART_STATION, DataTestSet1.ARRIVE_STATION, DataTestSet1.SEAT_TYPE, DataTestSet1.DEPART_DATE, DataTestSet1.AMOUNT);
        if (!result)
            test.pass("The canceled ticket is disappeared.");
        else
            test.fail("The canceled ticket is not disappeared.");
    }

}
