package MentoringWithAhmet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import javax.swing.*;
import java.time.Duration;

public class SprucelInterviewQuestion {

    ///*
    //1-Navigate to the website "https://www.thespruceeats.com/"
    //2-Under Ingredients option --> choose Fish&SeaFood option
    //3-ScrollDown to the search bar
    //4-Send the data: "Fish for dinner"
    //5-On the left side choose 4 star up option
    //6-From popular: Choose the Editor's choice option
    //7-Validate the name of product is "6-Ingredient Roasted Salmon Fillets"
    //8-Quit or close your driver
    // */

    @Test
    public void task1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.thespruceeats.com/");

        WebElement ingredients= driver.findElement(By.linkText("Ingredients"));
        Actions actions= new Actions(driver);
        actions.moveToElement(ingredients).perform();
        Thread.sleep(3000);
        WebElement fishSea= driver.findElement(By.xpath("//li[@class='global-nav__sub-list-item']//a[.='Fish & Seafood']"));
        BrowserUtils.clickWithJS(driver,fishSea);

        Thread.sleep(2000);
        WebElement searcjBox= driver.findElement(By.cssSelector(".search-form__input"));
        Thread.sleep(3000);
        BrowserUtils.scrollWithJS(driver,searcjBox);
        searcjBox.sendKeys("Fish for dinner");
        Thread.sleep(3000);
        searcjBox.sendKeys(Keys.ENTER);

        WebElement starts4= driver.findElement(By.cssSelector("#starRating_score_4Star"));
        BrowserUtils.clickWithJS(driver,starts4);

        Thread.sleep(2000);
        WebElement editors=driver.findElement(By.xpath("//input[@id='pop_search_editor']"));
        Thread.sleep(3000);
        BrowserUtils.clickWithJS(driver,editors);

        WebElement valid=driver.findElement(By.xpath("//span[@class='card__underline']"));
        Assert.assertEquals(BrowserUtils.getText(valid),"6-Ingredient Roasted Salmon Fillets");
        driver.quit();










    }

}
