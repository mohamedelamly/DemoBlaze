package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CheckoutPage;

public class CheckoutTest extends CartTest{
    CheckoutPage checkoutPage;
    boolean pricePaid;
    int expectedTotal;
    @BeforeClass
    public void clickOnPlaceOrder(){
        checkoutPage = cartPage.clickOnPlaceOrder();
        checkoutPage.fillFormData();
        expectedTotal = Integer.parseInt(checkoutPage.getTotalPrice().replace("Total: ","").trim());
        pricePaid = checkoutPage.getResultData().contains("Amount: " + expectedTotal + " USD");
    }
    @Test
    public void completeOrderCheckout(){
        Assert.assertTrue(pricePaid);
    }
    @AfterClass
    public void confirmMessgae(){
        checkoutPage.confirmMessage();
        System.out.println("Test finished successfully");
    }
}
