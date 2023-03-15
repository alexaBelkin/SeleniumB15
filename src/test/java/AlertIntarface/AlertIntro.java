package AlertIntarface;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BrowserUtils;

import java.time.Duration;

public class AlertIntro {
    @Test
    public void alertPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement alertButton= driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert()')]"));
        alertButton.click();
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText().trim(),"I am a JS Alert");
        Thread.sleep(500);
        alert.accept();
        WebElement message= driver.findElement(By.cssSelector("#result"));
        Assert.assertEquals(BrowserUtils.getText(message),"You successfully clicked an alert");
        driver.quit();


    }
    @Test
    public void alertDismiss(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement alertButton1=driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm()')]"));
        alertButton1.click();
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am a JS Confirm");
        //SoftAssert softAssert=new SoftAssert();
        //softAssert.assertEquals(alert.getText().trim(),"I am a JS Confirm","There is a comparison problem");
        alert.dismiss();

        WebElement message= driver.findElement(By.cssSelector("#result"));
        Assert.assertEquals(BrowserUtils.getText(message),"You clicked: Cancel");
        driver.quit();

    }

    @Test
    public void alertWithSendText(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement alertButton1=driver.findElement(By.xpath("//button[contains(@onclick,'jsPrompt()')]"));
        alertButton1.click();
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am a JS prompt");
        alert.sendKeys("Alexa");
        alert.accept();

        WebElement message= driver.findElement(By.cssSelector("#result"));
        Assert.assertEquals(message.getText(),"You entered: Alexa");
        driver.quit();


    }
}
