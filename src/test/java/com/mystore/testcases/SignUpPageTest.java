package com.mystore.testcases;

import actiondriver.Action;
import actiondriver.ActionInterface;
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
    @BeforeMethod
    public void setup()
    {
        action.openBrowser();
        indexPage=new IndexPage();
    }
    @AfterMethod
    public void tearDown()
    {
        action.closeBrowser();
    }
    @Test
    public void signUpWithValidCreds()
    {
        signUpPage=indexPage.clickOnSignUpBtn();
        Assert.assertEquals(signUpPage.pageTitle(),"Sign up");
        ResponsePopupBox response=signUpPage.signUpNewUser();
        System.out.println("Alert message: "+response.getResponseMessage());
        Assert.assertEquals(response.getResponseMessage(),"Sign up successful.");
    }
}
