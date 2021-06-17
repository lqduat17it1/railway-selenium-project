package testcases;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.RegisterPage;

public class RegisterTest extends BaseTest {

    RegisterPage registerPage = new RegisterPage();

    @Test(description = "TC07 - User can create new account")
    public void TC07() {
        homePage.open();

        registerPage = homePage.gotoRegisterPage();
        String actualMsg = registerPage.register(Constant.NEW_USERNAME, Constant.NEW_PASSWORD, Constant.NEW_PASSWORD, Constant.NEW_PID).getMessage();
        String expectedMsg = "Thank you for registering your account";
        if (actualMsg.equals(expectedMsg)) {
            test.log(LogStatus.PASS, "A message \""+ expectedMsg +"\" appears.");
        }
        else {
            test.log(LogStatus.FAIL, "A message displayed is not same expected message");
        }

    }

    @Test(description = "TC08 - User can't login with an account hasn't been activated")
    public void TC08() {
        test.log(LogStatus.SKIP,"Can not create an account with not activate");

    }

    @Test(description = "TC10 - User can't create account with \"Confirm password\" is not the same with \"Password\"")
    public void TC10() {
        registerPage = homePage.gotoRegisterPage();
        try {
            String successMsg = registerPage.register(Constant.NEW_USERNAME, Constant.NEW_PASSWORD, Constant.NEW_PASSWORD + "123", Constant.NEW_PID).getMessage();
            String actualMsg = registerPage.getMessage();
            String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
            if (actualMsg.equals(expectedMsg)) {
                test.log(LogStatus.PASS, "Message \"There're errors in the form. Please correct the errors and try again.\" appears.");
            }
            else {
                if (successMsg.equals("You're here")) {
                    test.log(LogStatus.PASS, "User can register account with invalid \"Confirm password\"");
                }
                else {
                    test.log(LogStatus.FAIL, "Message displays is wrong with design content");
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test(description = "TC11 - User can't create account while password and PID fields are empty")
    public void TC11() {
        registerPage = homePage.gotoRegisterPage();
        try {
            String successMsg = registerPage.register(Constant.NEW_USERNAME, "", "", "").getMessage();
            String actualErrorMsg = registerPage.getMessage();
            String expectedErrorMsg = "There're errors in the form. Please correct the errors and try again.";
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
            String expectedErrorPasswordMsg = "Invalid password length";
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
            String expectedErrorPIDMsg = "Invalid ID length";
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
