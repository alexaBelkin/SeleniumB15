package com.test.bank.tests;

import com.test.bank.pages.LoginPage;
import com.test.bank.pages.ManagerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigReader;

import java.time.Duration;

public class ManagerTest {
    WebDriver driver;
    @BeforeMethod
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to(ConfigReader.readProperty("url"));

    }

    @Test
    public void managerTest() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        LoginPage loginPage=new LoginPage(driver);
        loginPage.clickBankManagerLogin();
//addCustomer

        ManagerPage managerPage=new ManagerPage(driver);
        managerPage.clickAddCustomer();
        managerPage.firstName("Alexa");
        managerPage.lastName("Belkin");
        managerPage.postCode("12345");
        managerPage.addCustomer2Click();
        managerPage.addCustomer2(driver);
//openAccaunt
        managerPage.openAccountClick();
        managerPage.userSelect1("Alexa Belkin");
        managerPage.userSelect2("Dollar");
        managerPage.processClick();
        Thread.sleep(1000);
        managerPage.alertProcess(driver);
//Customers
        managerPage.customersClick();
        managerPage.searchCustomer("Belkin");
        managerPage.validationAllInfo(ConfigReader.readProperty("name1"),ConfigReader.readProperty("lastname"),ConfigReader.readProperty("postcode"));
        managerPage.clickDelete();
        //driver.quit();
    }


    @Test
    public void managerTest1() throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.clickBankManagerLogin();
//addCustomer

        ManagerPage managerPage=new ManagerPage(driver);
        managerPage.clickAddCustomer();
        managerPage.firstName("Alexa");
        managerPage.lastName("Belkin");
        managerPage.postCode("12345");
        managerPage.addCustomer2Click();
        managerPage.addCustomer2(driver);
//openAccaunt
        managerPage.openAccountClick();
        managerPage.userSelect1("Alexa Belkin");
        managerPage.userSelect2("Dollar");
        managerPage.processClick();
        Thread.sleep(1000);
        managerPage.alertProcess(driver);
//Customers
//        managerPage.customersClick();
//        managerPage.searchCustomer("Belkin");
//        managerPage.validationAllInfo("Alexa","Belkin","12345");
//        managerPage.clickDelete();


    }
    @Test
    public void managerTest2() throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.clickBankManagerLogin();
//addCustomer

        ManagerPage managerPage=new ManagerPage(driver);
        managerPage.clickAddCustomer();
        managerPage.firstName("Alexa");
        managerPage.lastName("Belkin");
        managerPage.postCode("12345");
        managerPage.addCustomer2Click();
        managerPage.addCustomer2(driver);
//openAccaunt
        managerPage.openAccountClick();
        managerPage.userSelect1("Alexa Belkin");
        managerPage.userSelect2("Dollar");
        managerPage.processClick();
        Thread.sleep(1000);
        managerPage.alertProcess(driver);
//Customers
        managerPage.customersClick();
        managerPage.searchCustomer("Belkin");

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
