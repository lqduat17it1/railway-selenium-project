package testcases;

import dataObjects.DataTestSet1;
import org.testng.annotations.Test;
import pageObjects.RegisterPage;

public class TC07 extends BaseTest {

    @Test(description = "TC07 - User can create new account", testName = "Register")
    public void tc07() {
        homePage.open();
        step(1, "Navigate to QA Railway Website");

        try {
            RegisterPage registerPage = homePage.gotoRegisterPage();
            step(2, "Click on \"Register\" tab");

            String actualMsg = registerPage.register(DataTestSet1.USERNAME_TC07, DataTestSet1.PASSWORD_TC07, DataTestSet1.PASSWORD_TC07, DataTestSet1.PID_TC07).getMessage();
            step(3, "Enter valid information into all fields");
            node = test.createNode("Register info details (Step 3)");
            node.info("Username: " + DataTestSet1.USERNAME_TC07);
            node.info("Password: " + DataTestSet1.PASSWORD_TC07);
            node.info("Confirm password: " + DataTestSet1.PASSWORD_TC07);
            node.info("PID: " + DataTestSet1.PID_TC07);

            String expectedMsg = "Thank you for registering your account";

            if (actualMsg.equals(expectedMsg)) {
                pass("A message \"" + expectedMsg + "\" appears.");
                checkMsgNodePass("Check message", actualMsg, expectedMsg);
            } else {
                fail("A message displayed is not same expected message");
                checkMsgNodeFail("Check message", actualMsg, expectedMsg);
            }
        }
        catch (Exception e) {
            test.fail(e);
        }
    }

}
