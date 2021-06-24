package pageObjects;

import common.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SuccessPage {

    // Locators
    private final By lblDepartStation = By.xpath("//table//td[count(//th[text()='Depart Station']/preceding-sibling::th)+1]");
    private final By lblArriveStation = By.xpath("//table//td[count(//th[text()='Arrive Station']/preceding-sibling::th)+1]");
    private final By lblSeatType = By.xpath("//table//td[count(//th[text()='Seat Type']/preceding-sibling::th)+1]");
    private final By lblDepartDate = By.xpath("//table//td[count(//th[text()='Depart Date']/preceding-sibling::th)+1]");
    private final By lblAmount = By.xpath("//table//td[count(//th[text()='Amount']/preceding-sibling::th)+1]");

    // Elements
    public WebElement getLblDepartStation() {
        return Driver.getDriver().findElement(lblDepartStation);
    }

    public WebElement getLblArriveStation() {
        return Driver.getDriver().findElement(lblArriveStation);
    }

    public WebElement getLblSeatType() {
        return Driver.getDriver().findElement(lblSeatType);
    }

    public WebElement getLblDepartDate() {
        return Driver.getDriver().findElement(lblDepartDate);
    }

    public WebElement getLblAmount() {
        return Driver.getDriver().findElement(lblAmount);
    }

    // Methods
    public boolean checkTicket(String departStation, String arriveStation, String seatType, String departDate, String amount) {
        return getLblDepartStation().getText().equals(departStation) && getLblArriveStation().getText().equals(arriveStation) && getLblSeatType().getText().equals(seatType) && getLblDepartDate().getText().equals(departDate) && getLblAmount().getText().equals(amount);

    }

}
