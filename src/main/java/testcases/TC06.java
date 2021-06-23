package testcases;

import dataObjects.DataTestSet1;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC06 extends BaseTest {

    @Test(description = "TC06 - Additional pages display once user logged in", testName = "Login")
    public void tc06() {
        homePage.open();
        step(1, "Navigate to QA Railway Website");

        try {
            LoginPage loginPage = homePage.gotoLoginPage();
            step(2, "Click on \"Login\" tab");

            loginPage.login(DataTestSet1.USERNAME, DataTestSet1.PASSWORD);
            step(3, "Login with valid account");
            node = test.createNode("Login info details (Step 3)");
            node.info("Username: " + DataTestSet1.USERNAME);
            node.info("Password: " + DataTestSet1.PASSWORD);

            String[] tab = {"My ticket", "Change password", "Log out"};
            for (String s : tab) {
                if (!homePage.checkTabExists(s)) {
                    fail(s + " is not displayed in menu bar");
                } else {
                    pass(s + " is displayed in menu bar");
                }
            }

            homePage.gotoMyTicketPage();
            step(4, "Click on \"My ticket\" tab");
            if (homePage.getTabSelected().equals("My ticket")) {
                pass("User can navigate to My ticket page");
            } else {
                fail("My ticket page is not displayed");
            }

            homePage.gotoChangePasswordPage();
            step(5, "Click on \"Change password\" tab");
            if (homePage.getTabSelected().equals("Change password")) {
                pass("User can navigate to Change password page");
            } else {
                fail("Change password page is not displayed");
            }
        }
        catch (Exception e) {
            test.fail(e);
        }
    }

}
