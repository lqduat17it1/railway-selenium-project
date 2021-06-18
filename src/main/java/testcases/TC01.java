package testcases;

import com.relevantcodes.extentreports.LogStatus;
import common.Constant;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC01 extends BaseTest {

    @Test(description = "TC01 - User can log into Railway with valid username and password")
    public void TC01() {
        homePage.open();
        test.log(LogStatus.INFO, "Navigate to QA Railway Website");

        LoginPage loginPage = homePage.gotoLoginPage();
        test.log(LogStatus.INFO, "Click on \"Login\" tab");
        String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        test.log(LogStatus.INFO, "Login");
        test.log(LogStatus.INFO, " - Enter Username: "+Constant.USERNAME);
        test.log(LogStatus.INFO, " - Enter Password: "+Constant.PASSWORD);
        test.log(LogStatus.INFO, "Actual Message: "+actualMsg);
        String expectedMsg = "Welcome " + Constant.USERNAME;
        test.log(LogStatus.INFO, "Expected Message: "+expectedMsg);

        if (actualMsg.equals(expectedMsg))
            test.log(LogStatus.PASS, "Login successfully");
        else
            test.log(LogStatus.FAIL, "Welcome message is not displayed as expected");
    }

}
