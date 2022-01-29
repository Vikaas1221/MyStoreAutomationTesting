package actiondriver;

import base.BaseClass;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action extends BaseClass implements ActionInterface
{

    @Override
    public void click(WebElement element)
    {
        try {
            waitForButtonToBeClickable(element,Integer.parseInt(prop.getProperty("pageLoadTimeout")));
            element.click();
        }
        catch (ElementClickInterceptedException e1)
        {
            try {
                JavaScriptClick(element);
            }
            catch (Exception e11)
            {
                e11.printStackTrace();
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }

    @Override
    public void JavaScriptClick(WebElement element)
    {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",element);
    }

    @Override
    public void waitForButtonToBeClickable(WebElement element,int timeout)
    {
        waitForElementToBeVisible(element,timeout);
        WebDriverWait wait=new WebDriverWait(driver,timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    @Override
    public void waitForElementToBeVisible(WebElement element,int timeout)
    {
        new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOf(element));
    }

    @Override
    public void waitForElementToBeVisible(WebElement element) {
        new WebDriverWait(driver,Integer.parseInt(prop.getProperty("pageLoadTimeout"))).until(ExpectedConditions.visibilityOf(element));
    }

    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }

    @Override
    public String currentPageURL() {
        return driver.getCurrentUrl();
    }

    @Override
    public void enterText(WebElement element, String text) {
        try {
            waitForElementToBeVisible(element,20);
            element.sendKeys(text);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public String getText(WebElement element) {
            waitForElementToBeVisible(element);
            return element.getText();
    }

    @Override
    public String getAttribute(WebElement element, String attribute) {
        waitForElementToBeVisible(element);
        return element.getAttribute(attribute);
    }

    @Override
    public void openBrowser() {
        launchBrowser();
    }

    @Override
    public void closeBrowser() {
        driver.quit();
    }

}
