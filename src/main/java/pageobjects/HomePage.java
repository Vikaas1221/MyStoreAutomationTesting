package pageobjects;

import actiondriver.Action;
import Interfaces.ActionInterface;
import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass
{
    ActionInterface action=new Action();
    @FindBy(xpath = "//a[contains(text(),'Welcome')]")
    WebElement WelcomeText;


    public HomePage()
    {
        PageFactory.initElements(driver,this);
    }

    public String getWelcomeText()
    {
        return action.getText(WelcomeText);
    }
}
