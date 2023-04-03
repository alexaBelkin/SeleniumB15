package com.test.sauceDemo.test;

import com.test.sauceDemo.pages.SauceLoginPage;
import com.test.sauceDemo.pages.SauceProductPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class SauceProductTest extends SauceDemoBase{


    @Test(dataProvider = "productLinkTesting",dataProviderClass = AllData.class)
    public void validateAllProducts(String productNAme,String productInfo,String expectedPrice){
        SauceLoginPage sauceLoginPage=new SauceLoginPage(driver);
        sauceLoginPage.loginPositive(ConfigReader.readProperty("QA_username"),
                ConfigReader.readProperty("QA_password"));
        SauceProductPage sauceProductPage=new SauceProductPage(driver);
        sauceProductPage.validateProductFromAll(productNAme,productInfo,expectedPrice);

    }
}
