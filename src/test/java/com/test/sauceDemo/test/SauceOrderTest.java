package com.test.sauceDemo.test;

import com.test.sauceDemo.pages.SauceLoginPage;
import com.test.sauceDemo.pages.SauceProductPage;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class SauceOrderTest extends SauceDemoBase{

    @Test(dataProvider = "orderData",dataProviderClass = AllData.class)
    public void orderValidation(String productName,String productPrice,String firstName,String lastName,String zipcode,String header) throws InterruptedException {
        SauceLoginPage sauceLoginPage=new SauceLoginPage(driver);
        sauceLoginPage.loginPositive(ConfigReader.readProperty("QA_username"),ConfigReader.readProperty("QA_password"));

        SauceProductPage sauceProductPage=new SauceProductPage(driver);
        sauceProductPage.validateOrder(productName,productPrice,firstName,lastName,zipcode,header);

    }


}
