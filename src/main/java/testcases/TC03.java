package testcases;

import common.Constant;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC03 extends BaseTest {

    @Test(description = "TC03 - User cannot log into Railway with invalid password")
    public void tc03() {
        homePage.open();
        step(1, "Navigate to QA Railway Website");

        LoginPage loginPage = homePage.gotoLoginPage();
        step(2, "Click on \"Login\" tab");

        loginPage.login(Constant.USERNAME, "");
        step(3, "Enter valid Email and invalid Password");
        node = test.createNode("Login info detail (Step 3)");
        node.info("Username: " + Constant.USERNAME);
        node.info("Password: ");

        String actualMsg = loginPage.getLblLoginMsg().getText();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        if (actualMsg.equals(expectedMsg)) {
            pass("User can't login and message \""+ expectedMsg +"\" appears.");
            setCheckNode("Check error message", actualMsg, expectedMsg, "pass");
        }
        else {
            actualMsg = homePage.getWelcomeMessage();
            if (!actualMsg.equals("Welcome guest!")) {
                fail("Login successfully with invalid password");
            }
            else {
                fail("An error message is wrong");
            }
            setCheckNode("Check error message", actualMsg, expectedMsg, "fail");
        }

    }

}
