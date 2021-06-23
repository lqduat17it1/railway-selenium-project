package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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
        return Constant.webdriver.get().findElement(txtEmail);
    }

    public WebElement getTxtPassword() {
        return Constant.webdriver.get().findElement(txtPassword);
    }

    public WebElement getTxtConfirmPassword() {
        return Constant.webdriver.get().findElement(txtConfirmPassword);
    }

    public WebElement getTxtPid() {
        return Constant.webdriver.get().findElement(txtPid);
    }

    public WebElement getBtnRegister() {
        return Constant.webdriver.get().findElement(btnRegister);
    }

    public WebElement getLblErrorMsg() {
        return Constant.webdriver.get().findElement(lblErrorMsg);
    }

    public WebElement getLblErrorPasswordMsg() {
        return Constant.webdriver.get().findElement(lblErrorPasswordMsg);
    }

    public WebElement getLblErrorPIDMsg() {
        return Constant.webdriver.get().findElement(lblErrorPIDMsg);
    }

    // Methods
    public AccountConfirmPage register(String email, String password, String confirmPassword,  String pid) {
        getTxtEmail().sendKeys(email);
        getTxtPassword().sendKeys(password);
        getTxtConfirmPassword().sendKeys(confirmPassword);
        getTxtPid().sendKeys(pid);
        getBtnRegister().sendKeys(Keys.ENTER);

        try {
            if (!getLblErrorMsg().isDisplayed()) {
                WebDriverWait wait = new WebDriverWait(Constant.webdriver.get(), Duration.ofSeconds(10));
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.tagName("h1")));
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
