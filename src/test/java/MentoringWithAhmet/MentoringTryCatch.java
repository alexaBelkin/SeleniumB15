package MentoringWithAhmet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class MentoringTryCatch {
    @Test
    public void practice() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://uitestpractice.com/Students/Index");

        WebElement clickNewButton= driver.findElement(By.linkText("Create New"));
        clickNewButton.click();
        Thread.sleep(1000);
        try{
            driver.navigate().refresh();
            clickNewButton.click();
        }catch(Exception a){};





    }
}
