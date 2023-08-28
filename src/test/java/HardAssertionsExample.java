import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

public class HardAssertionsExample {
    WebDriver driver;//global scope

    //for generating extent report:-
    ExtentReports reports = new ExtentReports();

    //for capturing events during test:-
    ExtentSparkReporter sparkReporter = new ExtentSparkReporter("EveningReport.html");

    //for each test:-
    ExtentTest test;

    @BeforeTest
    public void beforeTestAnnot(){
        reports.attachReporter(sparkReporter);
    }

    @BeforeMethod
    public void beforetestcase(){
        System.out.println("before method annotation runs before executing any test method!!");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\LENOVO\\Downloads\\chrome-win32\\chrome-win32\\chrome.exe");
        options.addArguments("--remote-allow-origin=*");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testcase1()  {
        test = reports.createTest("Launch the browser!!").assignAuthor("yash").assignDevice("chrome");
        System.out.println("test 1!!");
        driver.get("http://www.google.com");
        String title = driver.getTitle();
        System.out.println(title);
        //here hard-assert(default) passes so test case executes normally.
        Assert.assertEquals(title,"Google");
        test.pass("test is passed!!");//status
    }

    @Test
    public void testcase2()  {
        test = reports.createTest("Launch the browser!!").assignAuthor("varsha").assignDevice("edge");
        System.out.println("test 2!!");
        driver.get("http://www.google.com");
        String title = driver.getTitle();
        System.out.println(title);
        test.fail("test is failed!!");
        //here hard-assert(default) fails so test case executes normally.
        Assert.assertEquals(title,"google","title of the page is not same/matches");
        System.out.println("assert failed!!");
    }

    @Test
    public void testcase3() {
        test = reports.createTest("Launch the browser!!").assignAuthor("ambika").assignDevice("safari");
        System.out.println("test 3!!");
        driver.get("http://www.google.com");
        String title = driver.getTitle();
        System.out.println(title);
        //here hard-assert(default) passes so test case executes normally.
        Assert.assertNotEquals(title,"google");
        test.pass("test is passed!!");
    }

    @Test
    public void testcase4() {
        test = reports.createTest("Launch the browser!!").assignAuthor("deepika").assignDevice("opera");
        System.out.println("test 4!!");
        driver.get("http://www.google.com");
        String title = driver.getTitle();
        System.out.println(title);
        test.fail("test is failed!!");
        //here hard-assert(default) fails so test case executes normally.
        Assert.assertNotEquals(title,"Google","title of the page is same/matches");
    }

    @AfterMethod
    public void aftertestcase(){
        System.out.println("after method annotation runs after the successful execution of test method.");
        driver.close();
    }

    @AfterTest
    public void afterTestAnnot(){
        reports.flush();
    }
}
