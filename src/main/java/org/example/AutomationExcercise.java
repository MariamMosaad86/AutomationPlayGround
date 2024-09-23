package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import javax.xml.crypto.KeySelector;
import java.nio.channels.Selector;
import java.security.Key;

public class AutomationExcercise {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://automationexercise.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@href=\"/login\"]")).click();
        driver.findElement(By.name("name")).sendKeys("Mariam");
        driver.findElement(By.xpath("//input[@data-qa=\"signup-email\"]")).sendKeys("test99t8852@gmail.com");
        driver.findElement(By.xpath("//button[@data-qa=\"signup-button\"]")).click();
        driver.findElement(By.id("password")).sendKeys("12345678");

        WebElement dayDropdown=driver.findElement(By.id("days"));
        Select selectDay=new Select(dayDropdown);
        selectDay.selectByValue("4");

       WebElement monthDropDown=driver.findElement(By.id("months"));
       Select selectMonth=new Select(monthDropDown);
       selectMonth.selectByIndex(9);

       WebElement yearDropDown=driver.findElement(By.id("years"));
       Select selectYear=new Select(yearDropDown);
       selectYear.selectByValue("1986");

        driver.findElement(By.id("first_name")).sendKeys("Mariam");
        driver.findElement(By.id("last_name")).sendKeys("besho");
        driver.findElement(By.id("address1")).sendKeys("Alexandria");
        driver.findElement(By.id("state")).sendKeys("Alex");
        driver.findElement(By.id("city")).sendKeys("Alexandria");
        WebElement dropDown=driver.findElement(By.id("country"));
//        dropDown.click();
//         driver.findElement(By.xpath("//option[@value='Canada']")).click();;
        Select select=new Select(dropDown);
        select.selectByValue("Canada");
        select.selectByIndex(1);

        driver.findElement(By.id("zipcode")).sendKeys("1232");
        driver.findElement(By.id("mobile_number")).sendKeys("12365478455");
        driver.findElement(By.cssSelector("button.btn")).submit();

        String title =driver.findElement(By.cssSelector("h2.title")).getText();
        System.out.println(title);
        System.out.println(driver.getTitle());
        driver.manage().deleteAllCookies();


// /html/body/section/div/div/div/div[1]/form/p[6]/select


        Thread.sleep(3000);
        driver.quit();



    }
}
