package MentoringKuba;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LambaTest {

    WebDriver driver;

    @BeforeTest
    public void setUp(){
       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.get("https://www.lambdatest.com/selenium-playground/");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void ValidateEmailAndName_TC_01() throws InterruptedException {

        driver.findElement(By.xpath("//a[contains(text(),'Table Pagination')]")).click();
        WebElement selectMyRows= driver.findElement(By.xpath("//select[@id='maxRows']"));
        BrowserUtils.selectBy(selectMyRows,"5000","value");


        //we are storing our data-names in a list
        Thread.sleep(2000);
        List<WebElement> names=driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> emails=driver.findElements(By.xpath("//tr//td[3]"));
        List<WebElement> allNumbers=driver.findElements(By.xpath("//tr//td[4]"));

        for (int i=0;i<names.size();i++){
            Map<String,String> map=new HashMap<>();
            map.put(names.get(i).getText(),emails.get(i).getText());
            System.out.println(map);
        }
        for (int i = 0; i <allNumbers.size() ; i++) {
            Map<String,String> map=new HashMap<>();
            map.put(emails.get(i).getText(),allNumbers.get(i).getText().replace("-",""));
            System.out.println(map);

        }

    }

}
