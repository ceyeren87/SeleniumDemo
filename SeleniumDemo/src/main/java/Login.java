import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Login extends BasePage {

    String user = "ceyhun.eren@ogr.sakarya.edu.tr";
    String password = "123456";


    private By signin = By.xpath("//*[@id=\"nav-signin-tooltip\"]/a/span");
    private By email = By.id("ap_email");
    private By devamEt = By.id("continue");
    private By sifre = By.id("ap_password");
    private By signinSubmit = By.id("signInSubmit");


    public Login(WebDriver driver) {
        super(driver);
    }

    public void loginCase() throws InterruptedException, AWTException {

        click(signin);
        sendKeys(email,user);
        click(devamEt);
        sendKeys(sifre,password);
        click(signinSubmit);

    }
}
