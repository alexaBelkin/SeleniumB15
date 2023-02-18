package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDriverMethods {
    //driver.get
    //driver.manage.windows.maximize()
    //driver.getTitle
    //driver.getcurrentUrl()
    //driver.nabigateTo()
    //driver.pageSource()
    //driver.navigate.refresh
    //driver.navigate.forward()
    //driver.navigate.back()
    //driver.close()

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com/");
        System.out.println(driver.getTitle());
        driver.get("https://www.youtube.com/");
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);
        driver.navigate().back();//google
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        //System.out.println(driver.getPageSource());// giving you HTML structure of page
        driver.close();





    }
}
