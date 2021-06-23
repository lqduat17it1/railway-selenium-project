package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactPage {

    // Locators
    private final By lblEmail = By.cssSelector(".contact a");

    // Elements
    public WebElement getLblEmail() {
        return Constant.webdriver.get().findElement(lblEmail);
    }

    // Methods
    public void sendMail() {
        getLblEmail().click();
    }
}
