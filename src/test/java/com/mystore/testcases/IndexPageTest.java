package com.mystore.testcases;

import actiondriver.Action;
import Interfaces.ActionInterface;
import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.IndexPage;

import java.util.List;

public class IndexPageTest extends BaseClass
{
    IndexPage indexPage;
    ActionInterface action=new Action();
    @BeforeMethod(groups = "sanity")
    public void setup()
    {
        action.openBrowser();
        indexPage=new IndexPage();
    }
    @AfterMethod(groups = "sanity")
    public void tearDown()
    {
        action.closeBrowser();
    }
    @Test(priority = 1,groups = "sanity")
    public void validatePageTitle()
    {
        Assert.assertEquals("PRODUCT STORE", indexPage.pageTitle());
    }
    @Test(priority = 2)
    public void validateNavMenu()
    {
        List<String> navList=indexPage.links();
        Assert.assertTrue(navList.contains("Log in"));
    }
    @Test(priority = 3)
    public void validateNavigationToCartPage()
    {
        indexPage.clickOnCartBtn();
        Assert.assertEquals(action.currentPageURL(),prop.getProperty("url")+"/cart.html");
    }
    @Test(priority = 4)
    public void validateNavigationToHomePage()
    {
        indexPage.clickOnHomeBtn();
        Assert.assertEquals(action.currentPageURL(),prop.getProperty("url")+"/index.html");
    }

}
