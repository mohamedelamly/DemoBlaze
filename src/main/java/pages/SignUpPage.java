package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SignUpPage {
    private final WebDriver driver;
    WebDriverWait wait;
    WebElement userNameElement;
    WebElement passwordElement;
    String alertMessage;
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    private final By userNameInput = By.id("sign-username");
    private final By passwordInput = By.id("sign-password");
    private final By signUpButton = By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]");

    //Method to enter username text by taking it as parameter
    public void enterUserNameInput(String userName){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(userNameInput)));
        userNameElement= driver.findElement(userNameInput);
        userNameElement.clear();
        userNameElement.sendKeys(userName);
    }
    //Method to enter password text by taking it as parameter
    public void enterPasswordInput(String password){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(passwordInput)));
        passwordElement= driver.findElement(passwordInput);
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }
    //Method to fill data then click on Sign Up and accepting the alert
    public String signUpUserData(String userName, String password){

        enterUserNameInput(userName);
        enterPasswordInput(password);
        driver.findElement(signUpButton).click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alertMessage= alert.getText();
        alert.accept();
        return alertMessage;
    }
}
