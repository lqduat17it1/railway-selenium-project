package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class MyTicketPage {

    // Locators
    private final By selectDepartStation = By.name("FilterDpStation");
    private final By selectArriveStation = By.name("FilterArStation");
    private final By txtDepartDate = By.name("FilterDpDate");
    private final By selectStatus = By.name("FilterStatus");
    private final By btnApplyFilter = By.xpath("//input[@value='Apply Filter']");

    // Elements
    public Select getSelectDepartStation() {
        return new Select(Constant.WEBDRIVER.findElement(selectDepartStation));
    }

    public Select getSelectArriveStation() {
        return new Select(Constant.WEBDRIVER.findElement(selectArriveStation));
    }

    public WebElement getTxtDepartDate() {
        return Constant.WEBDRIVER.findElement(txtDepartDate);
    }

    public Select getSelectStatus() {
        return new Select(Constant.WEBDRIVER.findElement(selectStatus));
    }

    public WebElement getBtnApplyFilter() {
        return Constant.WEBDRIVER.findElement(btnApplyFilter);
    }

    public WebElement getBtnOperation(String departStation, String arriveStation) {
        return Constant.WEBDRIVER.findElement(By.xpath("//td[text()='"+ departStation +"']/following-sibling::td[text()='"+ arriveStation +"']/../td[count(//th[text()='Operation']/preceding-sibling::th)+1]"));
    }

    public WebElement getTicket(String departStation, String arriveStation, String departDate, String seatType, String amount) {
        return Constant.WEBDRIVER.findElement(By.xpath("//td[text()='"+ departStation +"']/../td[text()='"+ arriveStation +"']/../td[text()='"+ seatType +"']/../td[text()='"+ departDate +"']/../td[text()='"+ amount +"']"));
    }

    // Methods
    public void filters() {
        this.getBtnApplyFilter().click();
    }

    public void filters(String departStation, String arriveStation, String departDate, String status) {
        this.getSelectDepartStation().selectByVisibleText(departStation);
        this.getSelectArriveStation().selectByVisibleText(arriveStation);
        this.getTxtDepartDate().sendKeys(departDate);
        this.getSelectStatus().selectByVisibleText(status);
        this.getBtnApplyFilter().click();
    }

    public void checkTicketExists(String departStation, String arriveStation, String seatType, String departDate, String amount) {
        boolean rs = this.getTicket(departStation, arriveStation, seatType, departDate, amount).isDisplayed();
        Assert.assertTrue(rs);
    }

    public void checkTicketNotExists(String departStation, String arriveStation, String seatType, String departDate, String amount) {
        try {
            TimeUnit.SECONDS.sleep(1);
            boolean rs = this.getTicket(departStation, arriveStation, seatType, departDate, amount).isDisplayed();
            Assert.assertFalse(rs);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteTicket(String departStation, String arriveStation) {
        this.getBtnOperation(departStation, arriveStation).click();
        Constant.WEBDRIVER.switchTo().alert().accept();
    }

}
