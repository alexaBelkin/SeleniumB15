package frameAndIframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class NestedFrame {
    @Test
    public void nestedPractice() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement left= driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        Assert.assertEquals(BrowserUtils.getText(left),"LEFT");

        driver.switchTo().parentFrame();
        //driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        WebElement middle=driver.findElement(By.xpath("//div[contains(text(),'MIDDLE')]"));
        Assert.assertEquals(BrowserUtils.getText(middle),"MIDDLE");

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement right=driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        Assert.assertEquals(BrowserUtils.getText(right),"RIGHT");

        //BOTTOM FRAME

        driver.switchTo().defaultContent(); //directly to the main html
        driver.switchTo().frame("frame-bottom");
        WebElement bottom= driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        Assert.assertEquals(BrowserUtils.getText(bottom),"BOTTOM");




    }

}
