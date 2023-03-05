package JavaScriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaScriptPractice {

    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techtorialacademy.com/");


        WebElement copyright= driver.findElement(By.xpath("//div[contains(text(),'Copyright')]"));
        BrowserUtils.scrollWithJS(driver,copyright);
        String actual=BrowserUtils.getText(copyright);
        String expected="Copyright © 2023";
        Assert.assertEquals(actual,expected);

        WebElement apply= driver.findElement(By.xpath("//span[@data-magic='button-text']//strong[.='APPLY NOW']"));
        BrowserUtils.scrollWithJS(driver,apply);
        Thread.sleep(3000);
        BrowserUtils.clickWithJS(driver,apply);

        List<WebElement> elemets=driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));
        List<String> expectedList= Arrays.asList("info@techtorialacademy.com","+ 1 (224) 570 91 91","Chicago & Houston");

        for(int i=0;i<elemets.size();i++){
            Assert.assertEquals(BrowserUtils.getText(elemets.get(i)),expectedList.get(i));
        }


    }
}
