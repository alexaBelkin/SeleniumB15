package Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/radio-button");
        WebElement radioB= driver.findElement(By.xpath("//label[@for='yesRadio']"));
        radioB.click();
        String checkYes=driver.findElement(By.xpath("//span[contains(text(),'Yes')]")).getText();
        System.out.println(checkYes.equals("Yes")?"YES passed":"YES failed");
        WebElement impressiveB=driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        impressiveB.click();
        String impressiveCheck=driver.findElement(By.xpath("//span[contains(text(),'Impressive')]")).getText();
        System.out.println(impressiveCheck.equals("Impressive")?"Impressive PASSED":"Impressive FAILED");
        driver.quit();



    }
}
