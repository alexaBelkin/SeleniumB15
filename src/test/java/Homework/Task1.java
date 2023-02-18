package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/text-box");
        WebElement userName= driver.findElement(By.xpath("//input[@id='userName']"));
        userName.sendKeys("Alexa Belkin");
        WebElement email= driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("brownhorse12@gmail.com");
        WebElement currentAddress= driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("1233 smith st");
        WebElement permanent= driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanent.sendKeys("2244 robot drive");
        WebElement clickButton=driver.findElement(By.xpath("//button[@id='submit']"));
        Thread.sleep(1000);
        clickButton.click();
        WebElement line1=driver.findElement(By.xpath("//p[@id='name']"));
        String lineString=line1.getText();
        System.out.println(line1.isDisplayed()&&lineString.equals("Name:Alexa Belkin")?"PASSED":"FAILED");
        WebElement line2=driver.findElement(By.xpath("//p[@id='email']"));
        String line2String=line2.getText();
        System.out.println(line2.isDisplayed()&&line2String.equals("Email:brownhorse12@gmail.com")?"Emailed PASSED":"Email Failed");
        WebElement line3=driver.findElement(By.xpath("//p[@id='currentAddress']"));
        String line3String=line3.getText();
        System.out.println(line3.isDisplayed()&&line3String.equals("Current Address :1233 smith st")?"Current address PASSED":"CURRENT address FAILED");
        WebElement line4=driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        String line4String=line4.getText();
        System.out.println(line4.isDisplayed()&&line4String.equals("Permananet Address :2244 robot drive")?"Permanent address PASSED":"Permanent address FAILED");
        driver.quit();




    }
}
