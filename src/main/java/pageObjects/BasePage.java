package pageObjects;


import common.Driver;
import common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
        return Driver.getDriver().findElement(tabLogin);
    }

    protected WebElement getTabLogout() {
        return Driver.getDriver().findElement(tabLogout);
    }

    protected WebElement getLblWelcomeMessage() {
        return Driver.getDriver().findElement(lblWelcomeMessage);
    }

    protected WebElement getTabRegister() {
        return Driver.getDriver().findElement(tabRegister);
    }

    protected WebElement getTabBookTicket() {
        return Driver.getDriver().findElement(tabBookTicket);
    }

    protected WebElement getTabMyTicket() {
        return Driver.getDriver().findElement(tabMyTicket);
    }

    protected WebElement getTabTicketPrice() {
        return Driver.getDriver().findElement(tabTicketPrice);
    }

    protected WebElement getTabTimetable() {
        return Driver.getDriver().findElement(tabTimetable);
    }

    protected WebElement getTabContact() {
        return Driver.getDriver().findElement(tabContact);
    }

    protected WebElement getTabChangePassword() {
        return Driver.getDriver().findElement(tabChangePassword);
    }

    public WebElement getPageTitle() {
        return Driver.getDriver().findElement(pageTitle);
    }

    // Methods
    public String getWelcomeMessage() {
        return getLblWelcomeMessage().getText();
    }

    public LoginPage gotoLoginPage() {
        getTabLogin().click();
        Utilities.scrollDown();
        return new LoginPage();
    }

    public HomePage gotoLogoutTab() {
        getTabLogout().click();
        return new HomePage();
    }

    public RegisterPage gotoRegisterPage() {
        getTabRegister().click();
        Utilities.scrollDown();
        return new RegisterPage();
    }

    public BookTicketPage gotoBookTicketPage() {
        getTabBookTicket().click();
        Utilities.scrollDown();
        return new BookTicketPage();
    }

    public MyTicketPage gotoMyTicketPage() {
        getTabMyTicket().click();
        Utilities.scrollDown();
        return new MyTicketPage();
    }

    public TrainPriceListPage gotoTicketPricePage() {
        getTabTicketPrice().click();
        return new TrainPriceListPage();
    }

    public TimetablePage gotoTimetablePage() {
        getTabTimetable().click();
        Utilities.scrollDown();
        return new TimetablePage();
    }

    public ContactPage gotoContactPage() {
        getTabContact().click();
        return new ContactPage();
    }

    public ChangePasswordPage gotoChangePasswordPage() {
        getTabChangePassword().click();
        Utilities.scrollDown();
        return new ChangePasswordPage();
    }

    public String getTabSelected() {
        return Driver.getDriver().findElement(tabSelected).getText();
    }

    public boolean checkPageTitle(String pageTitle) {
        String title = getPageTitle().getText();
        return title.equals(pageTitle);
    }

    public boolean checkTabExists(String tabName) {
        try {
            String tab = Driver.getDriver().findElement(By.xpath("//div[@id='menu']//span[text()='"+ tabName +"']")).getText();
            return tab.equals(tabName);
        }
        catch (Exception e) {
            return false;
        }
    }
}
