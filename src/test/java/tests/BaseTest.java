package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public WebDriver driver;

    @BeforeClass
    public void setDriver(){
        driver = new ChromeDriver();
        driver.navigate().to("https://www.demoblaze.com/");
        driver.manage().window().maximize();
    }

    @AfterTest
    public void closeDriver(){
        driver.close();
    }
}
