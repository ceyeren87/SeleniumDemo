import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class TestRepository extends BasePage {

    Log log = new Log();

    public WebDriverWait wait;

    List<WebElement> ilgilenmiyorum = driver.findElements(By.xpath("//*[@class='a-size-base-plus a-color-base a-text-normal']"));
    private By search = By.id("twotabsearchtextbox");
    private By searchButton = By.id("nav-search-submit-button");
    private By addButon = By.id("add-to-cart-button");
    private By productTitle = By.id("productTitle");
    private By text = By.cssSelector("#search > div.s-desktop-width-max.s-desktop-content.s-opposite-dir.sg-row > div.s-matching-dir.sg-col-16-of-20.sg-col.sg-col-8-of-12.sg-col-12-of-16 > div > span:nth-child(4) > div.s-main-slot.s-result-list.s-search-results.sg-row > div:nth-child(7) > div > div > div > div > div.a-section.a-spacing-small.s-padding-left-small.s-padding-right-small > div.a-section.a-spacing-none.a-spacing-top-small.s-title-instructions-style");
    private By textAmount = By.id("corePrice_feature_div");
    private By textSepetAmount = By.id("sc-subtotal-amount-buybox");
    private By sepet = By.id("attach-sidesheet-view-cart-button");
    private By delete = By.cssSelector("input[name^='submit.delete']");


    public TestRepository(WebDriver driver) {
        super(driver);
    }

    public  void amazonTestOne() throws InterruptedException {

        wait = new WebDriverWait(driver, 35);

        sendKeys(search,"iphone");
        click(searchButton);
        String title = getText(text);
        click(text);
        assertText(productTitle,title);
        log.info("Seçilen Ürün ile Sepete Eklenen Ürün Aynı");
        String amount = getText(textAmount);
        String amonutText = amount.substring(0,Math.min(amount.length(),6));
        click(addButon);
        click(sepet);
        // Site de bug var örnek: 12.230 TL Sepetteki tutar bazen TL12.230 Bazen TL 12.230 olarak geliyor
        String sepetAmount = getText(textSepetAmount);
        String sepetAmountText = sepetAmount.substring(1,Math.min(sepetAmount.length(),7));
        Assert.assertEquals(amonutText,sepetAmountText);
        log.info("Seçilen Ürün ile Sepet Tutarı Aynı");
        click(delete);
    }

    public  void amazonTestTwo() throws InterruptedException {

        wait = new WebDriverWait(driver, 35);

        sendKeys(search,"iphone");
        click(searchButton);
        String title = getText(text);
        click(text);
        assertText(productTitle,title);
        log.info("Seçilen Ürün ile Sepete Eklenen Ürün Aynı");
        String amount = getText(textAmount);
        String amonutText = amount.substring(0,Math.min(amount.length(),6));
        click(addButon);
        click(sepet);
        String sepetAmount = getText(textSepetAmount);
        Assert.assertEquals(amonutText,sepetAmount);
        click(delete);
    }

    public  void amazonTestThree() throws InterruptedException {

        sendKeys(search,"iphone");
        click(searchButton);
    }

    public  void amazonTestFour() throws InterruptedException {

        sendKeys(search,"Samsung");
        click(searchButton);
    }

}
