package tests;

import data.ProductsNamesData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class BaseTest {
    public WebDriver driver;
    public String siteURL = "https://www.demoblaze.com/index.html";

    @BeforeClass
    public void setDriver(){
        driver = new ChromeDriver();
        driver.navigate().to(siteURL);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void closeDriver(){
        driver.close();
    }

    public String[] getProductsNames() {
        List<String> productNames = ProductsNamesData.readProductNamesFromCSV("productsdata.csv");
        // Convert List<String> to String[]
        String[] dataArray = new String[productNames.size()];
        for (int i = 0; i < productNames.size(); i++) {
            dataArray[i] = productNames.get(i);
        }
        return dataArray;
    }

}
