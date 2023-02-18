package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class YoutubeRealInterviewQuestion {
/* 1-Navigate to the website youtube
 2-Search for justin bieber
 3-Find the all song names and store in the list Justin Bieber - Hold On (Live from Paris)
 4-Use for and if conditions to find the song
 5-Click the song
 6-Enjoy your music
 7-Ready to be level 2
 */


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.youtube.com/");
        WebElement search= driver.findElement(By.xpath("//input[@id='search']"));
        search.sendKeys("justin bieber");
//        WebElement clickSearch=driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
//        clickSearch.click();
        search.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        List<WebElement> videoElements=driver.findElements(By.xpath("//a[@id='video-title']"));
        for(WebElement video:videoElements){

            video.sendKeys(Keys.ARROW_DOWN);
            video.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(200);

            if(video.getAttribute("title").trim().equals("Justin Bieber - Ghost")){
                video.click();
                break;
            }

        }





    }
}
