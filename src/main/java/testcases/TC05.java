package testcases;

import common.Utilities;
import dataObjects.DataTestSet1;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC05 extends BaseTest {

    @Test(description = "TC05 - System shows message when user enters wrong password several times", testName = "Login")
    public void tc05() {
        homePage.open();
        step(1, "Navigate to QA Railway Website");

        try {
            LoginPage loginPage = homePage.gotoLoginPage();
            step(2, "Click on \"Login\" tab");

            step(3, "Login with invalid info for 4 times");
            node = test.createNode(passFormat("Login info details (Step 3)"));
            for (int i = 1; i <= 4; i++) {
                Utilities.scrollDown();
                Utilities.clearTextInput(loginPage.getTxtUsername());
                loginPage.login(DataTestSet1.USERNAME, "12345678910");
                node.info(i + ". Login with username \"" + DataTestSet1.USERNAME + "\" and password \"12345678910\" ");
            }

            String actualMsg = loginPage.getLblLoginMsg().getText();
            String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";

            if (actualMsg.equals(expectedMsg)) {
                pass("User can't login and message \"" + expectedMsg + "\" appears.");
                checkMsgNodePass("Check message", actualMsg, expectedMsg);
            } else {
                fail("An error message is displays wrong content");
                checkMsgNodeFail("Check message", actualMsg, expectedMsg);
            }
        }
        catch (Exception e) {
            test.fail(e);
        }
    }

}
