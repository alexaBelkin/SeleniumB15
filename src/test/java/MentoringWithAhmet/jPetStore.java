package MentoringWithAhmet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class jPetStore {
    /*
1-Navigate to the website "https://petstore.octoperf.com/actions/Catalog.action"
2-Choose one category and put the product_id and name as a map format(Only one of the category) then print out
3-Go to the main menu and choose 2 different category and choose one item from there
4-Add them into the card
5-Validate the total cost equals to the price at the bottom shows.
6-Quit

 */

    @Test
    public void practice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://petstore.octoperf.com/actions/Catalog.action");

        driver.findElement(By.xpath("//area[@alt='Cats']")).click();
        List<WebElement> listOfCatsId=driver.findElements(By.xpath("//tr//a"));
        List<WebElement> listOfCatsKeys=driver.findElements(By.xpath("//tr//td"));
        HashMap<String,String> mapListOfCats=new HashMap<>();
        List<String> busket=new ArrayList<>();
        for (int i = 1; i < listOfCatsKeys.size() ; i+=2) {
            busket.add(listOfCatsKeys.get(i).getText());
        }
        for (int i = 0; i < listOfCatsId.size(); i++) {
            mapListOfCats.put(listOfCatsId.get(i).getText(),busket.get(i));
        }
        System.out.println(mapListOfCats);

        Thread.sleep(1000);
        driver.findElement(By.linkText("FL-DSH-01")).click();

        driver.findElement(By.xpath("//td[contains(text(),'Tailless')]//..//td[5]//a")).click();
        driver.navigate().back();
        driver.findElement(By.linkText("FL-DLH-02")).click();
        driver.findElement(By.xpath("//td[contains(text(),'Adult Male')]//..//td[5]//a")).click();



    }
}
