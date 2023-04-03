package waitTimes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.DriverHelper;

public class FluentWait {
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
    }
}
