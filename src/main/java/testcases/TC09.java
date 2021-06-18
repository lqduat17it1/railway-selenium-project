package testcases;

import com.relevantcodes.extentreports.LogStatus;
import common.Constant;
import dataObjects.DataTestSet1;
import org.testng.annotations.Test;
import pageObjects.ChangePasswordPage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;

public class TC09 extends BaseTest {

    @Test(description = "TC09 - User can change password")
    public void TC09() {
        homePage.open();
        test.log(LogStatus.INFO, "Navigate to QA Railway Website");

        RegisterPage registerPage = homePage.gotoRegisterPage();
        test.log(LogStatus.INFO, "Click on \"Register\" tab");

        registerPage.register(DataTestSet1.NEW_USERNAME, DataTestSet1.NEW_PASSWORD, DataTestSet1.NEW_PASSWORD, DataTestSet1.NEW_PID);
        test.log(LogStatus.INFO, "Register account");
        test.log(LogStatus.INFO, " - Enter username: "+ DataTestSet1.NEW_USERNAME);
        test.log(LogStatus.INFO, " - Enter password: "+ DataTestSet1.NEW_PASSWORD);
        test.log(LogStatus.INFO, " - Enter confirm password: "+ DataTestSet1.NEW_PASSWORD);
        test.log(LogStatus.INFO, " - Enter PID: "+ DataTestSet1.NEW_PID);

        LoginPage loginPage = homePage.gotoLoginPage();
        test.log(LogStatus.INFO, "Click on \"Login\" tab");

        loginPage.login(DataTestSet1.NEW_USERNAME, DataTestSet1.NEW_PASSWORD);
        test.log(LogStatus.INFO, "Login to Railway website");
        test.log(LogStatus.INFO, " - Enter Username: "+ Constant.USERNAME);
        test.log(LogStatus.INFO, " - Enter Password: "+Constant.PASSWORD);

        ChangePasswordPage changePasswordPage = homePage.gotoChangePasswordPage();
        test.log(LogStatus.INFO, "Click on \"Change password\" tab");

        String actualMsg = changePasswordPage.changePassword(DataTestSet1.NEW_PASSWORD, "1234567890");
        test.log(LogStatus.INFO, "Change password");
        test.log(LogStatus.INFO, " - Enter old password: "+ DataTestSet1.NEW_PASSWORD);
        test.log(LogStatus.INFO, " - Enter new password: 1234567890");
        test.log(LogStatus.INFO, "Actual message: "+ actualMsg);

        String expectedMsg = "Your password has been updated!";
        test.log(LogStatus.INFO, "Expected message: "+ expectedMsg);

        if (actualMsg.equals(expectedMsg)) {
            test.log(LogStatus.PASS, "Message \"Your password has been updated\" appears.");
        }
        else {
            test.log(LogStatus.FAIL, "A message \""+ actualMsg +"\" appears.");
        }

    }

}
