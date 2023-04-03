package waitTimes;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.DriverHelper;

import java.time.Duration;

public class FluentlyWait {
    WebDriver driver;
    @Test
    public void fluentWaitTest(){
        driver= DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement dynamicControls= driver.findElement(By.linkText("Dynamic Controls"));
        dynamicControls.click();
        WebElement checkBox= driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkBox.click();
        WebElement removeButton= driver.findElement(By.xpath("//button[contains(text(),'Remove')]"));
        removeButton.click();

        Wait<WebDriver> fluentWait=new FluentWait<>(driver)//polymorphism
                 .pollingEvery(Duration.ofSeconds(3))
                .withMessage("Text is not on the Page")
                .withTimeout(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class);
        WebElement message=fluentWait.until(mydriver->driver.findElement(By.xpath("//p[@id='message']")));
        Assert.assertEquals(BrowserUtils.getText(message),"It's gone!");

    }
}
