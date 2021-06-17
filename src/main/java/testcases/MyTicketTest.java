package testcases;

import com.relevantcodes.extentreports.LogStatus;
import common.Constant;
import org.testng.annotations.Test;
import pageObjects.BookTicketPage;
import pageObjects.LoginPage;
import pageObjects.MyTicketPage;

public class MyTicketTest extends BaseTest {

    @Test(description = "TC16 - User can cancel a ticket")
    public void TC16() {
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();
        bookTicketPage.bookTicket(Constant.DEPART_DATE, Constant.DEPART_STATION, Constant.ARRIVE_STATION, Constant.SEAT_TYPE, Constant.AMOUNT);

        MyTicketPage myTicketPage = homePage.gotoMyTicketPage();
        myTicketPage.deleteTicket(Constant.DEPART_STATION, Constant.ARRIVE_STATION);

       boolean result = myTicketPage.checkTicketNotExists(Constant.DEPART_STATION, Constant.ARRIVE_STATION, Constant.SEAT_TYPE, Constant.DEPART_DATE, Constant.AMOUNT);
       if (result)
           test.log(LogStatus.PASS, "The canceled ticket is disappeared.");
       else
           test.log(LogStatus.FAIL, "The canceled ticket is not disappeared.");
    }

}
