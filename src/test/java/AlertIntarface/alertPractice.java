package AlertIntarface;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class alertPractice {
    @Test
    public void Task() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.hyrtutorials.com/p/alertsdemo.html");

        WebElement click1= driver.findElement(By.cssSelector("#alertBox"));
        click1.click();

        Alert alert=driver.switchTo().alert();
        Thread.sleep(300);
        Assert.assertEquals(alert.getText(),"I am an alert box!");
        alert.accept();
        WebElement message= driver.findElement(By.cssSelector("#output"));
        Assert.assertEquals(BrowserUtils.getText(message),"You selected alert popup");

        WebElement click2= driver.findElement(By.cssSelector("#confirmBox"));
        click2.click();
        Thread.sleep(300);
        Assert.assertEquals(alert.getText(),"Press a button!");
        alert.dismiss();
        message= driver.findElement(By.cssSelector("#output"));
        Assert.assertEquals(BrowserUtils.getText(message),"You pressed Cancel in confirmation popup");

        WebElement click3= driver.findElement(By.cssSelector("#promptBox"));
        click3.click();
        Thread.sleep(300);
        alert.sendKeys("Alexa");
        alert.accept();
        Assert.assertEquals(BrowserUtils.getText(message),"You entered text Alexa in propmt popup");
        driver.quit();

    }
}
