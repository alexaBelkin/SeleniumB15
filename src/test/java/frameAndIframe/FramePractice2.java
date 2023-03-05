package frameAndIframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class FramePractice2 {

    @Test
    public void practiceFrame() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");

        WebElement pavilion= driver.findElement(By.linkText("Pavilion"));
        pavilion.click();

        Actions actions=new Actions(driver);

        BrowserUtils.switchByTitle(driver,"Home - qavalidation");
        WebElement selenuim=driver.findElement(By.xpath("//ul[@id='primary-menu']//span//span[.='Selenium']"));

        actions.moveToElement(selenuim).perform();
        Thread.sleep(2000);
        WebElement selJava= driver.findElement(By.xpath("//ul[@id='primary-menu']//span//span[.='Selenium-Java']"));
        Thread.sleep(2000);
        selJava.click();

        WebElement header=driver.findElement(By.tagName("h1"));
        Assert.assertEquals(BrowserUtils.getText(header),"Selenium-Java Tutorial – Basic to Advance");

        List<WebElement> list=driver.findElements(By.xpath("//ul[@class='ht_toc_list']//li"));
        for (WebElement single:list) {
            System.out.println(BrowserUtils.getText(single));
        }

        BrowserUtils.switchByTitle(driver,"iframes");

        driver.switchTo().frame("Frame1");
        WebElement category1=driver.findElement(By.linkText("Category1"));
        category1.click();
        BrowserUtils.switchByTitle(driver,"SeleniumTesting Archives");

        WebElement valid2= driver.findElement(By.tagName("h1"));
        Assert.assertEquals(BrowserUtils.getText(valid2),"Category Archives: SeleniumTesting");
        List<WebElement> text=driver.findElements(By.xpath("//h3//a"));
        for (WebElement text1:text
             ) {
            System.out.println(BrowserUtils.getText(text1));
        }

        BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().frame("Frame2");
        WebElement categor3= driver.findElement(By.linkText("Category3"));
        categor3.click();
        BrowserUtils.switchByTitle(driver,"SoftwareTesting Archives - qavalidation");

        WebElement header23= driver.findElement(By.tagName("h1"));
        Assert.assertEquals(BrowserUtils.getText(header23),"Category Archives: SoftwareTesting");






    }

}
