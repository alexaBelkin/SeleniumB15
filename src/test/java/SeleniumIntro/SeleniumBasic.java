package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasic {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();//new object
        driver.manage().window().maximize(); //maximaze the screen
        driver.get("https://www.amazon.com");//navigate to website
        System.out.println(driver.getTitle());//get the title
        String actualTitle= driver.getTitle();
        String expectedTitle="Amazon.com. Spend less. Smile more.";
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Your test is passed");
        }else{
            System.out.println("Your test is failed");
        }
        //driver.getCurrentUrl();
        driver.get("https://www.techtorialacademy.com/");
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.techtorialacademy.com/";
        String actTitle= driver.getTitle();
        String expectedTitleTech="Home";
        if(actualUrl.equals(expectedUrl)){
            System.out.println("url is passed");
        }else {
            System.out.println("URL failed");
        }
        if (actTitle.equals(expectedTitleTech)){
            System.out.println("title passed");
        }else{
            System.out.println("title is failed");
        }
        driver.close();


    }

}
