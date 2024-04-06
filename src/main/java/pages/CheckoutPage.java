package pages;

import net.datafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Year;
import java.time.YearMonth;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

public class CheckoutPage {
    WebDriver driver;
    WebDriverWait wait;
    Faker randomString;
    public String userName, userCardNumber;
    private final By checkoutTotalPrice = By.id("totalm");
    private final By checkoutName = By.id("name");
    private final By checkoutCountry = By.id("country");
    private final By checkoutCity = By.id("city");
    private final By checkoutCard = By.id("card");
    private final By checkoutMonth = By.id("month");
    private final By checkoutYear = By.id("year");
    private final By purchaseButton = By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]");
    private final By resultData = By.xpath("/html/body/div[10]/p");
    private final By okButton = By.xpath("/html/body/div[10]/div[7]/div/button");
    private final By successfulMessage = By.xpath("/html/body/div[10]/h2");

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        randomString = new Faker();
    }
    // add the name into checkout form
    public void addCheckoutName(){
        userName = randomString.funnyName().name();
        wait.until(ExpectedConditions.elementToBeClickable(checkoutName));
        driver.findElement(checkoutName).sendKeys(userName);
    }
    // add the country into checkout form
    public void addCheckoutCountry(){
        driver.findElement(checkoutCountry).sendKeys(randomString.country().name());
    }
    // add the city into checkout form
    public void addCheckoutCity(){
        driver.findElement(checkoutCity).sendKeys(randomString.address().cityName());
    }
    // add the card into checkout form
    public void addCheckoutCard(){
        userCardNumber = randomString.finance().creditCard();
        driver.findElement(checkoutCard).sendKeys(userCardNumber);
    }
    // add the month into checkout form
    public void addCheckoutMonth(){
        driver.findElement(checkoutMonth).sendKeys(YearMonth.now().getMonth().toString());
    }
    // add the year into checkout form
    public void addCheckoutYear(){
        driver.findElement(checkoutYear).sendKeys(Year.now().toString());
    }

    public void fillFormData(){
        addCheckoutName();
        addCheckoutCountry();
        addCheckoutCity();
        addCheckoutCard();
        addCheckoutMonth();
        addCheckoutYear();
        driver.findElement(purchaseButton).click();
    }
    public String getResultData(){
        return driver.findElement(resultData).getText();
    }
    public void confirmMessage(){
        wait.until(ExpectedConditions.and(
                ExpectedConditions.presenceOfElementLocated(successfulMessage),
                ExpectedConditions.elementToBeClickable(okButton)
        ));

        driver.findElement(okButton).click();
    }
    public String getTotalPrice(){
        return driver.findElement(checkoutTotalPrice).getText();
    }
}
