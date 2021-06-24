package pageObjects;

import common.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {

    // Locators
    private final By txtEmailAddress = By.id("email");
    private final By btnSend = By.xpath("//input[@value='Send Instructions']");
    private final By lblMsgError = By.className("message");

    // Elements
    public WebElement getTxtEmailAddress() {
        return Driver.getDriver().findElement(txtEmailAddress);
    }

    public WebElement getBtnSend() {
        return Driver.getDriver().findElement(btnSend);
    }

    public WebElement getLblMsgError() {
        return Driver.getDriver().findElement(lblMsgError);
    }

    // Methods
    public String passwordReset(String email) {
        getTxtEmailAddress().sendKeys(email);
        getBtnSend().click();

        return getLblMsgError().getText();
    }

}
