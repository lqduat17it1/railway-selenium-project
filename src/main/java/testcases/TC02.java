package testcases;

import dataObjects.DataTestSet1;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC02 extends BaseTest {

    @Test(description = "TC02 - User can't login with blank Username textbox", testName = "Login")
    public void tc02() {
        homePage.open();
        step(1, "Navigate to QA Railway Website");

        try {
            LoginPage loginPage = homePage.gotoLoginPage();
            step(2, "Click on \"Login\" tab");

            loginPage.login("", DataTestSet1.PASSWORD);
            step(3, "Doesn't type any words into \"Username\" textbox but enter valid information into \"Password\" textbox");
            node = test.createNode("Login info details (Step 3)");
            node.info("Username: ");
            node.info("Password: " + DataTestSet1.PASSWORD);

            step(4, "Click on \"Login\" button");

            String actualMsg = loginPage.getLblLoginMsg().getText();
            String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

            if (actualMsg.equals(expectedMsg)) {
                pass("User can't login and message \"" + expectedMsg + "\" appears.");
                checkMsgNodePass("Check error message", actualMsg, expectedMsg);
            } else {
                actualMsg = homePage.getWelcomeMessage();
                if (!actualMsg.equals("Welcome guest!")) {
                    fail("Login successfully with invalid username");
                } else {
                    fail("An error message is wrong");
                }
                checkMsgNodeFail("Check error message", actualMsg, expectedMsg);
            }
        }
        catch (Exception e) {
            test.fail(e);
        }
    }

}
