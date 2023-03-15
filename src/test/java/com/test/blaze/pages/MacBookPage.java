package com.test.blaze.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class MacBookPage {

    public MacBookPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(tagName = "h2")
    WebElement macBookText;

    @FindBy(tagName = "h3")
    WebElement priceMacbook;

    @FindBy(xpath = "//div[@id='more-information']")
    WebElement description;

    @FindBy(xpath = "//a[contains(text(),'Add to cart')]")
    WebElement addCartClick;


    public void macbookValidation(String expectedHeader,String expectedPrice,String expectedDescr) throws InterruptedException {
        Assert.assertTrue(BrowserUtils.getText(macBookText).contains(expectedHeader));
        Assert.assertTrue(BrowserUtils.getText(priceMacbook).contains(expectedPrice));
        Assert.assertTrue(BrowserUtils.getText(description).contains(expectedDescr));

    }

    public void clickAddToCart(WebDriver driver,String expectedAlert) throws InterruptedException {
        addCartClick.click();
        Thread.sleep(1000);
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText().trim(),expectedAlert);
        alert.accept();
    }
}
