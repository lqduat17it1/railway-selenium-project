package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

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
        return Constant.WEBDRIVER.findElement(txtEmail);
    }

    public WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    public WebElement getTxtConfirmPassword() {
        return Constant.WEBDRIVER.findElement(txtConfirmPassword);
    }

    public WebElement getTxtPid() {
        return Constant.WEBDRIVER.findElement(txtPid);
    }

    public WebElement getBtnRegister() {
        return Constant.WEBDRIVER.findElement(btnRegister);
    }

    public WebElement getLblErrorMsg() {
        return Constant.WEBDRIVER.findElement(lblErrorMsg);
    }

    public WebElement getLblErrorPasswordMsg() {
        return Constant.WEBDRIVER.findElement(lblErrorPasswordMsg);
    }

    public WebElement getLblErrorPIDMsg() {
        return Constant.WEBDRIVER.findElement(lblErrorPIDMsg);
    }

    // Methods
    public AccountConfirmPage register(String email, String password, String confirmPassword,  String pid) {
        getTxtEmail().sendKeys(email);
        getTxtPassword().sendKeys(password);
        getTxtConfirmPassword().sendKeys(confirmPassword);
        getTxtPid().sendKeys(pid);
        getBtnRegister().sendKeys(Keys.ENTER);
        try {
            TimeUnit.SECONDS.sleep(2);
        }
        catch (Exception e) {
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
