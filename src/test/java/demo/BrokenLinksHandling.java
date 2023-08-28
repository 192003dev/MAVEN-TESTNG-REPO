package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BrokenLinksHandling {
    public static void main(String[] args) throws InterruptedException{
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\LENOVO\\Downloads\\chrome-win32\\chrome-win32\\chrome.exe");
        options.addArguments("--remote-allow-origin=*");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        Thread.sleep(3000);
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        List<String> urlList = new ArrayList<>();
        for (WebElement e : links){
            String url = e.getAttribute("href");
            urlList.add(url);
            //checkBrokenLinks(url);
        }
        //lambda expression
        urlList.parallelStream().forEach(e-> {
            try {
                checkBrokenLinks(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        driver.close();
    }

   public static void checkBrokenLinks(String linkUrl) throws IOException {
       URL url = new URL(linkUrl);
       HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
       httpURLConnection.connect();
       if (httpURLConnection.getResponseCode() >= 400) {
           System.out.println(linkUrl+"--------------------------"+httpURLConnection.getResponseMessage()+"link is broken");
       }
       else {
           System.out.println(linkUrl+"--------------------------"+httpURLConnection.getResponseMessage());
       }
       }

   }

