package testcases;

import dataObjects.DataTestSet1;
import org.testng.annotations.Test;
import pageObjects.RegisterPage;

public class TC11 extends BaseTest {

    @Test(description = "TC11 - User can't create account while password and PID fields are empty")
    public void TC11() {
        homePage.open();
        test.info("Navigate to QA Railway Website");

        RegisterPage registerPage = homePage.gotoRegisterPage();
        test.info("Click on \"Register\" tab");

        try {
            String successMsg = registerPage.register(DataTestSet1.NEW_USERNAME, "", "", "").getMessage();
            test.info("Register account with only enter username");

            String actualErrorMsg = registerPage.getMessage();
            test.info("Actual error message: "+ actualErrorMsg);

            String expectedErrorMsg = "There're errors in the form. Please correct the errors and try again.";
            test.info("Expected error message: "+ expectedErrorMsg);

            if (actualErrorMsg.equals(expectedErrorMsg)) {
                test.pass("Message \""+ expectedErrorMsg +"\" appears above the form.");
            }
            else {
                if (successMsg.equals("You're here")) {
                    test.pass("User can register account with password and pid are empty");
                }
                else {
                    test.fail("Message displays is wrong with design content");
                }
            }

            boolean errorPasswordMsg = registerPage.getLblErrorPasswordMsg().isDisplayed();
            String actualErrorPasswordMsg = registerPage.getPasswordMsg();
            test.info("Actual error password message: "+ actualErrorPasswordMsg);

            String expectedErrorPasswordMsg = "Invalid password length";
            test.info("Expected error password message: "+ expectedErrorPasswordMsg);

            if (actualErrorPasswordMsg.equals(expectedErrorPasswordMsg) && errorPasswordMsg) {
                test.pass("Error message \""+ expectedErrorPasswordMsg +"\" displays");
            }
            else {
                if (!errorPasswordMsg)
                    test.fail("Error password message is not displayed");
                else
                    test.fail("Message displays is wrong with design content");
            }

            boolean errorPIDMsg = registerPage.getLblErrorPIDMsg().isDisplayed();
            String actualErrorPIDMsg = registerPage.getPIDMsg();
            test.info("Actual error pid message: "+ actualErrorPIDMsg);

            String expectedErrorPIDMsg = "Invalid ID length";
            test.info("Expected error pid message: "+ expectedErrorPIDMsg);

            if (actualErrorPIDMsg.equals(expectedErrorPIDMsg) && errorPIDMsg) {
                test.pass("Error message \""+ expectedErrorPIDMsg +"\" displays");
            }
            else {
                if (!errorPIDMsg)
                    test.fail("Error pid message is not displayed");
                else
                    test.fail("Message displays is wrong with design content");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
