package testcases;

import com.relevantcodes.extentreports.LogStatus;
import common.Constant;
import org.testng.annotations.Test;
import pageObjects.BookTicketPage;
import pageObjects.LoginPage;
import pageObjects.TimetablePage;

public class TC15 extends BaseTest {

    @Test(description = "TC15 - User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page")
    public void TC15() {
        homePage.open();
        test.log(LogStatus.INFO, "Navigate to QA Railway Website");

        LoginPage loginPage = homePage.gotoLoginPage();
        test.log(LogStatus.INFO, "Click on \"Login\" tab");

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        test.log(LogStatus.INFO, "Login to Railway website");
        test.log(LogStatus.INFO, " - Enter Username: "+Constant.USERNAME);
        test.log(LogStatus.INFO, " - Enter Password: "+Constant.PASSWORD);


        TimetablePage timetablePage = homePage.gotoTimetablePage();
        test.log(LogStatus.INFO, "Click on \"Timetable\" tab");

        BookTicketPage bookTicketPage = timetablePage.clickBookTicket("Huế", "Sài Gòn");
        Constant.js.executeScript("window.scrollBy(0,2000)");
        test.log(LogStatus.INFO, "Click book ticket link with depart station \"Huế\" and arrive station \"Sài Gòn\"");

        if (bookTicketPage.getSelectDepartFrom().getFirstSelectedOption().getText().equals("Huế"))
            test.log(LogStatus.PASS, "Depart from is loaded correctly");
        else
            test.log(LogStatus.FAIL, "Depart from is not loaded correctly");

        if (bookTicketPage.getSelectArriveAt().getFirstSelectedOption().getText().equals("Sài Gòn"))
            test.log(LogStatus.PASS, "Arrive at is loaded correctly");
        else
            test.log(LogStatus.FAIL, "Arrive at is not loaded correctly");
    }

}
