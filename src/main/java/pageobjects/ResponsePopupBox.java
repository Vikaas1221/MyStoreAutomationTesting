package pageobjects;

import actiondriver.Action;
import Interfaces.ActionInterface;
import base.BaseClass;
import org.openqa.selenium.support.PageFactory;

public class ResponsePopupBox extends BaseClass
{
    ActionInterface action=new Action();

    public ResponsePopupBox()
    {
        PageFactory.initElements(driver,this);
    }
    public String getResponseMessage()
    {
        return action.getAlertMsg();
    }
}
