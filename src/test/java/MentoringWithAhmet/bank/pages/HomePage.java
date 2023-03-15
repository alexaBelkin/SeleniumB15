package MentoringWithAhmet.bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement customerLoginButton;

    public void customerLoginClick(){
        customerLoginButton.click();
    }
}
