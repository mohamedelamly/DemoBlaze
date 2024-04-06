package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private final WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver= driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(6000));
    }

    private final By homeButton = By.partialLinkText("Home");
    private final By signUpButton = By.id("signin2");
    private final By logInButton = By.id("login2");
    private final By cartButton = By.partialLinkText("Cart");
    private By productName;
    public static String productPrice;
    private WebElement productNameElement;
    private WebElement productPriceElement;

    WebDriverWait wait;
    // navigate to SignUp page
    public SignUpPage navigateToSignUp(){
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }
    // navigate to Login page
    public LogInPage navigateToLogIn(){
        driver.findElement(logInButton).click();
        return new LogInPage(driver);
    }

    // Take product name as parameter Then navigate to the product page by clicking on it
    public ProductPage navigateToProduct(String productName){
        this.productName =By.partialLinkText(productName);
        wait.until(ExpectedConditions.presenceOfElementLocated(this.productName));
        productNameElement = driver.findElement(this.productName);
        // get product price by get the price element which is below the name using Relative Locator
        productPriceElement = driver.findElement(RelativeLocator.with(By.tagName("h5")).below(this.productName));
        productPrice = productPriceElement.getText();
        productNameElement.click();
        return new ProductPage(driver);
    }
    // navigate to Cart page
    public CartPage navigateToCart(){
        driver.findElement(cartButton).click();
        return new CartPage(driver);
    }
    // navigate to Home page
    public HomePage navigateToHome(){
        driver.findElement(homeButton).click();
        return new HomePage(driver);
    }
}
