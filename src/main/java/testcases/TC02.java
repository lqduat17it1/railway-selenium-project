package testcases;

import com.relevantcodes.extentreports.LogStatus;
import common.Constant;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC02 extends BaseTest {

    @Test(description = "TC02 - User can't login with blank Username textbox")
    public void TC02() {
        homePage.open();
        test.log(LogStatus.INFO, "Navigate to QA Railway Website");

        LoginPage loginPage = homePage.gotoLoginPage();
        test.log(LogStatus.INFO, "Click on \"Login\" tab");

        loginPage.login("", Constant.PASSWORD);
        test.log(LogStatus.INFO, "Login with empty username and password is \"123456789\"");

        String actualMsg = loginPage.getLblLoginMsg().getText();
        test.log(LogStatus.INFO, "Actual message: "+ actualMsg);
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
        test.log(LogStatus.INFO, "Expected message: "+ expectedMsg);

        if (actualMsg.equals(expectedMsg)) {
            test.log(LogStatus.PASS, "User can't login and message \""+ expectedMsg +"\" appears.");
        }
        else {
            actualMsg = homePage.getWelcomeMessage();
            if (!actualMsg.equals("Welcome guest!")) {
                test.log(LogStatus.FAIL, "Login successfully with invalid username");
            }
            else {
                test.log(LogStatus.FAIL, "An error message is wrong");
            }
        }

    }

}
