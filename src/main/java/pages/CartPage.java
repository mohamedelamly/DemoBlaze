package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;
    public CartPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private By productPrice;
    private By productsNumber = By.className("success");
    int productsPrice;
    int productsTotalPrice = 0;
    int cartTotalPrice = 0;
    private By cartPrice = By.id("totalp");
    private final By placeOrderButton = By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button");

    // get the number of products on cart to loop on it then get sum of all products price
    public int getProductsNumber(){
     wait.until(ExpectedConditions.presenceOfElementLocated(productsNumber));
        return driver.findElements(productsNumber).size();
    }

    // get the sum of products price on the cart table using cart size method
    public int getProductsTotalPrice(){
        getProductsNumber();
        for (int i =1; i <= getProductsNumber(); i++){
            productPrice = By.xpath("//*[@id='tbodyid']/tr[" + i + "]/td[3]");
            productsPrice = Integer.parseInt((driver.findElement(productPrice).getText()));
            productsTotalPrice += productsPrice;
        }
        return productsTotalPrice;
    }

    // get the cart total price which will be checkout
    public int getCartTotalPrice(){
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(cartPrice, "")));
        cartTotalPrice += Integer.parseInt(driver.findElement(cartPrice).getText().trim());
        return cartTotalPrice;
    }

    // click on place order button
    public CheckoutPage clickOnPlaceOrder(){
        driver.findElement(placeOrderButton).click();
        return new CheckoutPage(driver);
    }
}
