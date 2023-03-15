package com.test.bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement bankManagerLogin;
    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement customerLogin;

    public void clickBankManagerLogin(){
        bankManagerLogin.click();
    }
    public void clickCustomerLogin(){
        customerLogin.click();
    }
}

