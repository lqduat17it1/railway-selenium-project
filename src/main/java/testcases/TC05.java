package testcases;

import common.Constant;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC05 extends BaseTest {

    @Test(description = "TC05 - System shows message when user enters wrong password several times")
    public void TC05() {
        homePage.open();
        test.info("Navigate to QA Railway Website");

        LoginPage loginPage = homePage.gotoLoginPage();
        test.info("Click on \"Login\" tab");

        test.info("Login with invalid info for 4 times");
        for (int i=1; i<=4; i++) {
            Constant.js.executeScript("window.scrollBy(0,2000)");
            loginPage.login(Constant.USERNAME, "12345678910");
            test.info(i+". Login with username \""+ Constant.USERNAME +"\" and password \"12345678910\" ");
        }
        String actualMsg = loginPage.getLblLoginMsg().getText();
        test.info("Actual message: "+ actualMsg);

        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        test.info("Expected message: "+ expectedMsg);

        if (actualMsg.equals(expectedMsg)) {
            test.pass("User can't login and message \""+ expectedMsg +"\" appears.");
        }
        else {
            test.fail("An error message is displays wrong content");
        }

    }

}
