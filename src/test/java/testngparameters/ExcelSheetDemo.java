package testngparameters;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelSheetDemo {
    WebDriver driver;//global scope

    @BeforeMethod
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\LENOVO\\Downloads\\chrome-win32\\chrome-win32\\chrome.exe");
        options.addArguments("--remote-allow-origin=*");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @DataProvider(name = "excel-data")
    public Object[][] ExcelSheetDataProvider() throws IOException {
        /*we are creating an object from the excel sheet data by calling a
        * method that reads from the excel stored locally in our system.*/
     Object[][] arrObj = getExcelData(System.getProperty("user.dir")+"/src/ExcelData/Batch4.xlsx","TestData");
     return  arrObj;
    }

    /*This method handles the excel-opens it and reads the data from the
    * respective cells using a for-loop and returns it in the form of a string
    * array.*/
    public String[][] getExcelData(String fileName,String sheetName){
        String[][] data = null;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sh = wb.getSheet(sheetName);
            XSSFRow row = sh.getRow(0);
            int noOfRows = sh.getPhysicalNumberOfRows();
            int noOfCols = row.getLastCellNum();
            Cell cell;
            data = new String[noOfRows-1][noOfCols];

            for (int i=1;i<noOfRows;i++){
                for (int j=0;j<noOfCols;j++){
                    row = sh.getRow(i);
                    cell = row.getCell(j);
                    data[i-1][j] = cell.getStringCellValue();
                }
            }
        }catch (Exception e){
            System.out.println("The testng exception is: "+e.getMessage());
        }
        return data;
    }

    @Test(dataProvider = "excel-data")
    public void search(String s1,String s2) throws InterruptedException {
        driver.get("http://www.google.com");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys(s1+" "+s2);
        element.sendKeys(Keys.ENTER);
      //  Reporter.log("Keywords entered are:"+" "+s1+" "+s2);
        Thread.sleep(3000);
      //  Reporter.log("Search results are displayed!!");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
