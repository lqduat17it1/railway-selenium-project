package testcases;
    
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
        test.info("Navigate to QA Railway Website");

        LoginPage loginPage = homePage.gotoLoginPage();
        test.info("Click on \"Login\" tab");

        loginPage.login(DataTestSet1.NEW_USERNAME, DataTestSet1.NEW_PASSWORD);
        test.info("Login to Railway website");
        test.info(" - Enter Username: "+ Constant.USERNAME);
        test.info(" - Enter Password: "+ Constant.PASSWORD);

        ChangePasswordPage changePasswordPage = homePage.gotoChangePasswordPage();
        test.info("Click on \"Change password\" tab");

        String actualMsg = changePasswordPage.changePassword(DataTestSet1.NEW_PASSWORD, "1234567890");
        test.info("Change password");
        test.info(" - Enter old password: "+ DataTestSet1.NEW_PASSWORD);
        test.info(" - Enter new password: 1234567890");
        test.info("Actual message: "+ actualMsg);

        String expectedMsg = "Your password has been updated!";
        test.info("Expected message: "+ expectedMsg);

        if (actualMsg.equals(expectedMsg)) {
            test.pass("Message \"Your password has been updated\" appears.");
        }
        else {
            test.fail("A message \""+ actualMsg +"\" appears.");
        }

    }

}
