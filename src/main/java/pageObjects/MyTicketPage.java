package pageObjects;

import common.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyTicketPage {

    // Locators
    private final By selectDepartStation = By.name("FilterDpStation");
    private final By selectArriveStation = By.name("FilterArStation");
    private final By txtDepartDate = By.name("FilterDpDate");
    private final By selectStatus = By.name("FilterStatus");
    private final By btnApplyFilter = By.xpath("//input[@value='Apply Filter']");

    // Elements
    public Select getSelectDepartStation() {
        return new Select(Driver.getDriver().findElement(selectDepartStation));
    }

    public Select getSelectArriveStation() {
        return new Select(Driver.getDriver().findElement(selectArriveStation));
    }

    public WebElement getTxtDepartDate() {
        return Driver.getDriver().findElement(txtDepartDate);
    }

    public Select getSelectStatus() {
        return new Select(Driver.getDriver().findElement(selectStatus));
    }

    public WebElement getBtnApplyFilter() {
        return Driver.getDriver().findElement(btnApplyFilter);
    }

    public WebElement getBtnOperation(String departStation, String arriveStation) {
        return Driver.getDriver().findElement(By.xpath("//td[text()='"+ departStation +"']/following-sibling::td[text()='"+ arriveStation +"']/../td[count(//th[text()='Operation']/preceding-sibling::th)+1]"));
    }

    public WebElement getTicket(String departStation, String arriveStation, String departDate, String seatType, String amount) {
        return Driver.getDriver().findElement(By.xpath("//td[text()='"+ departStation +"']/../td[text()='"+ arriveStation +"']/../td[text()='"+ seatType +"']/../td[text()='"+ departDate +"']/../td[text()='"+ amount +"']"));
    }

    // Methods
    public void filters() {
        getBtnApplyFilter().click();
    }

    public void filters(String departStation, String arriveStation, String departDate, String status) {
        getSelectDepartStation().selectByVisibleText(departStation);
        getSelectArriveStation().selectByVisibleText(arriveStation);
        getTxtDepartDate().sendKeys(departDate);
        getSelectStatus().selectByVisibleText(status);
        getBtnApplyFilter().click();
    }

    public boolean checkTicketExists(String departStation, String arriveStation, String seatType, String departDate, String amount) {
        try {
            return getTicket(departStation, arriveStation, seatType, departDate, amount).isDisplayed();
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }


    public void deleteTicket(String departStation, String arriveStation) {
        getBtnOperation(departStation, arriveStation).click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Driver.getDriver().switchTo().alert().accept();
    }

}
