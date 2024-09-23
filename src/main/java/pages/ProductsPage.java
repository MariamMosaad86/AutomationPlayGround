package pages;

import driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductsPage {
    public Driver driver;

    By productsTitle = By.cssSelector("h2.title.text-center");
    By firstViewProductList = By.xpath("//a[@href=\"/product_details/1\"]");

    public ProductsPage(Driver driver) {
        this.driver = driver;
    }

    /*************************************** Assertions ******************************************/
    public ProductsPage checkThatUserCanNavigateToAllProductsListSuccessfully() {
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/products"));
        Assert.assertEquals(driver.element().getTextOf(productsTitle),"ALL PRODUCTS");
//        Assert.assertTrue(driver.get().getCurrentUrl().contains("/products"));
//          Assert.assertEquals(driver.get().findElement(productsTitle)
//          .getText(), "ALL PRODUCTS");
        return this;

    }

    /*************************************** Actions ******************************************/

    public FirstProductDetailsPage ClickOnFirstProductViewProduct() {
      driver.element().click(firstViewProductList);
             return new FirstProductDetailsPage(driver);
    }

}
