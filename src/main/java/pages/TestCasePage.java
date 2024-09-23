package pages;

import driverfactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestCasePage {
    public Driver driver;


    By testTitle=By.cssSelector("h2.title.text-center");

    public TestCasePage(Driver driver) {
        this.driver = driver;
    }

    /*************************************** Assertions ******************************************/
public TestCasePage checkThatUserIsNavigatedToTestCasesPageSuccessFully(){
//    Assert.assertTrue(driver.get().getCurrentUrl().contains("/test_cases"));
    Assert.assertTrue(driver.browser().getCurrentURL().contains("/test_cases"));
    Assert.assertTrue(driver.get().findElement(testTitle).getText().contains("CASES"));
    return this;
}
    /*************************************** Actions ******************************************/


}
