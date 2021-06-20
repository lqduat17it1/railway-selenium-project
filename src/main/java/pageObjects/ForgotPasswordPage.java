package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {

    // Locators
    private final By txtEmailAddress = By.id("email");
    private final By btnSend = By.xpath("//input[@value='Send Instructions']");
    private final By lblMsgError = By.className("message");

    // Elements
    public WebElement getTxtEmailAddress() {
        return Constant.WEBDRIVER.findElement(txtEmailAddress);
    }

    public WebElement getBtnSend() {
        return Constant.WEBDRIVER.findElement(btnSend);
    }

    public WebElement getLblMsgError() {
        return Constant.WEBDRIVER.findElement(lblMsgError);
    }

    // Methods
    public String passwordReset(String email) {
        getTxtEmailAddress().sendKeys(email);
        getBtnSend().click();

        return getLblMsgError().getText();
    }

}
