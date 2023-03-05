package WindowHamdle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Set;

public class SwitchWindows {
    @Test
    public void windowsPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/windows");

        WebElement click= driver.findElement(By.linkText("Click Here"));
        Thread.sleep(2000);
        click.click();
        String MainpageId=driver.getWindowHandle();//page id of the class
        Set<String> allID=driver.getWindowHandles();
        for(String singleId:allID){
            if(!singleId.equals(MainpageId)){
                driver.switchTo().window(singleId);
                break;
            }
        }

        WebElement newWindow= driver.findElement(By.tagName("h3"));
        Thread.sleep(2000);
        System.out.println(BrowserUtils.getText(newWindow));


    }

    @Test
    public void newWindowValidation() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techtorialacademy.com/");

        WebElement findCourses= driver.findElement(By.linkText("Find out which course is for you"));
        BrowserUtils.scrollWithJS(driver,findCourses);
        Thread.sleep(3000);
        BrowserUtils.clickWithJS(driver,findCourses);

        String mainPageId=driver.getWindowHandle();
        Set<String> allID=driver.getWindowHandles();
        for(String singleId:allID){
            if(!singleId.equals(mainPageId)){
                driver.switchTo().window(singleId);
                break;
            }
        }
        Assert.assertEquals(driver.getTitle().trim(),"Courses");

        WebElement applyNow=driver.findElement(By.linkText("Apply Now"));
        applyNow.click();



    }

    @Test
    public void practice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement button2= driver.findElement(By.cssSelector("#newTabBtn"));
        Thread.sleep(2000);
        button2.click();

        String mainID=driver.getWindowHandle();
        Set<String> allId=driver.getWindowHandles();
        for(String singleId:allId){
            if(!singleId.equals(mainID)){
                driver.switchTo().window(singleId);
            }
        }
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle().trim(),"AlertsDemo - H Y R Tutorials");

        WebElement alert=driver.findElement(By.xpath("//div[@class='post-head']//h1"));
        Assert.assertEquals(BrowserUtils.getText(alert),"AlertsDemo");

        WebElement click= driver.findElement(By.cssSelector("#confirmBox"));
        Thread.sleep(2000);
        click.click();
        driver.quit();


    }
}
