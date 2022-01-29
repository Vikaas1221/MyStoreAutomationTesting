package pageobjects;

import actiondriver.Action;
import actiondriver.ActionInterface;
import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class IndexPage extends BaseClass
{
    ActionInterface action=new Action();
    @FindBy(xpath = "//a[@id='nava']")
    WebElement title;

    @FindBy(xpath = "//div[@id='navbarExample']//li")
    List<WebElement> navigationLinks;

    public IndexPage()
    {
        PageFactory.initElements(driver,this);
    }

    public String pageTitle()
    {
        return action.getText(title);
    }

    public List<String> links()
    {
        List<String> allLinks=new ArrayList<>();
        for(WebElement link:navigationLinks)
        {
            String style=action.getAttribute(link,"style");
            if(!style.equalsIgnoreCase("display:none"))
            {
                allLinks.add(action.getText(link));
            }
        }
        return allLinks;
    }
    public List<WebElement> clickableLink()
    {
        List<WebElement> allLinks=new ArrayList<>();
        for (WebElement link:navigationLinks)
        {
            String style=action.getAttribute(link,"style");
            if(!style.equalsIgnoreCase("display:none"))
            {
                allLinks.add(link);
            }
        }
        return allLinks;
    }
    public void clickOnLoginBtn()
    {
        action.click(clickableLink().get(4));
    }
    public void clickOnSignUpBtn()
    {
        action.click(clickableLink().get(5));
    }
    public void clickOnCartBtn()
    {
        action.click(clickableLink().get(3));
    }
    public void clickOnHomeBtn()
    {
        action.click(clickableLink().get(0));
    }

}
