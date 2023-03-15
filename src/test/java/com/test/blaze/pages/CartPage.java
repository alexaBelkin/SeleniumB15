package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartPage {
    public CartPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath = "//tr//td")
    List<WebElement> validationInfo;

    @FindBy(xpath = "//button[contains(text(),'Place Order')]")
    WebElement placeOrder;

    public void placeOrderClick(){
        placeOrder.click();
    }

    public void validateCart(String name,String price){
        List<String> actual=new ArrayList<>();
        List<String> expected= Arrays.asList(name,price);

        for(int i=1;i<validationInfo.size()-1;i++){
            actual.add(BrowserUtils.getText(validationInfo.get(i)));
        }
        for (int i = 0; i < actual.size(); i++) {
            Assert.assertEquals(actual.get(i),expected.get(i));
        }
    }

}
