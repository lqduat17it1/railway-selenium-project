package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AccountConfirmPage {

    // Locators
    private final By lblMessage = By.cssSelector("#content p");
    private final By txtConfirmationCode = By.id("confirmationCode");
    private final By btnConfirm = By.xpath("//form//input[@value='Confirm']");

    // Elements
    public WebElement getLblMessage() {
        return Constant.WEBDRIVER.findElement(lblMessage);
    }

    public WebElement getTxtConfirmationCode() {
        return Constant.WEBDRIVER.findElement(txtConfirmationCode);
    }

    public WebElement getBtnConfirm() {
        return Constant.WEBDRIVER.findElement(btnConfirm);
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
