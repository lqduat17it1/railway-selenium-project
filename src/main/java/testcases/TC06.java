package testcases;

import com.relevantcodes.extentreports.LogStatus;
import common.Constant;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC06 extends BaseTest {

    @Test(description = "TC06 - Additional pages display once user logged in")
    public void TC06() {
        homePage.open();
        test.log(LogStatus.INFO, "Navigate to QA Railway Website");

        LoginPage loginPage = homePage.gotoLoginPage();
        test.log(LogStatus.INFO, "Click on \"Login\" tab");

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        test.log(LogStatus.INFO, "Login to Railway website");
        test.log(LogStatus.INFO, " - Enter Username: "+Constant.USERNAME);
        test.log(LogStatus.INFO, " - Enter Password: "+Constant.PASSWORD);

        String[] tab = {"My ticket", "Change password", "Log out"};
        for (String s : tab) {
            if (!homePage.checkTabExists(s)) {
                test.log(LogStatus.FAIL, s + " is not displayed in menu bar");
            } else {
                test.log(LogStatus.PASS, s + " is displayed in menu bar");
            }
        }

        homePage.gotoMyTicketPage();
        if (homePage.getTabSelected().equals("My ticket")) {
            test.log(LogStatus.PASS, "User can navigate to My ticket page");
        }
        else {
            test.log(LogStatus.FAIL, "My ticket page is not displayed");
        }

        homePage.gotoChangePasswordPage();
        if (homePage.getTabSelected().equals("Change password")) {
            test.log(LogStatus.PASS, "User can navigate to Change password page");
        }
        else {
            test.log(LogStatus.FAIL, "Change password page is not displayed");
        }

    }

}
