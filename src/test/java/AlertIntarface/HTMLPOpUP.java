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

public class HTMLPOpUP {
    @Test
    public void htmlPracticePopUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://sweetalert.js.org/");

        WebElement click1= driver.findElement(By.xpath("//button[contains(@onclick,'something went wrong')]"));
        Thread.sleep(1000);
        click1.click();
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText().trim(),"Oops, something went wrong!");
        alert.accept();

        WebElement click2=driver.findElement(By.xpath("//button[contains(@onclick,'Something went wrong!')]"));
        click2.click();
        WebElement closeBitton= driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
        WebElement textMessage= driver.findElement(By.xpath("//div[@class='swal-modal']"));
        Assert.assertTrue(BrowserUtils.getText(textMessage).contains("Something went wrong!"));
        closeBitton.click();

    }
}
