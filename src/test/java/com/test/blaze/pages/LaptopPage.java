package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class LaptopPage {

    public LaptopPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h4//a")
    List<WebElement> allLaptops;

    public void listOfLaptops(String expected){

        for(int i=0;i< allLaptops.size();i++){
            if(BrowserUtils.getText(allLaptops.get(i)).equals(expected)){
                allLaptops.get(i).click();
                break;
            }

        }
    }
}
