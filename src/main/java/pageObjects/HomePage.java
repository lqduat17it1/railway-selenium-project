package pageObjects;

import common.Driver;
import dataObjects.DataTestSet1;

public class HomePage extends BasePage {

    public HomePage open() {
        Driver.getDriver().navigate().to(DataTestSet1.RAILWAY_URL);
        return this;
    }
}
