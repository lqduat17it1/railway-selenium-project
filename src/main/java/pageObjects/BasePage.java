package pageObjects;


import common.Constant;
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

    protected WebElement getTabChangePassword() {
        return Constant.WEBDRIVER.findElement(tabChangePassword);
    }

    // Methods
    public String getWelcomeMessage() {
        return getLblWelcomeMessage().getText();
    }

    public LoginPage gotoLoginPage() {
        getTabLogin().click();
        Constant.js.executeScript("window.scrollBy(0,2000)");
        return new LoginPage();
    }

    public HomePage gotoLogoutTab() {
        getTabLogout().click();
        return new HomePage();
    }

    public RegisterPage gotoRegisterPage() {
        getTabRegister().click();
        Constant.js.executeScript("window.scrollBy(0,2000)");
        return new RegisterPage();
    }

    public BookTicketPage gotoBookTicketPage() {
        getTabBookTicket().click();
        Constant.js.executeScript("window.scrollBy(0,2000)");
        return new BookTicketPage();
    }

    public MyTicketPage gotoMyTicketPage() {
        getTabMyTicket().click();
        Constant.js.executeScript("window.scrollBy(0,2000)");
        return new MyTicketPage();
    }

    public TrainPriceListPage gotoTicketPricePage() {
        getTabTicketPrice().click();
        return new TrainPriceListPage();
    }

    public TimetablePage gotoTimetablePage() {
        getTabTimetable().click();
        Constant.js.executeScript("window.scrollBy(0,2000)");
        return new TimetablePage();
    }

    public ContactPage gotoContactPage() {
        getTabContact().click();
        return new ContactPage();
    }

    public ChangePasswordPage gotoChangePasswordPage() {
        getTabChangePassword().click();
        Constant.js.executeScript("window.scrollBy(0,2000)");
        return new ChangePasswordPage();
    }

    public String getTabSelected() {
        return Constant.WEBDRIVER.findElement(tabSelected).getText();
    }

    public boolean checkTabExists(String tabName) {
        try {
            String tab = Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//span[text()='"+ tabName +"']")).getText();
            return tab.equals(tabName);
        }
        catch (Exception e) {
            return false;
        }
    }
}
