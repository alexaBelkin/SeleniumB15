package com.test.etsy.tests;

import com.test.etsy.pages.MainPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class MainTest extends TestBaseEtsy {

    @Parameters({"text","phone","generation","case"})
    @Test
    public void searchButtonValid(String textForSearch,String phone,String year,String word3){
        MainPage mainPage=new MainPage(driver);
        mainPage.validationSearch(textForSearch);
        mainPage.textValidate(phone,year,word3);

    }
}
