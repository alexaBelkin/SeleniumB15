package JavaScriptExecutor;

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

public class JavaScriptMethods {


    @Test
    public void getTitle(){

        //We use Java Script methods when Selenium methods are not working
        //as expected.Spesifically,click,getTitle
        //NOTE: We love using ScrollintoView method from JAvaScript in professional enviroment

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techtorialacademy.com/");

        System.out.println(driver.getTitle() + " this is regular way to get title");
        JavascriptExecutor js= (JavascriptExecutor) driver;//your driver is acting like JS executor
        String title=js.executeScript("return document.title").toString();
        System.out.println(title+ " This is JavaScript method for title");

    }

    @Test
    public void clickJS(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/radio-button");

        WebElement radioClick= driver.findElement(By.xpath("//input[@id='yesRadio']"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",radioClick);

        WebElement message= driver.findElement(By.cssSelector(".mt-3"));
        String actual= BrowserUtils.getText(message);
        String expected="You have selected Yes";
        Assert.assertEquals(actual,expected);

        WebElement impressiveButton= driver.findElement(By.cssSelector("#impressiveRadio"));
        js.executeScript("arguments[0].click()",impressiveButton);
        String actualImoprMes=BrowserUtils.getText(message);
        String expectedImpr="You have selected Impressive";
        Assert.assertEquals(actualImoprMes,expectedImpr);


    }

    //this one is all about scrolling the page based on the location of element

    @Test
    public void scroll() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techtorialacademy.com/");
        WebElement findCourse=driver.findElement(By.xpath("//span[contains(text(),'Find')]"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",findCourse);//***
        Thread.sleep(2000);
        js.executeScript("arguments[0].click()",findCourse);//**
        System.out.println(js.executeScript("return document.title"));//*




    }

    @Test
    public void shortCutJSmethods() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techtorialacademy.com/");
        WebElement findCourse=driver.findElement(By.xpath("//span[contains(text(),'Find')]"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        Thread.sleep(2000);
        BrowserUtils.scrollWithJS(driver,findCourse);
        BrowserUtils.clickWithJS(driver,findCourse);
        System.out.println(BrowserUtils.getTitleWithJS(driver));
        driver.quit();


    }
}
