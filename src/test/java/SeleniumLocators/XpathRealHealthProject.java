package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathRealHealthProject {
    public static void main(String[] args) throws InterruptedException {
         /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your command for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Validate the header is "Appointment confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.
          */
      System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver= new ChromeDriver();
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        WebElement appt= driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        appt.click();
        WebElement userName=driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("John Doe");
        WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("ThisIsNotAPassword");
        WebElement loginButton= driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement element=driver.findElement(By.xpath("//option[@value='Tokyo CURA Healthcare Center']"));
        element.click();
        WebElement element1= driver.findElement(By.xpath("//label[@class='checkbox-inline']"));
        element1.click();
        WebElement element2= driver.findElement(By.xpath("//input[@value='Medicaid']"));
        element2.click();
        WebElement date= driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        date.sendKeys("02/19/2023");
        WebElement comment= driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
        comment.sendKeys("I made an appt");
        WebElement bookEl=driver.findElement(By.xpath("//button[@type='submit']"));
        bookEl.click();
        WebElement apptC= driver.findElement(By.xpath("//h2[contains(text(),'App')]"));
        System.out.println(apptC.getText().trim().equals("Appointment Confirmation")?"PAssed":"Failed");

        WebElement el1=driver.findElement(By.xpath("//p[contains(text(),'Tokyo')]"));
        System.out.println(el1.getText());
        WebElement el2=driver.findElement(By.xpath("//p[contains(text(),'Yes')]"));
        System.out.println(el2.getText());
        WebElement el3=driver.findElement(By.xpath("//p[contains(text(),'Med')]"));
        System.out.println(el3.getText());
        WebElement el4=driver.findElement(By.xpath("//p[contains(text(),'02/')]"));
        System.out.println(el4.getText());
        WebElement el5=driver.findElement(By.xpath("//p[contains(text(),'I made')]"));
        System.out.println(el5.getText());
        WebElement goHome= driver.findElement(By.xpath("//a[contains(text(),'Go')]"));
        goHome.click();
        Thread.sleep(4000);
        System.out.println(driver.getCurrentUrl());
        driver.close();


    }
}
