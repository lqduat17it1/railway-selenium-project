package testcases;

import dataObjects.DataTestSet1;
import org.testng.annotations.Test;
import pageObjects.RegisterPage;

public class TC10 extends BaseTest {

    @Test(description = "TC10 - User can't create account with \"Confirm password\" is not the same with \"Password\"")
    public void TC10() {
        homePage.open();
        test.info("Navigate to QA Railway Website");

        RegisterPage registerPage = homePage.gotoRegisterPage();
        test.info("Click on \"Register\" tab");

        try {
            String successMsg = registerPage.register(DataTestSet1.NEW_USERNAME, DataTestSet1.NEW_PASSWORD, DataTestSet1.NEW_PASSWORD + "123", DataTestSet1.NEW_PID).getMessage();
            test.info("Register account");
            test.info(" - Enter username: "+ DataTestSet1.NEW_USERNAME);
            test.info(" - Enter password: "+ DataTestSet1.NEW_PASSWORD);
            test.info(" - Enter confirm password: 123");
            test.info(" - Enter PID: "+ DataTestSet1.NEW_PID);

            String actualMsg = registerPage.getMessage();
            test.info("Actual message: "+ actualMsg);

            String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
            test.info("Expected message: "+ expectedMsg);

            if (actualMsg.equals(expectedMsg)) {
                test.pass("Message \""+ expectedMsg +"\" appears.");
            }
            else {
                if (successMsg.equals("You're here")) {
                    test.pass("User can register account with invalid \"Confirm password\"");
                }
                else {
                    test.fail("Message displays is wrong with design content");
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
