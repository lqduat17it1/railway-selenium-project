package pageObjects;


import common.Constant;
import common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    // Locators
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By tabRegister = By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");
    private final By tabBookTicket = By.xpath("//div[@id='menu']//span[text()='Book ticket']");
    private final By tabMyTicket = By.xpath("//div[@id='menu']//span[text()='My ticket']");
    private final By tabTicketPrice = By.xpath("//div[@id='menu']//span[text()='Ticket price']");
    private final By tabTimetable = By.xpath("//div[@id='menu']//span[text()='Timetable']");
    private final By tabContact = By.xpath("//div[@id='menu']//span[text()='Contact']");
    private final By tabSelected = By.xpath("//li[@class='selected']//span");
    private final By tabChangePassword = By.xpath("//div[@id='menu']//span[text()='Change password']");
    private final By pageTitle = By.tagName("h1");

    // Element
    protected WebElement getTabLogin() {
        return Constant.webdriver.get().findElement(tabLogin);
    }

    protected WebElement getTabLogout() {
        return Constant.webdriver.get().findElement(tabLogout);
    }

    protected WebElement getLblWelcomeMessage() {
        return Constant.webdriver.get().findElement(lblWelcomeMessage);
    }

    protected WebElement getTabRegister() {
        return Constant.webdriver.get().findElement(tabRegister);
    }

    protected WebElement getTabBookTicket() {
        return Constant.webdriver.get().findElement(tabBookTicket);
    }

    protected WebElement getTabMyTicket() {
        return Constant.webdriver.get().findElement(tabMyTicket);
    }

    protected WebElement getTabTicketPrice() {
        return Constant.webdriver.get().findElement(tabTicketPrice);
    }

    protected WebElement getTabTimetable() {
        return Constant.webdriver.get().findElement(tabTimetable);
    }

    protected WebElement getTabContact() {
        return Constant.webdriver.get().findElement(tabContact);
    }

    protected WebElement getTabChangePassword() {
        return Constant.webdriver.get().findElement(tabChangePassword);
    }

    public WebElement getPageTitle() {
        return Constant.webdriver.get().findElement(pageTitle);
    }

    // Methods
    public String getWelcomeMessage() {
        return getLblWelcomeMessage().getText();
    }

    public LoginPage gotoLoginPage() {
        getTabLogin().click();
        Constant.scrollDown();
        return new LoginPage();
    }

    public HomePage gotoLogoutTab() {
        getTabLogout().click();
        return new HomePage();
    }

    public RegisterPage gotoRegisterPage() {
        getTabRegister().click();
        Constant.scrollDown();
        return new RegisterPage();
    }

    public BookTicketPage gotoBookTicketPage() {
        getTabBookTicket().click();
        Constant.scrollDown();
        return new BookTicketPage();
    }

    public MyTicketPage gotoMyTicketPage() {
        getTabMyTicket().click();
        Constant.scrollDown();
        return new MyTicketPage();
    }

    public TrainPriceListPage gotoTicketPricePage() {
        getTabTicketPrice().click();
        return new TrainPriceListPage();
    }

    public TimetablePage gotoTimetablePage() {
        getTabTimetable().click();
        Constant.scrollDown();
        return new TimetablePage();
    }

    public ContactPage gotoContactPage() {
        getTabContact().click();
        return new ContactPage();
    }

    public ChangePasswordPage gotoChangePasswordPage() {
        getTabChangePassword().click();
        Constant.scrollDown();
        return new ChangePasswordPage();
    }

    public String getTabSelected() {
        return Constant.webdriver.get().findElement(tabSelected).getText();
    }

    public boolean checkPageTitle(String pageTitle) {
        String title = getPageTitle().getText();
        return title.equals(pageTitle);
    }

    public boolean checkTabExists(String tabName) {
        try {
            String tab = Constant.webdriver.get().findElement(By.xpath("//div[@id='menu']//span[text()='"+ tabName +"']")).getText();
            return tab.equals(tabName);
        }
        catch (Exception e) {
            return false;
        }
    }
}
