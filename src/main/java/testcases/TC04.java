package testcases;

import org.testng.annotations.Test;

public class TC04 extends BaseTest {

    @Test(description = "TC04 - Login page displays when un-logged User clicks on \"Book ticket\" tab")
    public void TC04() {
        homePage.open();
        test.info("Navigate to QA Railway Website");

        homePage.gotoBookTicketPage();
        test.info("Click on \"Book ticket\" tab");

        String tab = homePage.getTabSelected();
        if (tab.equals("Login")) {
            test.pass("Login page is displayed");
        }
        else {
            test.fail("Login page is not displayed");
        }

    }

}
