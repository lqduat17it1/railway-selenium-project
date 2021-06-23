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
        return Constant.webdriver.get().findElement(txtUsername);
    }

    public WebElement getTxtPassword() {
        return Constant.webdriver.get().findElement(txtPassword);
    }

    public WebElement getBtnLogin() {
        return Constant.webdriver.get().findElement(btnLogin);
    }

    public WebElement getLblLoginMsg() {
        return Constant.webdriver.get().findElement(lblLoginErrorMsg);
    }

    // Methods
    public HomePage login(String username, String password) {
        getTxtUsername().sendKeys(username);
        getTxtPassword().sendKeys(password);
        getBtnLogin().click();

        return new HomePage();
    }

}
