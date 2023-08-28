package testngparameters;

import org.testng.Assert;
import org.testng.annotations.Test;

//@Listeners(IAnnotationTransformerDemo.class)
public class DemoListener extends testngparameters.Test {

    //test-passed
    @Test//(retryAnalyzer = IRetryAnalyzerDemo.class)
    public void m1(){
        System.out.println("m1 method");
    }

    //test-failed
    @Test//class-level applying a listener(retryAnalyzer = IRetryAnalyzerDemo.class)
    public void m2(){
        System.out.println("m2 method");
        Assert.assertTrue(false);
    }

    //test-blocked/skipped
    @Test(enabled = false)
    public void m3(){
        System.out.println("m3 method");
    }

    //test-passed
    @Test
    public void m4(){
        System.out.println("m4 method");
    }
}
