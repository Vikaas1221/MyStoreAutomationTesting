package utility;

import Interfaces.ActionInterface;
import actiondriver.Action;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class EventListner implements ITestListener
{
    ExtentTest extentTest;

    @Override
    public void onTestStart(ITestResult result) {
        // Execute before the test case start
        extentTest=ExtentReportManager.reports.createTest(result.getName());
        extentTest.log(Status.INFO,"Extent test started");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.log(Status.SKIP,result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS,result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        ActionInterface action=new Action();
        extentTest.fail("Failed", MediaEntityBuilder.createScreenCaptureFromPath(action.takeScreenshot()).build());
    }

    @Override
    public void onFinish(ITestContext context) {
        // Execute after suite execution finished
        System.out.println("On finish method");
    }

}
