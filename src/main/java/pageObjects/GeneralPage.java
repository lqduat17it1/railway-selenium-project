package pageObjects;


import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {

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

    // Element
    protected WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    protected WebElement getTabLogout() {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    protected WebElement getLblWelcomeMessage() {
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }

    protected WebElement getTabRegister() {
        return Constant.WEBDRIVER.findElement(tabRegister);
    }

    protected WebElement getTabBookTicket() {
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }

    protected WebElement getTabMyTicket() {
        return Constant.WEBDRIVER.findElement(tabMyTicket);
    }

    protected WebElement getTabTicketPrice() {
        return Constant.WEBDRIVER.findElement(tabTicketPrice);
    }

    protected WebElement getTabTimetable() {
        return Constant.WEBDRIVER.findElement(tabTimetable);
    }

    protected WebElement getTabContact() {
        return Constant.WEBDRIVER.findElement(tabContact);
    }

    // Methods
    public String getWelcomeMessage() {
        return this.getLblWelcomeMessage().getText();
    }

    public LoginPage gotoLoginPage() {
        this.getTabLogin().click();
        return new LoginPage();
    }

    public RegisterPage gotoRegisterPage() {
        this.getTabRegister().click();
        return new RegisterPage();
    }

    public BookTicketPage gotoBookTicketPage() {
        this.getTabBookTicket().click();
        return new BookTicketPage();
    }

    public MyTicketPage gotoMyTicketPage() {
        this.getTabMyTicket().click();
        return new MyTicketPage();
    }

    public TrainPriceListPage gotoTicketPricePage() {
        this.getTabTicketPrice().click();
        return new TrainPriceListPage();
    }

    public TimetablePage gotoTimetablePage() {
        this.getTabTimetable().click();
        return new TimetablePage();
    }

    public ContactPage gotoContactPage() {
        this.getTabContact().click();
        return new ContactPage();
    }

}
