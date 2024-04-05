package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.Console;
import java.time.Duration;

public class HomePage {

    private final WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver= driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(6000));

    }

    private final By signUpButton = By.id("signin2");
    private final By logInButton = By.id("login2");
    By productName;
    private String productPrice;
    WebElement productNameElement;
    WebElement productPriceElement;

    WebDriverWait wait;

    public SignUpPage navigateToSignUp(){
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public LogInPage navigateToLogIn(){
        driver.findElement(logInButton).click();
        return new LogInPage(driver);
    }

    public ProductPage navigateToProduct(String productName){

        this.productName =By.partialLinkText(productName);

        wait.until(ExpectedConditions.presenceOfElementLocated(this.productName));
        productNameElement = driver.findElement(this.productName);

        productPriceElement = driver.findElement(RelativeLocator.with(By.tagName("h5")).below(this.productName));
        productPrice = productPriceElement.getText();
        productNameElement.click();
        System.out.println(productName +"++++++" + productPrice);
        return new ProductPage(driver);
    }
}
