package pages;

import driverfactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ContactUsPage {
    //    public WebDriver driver;
    public Driver driver;
    WebDriverWait wait;
    private FluentWait fluentWait;

    By formTitle = By.xpath("(//h2[@class=\"title text-center\"])[2]");
    By nameField = By.name("name");
    By emailField = By.name("email");
    By subjectField = By.name("subject");
    By messageField = By.id("message");
    By submitButton = By.name("submit");
    By successMessage = By.cssSelector("div.status.alert.alert-success");
    By homeButton = By.cssSelector("a.btn.btn-success");

    public ContactUsPage(Driver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));

        fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class);
    }

    /*************************************** Assertions ******************************************/

    @Step("checkThatContactUsPageIsLoadedSuccessfully")
    public ContactUsPage checkThatContactUsPageIsLoadedSuccessfully() {
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/contact_us"));
//        fluentWait.until(ExpectedConditions.textToBe(formTitle, "Get"));

        Assert.assertEquals(driver.element().getTextOf(formTitle), "GET IN TOUCH");
        return this;
    }

    @Step("checkThatFormShouldBeSubmittedSuccessfully")
    public ContactUsPage checkThatFormShouldBeSubmittedSuccessfully() {

        Assert.assertEquals(driver.element().getTextOf(successMessage), "Success! Your details have been submitted successfully.");
        return this;

    }

    /*************************************** Actions ******************************************/
@Step("User can fill In ContactUs Form")
    public ContactUsPage fillInContactUsForm(String name, String email, String subject, String message) {

        driver.element().fillFiled(nameField, name);
        driver.element().fillFiled(emailField, email);
        driver.element().fillFiled(subjectField, subject);
        driver.element().fillFiled(messageField, message);
        return this;
    }
@Step("User click On Submit Button")
    public ContactUsPage clickOnSubmitButton() {
        driver.element().click(submitButton);
       driver.get().switchTo().alert().accept();
//        driver.browser().acceptSwitchAlert();
        return this;

    }
@Step("User click On HomeButton")
    public HomePage clickOnHomeButton() {
        driver.element().click(homeButton);
        return new HomePage(driver);

    }

}
