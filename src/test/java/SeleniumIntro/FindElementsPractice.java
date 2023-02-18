package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindElementsPractice {
    //printout all links
    //print out only links with length more then = 12

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/");
        List<WebElement> elementList=driver.findElements(By.tagName("li"));
        int counter=0;
        for(WebElement element:elementList){

            System.out.println(element.getText().trim());
            counter++;
        }
        System.out.println(counter);


        int counter1=0;
        for(WebElement element:elementList){
            if(element.getText().length()>=12) {
                System.out.println(element.getText().trim());
                counter1++;
            }
        }
        System.out.println("second counter= "+counter1);


    }

}
