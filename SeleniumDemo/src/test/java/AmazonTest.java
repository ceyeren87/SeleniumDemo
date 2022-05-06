
import org.testng.annotations.Test;
import java.awt.*;



public class AmazonTest extends DeviceSetup{


    @Test(priority = 1)
    public void amazonTest () throws InterruptedException, AWTException {
        Login login = new Login(driver);
        TestRepository repository = new TestRepository(driver);

        driver.get(url);
        login.loginCase();
        repository.amazonTestThree();
    }

    @Test(priority = 2)
    //Başarısız senaryo
    public void amazonTestTwo () throws InterruptedException, AWTException {
        Login login = new Login(driver);
        TestRepository repository = new TestRepository(driver);

        driver.get(url);
        login.loginCase();
        repository.amazonTestThree();
    }
}
