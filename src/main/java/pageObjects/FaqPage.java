package pageObjects;

import common.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FaqPage {

    // Locators
    private final By linkCreateAnAccount = By.xpath("//div[@id='content']//a[contains(@href, 'Register')]");
    private final By linkBookTicketPage = By.xpath("//div[@id='content']//a[contains(@href, 'BookTicketPage')]");

    // Elements
    public WebElement getLinkCreateAnAccount() {
        return Driver.getDriver().findElement(linkCreateAnAccount);
    }

    public WebElement getLinkBookTicketPage() {
        return Driver.getDriver().findElement(linkBookTicketPage);
    }

}
