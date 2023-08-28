import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethodsDemo {
    @Test
    public void testcase1(){
        System.out.println("test 1!!");
        Assert.assertFalse(true);
    }

    @Test(dependsOnMethods = "testcase1")
    public void testcase2(){
        System.out.println("test 2!!");
    }

    @Test(dependsOnMethods = "testcase2",alwaysRun = true)
    public void testcase3(){
        System.out.println("test 3!!");
    }

    @Test(expectedExceptions = {ArithmeticException.class},expectedExceptionsMessageRegExp = "10 divided by zero is always infinity.")
    public void testcase4(){
        System.out.println("test 4!!");
        System.out.println(10/0);
        System.out.println("exceptions above handled!!");
    }
}
