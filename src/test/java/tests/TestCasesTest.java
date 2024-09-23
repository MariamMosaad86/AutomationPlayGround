package tests;

import browserActions.BrowserActions;
import driverfactory.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;


public class TestCasesTest {

    public Driver driver;
    BrowserActions browser;
//    HomePage homePage;
//    TestCasePage testCases;


    @BeforeClass
    public void setup() {
        driver = new Driver("CHROME");
        browser = new BrowserActions(driver.get());
        driver.get().manage().window().maximize();
//        driver.get().navigate().to("https://automationexercise.com/");
        browser.navigateToURL("https://automationexercise.com/");
    }

    @Test
    public void userCanNavigateToTestCasesPage() {
//        homePage = new HomePage(driver);
//        testCases = new TestCasePage(driver);
        new HomePage(driver)
                .checkThatUserShouldBeNavigatedToHomePageSuccessfully()
                .clickOnTestCaseLink()
                .checkThatUserIsNavigatedToTestCasesPageSuccessFully();

    }

    @AfterClass
    public void tearDown() {
        browser.deleteAllCookies();
        browser.quit();
//        driver.get().manage().deleteAllCookies();
//        driver.quit();
    }
}