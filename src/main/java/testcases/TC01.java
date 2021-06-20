package testcases;

import com.aventstack.extentreports.MediaEntityBuilder;
import common.Constant;
import common.Utilities;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC01 extends BaseTest {

    @Test(description = "TC01 - User can log into Railway with valid username and password")
    public void tc01() {
        homePage.open();
        step(1, "Navigate to QA Railway Website");

        LoginPage loginPage = homePage.gotoLoginPage();
        step(2, "Click on \"Login\" tab");

        String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        step(3, "Enter valid Email and Password");
        node = test.createNode("Login info detail (Step 3)");
        node.info("Username: " + Constant.USERNAME);
        node.info("Password: " + Constant.PASSWORD);

        step(4, "Click on \"Login\" button");

        String expectedMsg = "Welcome " + Constant.USERNAME;

        if (actualMsg.equals(expectedMsg)) {
            pass("Login successfully. Welcome user message is displayed.");
            setCheckNode("Check message", actualMsg, expectedMsg, "pass");
        }
        else
            try {
                fail("Welcome message is not displayed as expected");
                setCheckNode("Check message", actualMsg, expectedMsg, "fail");
            }
            catch (Exception e) {
                fail("Test failed, cannot attach screenshot");
            }
    }

}
