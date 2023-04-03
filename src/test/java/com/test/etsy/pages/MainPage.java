package com.test.etsy.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class MainPage {
    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@placeholder='Search for anything']")
    WebElement searchBox;
    @FindBy(xpath = "//a//h3")
    List<WebElement> allOptions;

    public void validationSearch(String searchText){
        searchBox.sendKeys(searchText, Keys.ENTER);}


    public void textValidate(String phone,String numberPhone,String casePhone){

        for (WebElement header:allOptions) {
            String word=BrowserUtils.getText(header).toLowerCase();
            Assert.assertTrue(word.contains(phone)||word.contains(numberPhone)||
                    word.contains(casePhone));
        }
    }


    }


