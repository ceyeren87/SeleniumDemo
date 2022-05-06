import org.testng.annotations.Test;

import java.awt.*;

public class AmazonTestTwo extends DeviceSetup {

    @Test(priority = 1)
    public void amazonTestTwo1 () throws InterruptedException, AWTException {
        Login login = new Login(driver);
        TestRepository repository = new TestRepository(driver);

        driver.get(url);
        login.loginCase();
        repository.amazonTestFour();
    }

    @Test(priority = 2)
    //Başarısız senaryo
    public void amazonTestTwo2 () throws InterruptedException, AWTException {
        Login login = new Login(driver);
        TestRepository repository = new TestRepository(driver);

        driver.get(url);
        login.loginCase();
        repository.amazonTestFour();
    }
}
