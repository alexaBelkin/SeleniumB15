package com.test.bank.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class ManagerPage {
    public ManagerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    WebElement addCustomer;
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName1;
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement zipcode;
    @FindBy(xpath = "//form//button[contains(text(),'Add Customer')]")
    WebElement addCustomer2;
    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    WebElement openAccount;
    @FindBy(css = "#userSelect")
    WebElement select1;
    @FindBy(css="#currency")
    WebElement select2;
    @FindBy(xpath = "//button[contains(text(),'Process')]")
    WebElement processButton;
    @FindBy(xpath = "//button[contains(text(),'Customers')]")
    WebElement customersClick;
    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    WebElement searchCustomer;
    @FindBy(xpath = "//button[contains(text(),'Delete')]")
    WebElement deleteButton;
    @FindBy(xpath = "//tbody//tr[1]//td[@class='ng-binding']")
    List<WebElement> allInfo;



    public void clickAddCustomer(){
        addCustomer.click();
    }
    public void firstName(String name){
        firstName.sendKeys(name);
    }
    public void lastName(String lastName){
        lastName1.sendKeys(lastName);

    }
    public void postCode(String postCode){
        zipcode.sendKeys(postCode);

    }
    public void addCustomer2Click(){
        addCustomer2.click();
    }

    public void addCustomer2(WebDriver driver){

        Alert alert=driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("Customer added successfully"));
        alert.accept();
    }
    public void openAccountClick(){
        openAccount.click();
    }
    public void userSelect1(String fullName){
        Select select=new Select(select1);
        select.selectByVisibleText(fullName);
    }
    public void userSelect2(String value){
        Select select=new Select(select2);
        select.selectByValue(value);
    }
    public void processClick(){
        processButton.click();
    }
    public void alertProcess(WebDriver driver) throws InterruptedException {
        Alert alert=driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("Account created successfully"));
        alert.accept();
        Thread.sleep(1000);
    }
    public void customersClick() throws InterruptedException {

        customersClick.click();
    }
    public void searchCustomer(String lastName){
        searchCustomer.sendKeys(lastName);
    }
     public void validationAllInfo(String name,String lastname,String postCode){
        List<String> expected= Arrays.asList(name,lastname,postCode);
        for(int i=0;i< allInfo.size();i++){
            Assert.assertEquals(BrowserUtils.getText(allInfo.get(i)),expected.get(i));
        }

     }

    public void clickDelete(){
        deleteButton.click();
    }


}
