package testcases;

import org.testng.annotations.Test;

public class TC04 extends BaseTest {

    @Test(description = "TC04 - Login page displays when un-logged User clicks on \"Book ticket\" tab", testName = "Login")
    public void tc04() {
        homePage.open();
        step(1, "Navigate to QA Railway Website");

        try {
            homePage.gotoBookTicketPage();
            step(2, "Click on \"Book ticket\" tab");

            String tab = homePage.getTabSelected();
            if (tab.equals("Login") && homePage.checkPageTitle("Login Page")) {
                pass("Login page is displayed");
                node = test.createNode(passFormat("Check the page being displayed"));
            } else {
                fail("Login page is not displayed");
                node = test.createNode(failFormat("Check the page being displayed"));
            }
            node.info("Tab selected: " + tab);
            node.info("Page title: " + homePage.getPageTitle().getText());
        }
        catch (Exception e) {
            test.fail(e);
        }
    }

}
