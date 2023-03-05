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

public class FramePractice {

    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");

        WebElement validation1=driver.findElement(By.tagName("h3"));
        Assert.assertEquals(BrowserUtils.getText(validation1),"An iFrame containing the TinyMCE WYSIWYG Editor");

        Thread.sleep(500);
        driver.switchTo().frame("mce_0_ifr");
        WebElement clearBox= driver.findElement(By.cssSelector("#tinymce"));
        clearBox.clear();
        clearBox.sendKeys("Alexa Belkin");


        driver.switchTo().parentFrame();
        WebElement clickElement= driver.findElement(By.linkText("Elemental Selenium"));
        clickElement.click();
        Thread.sleep(2000);
        BrowserUtils.switchByTitle(driver,"Using Selenium like a Pro");
        WebElement seleniumHeader= driver.findElement(By.tagName("h1"));

        Assert.assertEquals(BrowserUtils.getText(seleniumHeader),"Elemental Selenium");

    }


}
