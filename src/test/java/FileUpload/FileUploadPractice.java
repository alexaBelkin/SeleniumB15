package FileUpload;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class FileUploadPractice {
    @Test
    public void Practice1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/upload");

        WebElement chooseFIle=driver.findElement(By.cssSelector("#file-upload"));
        chooseFIle.sendKeys("/Users/alenanikolaeva/Desktop/usa.png");
        driver.findElement(By.cssSelector("#file-submit")).click();

        WebElement message= driver.findElement(By.cssSelector("#uploaded-files"));
        Assert.assertEquals(BrowserUtils.getText(message),"usa.png");

        driver.quit();

    }

    @Test
    public void Practice2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.guru99.com/test/upload/");

        WebElement chooseFile= driver.findElement(By.cssSelector(".upload_txt"));
        chooseFile.sendKeys("/Users/alenanikolaeva/Desktop/usa.png");
        WebElement message=driver.findElement(By.xpath("//b[contains(text(),'Select file')]"));
        Assert.assertEquals(BrowserUtils.getText(message),"Select file to send(max 196.45 MB)");

        driver.findElement(By.cssSelector("#terms")).click();
        driver.findElement(By.xpath("//button[@id='submitbutton']")).click();

        WebElement text= driver.findElement(By.xpath("//h3//center"));
        Assert.assertTrue(BrowserUtils.getText(text).contains("has been successfully uploaded."));
        driver.quit();



    }
}
