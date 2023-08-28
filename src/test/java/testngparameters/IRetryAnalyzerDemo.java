package testngparameters;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryAnalyzerDemo implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int maxCount = 2;

   public boolean retry(ITestResult var1){
       if (retryCount<maxCount){
           retryCount++;
           return true;
       }
       return false;
}

}
