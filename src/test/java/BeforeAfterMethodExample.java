import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeAfterMethodExample {

    WebDriver driver;//global scope

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
        System.out.println("test 1!!");
        driver.get("http://www.facebook.com");
    }

    @Test
    public void testcase2()  {
        System.out.println("test 2!!");
        driver.get("http://www.google.com");
    }

    @Test
    public void testcase3() {
        System.out.println("test 3!!");
        driver.get("http://www.yahoo.com");
    }

    @Test
    public void testcase4() {
        System.out.println("test 4!!");
        driver.get("http://www.google.com");
    }

    @AfterMethod
    public void aftertestcase(){
        System.out.println("after method annotation runs after the successful execution of test method.");
        driver.close();
    }
}
