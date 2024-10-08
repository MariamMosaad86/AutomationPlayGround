package tests;

import browserActions.BrowserActions;
import driverfactory.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.*;
import utilities.ScreenShotManager;

import java.time.Duration;

public class NewTest {

    public Driver driver;

    WebDriverWait wait;
    //    LoginSignUpPage loginSignUpPage;
//    RegistrationPage registrationPage;
//    RegistrationSuccessPage successPage;
//    AccountSuccessfullyDeletion deleteAccount;
//    AccountSuccessfullyDeletion deleteAccount;

//    LoginSignUpPage loginSignUpPage;
//    RegistrationSuccessPage successPage;
//    HomePage homePage;
//    RegistrationPage registrationPage;
//    AccountSuccessfullyDeletion deleteAccount;


    @BeforeClass
    public void setUp() {
        driver = new Driver();
        wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
//        driver.get().manage().window().maximize();
//        driver.get().navigate().to("https://automationexercise.com/");
    }

    @Test(priority = 1)
    public void userCanRegisterSuccessfully() {
//        homePage = new HomePage(driver);
//        loginSignUpPage = new LoginSignUpPage(driver);
//        registrationPage = new RegistrationPage(driver);
//        successPage = new RegistrationSuccessPage(driver);
//
//        homePage.checkThatUserShouldBeNavigatedToHomePageSuccessfully();
//        homePage.clickOnLoginLink();
//
//
//        loginSignUpPage.checkThatUserIsNavigatedToLoginSignUpPage();
//        loginSignUpPage.fillSignUpNamed("Mariam");
//        loginSignUpPage.fillSignUpEmail("TEST451355@gmail.com");
//        loginSignUpPage.clickOnSignUpButton();
//
//        registrationPage.checkThatRegistrationPageIsLoadedSuccessfully();
//
//        registrationPage.fillInRegistrationPage();
//        registrationPage.clickOnCreateAccountButton();
//
//
//        successPage.checkThatSuccessMessageShouldDisplayed();
        new HomePage(driver)
                .checkThatUserShouldBeNavigatedToHomePageSuccessfully()
                .clickOnLoginLink()
                .checkThatUserIsNavigatedToLoginSignUpPage()
                .fillSignUpNamed("Mariam")
                .fillSignUpEmail("TEST45130095mmn333@gmail.com")
                .clickOnSignUpButton()
                .checkThatRegistrationPageIsLoadedSuccessfully()
                .fillInRegistrationPage()
                .clickOnCreateAccountButton()
                .checkThatSuccessMessageShouldDisplayed();
        ScreenShotManager.captureScreenshot(driver.get(), "New Test");
        driver.browser().deleteAllCookies();


    }

    @Test(dependsOnMethods = "userCanRegisterSuccessfully", priority = 2)
    public void userCanLoginSuccessfully() {
//        driver.get().navigate().to("https://automationexercise.com/login");
        driver.browser().navigateToURL("https://automationexercise.com/login");


        new LoginSignUpPage(driver)
                .fillInLoginEmail("TEST45130095mmn333@gmail.com")
                .fillLoginPassword("12345678")
                .clickOnLoginButton()
                .checkThatTestCasesLinkShouldBeDisplayed()
                .checkThatLogoutLinksShouldBeDisplayed();

//
//        loginSignUpPage.fillInLoginEmail("TEST451355@gmail.com");
//        loginSignUpPage.fillLoginPassword("12345678");
//        loginSignUpPage.clickOnLoginButton();
//
//        homePage.checkThatTestCasesLinkShouldBeDisplayed();
//
//        homePage.checkThatLogoutLinksShouldBeDisplayed();
    }

    @Test(dependsOnMethods = "userCanLoginSuccessfully", priority = 3)
    public void userCanLogoutSuccessfully() {
        new HomePage(driver)
                .clickOnLogoutLink()
                .checkThatUserIsNavigatedToLoginSignUpPage();
//        homePage.clickOnLogoutLink();
//        homePage.checkThatLoginLinkShouldBeDisplayed();
//        loginSignUpPage.checkThatUserIsNavigatedToLoginSignUpPage();
//
    }

    @Test(dependsOnMethods = "userCanLogoutSuccessfully", priority = 4)
    public void userCanDeleteAccountSuccessfully() {
        //        deleteAccount=new AccountSuccessfullyDeletion(driver);
        new LoginSignUpPage(driver)
                .fillInLoginEmail("TEST45130095mmn333@gmail.com")
                .fillLoginPassword("12345678")
                .clickOnLoginButton()
                .checkThatLogoutLinksShouldBeDisplayed()
                .clickOnDeleteAccountLink()
                .checkThatAccountShouldBeDeletedSuccessfully()
                .clickOnContinueButton()
                .checkThatUserShouldBeNavigatedToHomePageSuccessfully()
                .checkThatLoginLinkShouldBeDisplayed();

//        loginSignUpPage.fillInLoginEmail("TEST451355@gmail.com");
//        loginSignUpPage.fillLoginPassword("12345678");
//        loginSignUpPage.clickOnLoginButton();
//
//        homePage.checkThatLogoutLinksShouldBeDisplayed();
//        homePage.clickOnDeleteAccountLink();
//
//        deleteAccount.checkThatAccountShouldBeDeletedSuccessfully();
//        deleteAccount.clickOnContinueButton();
//        homePage.checkThatLoginLinkShouldBeDisplayed();
    }

    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.browser().quit();
//        driver.get().manage().deleteAllCookies();
//        driver.quit();
    }
}
