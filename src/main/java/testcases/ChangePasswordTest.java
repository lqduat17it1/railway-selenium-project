package testcases;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import common.Constant;
import org.testng.annotations.Test;
import pageObjects.ChangePasswordPage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;

public class ChangePasswordTest extends BaseTest {

    RegisterPage registerPage = new RegisterPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "TC09 - User can change password")
    public void TC09() {
        homePage.open();

        registerPage = homePage.gotoRegisterPage();
        registerPage.register(Constant.NEW_USERNAME, Constant.NEW_PASSWORD, Constant.NEW_PASSWORD, Constant.NEW_PID);

        loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.NEW_USERNAME, Constant.NEW_PASSWORD);

        changePasswordPage = homePage.gotoChangePasswordPage();
        String actualMsg = changePasswordPage.changePassword(Constant.NEW_PASSWORD, "1234567890");
        String expectedMsg = "Your password has been updated!";
        if (actualMsg.equals(expectedMsg)) {
            test.log(LogStatus.PASS, "Message \"Your password has been updated\" appears.");
        }
        else {
            test.log(LogStatus.FAIL, "A message \""+ actualMsg +"\" appears.");
        }

    }

}
