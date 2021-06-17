package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class LoginPage {

    // Locators
    private final By txtUsername = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.xpath("//input[@value='Login']");
    private final By lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");

    // Elements
    public WebElement getTxtUsername() {
        return Constant.WEBDRIVER.findElement(txtUsername);
    }

    public WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    public WebElement getBtnLogin() {
        return Constant.WEBDRIVER.findElement(btnLogin);
    }

    public WebElement getLblLoginMsg() {
        return Constant.WEBDRIVER.findElement(lblLoginErrorMsg);
    }

    // Methods
    public HomePage login(String username, String password) {
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();

        return new HomePage();
    }

}
