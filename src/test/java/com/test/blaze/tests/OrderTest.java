package com.test.blaze.tests;

import com.test.blaze.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigReader;

import java.time.Duration;

public class OrderTest extends TestBaseBlaze{

    @Test
    public void OrderValidation() throws InterruptedException {
        MainPage mainPage=new MainPage(driver);
        mainPage.laptopClick();

        LaptopPage laptopPage=new LaptopPage(driver);
        laptopPage.listOfLaptops("MacBook Pro");

        MacBookPage macBookPage=new MacBookPage(driver);
        macBookPage.clickAddToCart(driver,"Product added");

        mainPage.cartClick();

        CartPage cartPage=new CartPage(driver);
        cartPage.validateCart("MacBook Pro","1100");
        cartPage.placeOrderClick();
        OrderPage orderPage=new OrderPage(driver);
        orderPage.validationOrder("Alexa","Turkey","Istanbul", ConfigReader.readProperty("card"),"march","1234","Thank you for your purchase!",driver);


    }


}
