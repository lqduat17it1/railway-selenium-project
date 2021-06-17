package testcases;

import com.relevantcodes.extentreports.LogStatus;
import common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class LoginTest extends BaseTest {

    LoginPage loginPage = new LoginPage();

    @Test(description = "TC01 - User can log into Railway with valid username and password")
    public void TC01() {
        homePage.open();

        loginPage = homePage.gotoLoginPage();
        String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;

        try {
            Assert.assertEquals(actualMsg, expectedMsg);
            test.log(LogStatus.PASS, "Login successfully");
        }
        catch (Exception e) {
            test.log(LogStatus.FAIL, "Welcome message is not displayed as expected");
        }
    }

    @Test(description = "TC02 - User can't login with blank Username textbox")
    public void TC02() {
        homePage.gotoLogoutTab();

        loginPage = homePage.gotoLoginPage();

        loginPage.login("", Constant.PASSWORD);
        String msg = loginPage.getLblLoginMsg().getText();
        if (msg.equals("There was a problem with your login and/or errors exist in your form.")) {
            test.log(LogStatus.PASS, "User can't login and message \"There was a problem with your login and/or errors exist in your form. \" appears.");
        }
        else {
            msg = homePage.getWelcomeMessage();
            if (!msg.equals("Welcome guest!")) {
                test.log(LogStatus.FAIL, "Login successfully with invalid username");
            }
            else {
                test.log(LogStatus.FAIL, "An error message is wrong");
            }
        }

    }

    @Test(description = "TC03 - User cannot log into Railway with invalid password")
    public void TC03() {
        Constant.js.executeScript("window.scrollBy(0,2000)");
        loginPage.login(Constant.USERNAME, "");
        String msg = loginPage.getLblLoginMsg().getText();
        if (msg.equals("There was a problem with your login and/or errors exist in your form.")) {
            test.log(LogStatus.PASS, "User can't login and message \"There was a problem with your login and/or errors exist in your form. \" appears.");
        }
        else {
            msg = homePage.getWelcomeMessage();
            if (!msg.equals("Welcome guest!")) {
                test.log(LogStatus.FAIL, "Login successfully with invalid password");
            }
            else {
                test.log(LogStatus.FAIL, "An error message is wrong");
            }
        }

    }

    @Test(description = "TC04 - Login page displays when un-logged User clicks on \"Book ticket\" tab")
    public void TC04() {
        homePage.gotoBookTicketPage();

        String tab = homePage.getTabSelected();
        if (tab.equals("Login")) {
            test.log(LogStatus.PASS, "Login page is displayed");
        }
        else {
            test.log(LogStatus.FAIL, "Login page is not displayed");
        }

    }

    @Test(description = "System shows message when user enters wrong password several times")
    public void TC05() {
        for (int i=1; i<=4; i++) {
            Constant.js.executeScript("window.scrollBy(0,2000)");
            loginPage.login(Constant.USERNAME, "12345678910");
        }
        String actualMsg = loginPage.getLblLoginMsg().getText();
        if (actualMsg.equals("You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.")) {
            test.log(LogStatus.PASS, "User can't login and message \"You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.\" appears.");
        }
        else {
            test.log(LogStatus.FAIL, "An error message is displays wrong content");
        }

    }

    @Test(description = "TC06 - Additional pages display once user logged in")
    public void TC06() {
        loginPage = homePage.gotoLoginPage();
        Constant.js.executeScript("window.scrollBy(0,2000)");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        String[] tab = {"My ticket", "Change password", "Log out"};
        for (String s : tab) {
            if (!homePage.checkTabExists(s)) {
                test.log(LogStatus.FAIL, s + " is not displayed in menu bar");
            } else {
                test.log(LogStatus.PASS, s + " is displayed in menu bar");
            }
        }

        homePage.gotoMyTicketPage();
        if (homePage.getTabSelected().equals("My ticket")) {
            test.log(LogStatus.PASS, "User navigate to My ticket page");
        }
        else {
            test.log(LogStatus.FAIL, "My ticket page is not displayed");
        }

        homePage.gotoChangePasswordPage();
        if (homePage.getTabSelected().equals("Change password")) {
            test.log(LogStatus.PASS, "User navigate to Change password page");
        }
        else {
            test.log(LogStatus.FAIL, "Change password page is not displayed");
        }

    }

}

