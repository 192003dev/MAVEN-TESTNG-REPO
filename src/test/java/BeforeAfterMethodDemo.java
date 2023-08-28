import org.testng.annotations.*;

public class BeforeAfterMethodDemo {

    @BeforeClass
    public void beforeall(){
        System.out.println("before class annotation runs always first ");
    }

    @BeforeMethod
    public void beforetestcase(){
        System.out.println("before method annotation runs before executing any test method!!");
    }

    @Test(groups = {"smoke"})
    public void testcase1(){
        System.out.println("test 1!!");
    }

    @Test(groups = {"sanity"})
    public void testcase2(){
        System.out.println("test 2!!");
    }

    @Test(dependsOnGroups = "smoke")
    public void testcase3(){
        System.out.println("test 3!!");
    }

    @Test
    public void testcase4(){
        System.out.println("test 4!!");
    }

    @AfterMethod
    public void aftertestcase(){
        System.out.println("after method annotation runs after the successful execution of test method.");
    }

    @AfterClass
    public void afterall(){
        System.out.println("after class annotation runs at the very end.");
    }
}
