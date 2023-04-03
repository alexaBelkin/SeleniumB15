package com.test.sauceDemo.test;

import org.testng.annotations.DataProvider;

public class AllData {

    @DataProvider(name = "sauce_negative")
    public Object[][] getSauceProvider(){
        return new Object[][]{
                {"standard_user","","Epic sadface: Password is required"},
                {"","secret_sauce","Epic sadface: Username is required"},
                {"Test123","Test123","Epic sadface: Username and password do not match any user in this service"}
        };
    }
    @DataProvider(name = "productLinkTesting")
    public Object[][] getProductsProvider(){
        return new Object[][]{
                {"Sauce Labs Backpack","Sly Pack","$29.99"},
                {"Sauce Labs Bike Light","3 lighting modes","$9.99"},
                {"Sauce Labs Bolt T-Shirt","From American Apparel","$15.99"},
                {"Sauce Labs Fleece Jacket","quarter-zip fleece","$49.99"},
                {"Sauce Labs Onesie","3-snap bottom closure","$7.99"},
                {"Test.allTheThings() T-Shirt (Red)","Super-soft and comfy","$15.99"}
        };
    }

    @DataProvider(name = "orderData")
    public Object[][] getCartProvider(){
        return new Object[][]{
                //productName,productPrice,firstName,lastName,zipcode,header
                {"Sauce Labs Backpack","$29.99","Don","Don","12345","Thank you for your order!"},
                {"Sauce Labs Bike Light","$9.99","Don","Don","12345","Thank you for your order!"},
                {"Sauce Labs Bolt T-Shirt","$15.99","Don","Don","12345","Thank you for your order!"},
                {"Sauce Labs Fleece Jacket","$49.99","Don","Don","12345","Thank you for your order!"},
                {"Sauce Labs Onesie","$7.99","Don","Don","12345","Thank you for your order!"},
                {"Test.allTheThings() T-Shirt (Red)","$15.99","Don","Don","12345","Thank you for your order!"}
        };
    }
}
