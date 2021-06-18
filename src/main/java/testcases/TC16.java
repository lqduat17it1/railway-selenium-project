package testcases;

import com.relevantcodes.extentreports.LogStatus;
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
        test.log(LogStatus.INFO, "Navigate to QA Railway Website");

        LoginPage loginPage = homePage.gotoLoginPage();
        test.log(LogStatus.INFO, "Click on \"Login\" tab");

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        test.log(LogStatus.INFO, "Login to Railway website");
        test.log(LogStatus.INFO, " - Enter Username: "+Constant.USERNAME);
        test.log(LogStatus.INFO, " - Enter Password: "+Constant.PASSWORD);

        BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();
        test.log(LogStatus.INFO, "Click on \"Register\" tab");

        bookTicketPage.bookTicket(DataTestSet1.DEPART_DATE_2, DataTestSet1.DEPART_STATION_2, DataTestSet1.ARRIVE_STATION_2, DataTestSet1.SEAT_TYPE_2, DataTestSet1.AMOUNT_2);
        test.log(LogStatus.INFO, "Book ticket");
        test.log(LogStatus.INFO, " - Select depart date: "+ DataTestSet1.DEPART_DATE_2);
        test.log(LogStatus.INFO, " - Select depart from: "+ DataTestSet1.DEPART_STATION_2);
        test.log(LogStatus.INFO, " - Select arrive at: "+ DataTestSet1.ARRIVE_STATION_2);
        test.log(LogStatus.INFO, " - Select seat type: "+ DataTestSet1.SEAT_TYPE_2);
        test.log(LogStatus.INFO, " - Select ticket amount: "+ DataTestSet1.AMOUNT_2);

        MyTicketPage myTicketPage = homePage.gotoMyTicketPage();
        test.log(LogStatus.INFO, "Click on \"My ticket\" tab");

        myTicketPage.deleteTicket(DataTestSet1.DEPART_STATION_2, DataTestSet1.ARRIVE_STATION_2);
        test.log(LogStatus.INFO, "Cancel ticket with depart station \""+ DataTestSet1.DEPART_STATION_2 +"\" and arrive station \""+ DataTestSet1.ARRIVE_STATION_2 +"\"");

        boolean result = myTicketPage.checkTicketNotExists(DataTestSet1.DEPART_STATION, DataTestSet1.ARRIVE_STATION, DataTestSet1.SEAT_TYPE, DataTestSet1.DEPART_DATE, DataTestSet1.AMOUNT);
        if (!result)
            test.log(LogStatus.PASS, "The canceled ticket is disappeared.");
        else
            test.log(LogStatus.FAIL, "The canceled ticket is not disappeared.");
    }

}
