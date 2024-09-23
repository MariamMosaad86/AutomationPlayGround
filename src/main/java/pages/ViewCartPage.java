package pages;

import driverfactory.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ViewCartPage {
    Driver driver;

    public ViewCartPage(Driver driver) {
        this.driver = driver;
    }

    By homeLink = By.xpath("(//li/a[@href])[9]");
    By productsTable = By.xpath("//div[@class=\"table-responsive cart_info\"]");

    public ViewCartPage checkThatUserCanNavigateToViewCartSuccessfully() {
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/view_cart"));
        Assert.assertTrue(driver.element().isDisplayed(homeLink));
        Assert.assertTrue(driver.get().findElement(productsTable).isDisplayed());
        return this;
    }
}
