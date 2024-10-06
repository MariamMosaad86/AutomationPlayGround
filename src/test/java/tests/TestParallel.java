package tests;

import driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.HomePage;

import java.time.Duration;

public class TestParallel {

    public ThreadLocal<Driver> driver;
    WebDriverWait wait;


    @BeforeClass
    @Parameters(value = {"browserName"})
    public void setUp(@Optional("CHROME") String browserName) {
        driver = new ThreadLocal<>();
        driver.set(new Driver(browserName));
//        driver.get().get().manage().window().maximize();
//        driver.get().get().navigate().to("https://automationexercise.com/");
        driver.get().get().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

    }

    @Test
    public void contactUsTest() throws InterruptedException {
//        driver.get().element().hoverOnItem(By.xpath("(//div[@class=\"product-overlay\"])[1]"))
//                .click(By.xpath("(//a[@class=\"btn btn-default add-to-cart\"])[1]"));
//        Thread.sleep(5000);

        new HomePage(driver.get()).checkThatUserShouldBeNavigatedToHomePageSuccessfully()
                .clickOnContactUsLink()
                .checkThatContactUsPageIsLoadedSuccessfully()
                .fillInContactUsForm("Mariam", "test12345@gmail.com", "Test", "Welcome")
                .clickOnSubmitButton()
                .checkThatFormShouldBeSubmittedSuccessfully()
                .clickOnHomeButton()
                .checkThatUserShouldBeNavigatedToHomePageSuccessfully();



    }

//    @AfterMethod
//    public void screenshotOnFailure(ITestResult result) {
//
//        if(result.getStatus() == ITestResult.FAILURE){
//            System.out.println("Test Failed");
//            System.out.println("Taking screen shot.....");
//            ScreenShotManager.captureScreenshot(driver.get(), result.getName());
//        }
//
//    }

    @AfterClass
    public void tearDown() {
        driver.get().get().manage().deleteAllCookies();
        driver.get().quit();
    }
}