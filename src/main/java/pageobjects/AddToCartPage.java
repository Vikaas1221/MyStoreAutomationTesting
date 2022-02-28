package pageobjects;

import Interfaces.ActionInterface;
import actiondriver.Action;
import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage extends BaseClass
{
    ActionInterface action=new Action();

    @FindBy(xpath = "//a[text()='Add to cart']")
    WebElement addToCart_btn;

    @FindBy(xpath = "//h2[@class='name']")
    WebElement selectedProduct;

    public AddToCartPage()
    {
        PageFactory.initElements(driver,this);
    }

    public ResponsePopupBox addProductToCart()
    {
        action.click(addToCart_btn);
        return new ResponsePopupBox();
    }
    public String SelectedProductName()
    {
        return action.getText(selectedProduct);
    }

}
