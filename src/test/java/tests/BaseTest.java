package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

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
}
