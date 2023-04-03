package com.test.blaze.tests;

import com.test.blaze.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ConfigReader;

import java.time.Duration;

public class OrderTest extends TestBaseBlaze{
    private Object customerInfo;

    @DataProvider(name = "customerInfo")
    public Object[][] getData(){
        return new Object[][]{
                {"Alexa","Turkey","Ankara","1223434","12","2025"},
                {"John","USA","Chicago","123453242","5","2026"},
                {"Phuong Pak","Vietnam","Siylong","9876678990","12","2027"}

        };
    }

    @Test(dataProvider = "customerInfo")
    public void OrderValidation(String name,String country,String city,String creditCard,String month,String year ) throws InterruptedException {
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
        orderPage.validationOrder(name,country,city, creditCard,month,year,"Thank you for your purchase!",driver);


    }


}
