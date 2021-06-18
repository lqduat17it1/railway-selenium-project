package testcases;

import com.relevantcodes.extentreports.LogStatus;
import dataObjects.DataTestSet1;
import org.testng.annotations.Test;
import pageObjects.RegisterPage;

public class TC07 extends BaseTest {

    @Test(description = "TC07 - User can create new account")
    public void TC07() {
        homePage.open();
        test.log(LogStatus.INFO, "Navigate to QA Railway Website");

        RegisterPage registerPage = homePage.gotoRegisterPage();
        test.log(LogStatus.INFO, "Click on \"Register\" tab");

        String actualMsg = registerPage.register(DataTestSet1.NEW_USERNAME, DataTestSet1.NEW_PASSWORD, DataTestSet1.NEW_PASSWORD, DataTestSet1.NEW_PID).getMessage();
        test.log(LogStatus.INFO, "Register account");
        test.log(LogStatus.INFO, " - Enter username: "+ DataTestSet1.NEW_USERNAME);
        test.log(LogStatus.INFO, " - Enter password: "+ DataTestSet1.NEW_PASSWORD);
        test.log(LogStatus.INFO, " - Enter confirm password: "+ DataTestSet1.NEW_PASSWORD);
        test.log(LogStatus.INFO, " - Enter PID: "+ DataTestSet1.NEW_PID);
        test.log(LogStatus.INFO, "Actual message: "+ actualMsg);

        String expectedMsg = "Thank you for registering your account";
        test.log(LogStatus.INFO, "Expected message: "+ expectedMsg);

        if (actualMsg.equals(expectedMsg)) {
            test.log(LogStatus.PASS, "A message \""+ expectedMsg +"\" appears.");
        }
        else {
            test.log(LogStatus.FAIL, "A message displayed is not same expected message");
        }

    }

}
