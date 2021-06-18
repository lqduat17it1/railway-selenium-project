package testcases;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class TC04 extends BaseTest {

    @Test(description = "TC04 - Login page displays when un-logged User clicks on \"Book ticket\" tab")
    public void TC04() {
        homePage.open();
        test.log(LogStatus.INFO, "Navigate to QA Railway Website");

        homePage.gotoBookTicketPage();
        test.log(LogStatus.INFO, "Click on \"Book ticket\" tab");

        String tab = homePage.getTabSelected();
        if (tab.equals("Login")) {
            test.log(LogStatus.PASS, "Login page is displayed");
        }
        else {
            test.log(LogStatus.FAIL, "Login page is not displayed");
        }

    }

}
