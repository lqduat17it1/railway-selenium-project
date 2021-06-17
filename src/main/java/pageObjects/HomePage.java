package pageObjects;

import common.Constant;

public class HomePage extends BasePage {

    public HomePage open() {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
        return this;
    }
}
