package pageObjects;

import common.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AccountConfirmPage {

    // Locators
    private final By lblMessage = By.cssSelector("#content p");
    private final By txtConfirmationCode = By.id("confirmationCode");
    private final By btnConfirm = By.xpath("//form//input[@value='Confirm']");

    // Elements
    public WebElement getLblMessage() {
        return Driver.getDriver().findElement(lblMessage);
    }

    public WebElement getTxtConfirmationCode() {
        return Driver.getDriver().findElement(txtConfirmationCode);
    }

    public WebElement getBtnConfirm() {
        return Driver.getDriver().findElement(btnConfirm);
    }

    // Methods
    public String getMessage() {
        return getLblMessage().getText();
    }

    public String confirmation(String code) {
        getTxtConfirmationCode().sendKeys(code);
        getBtnConfirm().click();

        return getMessage();
    }

}
