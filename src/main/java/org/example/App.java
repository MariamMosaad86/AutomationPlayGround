package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/login");
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
        String subHeader= driver.findElement(By.cssSelector("h4.subheader")).getText();
        System.out.println(subHeader);
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button.radius")).click();
        Boolean isFound= driver.findElement(By.xpath("//a[@href=\"/logout\"]")).isDisplayed();
        System.out.println(isFound);
        driver.findElement(By.xpath("//a[@href=\"/logout\"]")).click();
        driver.navigate().to("https://the-internet.herokuapp.com");
        driver.findElement(By.linkText("Form Authentication")).click();




        Thread.sleep(3000);
        driver.quit();
//        driver.findElement(By.id("password")).submit();
//driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
//        driver.findElement(By.className("radius")).click();
//      driver.findElement(By.cssSelector("button.radius")).click();
//        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
//        driver.findElement(By.cssSelector("form > type=\"submit\"")).click();
//        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
//        driver.findElement(By.xpath("//form//button[@type=\"submit\"]")).click();

//        String url=driver.getCurrentUrl();
//        System.out.println(url);
//        System.out.println(driver.getTitle());




//        driver.findElement(By.xpath("//a[@href=\"/login\"]")).click();
////        driver.findElement(By.linkText("Form Authe")).click();
//        String header=driver.findElement(By.cssSelector("h4.subheader")).getText();
//        System.out.println(header);
//
//        driver.findElement(By.id("username")).sendKeys("tomsmith");
//        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
//        driver.findElement(By.cssSelector("button.radius")).click();


    }
}
