package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
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
        return new Select(Constant.webdriver.get().findElement(selectDepartStation));
    }

    public Select getSelectArriveStation() {
        return new Select(Constant.webdriver.get().findElement(selectArriveStation));
    }

    public WebElement getTxtDepartDate() {
        return Constant.webdriver.get().findElement(txtDepartDate);
    }

    public Select getSelectStatus() {
        return new Select(Constant.webdriver.get().findElement(selectStatus));
    }

    public WebElement getBtnApplyFilter() {
        return Constant.webdriver.get().findElement(btnApplyFilter);
    }

    public WebElement getBtnOperation(String departStation, String arriveStation) {
        return Constant.webdriver.get().findElement(By.xpath("//td[text()='"+ departStation +"']/following-sibling::td[text()='"+ arriveStation +"']/../td[count(//th[text()='Operation']/preceding-sibling::th)+1]"));
    }

    public WebElement getTicket(String departStation, String arriveStation, String departDate, String seatType, String amount) {
        return Constant.webdriver.get().findElement(By.xpath("//td[text()='"+ departStation +"']/../td[text()='"+ arriveStation +"']/../td[text()='"+ seatType +"']/../td[text()='"+ departDate +"']/../td[text()='"+ amount +"']"));
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
        WebDriverWait wait = new WebDriverWait(Constant.webdriver.get(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Constant.webdriver.get().switchTo().alert().accept();
    }

}
