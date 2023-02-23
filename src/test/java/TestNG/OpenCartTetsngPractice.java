package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OpenCartTetsngPractice {
    @Test
    public void successfulLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.opencart.com/admin/");
        WebElement login = driver.findElement(By.xpath("//input[@id='input-username']"));
        login.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement clickButton = driver.findElement(By.xpath("//button[@type='submit']"));
        clickButton.click();
        Thread.sleep(2000);
        String tittleActual = driver.getTitle().trim();
        String expectedTitle = "Dashboard";
        Assert.assertEquals(tittleActual, expectedTitle);

    }

    @Test
    public void negativeLogin() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.opencart.com/admin/");
        WebElement login = driver.findElement(By.xpath("//input[@id='input-username']"));
        login.sendKeys("alexa");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("belkin");
        WebElement clickButton = driver.findElement(By.xpath("//button[@type='submit']"));
        clickButton.click();
        WebElement error = driver.findElement(By.xpath("//div[@id = 'alert']"));
        String actual = error.getText().trim();
        String expected = " No match for Username and/or Password.".trim();
        //Assert.assertFalse(false,expected);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void productValidation() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.opencart.com/admin/");
        WebElement login = driver.findElement(By.xpath("//input[@id='input-username']"));
        login.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement clickButton = driver.findElement(By.xpath("//button[@type='submit']"));
        clickButton.click();
        Thread.sleep(2000);
        WebElement closeButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeButton.click();
        WebElement catalog = driver.findElement(By.xpath("//li[@id='menu-catalog']"));
        catalog.click();
        Thread.sleep(2000);
        WebElement products = driver.findElement(By.xpath("//a[contains(text(),'Produ')]"));
        Assert.assertTrue(products.isDisplayed());

    }

    @Test
    public void validateBoxesFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.opencart.com/admin/");
        WebElement login = driver.findElement(By.xpath("//input[@id='input-username']"));
        login.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement clickButton = driver.findElement(By.xpath("//button[@type='submit']"));
        clickButton.click();
        Thread.sleep(2000);
        WebElement closeButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeButton.click();
        WebElement catalog = driver.findElement(By.xpath("//li[@id='menu-catalog']"));
        catalog.click();
        Thread.sleep(2000);
        WebElement products = driver.findElement(By.xpath("//a[contains(text(),'Produ')]"));
        products.click();
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (int i = 1; i < checkboxes.size(); i++) {
            Assert.assertTrue(checkboxes.get(i).isDisplayed());
            Assert.assertTrue(checkboxes.get(i).isEnabled());
            checkboxes.get(i).click();
            Thread.sleep(1000);
            Assert.assertTrue(checkboxes.get(i).isSelected());
            checkboxes.get(i).sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(1000);
        }

    }

    @Test
    public void validationProductNameFunc() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.opencart.com/admin/");
        WebElement login = driver.findElement(By.xpath("//input[@id='input-username']"));
        login.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement clickButton = driver.findElement(By.xpath("//button[@type='submit']"));
        clickButton.click();
        Thread.sleep(2000);
        WebElement closeButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeButton.click();
        WebElement catalog = driver.findElement(By.xpath("//li[@id='menu-catalog']"));
        catalog.click();
        Thread.sleep(2000);
        WebElement products = driver.findElement(By.xpath("//a[contains(text(),'Produ')]"));
        products.click();
        WebElement productNamesClick = driver.findElement(By.cssSelector(".asc"));
        productNamesClick.click();
        Thread.sleep(2000);
        List<WebElement> allElements = driver.findElements(By.xpath("//td[@class='text-start']"));
        List<String> actualList = new ArrayList<>();
        List<String> expected = new ArrayList<>();

        for (int i = 1; i < allElements.size(); i++) {
            actualList.add(allElements.get(i).getText().toLowerCase().trim());//mostly for cmparison like asc,desc(to upper or lower case)
            expected.add(allElements.get(i).getText().toLowerCase().trim());
        }
        Collections.sort(expected);//sorting for ascending
        Collections.reverse(expected);//making guarantee it is descending order
        System.out.println(expected);
        System.out.println(actualList);
        Assert.assertEquals(actualList, expected);


    }

    @Test
    public void validateProductName() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.opencart.com/admin/");
        WebElement login=driver.findElement(By.xpath("//input[@id='input-username']"));
        login.sendKeys("demo");
        WebElement password=driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");
        WebElement clickButton= driver.findElement(By.xpath("//button[@type='submit']"));
        clickButton.click();
        Thread.sleep(2000);
        WebElement closeButton=driver.findElement(By.xpath("//button[@class='btn-close']"));
        closeButton.click();
        WebElement catalog=driver.findElement(By.xpath("//li[@id='menu-catalog']"));
        catalog.click();
        Thread.sleep(2000);
        WebElement products=driver.findElement(By.xpath("//a[contains(text(),'Produ')]"));
        products.click();
        Thread.sleep(2000);
        List<WebElement> actualList=driver.findElements(By.xpath("//td[@class='text-start']"));
        List<String> expectedList=new ArrayList<>();

        List<String> actualElementList=new ArrayList<>();
        for(int i=1;i<actualList.size();i++){
            actualElementList.add(actualList.get(i).getText().toLowerCase().trim());
            expectedList.add(actualList.get(i).getText().toLowerCase().trim());
        }
        Collections.sort(actualElementList);
        Assert.assertEquals(expectedList,actualElementList);

    }

}
