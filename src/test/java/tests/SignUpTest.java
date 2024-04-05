package tests;

import data.SignUpData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignUpPage;

import java.util.List;

public class SignUpTest extends BaseTest{
    HomePage homePage;
    SignUpPage signUpPage;
    List<String[]> userData;
    String expectedSuccessfulMessage = "Sign up successful.";
    String signUpMessge;

    @BeforeClass
    public void navigateToSignUpPage(){
        homePage = new HomePage(driver);
        homePage.navigateToSignUp();
        signUpPage = new SignUpPage(driver);
        userData = SignUpData.readUserDataFromCSV("signupdata.csv");
    }
    @Test(priority = 1, dataProvider = "userData")
    public void signUpWithValidData(String userName, String password) {
        signUpMessge = signUpPage.signUpUserData(userName,password);
        Assert.assertEquals(signUpMessge,expectedSuccessfulMessage);
    }

    @DataProvider(name = "userData")
    public Object[][] userDataProvider() {

        // Convert List<String[]> to Object[][]
        Object[][] data = new Object[userData.size()][2];
        for (int i = 0; i < userData.size(); i++) {
            String[] row = userData.get(i);
            data[i][0] = row[0]; // username
            data[i][1] = row[1]; // password
        }
        return data;
    }
}
