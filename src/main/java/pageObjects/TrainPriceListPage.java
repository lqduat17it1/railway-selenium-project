package pageObjects;

import common.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TrainPriceListPage {

    // Elements
    public WebElement getBtnCheckPrice(String departStation, String arriveStation) {
        return Driver.getDriver().findElement(By.xpath("//td/li[text()='"+ departStation + " to " + arriveStation +"']/ancestor::tr//a"));
    }

    // Methods
    public TicketPricePage checkPrice(String departStation, String arriveStation) {
        getBtnCheckPrice(departStation, arriveStation).click();

        return new TicketPricePage();
    }

}
