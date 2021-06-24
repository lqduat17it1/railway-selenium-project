package pageObjects;

import common.Driver;
import dataObjects.DataTestSet1;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    // Locators
    private final By txtEmail = By.xpath("//input[@id='email']");
    private final By txtPassword = By.xpath("//input[@id='password']");
    private final By txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
    private final By txtPid = By.xpath("//input[@id='pid']");
    private final By btnRegister = By.xpath("//input[@value='Register' and @title='Register']");
    private final By lblErrorMsg = By.className("message");
    private final By lblErrorPasswordMsg = By.xpath("//li[@class='password']//label[@class='validation-error']");
    private final By lblErrorPIDMsg = By.xpath("//li[@class='pid-number']//label[@class='validation-error']");

    // Elements
    public WebElement getTxtEmail() {
        return Driver.getDriver().findElement(txtEmail);
    }

    public WebElement getTxtPassword() {
        return Driver.getDriver().findElement(txtPassword);
    }

    public WebElement getTxtConfirmPassword() {
        return Driver.getDriver().findElement(txtConfirmPassword);
    }

    public WebElement getTxtPid() {
        return Driver.getDriver().findElement(txtPid);
    }

    public WebElement getBtnRegister() {
        return Driver.getDriver().findElement(btnRegister);
    }

    public WebElement getLblErrorMsg() {
        return Driver.getDriver().findElement(lblErrorMsg);
    }

    public WebElement getLblErrorPasswordMsg() {
        return Driver.getDriver().findElement(lblErrorPasswordMsg);
    }

    public WebElement getLblErrorPIDMsg() {
        return Driver.getDriver().findElement(lblErrorPIDMsg);
    }

    // Methods
    public AccountConfirmPage register(String email, String password, String confirmPassword,  String pid) {
        getTxtEmail().sendKeys(email);
        getTxtPassword().sendKeys(password);
        getTxtConfirmPassword().sendKeys(confirmPassword);
        getTxtPid().sendKeys(pid);
        getBtnRegister().click();

        try {
            if (!getLblErrorMsg().isDisplayed()) {
                WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
                wait.until(ExpectedConditions.urlContains(DataTestSet1.CONFIRM_PAGE_URL));
            }
        }
        catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        return new AccountConfirmPage();
    }

    public String getMessage() {
        return getLblErrorMsg().getText();
    }

    public String getPasswordMsg() {
        return getLblErrorPasswordMsg().getText();
    }

    public String getPIDMsg() {
        return getLblErrorPIDMsg().getText();
    }
}
