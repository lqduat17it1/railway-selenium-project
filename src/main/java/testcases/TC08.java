package testcases;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class TC08 extends BaseTest {

    @Test(description = "TC08 - User can't login with an account hasn't been activated")
    public void TC08() {
        test.log(LogStatus.SKIP,"Can not create an account with not activate");
    }

}
