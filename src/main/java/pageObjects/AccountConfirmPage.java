package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountConfirmPage {

    // Locators
    private final By lblMessage = By.cssSelector("#content p");
    private final By txtConfirmationCode = By.id("confirmationCode");
    private final By btnConfirm = By.xpath("//form//input[@value='Confirm']");

    // Elements
    public WebElement getLblMessage() {
        return Constant.webdriver.get().findElement(lblMessage);
    }

    public WebElement getTxtConfirmationCode() {
        return Constant.webdriver.get().findElement(txtConfirmationCode);
    }

    public WebElement getBtnConfirm() {
        return Constant.webdriver.get().findElement(btnConfirm);
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
