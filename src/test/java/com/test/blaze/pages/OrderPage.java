package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class OrderPage {
    public OrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    @FindBy(css = "#name")
    WebElement name1;

    @FindBy(css = "#country")
    WebElement country1;

    @FindBy(css = "#city")
    WebElement city1;

    @FindBy(css = "#card")
    WebElement cardNumber1;

    @FindBy(css = "#month")
    WebElement month1;

    @FindBy(css = "#year")
    WebElement year1;
    @FindBy(xpath = "//button[contains(text(),'Purchase')]")
    WebElement putchaseButton1;
    @FindBy(xpath = "//button[contains(text(),'OK')]")
    WebElement alertOk;

    @FindBy(xpath = "//h2[contains(text(),'Thank you for your purchase!')]")
    WebElement purchaseMessage;

    public void validationOrder(String name,String country,String city,String card,String month,String year,String expected,WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        name1.sendKeys(name);country1.sendKeys(country);city1.sendKeys(city);
        cardNumber1.sendKeys(card);month1.sendKeys(month);year1.sendKeys(year);
        Thread.sleep(1000);
        putchaseButton1.click();

        Assert.assertEquals(BrowserUtils.getText(purchaseMessage),expected);
        Thread.sleep(1000);
        alertOk.click();
        Assert.assertEquals(driver.getTitle(),"STORE");
    }

}
