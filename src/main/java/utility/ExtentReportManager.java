package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager
{
    public static ExtentReports reports;
    public static void configureExtentReport()
    {
        reports=new ExtentReports();
        ExtentSparkReporter sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"\\target\\StoreReport.html");
        sparkReporter.config().setReportName("Executed By: "+System.getProperty("user.name"));
        sparkReporter.config().setDocumentTitle("My Store Automation Test Report");
        reports.attachReporter(sparkReporter);
    }
    public static void saveExtentReport()
    {
        reports.flush();
    }

}
