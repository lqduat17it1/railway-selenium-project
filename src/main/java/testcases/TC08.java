package testcases;

import org.testng.annotations.Test;

public class TC08 extends BaseTest {

    @Test(description = "TC08 - User can't login with an account hasn't been activated")
    public void TC08() {
        test.skip("Can not create an account with not activate");
    }

}
