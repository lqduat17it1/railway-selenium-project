package pageObjects;

import common.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {

    // Locators
    private final By txtUsername = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.xpath("//input[@value='Login']");
    private final By lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");

    // Elements
    public WebElement getTxtUsername() {
        return Driver.getDriver().findElement(txtUsername);
    }

    public WebElement getTxtPassword() {
        return Driver.getDriver().findElement(txtPassword);
    }

    public WebElement getBtnLogin() {
        return Driver.getDriver().findElement(btnLogin);
    }

    public WebElement getLblLoginMsg() {
        return Driver.getDriver().findElement(lblLoginErrorMsg);
    }

    // Methods
    public HomePage login(String username, String password) {
        getTxtUsername().sendKeys(username);
        getTxtPassword().sendKeys(password);
        getBtnLogin().click();

        return new HomePage();
    }

}
