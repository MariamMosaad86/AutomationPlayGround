package tests;

import driverfactory.Driver;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ViewCartPage;
import utilities.ScreenShotManager;

import java.time.Duration;

public class AddItemToCartAndViewCartTest {
    Driver driver;

    @BeforeClass
    public void setUp() {
        driver = new Driver("CHROME");
        driver.browser().maximizeWindow();
        driver.browser().navigateToURL("https://automationexercise.com/");
//        driver.browser().ScrollToBottom();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

    }

    @Test(priority = 1)
    public void addFirstItemToCart() {
        new HomePage(driver)
                .checkThatFeatureItemShouldBeDisplayed()
                .hoverOnFirstProduct()
                .clickOnFirstItem();
//        driver.element()
//                .explicitWaitForElementToBeVisible(By.xpath("//div[@class=\"modal-content\"]"), 10);
//        new HomePage(driver).clickOnContinue();
        new HomePage(driver).clickOnViewCart();
        ScreenShotManager.captureScreenshot(driver.get(), "View cart");


    }

    @Test(dependsOnMethods = "addFirstItemToCart", priority = 2)
    public void userCanViewCartSuccessfully() {
        new ViewCartPage(driver)
                .checkThatUserCanNavigateToViewCartSuccessfully();
    }

    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.browser().quit();
    }
}