package tests;

import browserActions.BrowserActions;
import driverfactory.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginSignUpPage;
import pages.RegistrationPage;
import pages.RegistrationSuccessPage;
import utilities.ScreenShotManager;

public class ErrorMessageTest {
    public Driver driver;
    public BrowserActions browser;
//    HomePage homePage;
//    LoginSignUpPage loginSignUpPage;
//    RegistrationPage registrationPage;
//    RegistrationSuccessPage successPage;

    @BeforeClass
    public void setup() {
        driver = new Driver("CHROME");
        driver.get().manage().window().maximize();
        driver.browser().navigateToURL("https://automationexercise.com/\"");

//        driver.get().navigate().to("https://automationexercise.com/");
    }

    @Test(priority = 1)
    public void userCanRegisterSuccessfully() {
//        loginSignUpPage = new LoginSignUpPage(driver);
//        registrationPage = new RegistrationPage(driver);
//        successPage = new RegistrationSuccessPage(driver);
        new HomePage(driver)
                .checkThatUserShouldBeNavigatedToHomePageSuccessfully()
                .clickOnLoginLink()
                .checkThatUserIsNavigatedToLoginSignUpPage()
                .fillSignUpNamed("Mariam")
                .fillSignUpEmail("TEST4513009mmn2@gmail.com")
                .clickOnSignUpButton()
                .checkThatRegistrationPageIsLoadedSuccessfully()
                .fillInRegistrationPage()
                .clickOnCreateAccountButton()
                .checkThatSuccessMessageShouldDisplayed();
    }


    @Test(dependsOnMethods = "userCanRegisterSuccessfully", priority = 2)
    public void userCanLogoutSuccessfully() {
        driver.get().navigate().to("https://automationexercise.com/");

        new HomePage(driver)
                .clickOnLogoutLink()
                .checkThatUserIsNavigatedToLoginSignUpPage();
    }

    @Test(dependsOnMethods = "userCanLogoutSuccessfully", priority = 3)
    public void userEnterExistEmail() {
        driver.get().navigate().to("https://automationexercise.com/login");
        new LoginSignUpPage(driver)
                .fillSignUpNamed("Mariam")
                .fillSignUpEmail("TEST4513009mmn2@gmail.com")
                .clickOnSignUpButton();

        new LoginSignUpPage(driver)
                .checkThatErrorMessageDisplayedWhenEnterExistEmail();
    }

    @AfterClass
    public void tearDown() {

        driver.browser().deleteAllCookies();
        driver.browser().quit();

//        driver.get().manage().deleteAllCookies();
//        driver.quit();
    }
}
