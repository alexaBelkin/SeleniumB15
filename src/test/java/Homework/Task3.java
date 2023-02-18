package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        WebElement username= driver.findElement(By.xpath("//input[@placeholder='Username']"));
        username.sendKeys("Java");
        WebElement password= driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("Selenium");
        WebElement clickButton= driver.findElement(By.xpath("//input[@id='login-button']"));
        clickButton.click();
        String error=driver.findElement(By.xpath("//h3[@data-test='error']")).getText().trim();
        System.out.println(error.equals("Epic sadface: Username and password do not match any user in this service")?"PASSED":"FAILED");
        driver.quit();

    }
}
