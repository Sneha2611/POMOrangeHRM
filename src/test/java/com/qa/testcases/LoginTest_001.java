package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.pageobjects.HomePage;
import com.qa.pageobjects.LoginPage;

public class LoginTest_001 extends BaseTest{

	HomePage hp;
	@Test
	
	public void loginTest() throws IOException
	{
		System.out.println(Thread.currentThread().getId());
		
		logger.info("URL is opened");
		
		lp.enterUsername();
		logger.info("Username entered");
		
		lp.getPassword().sendKeys(pass);
		logger.info("Password entered");
		
		hp = lp.clickonLogin();
		
		
		if(hp.getHomepageheader().equals("Dashboard"))
		{
			Assert.assertTrue(true);
			logger.info("Logged in successfully");
		}
		else
		{
			captureScreenshot(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Log in failed");
		}
		
		hp.clickLogout();
		
		
	}
		
	
	@Test
	public void headerTest() throws IOException
	{
		System.out.println(Thread.currentThread().getId());
		if(lp.getLoginpageheader().equals("LOGIN Panel"))
		{
			Assert.assertTrue(true);
			logger.info("Logged out successfully");
		}
		else
		{
			captureScreenshot(driver, "headerTest");
			Assert.assertTrue(false);
			logger.info("loginPageHeaserTest");
		}
	}
	
	
	
}
