package testcases;

import dataObjects.DataTestSet1;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC01 extends BaseTest {

    @Test(description = "TC01 - User can log into Railway with valid username and password", testName = "Login")
    public void tc01() {
        homePage.open();
        step(1, "Navigate to QA Railway Website");

        try {
            LoginPage loginPage = homePage.gotoLoginPage();
            step(2, "Click on \"Login\" tab");

            String actualMsg = loginPage.login(DataTestSet1.USERNAME, DataTestSet1.PASSWORD).getWelcomeMessage();
            step(3, "Enter valid Email and Password");
            node = test.createNode("Login info details (Step 3)");
            node.info("Username: " + DataTestSet1.USERNAME);
            node.info("Password: " + DataTestSet1.PASSWORD);

            step(4, "Click on \"Login\" button");

            String expectedMsg = "Welcome " + DataTestSet1.USERNAME;

            if (actualMsg.equals(expectedMsg)) {
                pass("Login successfully. Welcome user message is displayed.");
                checkMsgNodePass("Check message", actualMsg, expectedMsg);
            } else
                try {
                    fail("Welcome message is not displayed as expected");
                    checkMsgNodeFail("Check message", actualMsg, expectedMsg);
                } catch (Exception e) {
                    fail("Test failed, cannot attach screenshot");
                }
        }
        catch (Exception e) {
            test.fail(e);
        }

    }

}
