package testcases;

import dataObjects.DataTestSet1;
import org.testng.annotations.Test;
import pageObjects.RegisterPage;

public class TC11 extends BaseTest {

    @Test(description = "TC11 - User can't create account while password and PID fields are empty", testName = "Register")
    public void tc11() {
        homePage.open();
        step(1, "Navigate to QA Railway Website");

        RegisterPage registerPage = homePage.gotoRegisterPage();
        step(2, "Click on \"Register\" tab");

        try {
            String successMsg = registerPage.register("99" + DataTestSet1.NEW_USERNAME, "", "", "").getMessage();
            step(3, "Enter valid email address and leave other fields empty");
            node = test.createNode("Register info details (Step 3)");
            node.info("Username: " + "99" + DataTestSet1.NEW_USERNAME);
            node.info("Password: ");
            node.info("Confirm password: ");
            node.info("PID: ");
            step(4, "Click on \"Register\" button");

            String actualErrorMsg = registerPage.getMessage();
            String expectedErrorMsg = "There're errors in the form. Please correct the errors and try again.";

            if (actualErrorMsg.equals(expectedErrorMsg)) {
                pass("Message \""+ expectedErrorMsg +"\" appears above the form.");
                checkMsgNodePass("Check error message", actualErrorMsg, expectedErrorMsg);
            }
            else {
                if (successMsg.equals("You're here")) {
                    fail("User can register account with password and pid are empty");
                }
                else {
                    fail("Message displays is wrong with design content");
                }
                checkMsgNodeFail("Check error message", actualErrorMsg, expectedErrorMsg);
            }

            boolean errorPasswordMsg = registerPage.getLblErrorPasswordMsg().isDisplayed();
            String actualErrorPasswordMsg = registerPage.getPasswordMsg();
            String expectedErrorPasswordMsg = "Invalid password length";

            if (actualErrorPasswordMsg.equals(expectedErrorPasswordMsg) && errorPasswordMsg) {
                pass("Error message \""+ expectedErrorPasswordMsg +"\" displays");
                checkMsgNodePass("Check error password message", actualErrorPasswordMsg, expectedErrorPasswordMsg);
            }
            else {
                if (!errorPasswordMsg)
                    fail("Error password message is not displayed");
                else
                    fail("Message displays is wrong with design content");
                checkMsgNodeFail("Check error password message", actualErrorPasswordMsg, expectedErrorPasswordMsg);
            }

            boolean errorPIDMsg = registerPage.getLblErrorPIDMsg().isDisplayed();
            String actualErrorPIDMsg = registerPage.getPIDMsg();
            String expectedErrorPIDMsg = "Invalid ID length";

            if (actualErrorPIDMsg.equals(expectedErrorPIDMsg) && errorPIDMsg) {
                pass("Error message \""+ expectedErrorPIDMsg +"\" displays");
                checkMsgNodePass("Check error PID message", actualErrorPIDMsg, expectedErrorPIDMsg);
            }
            else {
                if (!errorPIDMsg)
                    fail("Error pid message is not displayed");
                else
                    fail("Message displays is wrong with design content");
                checkMsgNodeFail("Check error PID message", actualErrorPIDMsg, expectedErrorPIDMsg);
            }
        }
        catch (Exception e) {
            test.fail(e);
        }
    }

}
