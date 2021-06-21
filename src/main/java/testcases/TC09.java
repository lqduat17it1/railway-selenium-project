package testcases;
    
import dataObjects.DataTestSet1;
import org.testng.annotations.Test;
import pageObjects.ChangePasswordPage;
import pageObjects.LoginPage;

public class TC09 extends BaseTest {

    @Test(description = "TC09 - User can change password", testName = "Change Password")
    public void tc09() {
        homePage.open();
        step(1, "Navigate to QA Railway Website");

        try {
            LoginPage loginPage = homePage.gotoLoginPage();
            step(2, "Click on \"Login\" tab");

            loginPage.login(DataTestSet1.NEW_USERNAME, DataTestSet1.NEW_PASSWORD);
            step(3, "Login with valid account");
            node = test.createNode("Login info details (Step 3)");
            node.info("Username: " + DataTestSet1.NEW_USERNAME);
            node.info("Password: " + DataTestSet1.NEW_PASSWORD);

            ChangePasswordPage changePasswordPage = homePage.gotoChangePasswordPage();
            step(4, "Click on \"Change password\" tab");

            String actualMsg = changePasswordPage.changePassword(DataTestSet1.NEW_PASSWORD, DataTestSet1.NEW_PASSWORD + "1");
            step(5, "Enter valid value into all fields");
            node = test.createNode("Change password info details (Step 5)");
            node.info("Current password: " + DataTestSet1.NEW_PASSWORD);
            node.info("New password: " + DataTestSet1.NEW_PASSWORD + "1");
            step(6, "Click on \"Change Password\" button");

            String expectedMsg = "Your password has been updated!";

            if (actualMsg.equals(expectedMsg)) {
                pass("Message \"Your password has been updated\" appears.");
                checkMsgNodePass("Check message", actualMsg, expectedMsg);
            } else {
                fail("A message \"" + actualMsg + "\" appears.");
                checkMsgNodeFail("Check message", actualMsg, expectedMsg);
            }
        }
        catch (Exception e) {
            test.fail(e);
        }
    }

}
