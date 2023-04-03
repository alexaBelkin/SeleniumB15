package com.test.sauceDemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class SauceProductPage {
    public SauceProductPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    @FindBy(css = ".inventory_item_name")
    List<WebElement> allProducts;
    @FindBy(xpath = "//div[@class='inventory_details_price']/preceding-sibling::div[1]")
    WebElement productInfo;
    @FindBy(xpath = "//div[@class='inventory_details_price']")
    WebElement productPrice;
    @FindBy(xpath = "//div[@class='inventory_details_desc_container']//div[1]")
    WebElement productName1;
    @FindBy(xpath = "//button[contains(text(),'Add to cart')]")
    WebElement addToCartButton;
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement cartButton;
    @FindBy(css="#checkout")
    WebElement checkOutButton;
    @FindBy(css = "#first-name")
    WebElement firstName;
    @FindBy(css = "#last-name")
    WebElement lastName;
    @FindBy(css = "#postal-code")
    WebElement postalCode;
    @FindBy(css = "#continue")
    WebElement contunueButton;
    @FindBy(css = "#finish")
    WebElement finishButton;
    @FindBy(tagName = "h2")
    WebElement header;



    public void validateProductFromAll(String productName,String containsWord,String Price){
        for(WebElement product:allProducts){
            if(BrowserUtils.getText(product).equalsIgnoreCase(productName)){
                product.click();
                break;
            }

        }
        Assert.assertTrue(BrowserUtils.getText(productInfo).contains(containsWord));
        Assert.assertEquals(BrowserUtils.getText(productPrice),Price);

    }
    public void validateOrder(String productName,String price,String firstNAme,String lastNAme,String zipcode,String expectedHeader) throws InterruptedException {
        for(WebElement product:allProducts){
            if(BrowserUtils.getText(product).equalsIgnoreCase(productName)){
                product.click();
                break;

            }
        }
        Assert.assertEquals(BrowserUtils.getText(productName1),productName);
        Assert.assertEquals(BrowserUtils.getText(productPrice),price);
        addToCartButton.click();
        cartButton.click();
        checkOutButton.click();
        firstName.sendKeys(firstNAme);
        lastName.sendKeys(lastNAme);
        postalCode.sendKeys(zipcode);
        contunueButton.click();
        finishButton.click();
        Thread.sleep(2000);
        Assert.assertEquals(BrowserUtils.getText(header),expectedHeader);

    }

}
