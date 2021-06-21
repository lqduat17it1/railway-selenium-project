package testcases;

import org.testng.annotations.Test;

public class TC08 extends BaseTest {

    @Test(description = "TC08 - User can't login with an account hasn't been activated", testName = "Register")
    public void tc08() {
        skip("Can not create an account with not activate");
    }

}
