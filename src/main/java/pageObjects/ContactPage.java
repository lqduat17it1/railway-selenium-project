package pageObjects;

import common.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactPage {

    // Locators
    private final By lblEmail = By.cssSelector(".contact a");

    // Elements
    public WebElement getLblEmail() {
        return Driver.getDriver().findElement(lblEmail);
    }

    // Methods
    public void sendMail() {
        getLblEmail().click();
    }
}
