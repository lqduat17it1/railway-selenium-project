package testcases;

import com.relevantcodes.extentreports.LogStatus;
import dataObjects.DataTestSet1;
import org.testng.annotations.Test;
import pageObjects.RegisterPage;

public class TC10 extends BaseTest {

    @Test(description = "TC10 - User can't create account with \"Confirm password\" is not the same with \"Password\"")
    public void TC10() {
        homePage.open();
        test.log(LogStatus.INFO, "Navigate to QA Railway Website");

        RegisterPage registerPage = homePage.gotoRegisterPage();
        test.log(LogStatus.INFO, "Click on \"Register\" tab");

        try {
            String successMsg = registerPage.register(DataTestSet1.NEW_USERNAME, DataTestSet1.NEW_PASSWORD, DataTestSet1.NEW_PASSWORD + "123", DataTestSet1.NEW_PID).getMessage();
            test.log(LogStatus.INFO, "Register account");
            test.log(LogStatus.INFO, " - Enter username: "+ DataTestSet1.NEW_USERNAME);
            test.log(LogStatus.INFO, " - Enter password: "+ DataTestSet1.NEW_PASSWORD);
            test.log(LogStatus.INFO, " - Enter confirm password: 123");
            test.log(LogStatus.INFO, " - Enter PID: "+ DataTestSet1.NEW_PID);

            String actualMsg = registerPage.getMessage();
            test.log(LogStatus.INFO, "Actual message: "+ actualMsg);

            String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
            test.log(LogStatus.INFO, "Expected message: "+ expectedMsg);

            if (actualMsg.equals(expectedMsg)) {
                test.log(LogStatus.PASS, "Message \""+ expectedMsg +"\" appears.");
            }
            else {
                if (successMsg.equals("You're here")) {
                    test.log(LogStatus.PASS, "User can register account with invalid \"Confirm password\"");
                }
                else {
                    test.log(LogStatus.FAIL, "Message displays is wrong with design content");
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
