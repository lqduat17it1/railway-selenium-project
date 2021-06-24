package pageObjects;

import common.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage {

    // Locators
    private final By txtCurrentPassword = By.id("currentPassword");
    private final By txtNewPassword = By.id("newPassword");
    private final By txtConfirmPassword = By.id("confirmPassword");
    private final By btnChangePassword = By.xpath("//input[@value='Change Password']");
    private final By lblErrorMsg = By.className("message");

    // Elements
    public WebElement getTxtCurrentPassword() {
        return Driver.getDriver().findElement(txtCurrentPassword);
    }

    public WebElement getTxtNewPassword() {
        return Driver.getDriver().findElement(txtNewPassword);
    }

    public WebElement getTxtConfirmPassword() {
        return Driver.getDriver().findElement(txtConfirmPassword);
    }

    public WebElement getBtnChangePassword() {
        return Driver.getDriver().findElement(btnChangePassword);
    }

    public WebElement getLblErrorMsg() {
        return Driver.getDriver().findElement(lblErrorMsg);
    }

    // Methods
    public String changePassword(String currentPassword, String newPassword) {
        getTxtCurrentPassword().sendKeys(currentPassword);
        getTxtNewPassword().sendKeys(newPassword);
        getTxtConfirmPassword().sendKeys(newPassword);
        getBtnChangePassword().click();

        return getLblErrorMsg().getText();
    }

}
