package pages;

import driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class LoginSignUpPage {
    //    public WebDriver driver;
    public Driver driver;
    By loginEmail = By.xpath("//input[@data-qa=\"login-email\"]");
    By loginPassword = By.name("password");
    By loginButton = By.xpath("//button[@data-qa=\"login-button\"]");
    By signUpFormTitle = By.xpath("(//h2)[3]");
    By signupName = By.name("name");
    By SignupEmail = By.xpath("//input[@data-qa=\"signup-email\"]");
    By signUpButton = By.xpath("//button[@data-qa=\"signup-button\"]");
    By errorMessage = By.xpath("//p[@style=\"color: red;\"]");

    public LoginSignUpPage(Driver driver) {
        this.driver = driver;
    }

    /***************************************Assertions******************************************/

    public LoginSignUpPage checkThatUserIsNavigatedToLoginSignUpPage() {
//        Assert.assertTrue(driver.get().getCurrentUrl().contains("/login"));
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/login"));
        Assert.assertEquals(driver.element().getTextOf(signUpFormTitle), "New User Signup!");
        return this;
    }

    public LoginSignUpPage checkThatErrorMessageDisplayedWhenEnterExistEmail() {
        Assert.assertEquals(driver.element().getTextOf(errorMessage), "Email Address already exist!");
        return this;
    }


    /***************************************Actions******************************************/
    public LoginSignUpPage fillInLoginEmail(String email) {
        driver.element().fillFiled(loginEmail, email);
        return this;
    }

    public LoginSignUpPage fillLoginPassword(String password) {
        driver.element().fillFiled(loginPassword, password);
        return this;
    }

    public HomePage clickOnLoginButton() {
        driver.element().click(loginButton);
        return new HomePage(driver);
    }

    public LoginSignUpPage fillSignUpNamed(String name) {
        driver.element().fillFiled(signupName,name);
        return this;
    }

    public LoginSignUpPage fillSignUpEmail(String email) {
        driver.element().fillFiled(SignupEmail, email);
        return this;
    }

    public RegistrationPage clickOnSignUpButton() {
        driver.element().click(signUpButton);
        return new RegistrationPage(driver);
    }


}
