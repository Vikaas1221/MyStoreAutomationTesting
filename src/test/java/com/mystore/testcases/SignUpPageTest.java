package com.mystore.testcases;

import actiondriver.Action;
import Interfaces.ActionInterface;
import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.IndexPage;
import pageobjects.ResponsePopupBox;
import pageobjects.SignUpPage;

public class SignUpPageTest extends BaseClass
{
    ActionInterface action=new Action();
    IndexPage indexPage;
    SignUpPage signUpPage;
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
    public void signUpWithNewUser()
    {
        signUpPage=indexPage.clickOnSignUpBtn();
        Assert.assertEquals(signUpPage.pageTitle(),"Sign up");
        ResponsePopupBox response=signUpPage.signUp();
        Assert.assertEquals(response.getResponseMessage(),"Sign up successful.");
    }
    @Test(groups = "sanity")
    public void signUpWithAlreadyExistingUser()
    {
        signUpPage=indexPage.clickOnSignUpBtn();
        Assert.assertEquals(signUpPage.pageTitle(),"Sign up");
        ResponsePopupBox response=signUpPage.signUp(prop.getProperty("username"),prop.getProperty("password") );
        Assert.assertEquals(response.getResponseMessage(),"This user already exist.");
    }
    @Test
    public void signUpWithOnlyUsername()
    {
        signUpPage=indexPage.clickOnSignUpBtn();
        Assert.assertEquals(signUpPage.pageTitle(),"Sign up");
        ResponsePopupBox response=signUpPage.signUp(prop.getProperty("username"),"");
        Assert.assertEquals(response.getResponseMessage(),"Please fill out Username and Password.");
    }


}
