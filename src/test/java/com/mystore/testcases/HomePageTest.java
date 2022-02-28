package com.mystore.testcases;

import Interfaces.ActionInterface;
import actiondriver.Action;
import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.AddToCartPage;
import pageobjects.HomePage;
import pageobjects.IndexPage;
import pageobjects.LoginPage;

public class HomePageTest extends BaseClass
{
    ActionInterface action=new Action();
    HomePage homePage;


    @BeforeMethod(groups = "sanity")
    public void setup()
    {
        action.openBrowser();
        homePage=new HomePage();
    }
    @AfterMethod(groups = "sanity")
    public void tearDown()
    {
        action.closeBrowser();
    }

    @Test
    public void selectProduct()
    {
       homePage.selectTheProduct();
       Assert.assertEquals(action.currentPageURL(),prop.getProperty("url")+"/prod.html?idp_=1");
    }
    @Test(groups = "sanity")
    public void loggedInUserSelectProduct()
    {
        new IndexPage().clickOnLoginBtn().login(prop.getProperty("username"),prop.getProperty("password") );
        action.sleep(1000);
        homePage.selectTheProduct();
        Assert.assertEquals(action.currentPageURL(),prop.getProperty("url")+"/prod.html?idp_=1");
    }
}
