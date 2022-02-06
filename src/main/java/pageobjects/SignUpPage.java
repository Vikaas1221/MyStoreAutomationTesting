package pageobjects;

import actiondriver.Action;
import actiondriver.ActionInterface;
import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends BaseClass
{
    ActionInterface action=new Action();
    String user_name,pass_word;

    @FindBy(xpath = "//h5[text()='Sign up']")
    WebElement pageTitle;

    @FindBy(id = "sign-username")
    WebElement username;

    @FindBy(id = "sign-password")
    WebElement password;

    @FindBy(xpath = "//button[text()='Sign up']")
    WebElement signup_btn;

    public SignUpPage()
    {
        PageFactory.initElements(driver,this);
    }

    public String pageTitle()
    {
        return action.getText(pageTitle);
    }
    public ResponsePopupBox signUp()
    {
        action.enterText(username,action.generateName());
        action.enterText(password,"qavj");
        action.click(signup_btn);
        return new ResponsePopupBox();
    }
    public ResponsePopupBox signUp(String user_name, String password_)
    {

        action.enterText(username,user_name);
        action.enterText(password,password_);
        action.click(signup_btn);
        return new ResponsePopupBox();
    }

}
