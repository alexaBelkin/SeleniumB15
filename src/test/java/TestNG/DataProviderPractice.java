package TestNG;

import jdk.jfr.DataAmount;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

    @DataProvider(name = "couples")
    public Object[][] getData(){


        return new Object[][]{
                {"Ahmet","Ayse"},
                {"Mr.M","Mr.S"},
                {"Ivana","Mr.Darko"},
                {"Gulmira","Mr.V"},
                {"Mr.B","Mr.Julianna"}
        };
    }


    @Test(dataProvider = "couples")
    public void test1(String firstCouple,String secondCouple){
        System.out.println(firstCouple+secondCouple);
    }
//    @Test
//    public void test2(){
//        System.out.println("Mr.M"+"Mr.S");
//    }
//    @Test
//    public void test3(){
//        System.out.println("Ivana"+"Mr.Darko");
//    }
//    @Test
//    public void test4(){
//        System.out.println("Gulmira"+"Mr.V");
//    }
//    @Test
//    public void test5(){
//        System.out.println("Mr.B"+"Mr.Julianna");
//    }
}
