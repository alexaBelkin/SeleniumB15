package TestNG;

import org.testng.annotations.*;

public class TestNGAnnotations {
    @BeforeSuite//it will run before everything--> clear the cookies and caches
    public void beforeSuite(){
        System.out.println("I am beforeSuite");
    }
    @BeforeTest
    public void beforeTest(){

    }

    @BeforeClass//it runs before every class and people use to launch their browser driver=DriverHelper.getDriver()
    public void beforeClass(){
        System.out.println("I am beforeClass annotation");
    }

    @BeforeMethod// it runs before every test and its good to you for setting up your automation(TestBase class)
    public void beforeMethod(){
        System.out.println("I am before MethodAnnotation");
    }

    @Test
    public void test(){
        System.out.println("I am testAnnotation");
    }
    @Test//it executes the codes
    public void test1(){
        System.out.println("I am second testAnnotation");
    }

    @AfterMethod//it runs after every test annotation and it is good use for screenshot and quit your driver
    public void afterMethod(){
        System.out.println("I am after method");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("I am after class annotation");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("I am after TEST annotation");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("I am after suite annotation");
    }
}
