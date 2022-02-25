package utility;

import Interfaces.ActionInterface;
import actiondriver.Action;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class EventListner implements ITestListener
{
    ExtentTest extentTest;
    @Override
    public void onTestStart(ITestResult result) {
         //Execute before the test case start
        extentTest=ExtentReportManager.reports.createTest(result.getName());
        extentTest.log(Status.INFO,"Execution of Testcases started");
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.log(Status.SKIP,result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
      extentTest.log(Status.PASS,result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        String methodName=result.getMethod().getMethodName();
        if (result.getStatus()==ITestResult.FAILURE)
        {
            ActionInterface action = new Action();
            String exception= Arrays.toString(result.getThrowable().getStackTrace());
            extentTest.fail("Failed Method:"+methodName+"\n"+"Exception: "+exception);
            try {
                //In order to attach screenshot at the step where TC failed then we use MediaEntityBuilder
                extentTest.fail("Failed", MediaEntityBuilder.createScreenCaptureFromPath("./Screenshots/"+action.takeScreenshot()).build());
              //  extentTest.addScreenCaptureFromPath("./Screenshots/"+action.takeScreenshot());
            }
            catch (Exception e)
            {
                extentTest.fail("Cannot attached screenshot");
            }
        }

    }

    @Override
    public void onFinish(ITestContext context) {
        // Execute after suite execution finished
        System.out.println("On finish method");
    }

}
