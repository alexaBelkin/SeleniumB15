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

public class DragDrop {
    @Test
    public void DragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");

        WebElement cookies=driver.findElement(By.xpath("//button[.='Accept Cookies']"));
        Thread.sleep(2000);
        cookies.click();
        WebElement orangeBox=driver.findElement(By.xpath("//div[@class='test2']"));
        String actualMessege= BrowserUtils.getText(orangeBox);
        String expected="... Or here.";
        Assert.assertEquals(actualMessege,expected);
        Thread.sleep(1000);
        String actualColorBox=orangeBox.getCssValue("background-color");
        String expectedColor="rgba(238, 111, 11, 1)";
        Assert.assertEquals(actualColorBox,expectedColor);

        WebElement dragger=driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions=new Actions(driver);
        actions.scrollByAmount(300,300);
        actions.dragAndDrop(dragger,orangeBox).perform();

        Thread.sleep(3000);
        orangeBox=driver.findElement(By.xpath("//div[@class='test2']"));
        String ActualMessageAfterDragandDrop=BrowserUtils.getText(orangeBox);
        String expectedMessage="You did great!";
        Assert.assertEquals(ActualMessageAfterDragandDrop,expectedMessage);






    }
    @Test
    public void ClickAndHold() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");

        WebElement cookies=driver.findElement(By.xpath("//button[.='Accept Cookies']"));
        Thread.sleep(2000);
        cookies.click();
        WebElement blueBox= driver.findElement(By.xpath("//div[@class='test1']"));
        String actualMessageBlueBox=BrowserUtils.getText(blueBox);
        String expectedMessaheBlue="Drag the small circle here ...";
        Assert.assertEquals(actualMessageBlueBox,expectedMessaheBlue);


        Thread.sleep(1000);
        String actualColorBox=blueBox.getCssValue("background-color");
        String expectedColor="rgba(63, 81, 181, 1)";
        Assert.assertEquals(actualColorBox,expectedColor);

        WebElement draggable=driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(draggable).moveToElement(blueBox).release().perform();

        blueBox= driver.findElement(By.xpath("//div[@class='test1']"));
        String actualMessageAfterClick=BrowserUtils.getText(blueBox);
        String expectedAfterClick="You did great!";
        Assert.assertEquals(actualMessageAfterClick,expectedAfterClick);




    }
}
