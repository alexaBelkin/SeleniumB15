package com.test.sentrifugo.tests;

import com.test.sentrifugo.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class LoginTest {
    @Test
    public void validateSuccesfullLogin(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://demo.sentrifugo.com/index.php/");
        LoginPage loginPage=new LoginPage(driver);// for pageFactory to initialize your elements
        loginPage.login("EM01","sentrifugo");
        Assert.assertTrue(driver.getCurrentUrl().endsWith("welcome"));
        //usually for validation we use getTitle but at this time we need to use getCurrentUrl because titles are the same
    }
    @Test
    public void validateNegativeLogin1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://demo.sentrifugo.com/index.php/");
        LoginPage loginPage=new LoginPage(driver);// for pageFactory to initialize your elements
        loginPage.login("Alexa","sentrifugo");
        Assert.assertEquals(loginPage.validateErrorMessage(),"The username or password you entered is incorrect.");
        Assert.assertEquals(loginPage.validateColorOfErrorMessage().trim(),"rgba(255, 0, 0, 1)");

    }

}
