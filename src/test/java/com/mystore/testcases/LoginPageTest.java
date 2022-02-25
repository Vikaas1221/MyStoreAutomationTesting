package com.mystore.testcases;

import actiondriver.Action;
import Interfaces.ActionInterface;
import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.IndexPage;
import pageobjects.LoginPage;
import pageobjects.ResponsePopupBox;


public class LoginPageTest extends BaseClass
{
    ActionInterface action=new Action();
    IndexPage indexPage;
    LoginPage loginPage;
    HomePage homePage;
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

    @Test(groups = "sanity")
    public void LoginWithCorrectCredentials()
    {
       loginPage=indexPage.clickOnLoginBtn();
       Assert.assertEquals(loginPage.pageTitle(),"Log in");
       homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
       Assert.assertEquals(homePage.getWelcomeText(),"Welcome"+prop.getProperty("username"));
    }
    @Test
    public void LoginWithIncorrectCredentials()
    {
        loginPage=indexPage.clickOnLoginBtn();
        Assert.assertEquals(loginPage.pageTitle(),"Log in");
        ResponsePopupBox response =loginPage.loginWithInvalidCredentials(prop.getProperty("username"),"" );
        Assert.assertEquals(response.getResponseMessage(),"Please fill out Username and Password.");
    }
}
