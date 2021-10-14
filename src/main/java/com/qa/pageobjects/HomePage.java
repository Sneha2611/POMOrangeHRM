package com.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;



public class HomePage extends BaseTest {
	//WebDriver driver;

	
	public HomePage() {

		// TODO Auto-generated constructor stub
		//driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1")
	@CacheLookup
	private WebElement homepageheader;
 
	@FindBy(xpath = "//a[@id='welcome']")
	WebElement welcome_link;
	
	@FindBy(xpath = "//div[@id='welcome-menu']/ul/li[3]/a")
	WebElement logout;
	
	@FindBy(xpath = "//div[@id='mainMenu']/ul/li[5]/a")
	WebElement recruitement;
	
	public String getPageTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}

	public String getHomepageheader() {
		return homepageheader.getText();
	}

	public LoginPage clickLogout()
	{
		welcome_link.click();
		logout.click();
		
		return new LoginPage();
	}
	
	public RecruitmentPage clickRecruitement()
	{
		recruitement.click();
		return new RecruitmentPage();
	}
	
}
