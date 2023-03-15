package com.test.blaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MainPage {

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath = "//a[contains(text(),'Laptops')]")
    WebElement laptopClick;

    @FindBy(css = "#cartur")
    WebElement cart;



    public void laptopClick(){
        laptopClick.click();
    }
    public void cartClick(){
        cart.click();
    }


}

