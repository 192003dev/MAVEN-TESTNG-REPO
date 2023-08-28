package demo;

import org.testng.annotations.Test;

public class demo {
    @Test(groups = {"smoke"})
    public void t1(){
        System.out.println("t1!!");
    }
}
