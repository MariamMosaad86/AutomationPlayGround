package pages;

import driverfactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class RegistrationSuccessPage {
    public Driver driver;;
    private WebDriverWait wait;

    By successMessage = By.xpath("//h2[@data-qa=\"account-created\"]");
    By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");

// انا هنا ضفت ال wait فى ال constructor
    public RegistrationSuccessPage(Driver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));

    }

    /*************************************** Assertions ******************************************/
    @Step("check That Success Message Should Displayed")
    public RegistrationSuccessPage checkThatSuccessMessageShouldDisplayed() {

//        wait.until(ExpectedConditions.urlContains("account_created"));
// و جيت هنا قلتلة استنى ال 30 ثانية دول لحد ما شرط معين يتحقق- لو اتحقق قبل ال 30 ثانية خلاص متستناش
        wait.until(ExpectedConditions.visibilityOf(driver.get().findElement(successMessage)));

//        Assert.assertTrue(driver.get().getCurrentUrl().contains("/account_created"));
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/account_created"));
        Assert.assertTrue(driver.element().isDisplayed(successMessage));
        Assert.assertEquals(driver.element().getTextOf(successMessage), "ACCOUNT CREATED!");
        return this;
    }
}
