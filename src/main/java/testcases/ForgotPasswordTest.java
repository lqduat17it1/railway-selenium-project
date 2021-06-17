package testcases;

import com.relevantcodes.extentreports.LogStatus;
import common.Constant;
import org.testng.annotations.Test;
import pageObjects.ForgotPasswordPage;
import pageObjects.RegisterPage;

public class ForgotPasswordTest extends BaseTest {

    RegisterPage registerPage = new RegisterPage();
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    @Test(description = "TC12 - Errors display when password reset token is blank")
    public void TC12() {
//        homePage.open();
//
//        registerPage = homePage.gotoRegisterPage();
//        registerPage.register(Constant.NEW_USERNAME, Constant.NEW_PASSWORD, Constant.NEW_PASSWORD, Constant.NEW_PID);
//
//        try {
//            forgotPasswordPage.passwordReset(Constant.NEW_USERNAME);
//        }
//        catch (Exception e) {
//            test.log(LogStatus.FAIL, "Server error");
//        }
        test.log(LogStatus.SKIP, "Function is not complete");
    }

    @Test(description = "TC13 - Errors display if password and confirm password don't match when resetting password")
    public void TC13() {
        test.log(LogStatus.SKIP, "Function is not complete");
    }

}
