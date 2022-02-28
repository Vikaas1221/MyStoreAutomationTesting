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

    @FindBy(xpath = "//div[@id='tbodyid']/div[1]//img")
    WebElement ProductCard;



    public HomePage()
    {
        PageFactory.initElements(driver,this);
    }

    public String getWelcomeText()
    {
        return action.getText(WelcomeText);
    }

    public void selectTheProduct()
    {
        action.scrollIntoView(ProductCard);
        //String text=ProductCard.getText();
        action.click(ProductCard);

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
