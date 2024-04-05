package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver= driver;
    }

    private final By signUpButton = By.id("signin2");
    private final By logInButton = By.id("login2");

    public SignUpPage navigateToSignUp(){
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public LogInPage navigateToLogIn(){
        driver.findElement(logInButton).click();
        return new LogInPage(driver);
    }
}
