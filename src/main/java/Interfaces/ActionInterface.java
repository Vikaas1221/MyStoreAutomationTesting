package Interfaces;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public interface ActionInterface
{
    void click(WebElement element);
    void JavaScriptClick(WebElement element);
    void waitForButtonToBeClickable(WebElement element,int timeout);
    void waitForElementToBeVisible(WebElement element,int timeout);
    void waitForElementToBeVisible(WebElement element);
    void sleep(int time);
    void scrollIntoView(WebElement element);
    String getPageTitle();
    String currentPageURL();
    void enterText(WebElement element,String text);
    String getText(WebElement element);
    String getAttribute(WebElement element,String attribute);
    String getAlertMsg();
    String generateName();
    void openBrowser();
    void closeBrowser();
    String takeScreenshot();
}
