package waitTimes;

public class ImplicitlyWait {

    //we use it under DriverHelper or @BeforeMethod
    //driver.manage.timeouts(ImplicitlyWait(Duration.ofSecond(9))
    //It will throw NOSUCHELEMENT exeption if it doesn't load
}
