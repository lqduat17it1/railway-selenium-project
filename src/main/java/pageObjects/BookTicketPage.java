package pageObjects;

import common.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BookTicketPage {

    // Locators
    private final By selectDepartDate = By.name("Date");
    private final By selectDepartFrom = By.name("DepartStation");
    private final By selectArriveAt = By.name("ArriveStation");
    private final By selectSeatType = By.name("SeatType");
    private final By selectTicketAmount = By.name("TicketAmount");
    private final By btnBookTicket = By.xpath("//input[@value='Book ticket']");
    private final By pageTitle = By.tagName("h1");

    // Elements
    public Select getSelectDepartDate() {
        return new Select(Driver.getDriver().findElement(selectDepartDate));
    }

    public Select getSelectDepartFrom() {
        return new Select(Driver.getDriver().findElement(selectDepartFrom));
    }

    public Select getSelectArriveAt() {
        return new Select(Driver.getDriver().findElement(selectArriveAt));
    }

    public Select getSelectSeatType() {
        return new Select(Driver.getDriver().findElement(selectSeatType));
    }

    public Select getSelectTicketAmount() {
        return new Select(Driver.getDriver().findElement(selectTicketAmount));
    }

    public WebElement getBtnBookTicket() {
        return Driver.getDriver().findElement(btnBookTicket);
    }

    public WebElement getPageTitle() {
        return Driver.getDriver().findElement(pageTitle);
    }

    // Methods
    public SuccessPage bookTicket(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) {
        Driver.wait.until(ExpectedConditions.textToBePresentInElement(getPageTitle(), "Book ticket"));
        getSelectDepartDate().selectByVisibleText(departDate);
        getSelectDepartFrom().selectByVisibleText(departFrom);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        if (!departFrom.equals("Sài Gòn"))
            wait.until(ExpectedConditions.textToBePresentInElementLocated(selectArriveAt, "Sài Gòn"));
        else
            wait.until(ExpectedConditions.textToBePresentInElementLocated(selectArriveAt, "Phan Thiết"));
        getSelectArriveAt().selectByVisibleText(arriveAt);
        getSelectSeatType().selectByVisibleText(seatType);
        getSelectTicketAmount().selectByVisibleText(ticketAmount);
        getBtnBookTicket().click();

        return new SuccessPage();
    }

    public void checkStation(String departFrom, String arriveAt) {
        Assert.assertEquals(getSelectDepartFrom().getFirstSelectedOption().getText(), departFrom);
        Assert.assertEquals(getSelectArriveAt().getFirstSelectedOption().getText(), arriveAt);
    }

}
