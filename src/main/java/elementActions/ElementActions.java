package elementActions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementActions {
    private WebDriver driver;
    private WebDriverWait wait;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public WebElement explicitWaitForElementToBeClickable(By locator, long timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Method to explicitly wait for an element to be visible
    public WebElement explicitWaitForElementToBeVisible(By locator, long timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public ElementActions click(By locator) {
        System.out.println("Click on: " + locator.toString());
        driver.findElement(locator).click();
        return this;
    }

    public ElementActions fillField(By locator, String text) {
        clearField(locator);
        System.out.println("Fill field: " + locator.toString() + "with:" + text);
        driver.findElement(locator).sendKeys(text);
        return this;
    }


    public ElementActions clearField(By locator) {
        System.out.println("Clear field with locator : " + locator.toString());
        driver.findElement(locator).clear();
        return this;
    }

    public ElementActions searchBar(By locator, String text) {
        clearField(locator);
        System.out.println("Type \"" + text + "\" into " + "\" Search Product\".");
        driver.findElement(locator).sendKeys(text);
        return this;
    }

    public ElementActions selectByIndex(By locator, int index) {
        new Select(driver.findElement(locator)).selectByIndex(index);

        return this;
    }

    public ElementActions selectByValue(By locator, String text) {
        new Select(driver.findElement(locator)).selectByValue(text);
        return this;
    }

    public ElementActions scrollToElement(By locator) {

        new Actions(driver).scrollToElement(driver.findElement(locator)).build().perform();
        return this;
    }


    public ElementActions hoverOnItem(By locator) {
        new Actions(driver).moveToElement(driver.findElement(locator)).click().build().perform();
        return this;
    }

    public String getTextOf(By locator) {
        return driver.findElement(locator).getText();
    }

    public boolean isDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    public boolean isSelected(By locator) {
        return driver.findElement(locator).isSelected();
    }

    public boolean isClickable(By locator) {
        return driver.findElement(locator).isEnabled();
    }

}