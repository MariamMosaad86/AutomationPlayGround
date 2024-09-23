package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;


public class App2
{
    public static void main( String[] args )
    {
        WebDriver driver = new EdgeDriver();

        driver.navigate().to("https://automationexercise.com/login");
        driver.findElement(By.name("name")).sendKeys("Mohammed");
        driver.findElement(By.xpath("//input[@data-qa=\"signup-email\"]")).sendKeys("tes5t878674@gmail.com");
        driver.findElement(By.xpath("//button[@data-qa=\"signup-button\"]")).click();

        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.id("first_name")).sendKeys("Mohammed");
        driver.findElement(By.id("last_name")).sendKeys("Taher");
        driver.findElement(By.id("address1")).sendKeys("Alexandria");
        driver.findElement(By.id("state")).sendKeys("Alex");
        driver.findElement(By.id("city")).sendKeys("Alex");

        WebElement dropdown = driver.findElement(By.id("country"));

//        dropdown.click();
     driver.findElement(By.xpath("//option[@value='Canada']")).click();
        //  /html/body/section/div/div/div/div[1]/form/div/div[1]/div/select

        Select select = new Select(dropdown);

        select.selectByValue("Canada");
        select.selectByIndex(1);

        driver.findElement(By.xpath("//input[@data-qa=\"zipcode\"]")).sendKeys("21500");
        driver.findElement(By.xpath("//input[@data-qa=\"mobile_number\"]")).sendKeys("01234456978");
        driver.findElement(By.xpath("//button[@data-qa=\"create-account\"]")).click();


    }
}