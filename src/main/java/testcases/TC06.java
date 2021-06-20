package testcases;

import common.Constant;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC06 extends BaseTest {

    @Test(description = "TC06 - Additional pages display once user logged in")
    public void TC06() {
        homePage.open();
        test.info("Navigate to QA Railway Website");

        LoginPage loginPage = homePage.gotoLoginPage();
        test.info("Click on \"Login\" tab");

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        test.info("Login to Railway website");
        test.info(" - Enter Username: "+Constant.USERNAME);
        test.info(" - Enter Password: "+Constant.PASSWORD);

        String[] tab = {"My ticket", "Change password", "Log out"};
        for (String s : tab) {
            if (!homePage.checkTabExists(s)) {
                test.fail(s + " is not displayed in menu bar");
            } else {
                test.pass(s + " is displayed in menu bar");
            }
        }

        homePage.gotoMyTicketPage();
        if (homePage.getTabSelected().equals("My ticket")) {
            test.pass("User can navigate to My ticket page");
        }
        else {
            test.fail("My ticket page is not displayed");
        }

        homePage.gotoChangePasswordPage();
        if (homePage.getTabSelected().equals("Change password")) {
            test.pass("User can navigate to Change password page");
        }
        else {
            test.fail("Change password page is not displayed");
        }

    }

}
