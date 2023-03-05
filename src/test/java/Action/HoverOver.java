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
import java.util.*;

public class HoverOver {

    @Test
    public void validateNamesFromPictures() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/hovers");

        List<WebElement> users=driver.findElements(By.tagName("h5"));
        List<WebElement> images=driver.findElements(By.xpath("//div[@class='figure']//img"));
        List<String> actualNames=new ArrayList<>();
        List<String> expectedNAmes= Arrays.asList("name: user1","name: user2","name: user3");
        Actions actions=new Actions(driver);

        for(int i=0;i< users.size();i++){
            Thread.sleep(2000);
            actions.moveToElement(images.get(i)).perform(); //you are hover overing the pictures
            actualNames.add(BrowserUtils.getText(users.get(i)));
        }
        Assert.assertEquals(actualNames,expectedNAmes);

    }

    @Test
    public void practiceMove() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/fx/expand");

        WebElement cookies=driver.findElement(By.xpath("//button[.='Accept Cookies']"));
        Thread.sleep(2000);
        cookies.click();

        List<WebElement> names=driver.findElements(By.xpath("//div[@class='product-description']//h3"));
        List<WebElement> prices=driver.findElements(By.xpath("//div[@class='product-description']//p"));
        Map<String,String> mapList=new LinkedHashMap<>();

        List<WebElement> images=driver.findElements(By.xpath("//div[@role='listitem']//img"));
        Actions actions=new Actions(driver);
        actions.scrollByAmount(200,200);

        for(int i=0;i< names.size();i++){
            Thread.sleep(500);
            actions.moveToElement(images.get(i)).perform();
            mapList.put(BrowserUtils.getText(names.get(i)),BrowserUtils.getText(prices.get(i)));
        }
        System.out.println(mapList);


    }
}
