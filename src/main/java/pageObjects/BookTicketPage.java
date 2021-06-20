package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

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
        getSelectDepartDate().selectByVisibleText(departDate);
        getSelectDepartFrom().selectByVisibleText(departFrom);
        try {
            TimeUnit.SECONDS.sleep(1);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
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
