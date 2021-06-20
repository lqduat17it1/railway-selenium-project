package testcases;

import dataObjects.DataTestSet1;
import org.testng.annotations.Test;
import pageObjects.RegisterPage;

public class TC07 extends BaseTest {

    @Test(description = "TC07 - User can create new account")
    public void TC07() {
        homePage.open();
        test.info("Navigate to QA Railway Website");

        RegisterPage registerPage = homePage.gotoRegisterPage();
        test.info("Click on \"Register\" tab");

        String actualMsg = registerPage.register(DataTestSet1.NEW_USERNAME, DataTestSet1.NEW_PASSWORD, DataTestSet1.NEW_PASSWORD, DataTestSet1.NEW_PID).getMessage();
        test.info("Register account");
        test.info(" - Enter username: "+ DataTestSet1.NEW_USERNAME);
        test.info(" - Enter password: "+ DataTestSet1.NEW_PASSWORD);
        test.info(" - Enter confirm password: "+ DataTestSet1.NEW_PASSWORD);
        test.info(" - Enter PID: "+ DataTestSet1.NEW_PID);
        test.info("Actual message: "+ actualMsg);

        String expectedMsg = "Thank you for registering your account";
        test.info("Expected message: "+ expectedMsg);

        if (actualMsg.equals(expectedMsg)) {
            test.pass("A message \""+ expectedMsg +"\" appears.");
        }
        else {
            test.fail("A message displayed is not same expected message");
        }

    }

}
