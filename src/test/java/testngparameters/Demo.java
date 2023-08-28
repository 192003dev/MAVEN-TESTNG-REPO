package testngparameters;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo {
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

    @Parameters({"s1"})
    @Test
    public void testcase1(String s1) throws InterruptedException {
        System.out.println("test 1!!");
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys(s1);
        element.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }

    @Parameters({"s2"})
    @Test
    public void testcase2(String s2) throws InterruptedException {
        System.out.println("test 2!!");
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys(s2);
        element.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }

    @AfterMethod
    public void aftertestcase(){
        System.out.println("after method annotation runs after the successful execution of test method.");
        driver.close();
    }
}
