package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class OpenCartTetsngPractice {
    @Test
    public void successfulLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.opencart.com/admin/");
        WebElement login=driver.findElement(By.xpath("//input[@id='input-username']"));
        login.sendKeys("demo");
        WebElement password=driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement clickButton= driver.findElement(By.xpath("//button[@type='submit']"));
        clickButton.click();
        Thread.sleep(2000);
        String tittleActual=driver.getTitle();
        String expectedTitle="Dashboard";
        Assert.assertEquals(tittleActual,expectedTitle);

    }
    @Test
    public void validation(String act,String exp){

    }
}
