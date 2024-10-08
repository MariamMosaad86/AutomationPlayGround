package pages;

import driverfactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;

public class HomePage {
    //    public WebDriver driver;
    public Driver driver;
    By loginLink = By.xpath("//a[@href=\"/login\"]");
    By logoutLink = By.xpath("//a[@href=\"/logout\"]");
    By deleteAccountLink = By.xpath("//a[@href=\"/delete_account\"]");
    By contactusLink = By.xpath("//a[@href=\"/contact_us\"]");
    By testCaseLink = By.xpath("//a[@href=\"/test_cases\"]");
    By productsLink = By.xpath("//a[@href=\"/products\"]");
    By clickOnContinueButton = By.xpath("//button[@class=\"btn btn-success close-modal btn-block\"]");
    By clickOnViewCart = By.xpath("(//a[@href=\"/view_cart\"])[2]");


    By hoverOnFirstItem = By.xpath("(//div[@class=\"overlay-content\"])[1]");
    By clickAddToCartButton = By.xpath("(//a[@class=\"btn btn-default add-to-cart\"])[1]");
    By productTitle = By.xpath("(//h2[\"title text-center\"])[6]");



    public HomePage(Driver driver) {
        this.driver = driver;
    }

    /*************************************** Assertions ******************************************/
@Step("checkThatLogoutLinksShouldBeDisplayed")
    public HomePage checkThatLogoutLinksShouldBeDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(logoutLink));
        return this;
    }
@Step("checkThatLoginLinkShouldBeDisplayed")
    public HomePage checkThatLoginLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(loginLink));
        return this;
    }

@Step("checkThatDeleteAccountLinkShouldBeDisplayed")
    public HomePage checkThatDeleteAccountLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(deleteAccountLink));
        return this;
    }
    @Step("check That User Should Be Navigated To HomePage Successfully")
    public HomePage checkThatUserShouldBeNavigatedToHomePageSuccessfully() {
//        Assert.assertEquals(driver.get().getCurrentUrl(), "https://automationexercise.com/");
        Assert.assertEquals(driver.browser().getCurrentURL(), "https://automationexercise.com/");

        return this;
    }
@Step("check That Test Cases Link Should Be Displayed")
    public HomePage checkThatTestCasesLinkShouldBeDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(testCaseLink));
        return this;
    }

   @Step("check That Feature Item Should Be Displayed")
    // New 14/9/2024
    public HomePage checkThatFeatureItemShouldBeDisplayed() {
        Assert.assertEquals(driver.element().getTextOf(productTitle), "FEATURES ITEMS");
        return this;
    }

    /*************************************** Actions ******************************************/
@Step("User clicks On LoginLink")
    public LoginSignUpPage clickOnLoginLink() {
        driver.element().click(loginLink);
        return new LoginSignUpPage(driver);
    }
@Step("User clicks On Logout Link")
    public LoginSignUpPage clickOnLogoutLink() {
        driver.element().click(logoutLink);
        return new LoginSignUpPage(driver);
    }
@Step("User clicks On Delete Account Link")
    public AccountSuccessfullyDeletion clickOnDeleteAccountLink() {
        driver.element().click(deleteAccountLink);
        return new AccountSuccessfullyDeletion(driver);
    }
@Step("User clicks On ContactUs Link")
    public ContactUsPage clickOnContactUsLink() {
        driver.element().click(contactusLink);
        return new ContactUsPage(driver);
    }
@Step("User clicks On TestCase Link")
    public TestCasePage clickOnTestCaseLink() {
        driver.element().click(testCaseLink);
        return new TestCasePage(driver);
    }
@Step("User clicks On Products Link")
    public ProductsPage clickOnProductsLink() {
        driver.element().click(productsLink);
        return new ProductsPage(driver);
    }
@Step("hover On FirstProduct")
    //NEW 14/9/2024
    public HomePage hoverOnFirstProduct() {
        driver.element().hoverOnItem(hoverOnFirstItem);
        return this;
    }
@Step("User clicks On First Item")
    public HomePage clickOnFirstItem() {
//        driver.element().explicitWaitForElementToBeClickable(clickAddToCartButton, 30);
        driver.element().click(clickAddToCartButton);
        return this;
    }
@Step("User clicks On Continue")
    public HomePage clickOnContinue() {
        driver.element().click(clickOnContinueButton);
        return this;
    }

    @Step("User clicks On ViewCart")
    public ViewCartPage clickOnViewCart() {
        driver.element().click(clickOnViewCart);
        return new ViewCartPage(driver);
    }

}