package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class DreamCar {
    @Test
    public void validate() throws InterruptedException {
        /*
NOTE: Please use browser utils for the select classes if it is needed.
1-Navigate to the website https://www.cars.com/
2-Choose the "New Cars" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.60056
8-Click Search Button
9-Validate the header "New Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX 350

     */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.cars.com/");
        WebElement clickNew=driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowserUtils.selectBy(clickNew,"New","text");
        WebElement makeClick=driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(makeClick,"Lexus","text");
        WebElement modelClick=driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(modelClick,"  RX 350","text");
        WebElement noPrice=driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        Select noPriceSelect=new Select(noPrice);

        noPriceSelect.getFirstSelectedOption();

        Assert.assertTrue(noPriceSelect.getFirstSelectedOption().isSelected());
        WebElement distance= driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(distance,"40 miles","text");
        WebElement zipcode=driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipcode.sendKeys(Keys.CLEAR); //zipcode.clear
        Thread.sleep(2000);
        zipcode.sendKeys("60067");
        WebElement searchButton=driver.findElement(By.xpath("//button[@data-linkname='search-new-make']"));
        searchButton.click();
        WebElement header= driver.findElement(By.tagName("h1"));
        String headerString= header.getText().trim();
        String expected="New Lexus RX 350 for sale";
        Assert.assertEquals(headerString,expected);
        WebElement sortClick=driver.findElement(By.cssSelector("#sort-dropdown"));
        Thread.sleep(2000);
        BrowserUtils.selectBy(sortClick,"Lowest price","text");
        List<WebElement> allTitles=driver.findElements(By.xpath("//h2[@class='title']"));

        for(WebElement title:allTitles){
            Assert.assertTrue(BrowserUtils.getText(title).contains("Lexus RX 350"));
        }
        List<String> numbers= Arrays.asList("1","2","3");
        List<Integer> numbers2=Arrays.asList(1,3,2);


        driver.quit();




    }
}
