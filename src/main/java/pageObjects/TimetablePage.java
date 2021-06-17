package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimetablePage {

    // Elements
    public WebElement getBtnCheckPrice(String departStation, String arriveStation) {
        return Constant.WEBDRIVER.findElement(By.xpath("//td[text()='"+ departStation +"']/following-sibling::td[text()='"+ arriveStation +"']/../td[count(//th[text()='Check Price']/preceding-sibling::th)+1]"));
    }

    public WebElement getBtnBookTicket(String departStation, String arriveStation) {
        return Constant.WEBDRIVER.findElement(By.xpath("//td[text()='"+ departStation +"']/following-sibling::td[text()='"+ arriveStation +"']/../td[count(//th[text()='Book ticket']/preceding-sibling::th)+1]"));
    }

    // Methods
    public TicketPricePage checkPrice(String departStation, String arriveStation) {
        this.getBtnCheckPrice(departStation, arriveStation).click();

        return new TicketPricePage();   
    }

    public BookTicketPage bookTicket(String departStation, String arriveStation) {
        this.getBtnBookTicket(departStation, arriveStation).click();

        return new BookTicketPage();
    }

}