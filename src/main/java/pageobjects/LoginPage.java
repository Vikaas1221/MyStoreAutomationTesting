package pageobjects;

import actiondriver.Action;
import Interfaces.ActionInterface;
import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass
{
    ActionInterface action=new Action();

    @FindBy(id = "logInModalLabel")
    WebElement pageTitle;

    @FindBy(id = "loginusername")
    WebElement username;

    @FindBy(id = "loginpassword")
    WebElement password;

    @FindBy(xpath = "//button[text()='Log in']")
    WebElement login_btn;

    public LoginPage()
    {
        PageFactory.initElements(driver,this);
    }

    public String pageTitle()
    {
        return action.getText(pageTitle);
    }

    public HomePage login(String user_name,String password_)
    {
        action.enterText(username,user_name);
        action.enterText(password,password_);
        action.click(login_btn);
        return new HomePage();
    }
    public ResponsePopupBox loginWithInvalidCredentials(String user_name,String password_)
    {
        action.enterText(username,user_name);
        action.enterText(password,password_);
        action.click(login_btn);
        return new ResponsePopupBox();
    }

}
