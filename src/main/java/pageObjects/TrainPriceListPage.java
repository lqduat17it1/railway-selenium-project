package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TrainPriceListPage {

    // Elements
    public WebElement getBtnCheckPrice(String departStation, String arriveStation) {
        return Constant.WEBDRIVER.findElement(By.xpath("//td/li[text()='"+ departStation + " to " + arriveStation +"']/ancestor::tr//a"));
    }

    // Methods
    public TicketPricePage checkPrice(String departStation, String arriveStation) {
        this.getBtnCheckPrice(departStation, arriveStation).click();

        return new TicketPricePage();
    }

}