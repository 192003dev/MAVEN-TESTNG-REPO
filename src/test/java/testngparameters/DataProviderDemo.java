package testngparameters;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class DataProviderDemo {
    WebDriver driver;//global scope
    @DataProvider(name = "data")
    public Object[][] dataProviderFunction(){
        return new Object[][]{{"selenium","pune"},{"selenium","nashik"}};
    }

    @Parameters({"browserName"})
    @BeforeMethod
    public void beforetestcase(String browserName){

        if (browserName.equals("chrome")){
            //opening chrome browser:-
            System.out.println("before method annotation runs before executing any test method!!");
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Users\\LENOVO\\Downloads\\chrome-win32\\chrome-win32\\chrome.exe");
            options.addArguments("--remote-allow-origin=*");
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
            driver = new ChromeDriver();
        }else if (browserName.equals("edge")){
            System.setProperty("webdriver.edge.driver","C:\\Users\\LENOVO\\Downloads\\edgedriver_win64\\msedgedriver.exe");
            driver = new EdgeDriver();
        }else {
            System.out.println("please select correct browser!!");
        }
    }

    @Test(dataProvider = "data")
    public void testcase1(String s1,String s2) throws InterruptedException {
        System.out.println("test 1!!");
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys(s1+" "+s2);
        element.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }

    @Test(dataProvider = "data")
    public void testcase2(String s1,String s2) throws InterruptedException {
        System.out.println("test 2!!");
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys(s1+" "+s2);
        element.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }

    @AfterMethod
    public void aftertestcase(){
        System.out.println("after method annotation runs after the successful execution of test method.");
        driver.close();
    }
}
