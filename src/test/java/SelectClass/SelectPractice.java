package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectPractice {
    @Test
    public void ValidateFirstOptionAndPrintAllOptions() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("file:///Users/alenanikolaeva/Downloads/Techtorialhtml.html");
        WebElement optionbox= driver.findElement(By.xpath("//select[@name='country']"));
        optionbox.click();
        Select select=new Select(optionbox);
        String selected= select.getFirstSelectedOption().getText().trim();
        String expected="UNITED STATES";
        Assert.assertEquals(selected,expected);

        List<WebElement> alloptions=select.getOptions();
        int counter=0;
        for(int i=0;i<alloptions.size();i++){ //you can also use for each loop
            System.out.println(alloptions.get(i).getText());
            counter++;
        }
        System.out.println(counter);
        //index value //value //value text
        select.selectByValue("22");// bolivia
        Thread.sleep(3000);
        select.selectByIndex(56);//egeept
        Thread.sleep(3000);
        select.selectByVisibleText("RUSSIA ");
        Thread.sleep(3000);


    }

    @Test
    public void multiSelect(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("file:///Users/alenanikolaeva/Downloads/Techtorialhtml.html");
        WebElement countryBox=driver.findElement(By.cssSelector(".select"));
        Select country=new Select(countryBox);
        country.selectByVisibleText("One");



    }

    @Test
    public void validateOrderMessage() throws InterruptedException {
        /*
1-Navigate to the website
2-Select one way trip button
3-Choose 4 passangers(1 wife-1 husband-2 kids)
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message at the top.There is a bug here/
 "After flight finder - No Seats Avaialble"

 NOTE:Your test should fail and say available is not matching with Available.
 NOTE2:You can use any select method value,visibleText
 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement oneway= driver.findElement(By.xpath("//input[@value='roundtrip']"));
        oneway.click();
        WebElement passengers=driver.findElement(By.xpath("//select[@name='passCount']"));
        Select selectPass=new Select(passengers);
        selectPass.selectByValue("4");
        WebElement departing= driver.findElement(By.xpath("//select[@name='toPort']"));
        Select selectDeparting=new Select(departing);
        String defaultDepart = selectDeparting.getFirstSelectedOption().getText();
        String expected="Acapulco";
        Assert.assertEquals(defaultDepart,expected);
        selectDeparting.selectByVisibleText("Paris");
        WebElement departMonth= driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select monthDep=new Select(departMonth);
        monthDep.selectByValue("8");
        WebElement dayDep=driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select daySelect=new Select(dayDep);
        daySelect.selectByValue("15");
        Thread.sleep(2000);
        WebElement arrival=driver.findElement(By.xpath("//select[@name='toPort']"));
        Select arrivalSelect=new Select(arrival);
        arrivalSelect.selectByVisibleText("San Francisco ");
        WebElement arrivalMonth=driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select MonthSelect=new Select(arrivalMonth);
        Thread.sleep(2000);
        MonthSelect.selectByValue("12");
        WebElement arrivalDay=driver.findElement(By.xpath("//select[@name='toDay']"));
        Select arrDaySelect=new Select(arrivalDay);
        arrDaySelect.selectByValue("15");
        WebElement firstClass=driver.findElement(By.xpath("//input[@value='First']"));
        Thread.sleep(2000);
        firstClass.click();
        WebElement airlineCarrierBox= driver.findElement(By.xpath("//select[@name='airline']"));
        Select airlineSelect=new Select(airlineCarrierBox);
        List<WebElement> allAirline=airlineSelect.getOptions();
        List<String> expectedList= Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");
        for(int i=0;i<allAirline.size();i++){
            Assert.assertEquals(allAirline.get(i).getText(),expectedList.get(i));
        }
        airlineSelect.selectByVisibleText("Unified Airlines");
        WebElement contClick= driver.findElement(By.xpath("//input[@name='findFlights']"));
        Thread.sleep(2000);
        contClick.click();
        WebElement validText= driver.findElement(By.xpath("//font[@size='4']"));
        String actualText=validText.getText().trim();
        String expectText="After flight finder - No Seats Avaialble";
        Thread.sleep(2000);
        Assert.assertEquals(actualText,expectText);
        driver.quit();



    }



    @Test
    public void shortCutsSelectClass() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement oneway= driver.findElement(By.xpath("//input[@value='roundtrip']"));
        oneway.click();
        WebElement passengers=driver.findElement(By.xpath("//select[@name='passCount']"));
        BrowserUtils.selectBy(passengers,"4","text");
        WebElement departing= driver.findElement(By.xpath("//select[@name='toPort']"));
        Select selectDeparting=new Select(departing);
        String defaultDepart = selectDeparting.getFirstSelectedOption().getText();
        String expected="Acapulco";
        Assert.assertEquals(defaultDepart,expected);
        selectDeparting.selectByVisibleText("Paris");
        WebElement departMonth= driver.findElement(By.xpath("//select[@name='fromMonth']"));
        BrowserUtils.selectBy(departMonth,"August","text");
        WebElement dayDep=driver.findElement(By.xpath("//select[@name='fromDay']"));
        BrowserUtils.selectBy(dayDep,"15","text");
        Thread.sleep(2000);
        WebElement arrival=driver.findElement(By.xpath("//select[@name='toPort']"));
        BrowserUtils.selectBy(arrival,"San Francisco ","text");
        WebElement arrivalMonth=driver.findElement(By.xpath("//select[@name='toMonth']"));
        BrowserUtils.selectBy(arrivalMonth,"December","text");
        Thread.sleep(2000);

        WebElement arrivalDay=driver.findElement(By.xpath("//select[@name='toDay']"));
        BrowserUtils.selectBy(arrivalDay,"15","text");
        WebElement firstClass=driver.findElement(By.xpath("//input[@value='First']"));

        Thread.sleep(2000);
        firstClass.click();
        WebElement airlineCarrierBox= driver.findElement(By.xpath("//select[@name='airline']"));
        Select airlineSelect=new Select(airlineCarrierBox);
        List<WebElement> allAirline=airlineSelect.getOptions();
        List<String> expectedList= Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");
        for(int i=0;i<allAirline.size();i++){
            Assert.assertEquals(allAirline.get(i).getText(),expectedList.get(i));
        }
        airlineSelect.selectByVisibleText("Unified Airlines");
        WebElement contClick= driver.findElement(By.xpath("//input[@name='findFlights']"));
        Thread.sleep(2000);
        contClick.click();
        WebElement validText= driver.findElement(By.xpath("//font[@size='4']"));
        String actualText=validText.getText().trim();
        String expectText="After flight finder - No Seats Avaialble";
        Thread.sleep(2000);
        Assert.assertEquals(actualText,expectText);
        driver.quit();

    }
}
