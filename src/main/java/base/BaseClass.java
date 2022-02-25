package base;

import com.aventstack.extentreports.ExtentReports;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utility.ExtentReportManager;


import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass
{
    //Read the properties file
    public static Properties prop;
    public static WebDriver driver;
    /*
    * @ReadPropertiesFile- It will read the data from the properties file
     */
    @BeforeSuite(groups = "sanity")
    public static void ReadPropertiesFile()
    {
        ExtentReportManager.configureExtentReport();
        try {
            prop=new Properties();
            FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"/configration/config.properties");
            prop.load(ip);
        }
        catch (Exception e)
        {
            System.out.println("Failed to read file due to exception: "+e.getMessage());
        }
    }
    @AfterSuite(groups = "sanity")
    public void SaveReport()
    {
        System.out.println("In After suite method");
        ExtentReportManager.saveExtentReport();
        System.out.println("After suite method exected");
    }
    public static void launchBrowser()
    {
        String browser=prop.getProperty("browser");
        if(browser.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("pageLoadTimeout")), TimeUnit.SECONDS);
            driver.get(prop.getProperty("url"));
        }
        else if (browser.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("pageLoadTimeout")), TimeUnit.SECONDS);
            driver.get(prop.getProperty("url"));
        }
        else if (browser.equalsIgnoreCase("ie"))
        {
            WebDriverManager.iedriver().setup();
            driver=new InternetExplorerDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("pageLoadTimeout")), TimeUnit.SECONDS);
            driver.get(prop.getProperty("url"));
        }
        else
        {
            System.out.println("Please provide the valid name of the browser in the properties file");
            return;
        }
    }


}
