package MentoringWithAhmet.bank.tests;

import MentoringWithAhmet.bank.pages.AccauntPage;
import MentoringWithAhmet.bank.pages.CustomerPage;
import MentoringWithAhmet.bank.pages.HomePage;
import org.testng.annotations.Test;

public class TestCustomer extends Setup {

    @Test
    public void test1(){
        HomePage homePage=new HomePage(driver);
        homePage.customerLoginClick();

        CustomerPage customerPage=new CustomerPage(driver);
        customerPage.selectUser("Harry Potter");

        AccauntPage accauntPage=new AccauntPage(driver);
        accauntPage.accauntValidation("Welcome Harry Potter !!","500","Deposit Successful",
                "200","Transaction successful");

    }
}
