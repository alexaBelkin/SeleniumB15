package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathLocator {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement abTesting= driver.findElement(By.linkText("A/B Testing"));
        abTesting.click();
        WebElement paragraph=driver.findElement(By.xpath("/html/body/div[2]/div/div/p"));
        System.out.println(paragraph.getText().trim());
        WebElement elementalSel= driver.findElement(By.xpath("//a[contains(text(),'Elemental Selenium')]"));
        WebElement elementalSel2= driver.findElement(By.xpath("//a[.='Elemental Selenium']"));
        Thread.sleep(3000);

        System.out.println(elementalSel.getText().trim());
        elementalSel2.click();


    }



}
