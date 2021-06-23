package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TicketPricePage {

    // Locators
    private final By txtStation = By.xpath("//th[contains(text(), 'Ticket price')]");

    // Elements
    public WebElement getTxtStation() {
        return Constant.webdriver.get().findElement(txtStation);
    }

    public WebElement getBtnBookTicket(String seatType) {
        return Constant.webdriver.get().findElement(By.xpath("//td[text()='"+ seatType +"']/..//a"));
    }

    // Methods
    public void checkStation(String departStation, String arriveStation) {
        String str = "Ticket price from "+ departStation +" to "+ arriveStation;
        Assert.assertEquals(getTxtStation().getText(), str);
    }

    public BookTicketPage bookTicket(String seatType) {
        getBtnBookTicket(seatType).click();

        return new BookTicketPage();
    }

}
