package WindowHamdle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class SwitchmultipleWindows {
    @Test
    public void multipleWindows() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");
        js.executeScript("window.open('https://www.techtorialacademy.com/courses')");
        BrowserUtils.switchByTitle(driver,"Contact us");
        Thread.sleep(3000);
        BrowserUtils.switchByTitle(driver,"Home");
        Thread.sleep(3000);
        BrowserUtils.switchByTitle(driver,"Courses");
        Thread.sleep(3000);
        driver.quit();



    }
    @Test
    public void task2() throws InterruptedException {
               /*
1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
2-Click open multiple tabs under Button 4
3-the Basic Control and fill all the blanks
4-Click Register button and validate the message "Registration is Successful"
5-GO to the Window handle practice page and validate Header  which is Window Handles Practice
6- go to the alertsDemo page and click  the "Click Me" button under prompt box
7-quit all the pages.
8-Proud of yourself
 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement button4=driver.findElement(By.cssSelector("#newTabsBtn"));
        BrowserUtils.scrollWithJS(driver,button4);

        button4.click();


        BrowserUtils.switchByTitle(driver,"Basic Controls - H Y R Tutorials");

        WebElement firstName=driver.findElement(By.xpath("//input[@id='firstName']"));
        firstName.sendKeys("Alexa");

        WebElement LastName= driver.findElement(By.xpath("//input[@id='lastName']"));
        BrowserUtils.scrollWithJS(driver,LastName);
        LastName.sendKeys("Belkin");
        Thread.sleep(500);
        WebElement female= driver.findElement(By.cssSelector("#femalerb"));
        female.click();

        WebElement language= driver.findElement(By.cssSelector("#englishchbx"));
        language.click();

        WebElement email= driver.findElement(By.cssSelector("#email"));
        email.sendKeys("alexa@gmail.com");
        Thread.sleep(2000);

        WebElement password=driver.findElement(By.cssSelector("#password"));
        password.sendKeys("122334");

        WebElement register=driver.findElement(By.cssSelector("#registerbtn"));
        BrowserUtils.clickWithJS(driver,register);

        WebElement msg= driver.findElement(By.xpath("//label[@id='msg']"));
        Assert.assertEquals(BrowserUtils.getText(msg),"Registration is Successful");

        BrowserUtils.switchByTitle(driver,"Window Handles Practice - H Y R Tutorials");

        WebElement header=driver.findElement(By.xpath("//h1[@itemprop='name']"));
        Assert.assertEquals(BrowserUtils.getText(header),"Window Handles Practice");
        Thread.sleep(2000);
        BrowserUtils.switchByTitle(driver,"AlertsDemo - H Y R Tutorials");

        WebElement click= driver.findElement(By.xpath("//button[@id='promptBox']"));

        BrowserUtils.clickWithJS(driver,click);
        driver.quit();









    }

}
