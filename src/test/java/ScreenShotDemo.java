import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class ScreenShotDemo {

        @Test
        public void verifyTakeAScreenShot() {
                ChromeOptions options = new ChromeOptions();
                options.setBinary("C:\\Users\\LENOVO\\Downloads\\chrome-win32\\chrome-win32\\chrome.exe");
                options.addArguments("--remote-allow-origin=*");
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
                WebDriver driver = new ChromeDriver();
                driver.get("https://www.amazon.in/");
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                try {
                        FileHandler.copy(screenshot, new File("C:\\Users\\LENOVO\\Desktop\\st\\images\\screenshot.jpeg"));
                } catch (Exception e) {
                        System.out.println(e);
                }
                driver.close();
        }
}
