package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatorPractice {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");
        WebElement firstName= driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstName.sendKeys("Alena");
        WebElement lastName=driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Belkin");
        WebElement email= driver.findElement(By.xpath("//input[@id='input-email']"));
        email.sendKeys("alena.ni123333@ya.ru");
        WebElement telephone= driver.findElement(By.xpath("//input[@type='tel']"));
        telephone.sendKeys("7735107788");
        WebElement password= driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("TruckDriver123");
        WebElement password1= driver.findElement(By.xpath("//input[@id='input-confirm']"));
        password1.sendKeys("TruckDriver123");
        WebElement checkBox= driver.findElement(By.xpath("//input[@name='agree']"));
        checkBox.click();
        WebElement continueBot= driver.findElement(By.xpath("//input[@type='submit']"));
        continueBot.click();
        WebElement accountCreated= driver.findElement(By.xpath("//h1[contains(text(),'Your')]"));
        System.out.println(accountCreated.getText().trim().equals("Your Account Has Been Created!")?"PASSED":"FAiled");









    }

}
