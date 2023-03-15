package MentoringWithAhmet.bank.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverHelper;

public class Setup {

    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= DriverHelper.getDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

//    @AfterMethod
//    public void tearsDown(){
//        driver.quit();
//    }
}
