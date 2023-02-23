package MentoringWithAhmet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task {
    @Test
    public void creatingFacebook() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.facebook.com/");
        WebElement creatAccButton= driver.findElement(By.xpath("//a[contains(text(),\"Create new account\")]"));
        Thread.sleep(2000);
        creatAccButton.click();
        WebElement firstName= driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("Alexa");
        WebElement lastName= driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Belkin");
        WebElement phoneNumber= driver.findElement(By.xpath("//input[@name='reg_email__']"));
        phoneNumber.sendKeys("7715432378");
        WebElement newPassword=driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
        newPassword.sendKeys("12er12er23");
        WebElement month= driver.findElement(By.xpath("//option[contains(text(),'Mar')]"));
        month.click();
        WebElement day= driver.findElement(By.xpath("//option[.='27']"));
        day.click();
        WebElement year= driver.findElement(By.xpath("//option[.='1995']"));
        year.click();
        WebElement sex= driver.findElement(By.xpath("//label[contains(text(),'Female')]"));
        sex.click();
        WebElement signUp= driver.findElement(By.xpath("//button[@name='websubmit']"));
        Thread.sleep(2000);
        signUp.click();
        driver.quit();





    }
}
