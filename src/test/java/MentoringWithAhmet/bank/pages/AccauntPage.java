package MentoringWithAhmet.bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class AccauntPage {
//    TASK: (might be homework it depends on your performance)
//
//            1-Click Customer Login
// 2-Find Harry Potter from the List
// 3-Click Login
// 4-Validate the "Welcome Your Harry Potter" from header
// 5-Click Deposit and put 500
//            6-Validate "Deposit Successful
//            7-Click Withdrawl and put 300
//            8-Validate "Transaction successful"
//            9-Get the balance from the Customer Page(200)
// 10-Click Transaction
// 11-get the 500 and 300 from the table and substract them
// 12-Validate balance from customer page amount(200) equals to transaction amount(500-300).
//            12-Quit the driver



    public AccauntPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[2]//strong[contains(text(),'Welcome')]")
    WebElement welcomeMessage;
    @FindBy(xpath = "//button[contains(text(),'Deposit')]")
    WebElement depositButton;
    @FindBy (xpath = "//input[@placeholder='amount']")
    WebElement inputMoney;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement depositMoneyButton;
    @FindBy(xpath = "//span[@ng-show='message']")
    WebElement messageDeposit;
    @FindBy(xpath = "//button[@ng-click='withdrawl()']")
    WebElement withdrowClick;
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement withDrawInput;
    @FindBy(xpath = "//span[@ng-show='message']")
    WebElement withdrowMessage;
    @FindBy(xpath = "//div[2]//div[2]//strong[2]")
    WebElement balance;
    @FindBy(xpath = "//button[contains(text(),'Transactions')]")
    WebElement transactionsClick;

    public void accauntValidation(String expectedHeader,String moneyIn,String expectedDepositMessage,String moneyOut,
                                  String expectedWithdrowMessage){
        Assert.assertEquals(BrowserUtils.getText(welcomeMessage),expectedHeader);
        depositButton.click();
        inputMoney.sendKeys(moneyIn);
        depositMoneyButton.click();
        Assert.assertEquals(BrowserUtils.getText(messageDeposit),expectedDepositMessage);
        withdrowClick.click();
        withDrawInput.sendKeys(moneyOut);
        Assert.assertEquals(BrowserUtils.getText(withdrowMessage),expectedWithdrowMessage);
        transactionsClick.click();





    }
}
