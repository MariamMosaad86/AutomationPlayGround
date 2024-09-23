package pages;

import driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountSuccessfullyDeletion {
    Driver driver;

    public AccountSuccessfullyDeletion(Driver driver) {
        this.driver = driver;
    }
    By successMessage=By.xpath("//h2[@data-qa=\"account-deleted\"]");
    By continueButton=By.xpath("//a[@data-qa=\"continue-button\"]");

    /*************************************** Assertions ******************************************/

    public AccountSuccessfullyDeletion checkThatAccountShouldBeDeletedSuccessfully(){
        Assert.assertTrue(driver.browser().getCurrentURL().contains("delete_account"));
        Assert.assertTrue(driver.element().isDisplayed(successMessage));
        Assert.assertEquals(driver.element().getTextOf(successMessage), "ACCOUNT DELETED!");
        return this;
    }
    public HomePage clickOnContinueButton(){
        driver.element().click(continueButton);
        return new HomePage(driver);
    }

}
