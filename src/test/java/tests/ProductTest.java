package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;

public class ProductTest extends BaseTest{
    HomePage homePage;
    ProductPage productPage;

    @BeforeClass
    public void navigateToProductPage(){
        homePage = new HomePage(driver);
        homePage.navigateToProduct("Nokia lumia");
        productPage = new ProductPage(driver);
    }

    @Test
    public void test(){
        Assert.assertEquals("","");
    }
}
