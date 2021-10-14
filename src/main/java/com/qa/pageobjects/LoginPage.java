package com.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.BaseTest;
import com.qa.utilities.ReadConfig;

public class LoginPage extends BaseTest {

	//WebDriver driver;
	//WebDriverWait wait ;
	ReadConfig readconfig = new ReadConfig();
	
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//div[@id='logInPanelHeading']")
	@CacheLookup
	 WebElement loginpageheader;

	@FindBy(xpath = "//input[@id='txtUsername']")
	@CacheLookup
	 WebElement user;

	@FindBy(id = "txtPassword")
	@CacheLookup
	 WebElement password;

	@FindBy(id = "btnLogin")
	@CacheLookup
	 WebElement loginbtn;

	
	
	public String getPageTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}

	
	public String getLoginpageheader() {
		waitForElementPresent(loginpageheader);
		return loginpageheader.getText();
	}
	
	public WebElement getUsername() {
		
		return user;
		
	}

	public WebElement getPassword() {
		return password;
	}

	public void enterUsername()
	{
		waitForElementPresent(user);
		getUsername().sendKeys(username);
	}
	
	public HomePage clickonLogin() {
		waitForElementPresent(loginbtn);
		loginbtn.click();
		return new HomePage();
	}

}
