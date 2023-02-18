package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CSSlocators {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.etsy.com/?utm_source=bing&utm_medium=cpc&utm_term=etsy_e&utm_campaign=Search_US_Brand_BNG_ENG_General-Brand_Core_All_Exact&utm_ag=A1&utm_custom1=_k_40e034c81be9145bdd9057391690ff3a_k_&utm_content=bing_131876476_2730742026_81638813116376_kwd-38923007297:loc-190_c_&utm_custom2=131876476&msclkid=40e034c81be9145bdd9057391690ff3a");
//        WebElement searchBox= driver.findElement(By.cssSelector("#global-enhancements-search-query"));
//        searchBox.sendKeys("Watch", Keys.ENTER);
//        System.out.println(driver.getTitle().trim());
        WebElement searchBoxWithclass= driver.findElement(By.cssSelector(".wt-input"));
        searchBoxWithclass.sendKeys("Watch",Keys.ENTER);





    }
}
