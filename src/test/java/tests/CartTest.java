package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

public class CartTest extends BaseTest{

    HomePage homePage;
    CartPage cartPage;
    ProductPage productPage;
    int productsPrice ;
    int cartPrice ;
    String[] products = {"Samsung", "Nokia"};

    @BeforeClass()
    public void navigateToCartPage(){
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        // call add productsToCart method to add products to cart before test cart
        addProductsToCart(products);
        //Navigate To cart after adding products to it
        cartPage= homePage.navigateToCart();
        // get cart total price from cart page
        cartPrice = cartPage.getCartTotalPrice();
        // get products sum price from products table in cart page
        productsPrice = cartPage.getProductsTotalPrice();

    }

    // Method to take the products names to add it to cart
    public void addProductsToCart(String[] products){
        for(String productsNames: products) {
            productPage = homePage.navigateToProduct(productsNames);
            productPage.addProductToCart();
            homePage = homePage.navigateToHome();
        }
    }

    @Test
    // Validate products sum price is matching with cart total price
    public void validateTotalPrice(){
        Assert.assertEquals(cartPrice, productsPrice);
    }
}
