package SoftAssertPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SoftAssertIntro {
    public int getSum(int num1, int num2){
        return num1+num2;
    }
    @Test
    public void test(){
        Assert.assertEquals(getSum(1,5),6);
        System.out.println("test1");
        Assert.assertEquals(getSum(3,7),10);
        System.out.println("test2");
        Assert.assertEquals(getSum(5,9),14);
        System.out.println("test3");

    }

}
