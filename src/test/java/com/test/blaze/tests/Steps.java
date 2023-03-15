package com.test.blaze.tests;

import com.test.blaze.pages.LaptopPage;
import com.test.blaze.pages.MacBookPage;
import com.test.blaze.pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Steps extends TestBaseBlaze{


    @Test
    public void validation() throws InterruptedException {
        MainPage mainPage=new MainPage(driver);
        mainPage.laptopClick();

        LaptopPage laptopPage=new LaptopPage(driver);
        laptopPage.listOfLaptops("MacBook Pro");

        MacBookPage macBookPage=new MacBookPage(driver);
        macBookPage.macbookValidation("MacBook Pro","$1100 *includes tax","Product description");
        macBookPage.clickAddToCart(driver,"Product added");

    }
}
