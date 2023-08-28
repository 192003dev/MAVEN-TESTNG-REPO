package testngparameters;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//to access the methods for listeners press ctrl+click on listener name
//for multi-cursor you need to press alt+j

public class Test implements ITestListener {
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure");
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped");
    }

    public void onStart(ITestContext context) {
        System.out.println("onStart");
    }

    public void onFinish(ITestContext context) {
        System.out.println("onFinish");
    }

}
