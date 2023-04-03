package com.test.sauceDemo.test;

import com.test.sauceDemo.pages.SauceLoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class SauceLoginTest extends SauceDemoBase{

//   @DataProvider(name = "sauce_negative")
//   public Object[][] getSauceProvider(){
//       return new Object[][]{
//           {"standard_user","","Epic sadface: Password is required"},
//               {"","secret_sauce","Epic sadface: Username is required"},
//               {"Test123","Test123","Epic sadface: Username and password do not match any user in this service"}
//
//       };
//   }


    @Test
    public void validatePositiveLogin(){
        SauceLoginPage sauceLoginPage=new SauceLoginPage(driver);
        sauceLoginPage.loginPositive(ConfigReader.readProperty("QA_username"),
                ConfigReader.readProperty("QA_password"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }

    @Test(dataProvider = "sauce_negative",dataProviderClass = AllData.class)
    public void validateNegativeLogin(String username,String password,String errorMessage){
        SauceLoginPage sauceLoginPage=new SauceLoginPage(driver);
        sauceLoginPage.loginNegative(username,password,errorMessage);
    }
}
