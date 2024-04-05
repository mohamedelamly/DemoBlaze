package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private final WebDriver driver;
    Alert alert;
    String alertMessage;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By addToCartButton = By.partialLinkText("Add to cart");
    private final By productName = By.xpath("//*[@id=\"tbodyid\"]/h2");
    private final By productPrice = By.xpath("//*[@id=\"tbodyid\"]/h3");

    public void getProductName(){
        driver.findElement(productName).getText();
    }

    public void getProductPrice(){
        driver.findElement(productPrice).getText();
    }

    public void addProductToCart(){
        driver.findElement(addToCartButton).click();
         alert = driver.switchTo().alert();
         alertMessage = alert.getText();
         alert.accept();
    }

}
