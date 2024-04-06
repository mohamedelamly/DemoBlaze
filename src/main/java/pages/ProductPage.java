package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private final WebDriver driver;
    Alert alert;
    String alertMessage;
    WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    private final By addToCartButton = By.cssSelector("#tbodyid > div.row > div > a");
    private final By productName = By.xpath("//*[@id=\"tbodyid\"]/h2");
    private final By productPrice = By.xpath("//*[@id=\"tbodyid\"]/h3");

    // get product name from product details page
    public void getProductName(){
        wait.until(ExpectedConditions.presenceOfElementLocated(productName));
        driver.findElement(productName).getText();
    }

    // get product price from product details page
    public String getProductPrice(){
        wait.until(ExpectedConditions.presenceOfElementLocated(productPrice));
        return driver.findElement(productPrice).getText();
    }

    // sff product to the cart and accepting the alert
    public void addProductToCart(){
        wait.until(ExpectedConditions.presenceOfElementLocated(addToCartButton));
        driver.findElement(addToCartButton).click();
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        alertMessage = alert.getText();
        alert.accept();
    }

}
