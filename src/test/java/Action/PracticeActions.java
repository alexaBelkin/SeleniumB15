package Action;

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

public class PracticeActions {
    @Test
    public void validaeMessageAndColor(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/droppable");

        WebElement dragger=driver.findElement(By.cssSelector("#draggable"));
        Actions actions=new Actions(driver);

        WebElement dropBox= driver.findElement(By.xpath("//div[@class='simple-drop-container']//div[@id='droppable']"));
        actions.clickAndHold(dragger).moveToElement(dropBox).release().perform();

        dropBox= driver.findElement(By.xpath("//div[@class='simple-drop-container']//div[@id='droppable']"));

        String actualColor= dropBox.getCssValue("background-color");
        String expectedColor="rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualColor,expectedColor);

        String text=BrowserUtils.getText(dropBox);
        String expected="Dropped!";
        Assert.assertEquals(text,expected);
        driver.quit();

    }


    @Test
    public void ClickAndHold() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/droppable");

        WebElement accept=driver.findElement(By.xpath("//a[.='Accept']"));
        Thread.sleep(2000);
        accept.click();


        Thread.sleep(2000);
        WebElement noAcceptable= driver.findElement(By.cssSelector("#notAcceptable"));
        String text1=noAcceptable.getText().trim();
        String expected="Not Acceptable";

        Assert.assertEquals(text1,expected);


        WebElement dropBox= driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        String dropbBoxText=dropBox.getText().trim();
        String expected2="Drop here";
        Assert.assertEquals(dropbBoxText,expected2);

        Actions actions=new Actions(driver);
        Thread.sleep(2000);
        actions.clickAndHold(noAcceptable).moveToElement(dropBox).release().perform();

        //dropBox= driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        String dropBoxTextafterDrop=BrowserUtils.getText(dropBox);
        String expectedText="Drop here";
        Assert.assertEquals(dropBoxTextafterDrop,expectedText);
        driver.quit();



    }
}
