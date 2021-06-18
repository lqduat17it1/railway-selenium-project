package testcases;

import com.relevantcodes.extentreports.LogStatus;
import common.Constant;
import dataObjects.DataTestSet1;
import org.testng.annotations.Test;
import pageObjects.BookTicketPage;
import pageObjects.LoginPage;

public class TC14 extends BaseTest {

    @Test(description = "TC14 - User can book 1 ticket at a time")
    public void TC14() {
        homePage.open();
        test.log(LogStatus.INFO, "Navigate to QA Railway Website");

        LoginPage loginPage = homePage.gotoLoginPage();
        test.log(LogStatus.INFO, "Click on \"Login\" tab");

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        test.log(LogStatus.INFO, "Login to Railway website");
        test.log(LogStatus.INFO, " - Enter Username: "+Constant.USERNAME);
        test.log(LogStatus.INFO, " - Enter Password: "+Constant.PASSWORD);

        BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();
        test.log(LogStatus.INFO, "Click on \"Book ticket\" tab");

        try {
            boolean result = bookTicketPage.bookTicket(DataTestSet1.DEPART_DATE, DataTestSet1.DEPART_STATION, DataTestSet1.ARRIVE_STATION, DataTestSet1.SEAT_TYPE, DataTestSet1.AMOUNT).checkTicket(DataTestSet1.DEPART_STATION, DataTestSet1.ARRIVE_STATION, DataTestSet1.SEAT_TYPE, DataTestSet1.DEPART_DATE, DataTestSet1.AMOUNT);
            test.log(LogStatus.INFO, "Book ticket");
            test.log(LogStatus.INFO, " - Select depart date: "+ DataTestSet1.DEPART_DATE);
            test.log(LogStatus.INFO, " - Select depart from: "+ DataTestSet1.DEPART_STATION);
            test.log(LogStatus.INFO, " - Select arrive at: "+ DataTestSet1.ARRIVE_STATION);
            test.log(LogStatus.INFO, " - Select seat type: "+ DataTestSet1.SEAT_TYPE);
            test.log(LogStatus.INFO, " - Select ticket amount: "+ DataTestSet1.AMOUNT);

            if (result) {
                test.log(LogStatus.PASS, "User book ticket successfully");
            } else
                test.log(LogStatus.FAIL, "Ticket information is not correctly");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
