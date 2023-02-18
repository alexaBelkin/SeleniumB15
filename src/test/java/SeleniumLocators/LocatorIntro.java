package SeleniumLocators;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorIntro {
    //ID locator
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("file:///Users/alenanikolaeva/Downloads/Techtorialhtml.html");
        WebElement header= driver.findElement(By.id("techtorial1"));
        String actualHeader=header.getText().trim();//techtorial academy
        String expectedHeader="Techtorial Academy";
        System.out.println(actualHeader);
        System.out.println(actualHeader.equals(expectedHeader)? "passed":"failed");
        WebElement paragraph=driver.findElement(By.id("details2"));
        String elementText=paragraph.getText();
        System.out.println(elementText);

        WebElement firstName= driver.findElement(By.name("firstName"));
        firstName.sendKeys("Alexa");
        WebElement lastName=driver.findElement(By.name("lastName"));
        lastName.sendKeys("Belkin");
        WebElement phone= driver.findElement(By.name("phone"));
        phone.sendKeys("7735108588");
        WebElement email=driver.findElement(By.name("userName"));
        email.sendKeys("alexa@gmail.com");
        WebElement address=driver.findElement(By.name("address1"));
        address.sendKeys("4546 forth abe");
        WebElement address1=driver.findElement(By.name("address2"));
        address1.sendKeys("sodovoe kolzo");
        WebElement city= driver.findElement(By.name("city"));
        city.sendKeys("Chicago");
        WebElement state=driver.findElement(By.name("state"));
        state.sendKeys("IL");
        WebElement zipcode=driver.findElement(By.name("postalCode"));

        zipcode.sendKeys("788709");

        //class LOCATOR:
        WebElement checkboxLabel=driver.findElement(By.className("checkboxes"));
        System.out.println(checkboxLabel.getText());
        WebElement javaBox=driver.findElement(By.id("cond1"));
        if(javaBox.isDisplayed()&&!javaBox.isSelected()){
            javaBox.click();
        }
        WebElement testIng=driver.findElement(By.id("cond3"));
        if(testIng.isDisplayed()&&!testIng.isSelected()){
            testIng.click();
        }
        WebElement cucmnerBox= driver.findElement(By.id("cond4"));
        if (cucmnerBox.isDisplayed()&&!cucmnerBox.isSelected()){
            cucmnerBox.click();
        }
        //TAG NAME LOCATOR:
        WebElement version=driver.findElement(By.tagName("u"));
        String actualVersion=version.getText().trim();
        String expectedVersion="Use Java Version";
        if(actualVersion.equals(expectedVersion)){
            System.out.println("Validation is passed");
        }else{
            System.out.println("Validation is failed");
        }






    }

}
