package tests.TestNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("The name of the test case success is: " + iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
    System.out.println("The name of the test case failed is: " + iTestResult.getName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println(iTestContext.getName() + " test case started");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
