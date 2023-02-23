package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SelectBasics {

    //SELECT CLASS IS ALL ABOUT DROP DOWN
    @Test
    public void practiceSelect() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement dropdown= driver.findElement(By.linkText("Dropdown")); //a tag and text
        dropdown.click();
        //location of the box
        WebElement optionBox= driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select options=new Select(optionBox); //provide loaction of the box inside of Select object
        options.selectByValue("1");
        Thread.sleep(2000);
        options.selectByVisibleText("Option 2");//better to use it
        Thread.sleep(2000);
        options.selectByIndex(1);
        Thread.sleep(2000);
        System.out.println(options.getFirstSelectedOption().getText().trim());
        List<WebElement> allTheOptions=options.getOptions();
        List<String> expectedOptions= Arrays.asList("Please select an option","Option 1","Option 2");
        for(int i=0;i<allTheOptions.size();i++){
            Assert.assertEquals(allTheOptions.get(i).getText().trim(),expectedOptions.get(i));
        }




        driver.quit();

    }

}
