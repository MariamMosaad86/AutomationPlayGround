package pages;

import driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegistrationPage {
    public Driver driver;
    /********************************** Actions ****************************/
    By pageTitle = By.xpath("(//h2)[1]");
    By password = By.id("password");
    By firstName = By.id("first_name");
    By lastName = By.id("last_name");
    By address = By.id("address1");
    By state = By.id("state");
    By city = By.id("city");
    By day = By.id("days");
    By month = By.id("months");
    By years = By.id("years");
    By country = By.id("country");
    By zipCode = By.xpath("//input[@data-qa=\"zipcode\"]");
    By mobileNumber = By.xpath("//input[@data-qa=\"mobile_number\"]");
    By createAccountButton = By.xpath("//button[@data-qa=\"create-account\"]");

    public RegistrationPage(Driver driver) {
        this.driver = driver;
    }

    /********************************* Assertions *******************************/

    public RegistrationPage checkThatRegistrationPageIsLoadedSuccessfully() {
//     Assert.assertTrue(driver.get().getCurrentUrl().contains("/signup"));
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/signup"));
        Assert.assertEquals(driver.element().getTextOf(pageTitle), "ENTER ACCOUNT INFORMATION");
        return this;
    }

    /***************************************Actions******************************************/
    public RegistrationPage fillInRegistrationPage() {
        driver.element().fillFiled(password, "12345678");

        driver.element().selectByIndex(day, 4);

//       Select selectDay = new Select(driver.get().findElement(day));
//       selectDay.selectByIndex(4);
        driver.element().selectByIndex(month, 10);
//        Select selectMonth = new Select(driver.get().findElement(month));
//        selectMonth.selectByIndex(10);
        driver.element().selectByValue(years, "1986");
//        Select selectYear = new Select(driver.get().findElement(years));
//        selectYear.selectByValue("1986");
        driver.element().fillFiled(firstName, "Mariam");
        driver.element().fillFiled(lastName, "Mossad");
        driver.element().fillFiled(address, "Alexandria");
        driver.element().fillFiled(state, "Alex");
        driver.element().fillFiled(city, "Alex");

        driver.element().selectByValue(country, "Canada");
//        Select selectCountry = new Select(driver.get().findElement(country));
//        selectCountry.selectByValue("Canada");
        driver.element().fillFiled(zipCode, "21500");
        driver.element().fillFiled(mobileNumber, "01236587412");
        return this;
    }

    public RegistrationSuccessPage clickOnCreateAccountButton() {
        driver.element().click(createAccountButton);
        return new RegistrationSuccessPage(driver);
    }

}