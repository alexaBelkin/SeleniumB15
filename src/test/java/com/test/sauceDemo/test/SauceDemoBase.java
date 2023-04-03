package com.test.sauceDemo.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class SauceDemoBase {

    public WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver=DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("QA_sauceUrl"));
    }

    @AfterMethod
    public void tearsDown(){
        BrowserUtils.getScreenShot(driver,"sauceDemoScreenShot");
     //driver.quit();
    }

}
