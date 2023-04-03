package com.test.sauceDemo.pages;

import com.test.sauceDemo.test.SauceDemoBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class SauceLoginPage {
    public SauceLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#user-name")
    WebElement username;
    @FindBy(css = "#password")
    WebElement password;
    @FindBy(css = "#login-button")
    WebElement loginButton;
    @FindBy(tagName = "h3")
    WebElement message;

    public void loginPositive(String name,String password){
        this.username.sendKeys(name);
        this.password.sendKeys(password);
        loginButton.click();


    }
    public void loginNegative(String name,String password,String expectedMessage){
      this.username.sendKeys(name);
      this.password.sendKeys(password);
      loginButton.click();
        Assert.assertEquals(BrowserUtils.getText(message),expectedMessage);

    }
}


