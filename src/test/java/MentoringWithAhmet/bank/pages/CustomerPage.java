package MentoringWithAhmet.bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomerPage {

    public CustomerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css="#userSelect")
    WebElement selectUser;
    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginButton;

    public void selectUser(String user){
        Select select=new Select(selectUser);
        select.selectByVisibleText(user);
        loginButton.click();

    }
}
