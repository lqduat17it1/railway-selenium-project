package testcases;

import com.relevantcodes.extentreports.LogStatus;
import dataObjects.DataTestSet1;
import org.testng.annotations.Test;
import pageObjects.RegisterPage;

public class TC11 extends BaseTest {

    @Test(description = "TC11 - User can't create account while password and PID fields are empty")
    public void TC11() {
        homePage.open();
        test.log(LogStatus.INFO, "Navigate to QA Railway Website");

        RegisterPage registerPage = homePage.gotoRegisterPage();
        test.log(LogStatus.INFO, "Click on \"Register\" tab");

        try {
            String successMsg = registerPage.register(DataTestSet1.NEW_USERNAME, "", "", "").getMessage();
            test.log(LogStatus.INFO, "Register account with only enter username");

            String actualErrorMsg = registerPage.getMessage();
            test.log(LogStatus.INFO, "Actual error message: "+ actualErrorMsg);

            String expectedErrorMsg = "There're errors in the form. Please correct the errors and try again.";
            test.log(LogStatus.INFO, "Expected error message: "+ expectedErrorMsg);

            if (actualErrorMsg.equals(expectedErrorMsg)) {
                test.log(LogStatus.PASS, "Message \""+ expectedErrorMsg +"\" appears above the form.");
            }
            else {
                if (successMsg.equals("You're here")) {
                    test.log(LogStatus.PASS, "User can register account with password and pid are empty");
                }
                else {
                    test.log(LogStatus.FAIL, "Message displays is wrong with design content");
                }
            }

            boolean errorPasswordMsg = registerPage.getLblErrorPasswordMsg().isDisplayed();
            String actualErrorPasswordMsg = registerPage.getPasswordMsg();
            test.log(LogStatus.INFO, "Actual error password message: "+ actualErrorPasswordMsg);

            String expectedErrorPasswordMsg = "Invalid password length";
            test.log(LogStatus.INFO, "Expected error password message: "+ expectedErrorPasswordMsg);

            if (actualErrorPasswordMsg.equals(expectedErrorPasswordMsg) && errorPasswordMsg) {
                test.log(LogStatus.PASS, "Error message \""+ expectedErrorPasswordMsg +"\" displays");
            }
            else {
                if (!errorPasswordMsg)
                    test.log(LogStatus.FAIL, "Error password message is not displayed");
                else
                    test.log(LogStatus.FAIL, "Message displays is wrong with design content");
            }

            boolean errorPIDMsg = registerPage.getLblErrorPIDMsg().isDisplayed();
            String actualErrorPIDMsg = registerPage.getPIDMsg();
            test.log(LogStatus.INFO, "Actual error pid message: "+ actualErrorPIDMsg);

            String expectedErrorPIDMsg = "Invalid ID length";
            test.log(LogStatus.INFO, "Expected error pid message: "+ expectedErrorPIDMsg);

            if (actualErrorPIDMsg.equals(expectedErrorPIDMsg) && errorPIDMsg) {
                test.log(LogStatus.PASS, "Error message \""+ expectedErrorPIDMsg +"\" displays");
            }
            else {
                if (!errorPIDMsg)
                    test.log(LogStatus.FAIL, "Error pid message is not displayed");
                else
                    test.log(LogStatus.FAIL, "Message displays is wrong with design content");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
