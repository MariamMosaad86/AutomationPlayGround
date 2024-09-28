package tests;

import browserActions.BrowserActions;
import driverfactory.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.FirstProductDetailsPage;
import pages.HomePage;
import pages.ProductsPage;


public class ProductsTest {
    public Driver driver;
    public BrowserActions browser;
    //    HomePage homePage;
//    ProductsPage productsPage;
//    FirstProductDetailsPage firstProductDetailsPage;

    @BeforeClass
    public void setUp() {
        driver = new Driver();
//        driver.get().manage().window().maximize();
//        driver.browser().navigateToURL("https://automationexercise.com/");
//        Driver.get().navigate().to("https://automationexercise.com/");
    }

    @Test(priority = 1)
    public void userCanNavigateToHomePageSuccessfully() {
        new HomePage(driver)
                .checkThatUserShouldBeNavigatedToHomePageSuccessfully()
                .clickOnProductsLink();
    }

    @Test(dependsOnMethods = "userCanNavigateToHomePageSuccessfully", priority = 2)
    public void userCanNavigateToAllProductsPageSuccessfully() {
        new ProductsPage(driver)
                .checkThatUserCanNavigateToAllProductsListSuccessfully();
    }

    @Test(dependsOnMethods = "userCanNavigateToAllProductsPageSuccessfully", priority = 3)
    public void userCanClickOnFirstProductLink() {
        new ProductsPage(driver).ClickOnFirstProductViewProduct();
    }

    @Test(dependsOnMethods = "userCanClickOnFirstProductLink", priority = 4)
    public void userCanNavigateToFirstProductDetailsPage() {
        new FirstProductDetailsPage(driver)
                .CheckThatUserCanNavigateToFirstProductDetailsPage();

    }

    @AfterClass
    public void tearDown() {

    driver.browser().deleteAllCookies();
     driver.browser().quit();

    }

}
