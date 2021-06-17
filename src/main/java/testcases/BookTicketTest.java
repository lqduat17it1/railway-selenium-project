package testcases;

import com.relevantcodes.extentreports.LogStatus;
import common.Constant;
import org.testng.annotations.Test;
import pageObjects.BookTicketPage;
import pageObjects.LoginPage;
import pageObjects.TimetablePage;

public class BookTicketTest extends BaseTest {

    BookTicketPage bookTicketPage = new BookTicketPage();
    LoginPage loginPage = new LoginPage();
    TimetablePage timetablePage = new TimetablePage();

    @Test(description = "TC14 - User can book 1 ticket at a time")
    public void TC14() {
        homePage.open();

        loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        bookTicketPage = homePage.gotoBookTicketPage();
        try {
            boolean result = bookTicketPage.bookTicket("6/21/2021", "Sài Gòn", "Nha Trang", "Soft bed with air conditioner", "1").checkTicket("Sài Gòn", "Nha Trang", "Soft bed with air conditioner", "6/21/2021", "1");
            if (result) {
                test.log(LogStatus.PASS, "User book ticket successfully");
            } else
                test.log(LogStatus.FAIL, "Ticket information is not correctly");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test(description = "TC15 - User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page")
    public void TC15() {
        timetablePage = homePage.gotoTimetablePage();
        bookTicketPage = timetablePage.bookTicket("Huế", "Sài Gòn");

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
