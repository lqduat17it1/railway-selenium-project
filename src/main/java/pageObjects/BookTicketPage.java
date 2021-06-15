package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BookTicketPage {

    // Locators
    private final By selectDepartDate = By.name("Date");
    private final By selectDepartFrom = By.name("DepartStation");
    private final By selectArriveAt = By.name("ArriveStation");
    private final By selectSeatType = By.name("SeatType");
    private final By selectTicketAmount = By.name("TicketAmount");
    private final By btnBookTicket = By.xpath("//input[@value='Book ticket']");

    // Elements
    public Select getSelectDepartDate() {
        return new Select(Constant.WEBDRIVER.findElement(selectDepartDate));
    }

    public Select getSelectDepartFrom() {
        return new Select(Constant.WEBDRIVER.findElement(selectDepartFrom));
    }

    public Select getSelectArriveAt() {
        return new Select(Constant.WEBDRIVER.findElement(selectArriveAt));
    }

    public Select getSelectSeatType() {
        return new Select(Constant.WEBDRIVER.findElement(selectSeatType));
    }

    public Select getSelectTicketAmount() {
        return new Select(Constant.WEBDRIVER.findElement(selectTicketAmount));
    }

    public WebElement getBtnBookTicket() {
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }

    // Methods
    public SuccessPage bookTicket(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) {
        this.getSelectDepartDate().selectByVisibleText(departDate);
        this.getSelectDepartFrom().selectByVisibleText(departFrom);
        this.getSelectArriveAt().selectByVisibleText(arriveAt);
        this.getSelectSeatType().selectByVisibleText(seatType);
        this.getSelectTicketAmount().selectByVisibleText(ticketAmount);
        this.getBtnBookTicket().click();

        return new SuccessPage();
    }

    public void checkStation(String departFrom, String arriveAt) {
        Assert.assertEquals(this.getSelectDepartFrom().getFirstSelectedOption().getText(), departFrom);
        Assert.assertEquals(this.getSelectArriveAt().getFirstSelectedOption().getText(), arriveAt);
    }

}
