package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.util.Properties;

public class BaseClass
{
    //Read the properties file
    public static Properties prop;
    public static WebDriver driver;
    /*
    * @ReadPropertiesFile- It will read the data from the properties file
     */
    @BeforeSuite
    public static void ReadPropertiesFile()
    {
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
    public static void launchBrowser()
    {
        String browser=prop.getProperty("browser");
        if(browser.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("ie"))
        {
            WebDriverManager.iedriver().setup();
            driver=new InternetExplorerDriver();
        }
        else
        {
            System.out.println("Please provide the valid name of the browser in the properties file");
            return;
        }
    }
}
