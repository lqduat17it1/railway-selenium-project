package pageObjects;

import common.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimetablePage {

    // Elements
    public WebElement getBtnCheckPrice(String departStation, String arriveStation) {
        return Driver.getDriver().findElement(By.xpath("//td[text()='"+ departStation +"']/following-sibling::td[text()='"+ arriveStation +"']/../td[count(//th[text()='Check Price']/preceding-sibling::th)+1]"));
    }

    public WebElement getBtnBookTicket(String departStation, String arriveStation) {
        return Driver.getDriver().findElement(By.xpath("//td[text()='"+ departStation +"']/following-sibling::td[text()='"+ arriveStation +"']/../td[count(//th[text()='Book ticket']/preceding-sibling::th)+1]"));
    }

    // Methods
    public TicketPricePage clickCheckPrice(String departStation, String arriveStation) {
        getBtnCheckPrice(departStation, arriveStation).click();

        return new TicketPricePage();   
    }

    public BookTicketPage clickBookTicket(String departStation, String arriveStation) {
        getBtnBookTicket(departStation, arriveStation).click();

        return new BookTicketPage();
    }

}
