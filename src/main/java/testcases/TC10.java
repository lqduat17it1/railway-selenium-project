package testcases;

import common.Utilities;
import dataObjects.DataTestSet1;
import org.testng.annotations.Test;
import pageObjects.RegisterPage;

public class TC10 extends BaseTest {

    @Test(description = "TC10 - User can't create account with \"Confirm password\" is not the same with \"Password\"", testName = "Register")
    public void tc10() {
        homePage.open();
        step(1, "Navigate to QA Railway Website");

        try {
            RegisterPage registerPage = homePage.gotoRegisterPage();
            step(2, "Click on \"Register\" tab");

            String USERNAME = Utilities.getRandomNumber() + DataTestSet1.USERNAME;
            String CONFIRM_PASSWORD = DataTestSet1.PASSWORD + Utilities.getRandomNumber();
            String successMsg = registerPage.register(USERNAME, DataTestSet1.PASSWORD, CONFIRM_PASSWORD, DataTestSet1.PID).getMessage();
            step(3, "Enter valid information into all fields except \"Confirm password\" is not the same with \"Password\"");
            node = test.createNode("Register info details (Step 3)");
            node.info("Username: " + USERNAME);
            node.info("Password: " + DataTestSet1.PASSWORD);
            node.info("Confirm password: " + CONFIRM_PASSWORD);
            node.info("PID: "+ DataTestSet1.PID);
            step(4, "Click on \"Register\" button");

            String actualMsg = registerPage.getMessage();
            String expectedMsg = "There're errors in the form. Please correct the errors and try again.";

            if (actualMsg.equals(expectedMsg)) {
                pass("Message \""+ expectedMsg +"\" appears.");
                checkMsgNodePass("Check message", actualMsg, expectedMsg);
            }
            else {
                if (successMsg.equals("You're here")) {
                    pass("User can register account with invalid \"Confirm password\"");
                }
                else {
                    fail("Message displays is wrong with design content");
                }
                checkMsgNodeFail("Check message", actualMsg, expectedMsg);
            }
        }
        catch (Exception e) {
            test.fail(e);
        }

    }

}
