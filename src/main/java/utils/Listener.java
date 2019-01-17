package utils;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.*;
import org.testng.annotations.Listeners;
import ui.initialDriver.InitialDriver;

@Listeners({Listener.class})

public class Listener  implements ITestListener, ISuiteListener, IInvokedMethodListener {

    @Override
    public void onStart(ISuite arg0) {
        if(!arg0.getName().contains("Default Suite"))
        {
            ExtentManager.getReporter(arg0.getName()).startTest(arg0.getName());}

    }

    // This belongs to ISuiteListener and will execute, once the Suite is finished

    @Override

    public void onFinish(ISuite arg0) {
        ExtentTestManager.endTest(arg0.getName());
        ExtentManager.getReporter(arg0.getName()).flush();

    }
    @Override
    // This belongs to ITestListener and will execute before starting of Test set/batch

    public void onStart(ITestContext arg0) {

    }
    @Override
    // This belongs to ITestListener and will execute, once the Test set/batch is finished

    public void onFinish(ITestContext arg0) {

    }
    @Override
    // This belongs to ITestListener and will execute only when the test is pass

    public void onTestSuccess(ITestResult arg0) {
        //Extentreports log operation for passed tests.
        ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
        InitialDriver.getInstance().destroy();

    }
    @Override
    // This belongs to ITestListener and will execute only on the event of fail test

    public void onTestFailure(ITestResult arg0) {
        new Screeen().getScreen();
        InitialDriver.getInstance().destroy();

    }
    @Override
    // This belongs to ITestListener and will execute before the main test start (@Test)

    public void onTestStart(ITestResult arg0) {
        //Start operation for extentreports.
        ExtentTestManager.startTest(arg0.getName(),"");
    }
    @Override
    // This belongs to ITestListener and will execute only if any of the main test(@Test) get skipped

    public void onTestSkipped(ITestResult arg0) {
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
        InitialDriver.getInstance().destroy();

    }
    @Override
    // This is just a piece of shit, ignore this

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

    }
}