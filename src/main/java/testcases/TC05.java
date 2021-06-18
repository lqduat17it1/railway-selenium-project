package testcases;

import com.relevantcodes.extentreports.LogStatus;
import common.Constant;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC05 extends BaseTest {

    @Test(description = "TC05 - System shows message when user enters wrong password several times")
    public void TC05() {
        homePage.open();
        test.log(LogStatus.INFO, "Navigate to QA Railway Website");

        LoginPage loginPage = homePage.gotoLoginPage();
        test.log(LogStatus.INFO, "Click on \"Login\" tab");

        test.log(LogStatus.INFO, "Login with invalid info for 4 times");
        for (int i=1; i<=4; i++) {
            Constant.js.executeScript("window.scrollBy(0,2000)");
            loginPage.login(Constant.USERNAME, "12345678910");
            test.log(LogStatus.INFO, i+". Login with username \""+ Constant.USERNAME +"\" and password \"12345678910\" ");
        }
        String actualMsg = loginPage.getLblLoginMsg().getText();
        test.log(LogStatus.INFO, "Actual message: "+ actualMsg);

        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        test.log(LogStatus.INFO, "Expected message: "+ expectedMsg);

        if (actualMsg.equals(expectedMsg)) {
            test.log(LogStatus.PASS, "User can't login and message \""+ expectedMsg +"\" appears.");
        }
        else {
            test.log(LogStatus.FAIL, "An error message is displays wrong content");
        }

    }

}
