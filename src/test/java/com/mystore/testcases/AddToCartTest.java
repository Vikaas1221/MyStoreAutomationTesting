package com.mystore.testcases;

import Interfaces.ActionInterface;
import actiondriver.Action;
import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.*;

import java.util.List;

public class AddToCartTest extends BaseClass
{
    ActionInterface action=new Action();
    AddToCartPage addToCartPage;
    IndexPage indexPage;
    LoginPage loginPage=new LoginPage();
    HomePage homePage;


    @BeforeMethod(groups = "sanity")
    public void setup()
    {
        action.openBrowser();
        homePage=new HomePage();
        addToCartPage=new AddToCartPage();

    }
    @AfterMethod(groups = "sanity")
    public void tearDown()
    {
        action.closeBrowser();
    }

    @Test
    public void addProductToCart()
    {
        String selectedProduct=homePage.selectTheProduct();
        Assert.assertEquals(addToCartPage.SelectedProductName(),selectedProduct);
        ResponsePopupBox response=addToCartPage.addProductToCart();
        Assert.assertEquals(response.getResponseMessage(),"Product added");
    }
    @Test
    public void loggedInUserAddProductToCart()
    {
        new IndexPage().clickOnLoginBtn().login(prop.getProperty("username"),prop.getProperty("password") );
        action.sleep(1000);
        String selectedProduct=homePage.selectTheProduct();
        Assert.assertEquals(addToCartPage.SelectedProductName(),selectedProduct);
        ResponsePopupBox response=addToCartPage.addProductToCart();
        Assert.assertEquals(response.getResponseMessage(),"Product added.");
    }
}
