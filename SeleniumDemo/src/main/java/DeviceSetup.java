import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
public class DeviceSetup {

    public String url = "https://www.amazon.com.tr/";

    public static String newDate(){
        return new SimpleDateFormat("MMM dd HH.mm.ss").format(Calendar.getInstance().getTime());
    }

    public WebDriver driver;
    public WebDriverWait wait;

    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser) throws MalformedURLException {

        if(browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            //System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(200,TimeUnit.SECONDS);
        }else if(browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            //System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
            driver = new FirefoxDriver();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(200,TimeUnit.SECONDS);
        }else if(browser.equals("grid-chrome")){
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("start-maximized");
            driver = new RemoteWebDriver(new URL("http://172.22.118.64:4444/wd/hub"), chromeOptions);
            driver.manage().timeouts().pageLoadTimeout(200,TimeUnit.SECONDS);
        }else if(browser.equals("grid-firefox")){
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("start-maximized");
            driver = new RemoteWebDriver(new URL("http://172.22.118.64:4444/wd/hub"), firefoxOptions);
            driver.manage().timeouts().pageLoadTimeout(200,TimeUnit.SECONDS);
        }
    }


    @AfterMethod
    public void quit(ITestResult result) throws IOException {

        if(ITestResult.FAILURE==result.getStatus()){

            TakesScreenshot ts = (TakesScreenshot)driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source,new File("./Screenshots/"+result.getMethod().getMethodName()+"-"+ newDate() +".png"));
            driver.manage().deleteAllCookies();
            driver.quit();

        }else{
            driver.manage().deleteAllCookies();
            driver.quit();
        }

    }






}
