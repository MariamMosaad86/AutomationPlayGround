package pages;

import driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FirstProductDetailsPage {
    public Driver driver;

    By productName=By.xpath("//div[@class=\"product-information\"]/h2");
    By category=By.xpath("(//div[@class=\"product-information\"]/p)[1]");
    By price=By.xpath("//div[@class=\"product-information\"]/span/span");
    By availability=By.xpath("(//div[@class=\"product-information\"]/p)[2]");
    By condition=By.xpath("(//div[@class=\"product-information\"]/p)[3]");
    By brand=By.xpath("(//div[@class=\"product-information\"]/p)[4]");

    public FirstProductDetailsPage(Driver driver) {
        this.driver = driver;
    }
    /*************************************** Assertions ******************************************/
public FirstProductDetailsPage CheckThatUserCanNavigateToFirstProductDetailsPage(){
//    Assert.assertTrue(driver.get().getCurrentUrl().contains("/product_details/1"));

    Assert.assertTrue(driver.browser().getCurrentURL().contains("/product_details/1"));
    Assert.assertTrue(driver.get().findElement(productName).isDisplayed());
    Assert.assertTrue(driver.get().findElement(category).isDisplayed());
    Assert.assertTrue(driver.get().findElement(price).isDisplayed());
    Assert.assertTrue(driver.get().findElement(availability).isDisplayed());
    Assert.assertTrue(driver.get().findElement(condition).isDisplayed());
    Assert.assertTrue(driver.get().findElement(brand).isDisplayed());
    return this;

}
    /*************************************** Actions ******************************************/

}
