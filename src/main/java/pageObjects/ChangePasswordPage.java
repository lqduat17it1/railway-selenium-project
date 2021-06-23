package pageObjects;

import common.Constant;
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
        return Constant.webdriver.get().findElement(txtCurrentPassword);
    }

    public WebElement getTxtNewPassword() {
        return Constant.webdriver.get().findElement(txtNewPassword);
    }

    public WebElement getTxtConfirmPassword() {
        return Constant.webdriver.get().findElement(txtConfirmPassword);
    }

    public WebElement getBtnChangePassword() {
        return Constant.webdriver.get().findElement(btnChangePassword);
    }

    public WebElement getLblErrorMsg() {
        return Constant.webdriver.get().findElement(lblErrorMsg);
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
