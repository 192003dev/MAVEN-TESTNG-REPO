import org.testng.annotations.Test;

public class AlphabeticalTestCaseOrder {
    //how by default the test scripts/methods are executed
    //=>most of the times it is executed in alphabetical order/numeric order.

    @Test(priority = 1,enabled = false)//lowest value always gets highest priority
    public void A(){
        System.out.println("A method!!");
        System.out.println(10/0);
    }

    @Test(priority = 9,invocationCount = 5,invocationTimeOut = 15)//highest value always gets lowest priority
    public void C(){
        System.out.println("C method!!");
    }

    @Test(priority = 8,description = "this is a E method!!")
    public void E(){
        System.out.println("E method!!");
    }

    @Test(priority = 5)
    public void D(){
        System.out.println("D method!!");
    }

    @Test(priority = 7)
    public void B(){
        System.out.println("B method!!");
    }

    @Test(priority = 6)
    public void L1(){
        System.out.println("L1 method!!");
    }

    @Test(priority = 3)
    public void L4(){
        System.out.println("L4 method!!");
    }

    @Test(priority = 4)
    public void L2(){
        System.out.println("L2 method!!");
    }

    @Test(priority = 2)
    public void L3(){
        System.out.println("L3 method!!");
    }

}
