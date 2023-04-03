package waitTimes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.DriverHelper;

import java.time.Duration;

public class ExplicitlyWait {
    WebDriver driver;

    @Test
    public void validateText(){
        driver= DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement dynamicLoading= driver.findElement(By.xpath("//a[contains(text(),'Dynamic Loading')]"));
        dynamicLoading.click();
        WebElement example1= driver.findElement(By.xpath("//a[contains(text(),'Example 1')]"));
        example1.click();
        WebElement startClick= driver.findElement(By.tagName("button"));
        startClick.click();
        WebElement text= driver.findElement(By.cssSelector("#finish"));
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        text=wait.until(ExpectedConditions.visibilityOf(text));

        Assert.assertEquals(BrowserUtils.getText(text),"Hello World!");

    }
    @Test
    public void validateText2(){
        driver= DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement dynamicControls= driver.findElement(By.linkText("Dynamic Controls"));
        dynamicControls.click();
        WebElement checkBox= driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkBox.click();
        WebElement removeButton= driver.findElement(By.xpath("//button[contains(text(),'Remove')]"));
        removeButton.click();
        WebElement message= driver.findElement(By.cssSelector("#message"));
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        message=wait.until(ExpectedConditions.visibilityOf(message));
        Assert.assertEquals(BrowserUtils.getText(message),"It's gone!");
    }
}
