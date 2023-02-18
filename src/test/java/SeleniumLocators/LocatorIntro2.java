package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorIntro2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("file:///Users/alenanikolaeva/Downloads/Techtorialhtml.html");
        //linkText locator (a-tag)
        WebElement javalink= driver.findElement(By.linkText("Java")); //a tag with the text
        javalink.click();
        WebElement header= driver.findElement(By.tagName("h1"));
        System.out.println(header.getText().trim().equals("Java")?"Passed":"FAILED");
        driver.navigate().back();
        WebElement javalink1=driver.findElement(By.linkText("Selenium"));
        javalink1.click();
        WebElement header1= driver.findElement(By.tagName("h1"));
        System.out.println(header1.getText().trim().equals("Selenium automates browsers. That's it!")?"PASSED":"FAILED");
        driver.navigate().back();
        WebElement link= driver.findElement(By.linkText("Cucumber"));
        link.click();
        WebElement header2= driver.findElement(By.tagName("h1"));
        System.out.println(header2.getText().trim().equals("Tools & techniques that elevate teams to greatness")?"PASSED":"FAILED");
        driver.navigate().back();
        WebElement testNg= driver.findElement(By.linkText("TestNG"));
        testNg.click();
        WebElement header3= driver.findElement(By.tagName("h2"));
        System.out.println(header3.getText().trim().equals("TestNG")?"PASSED":"FAiled");
        driver.navigate().back();

        System.out.println(driver.getCurrentUrl().equals("file:///Users/alenanikolaeva/Downloads/Techtorialhtml.html")?"URL PASSED":"URL FAILED");

        //partial link text locator //must have a-tag and text (will work even with a few letters since its unique
        WebElement restApi= driver.findElement(By.partialLinkText("Rest"));
        restApi.click();
        System.out.println(driver.getCurrentUrl().trim().equals("https://rest-assured.io/")?"PASSED":"FAILED");
        driver.navigate().back();
        driver.close();








    }


}
