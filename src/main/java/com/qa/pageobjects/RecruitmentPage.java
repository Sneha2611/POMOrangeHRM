package com.qa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;

public class RecruitmentPage extends BaseTest{
	
	@FindBy(xpath = "//div[@id='mainMenu']/ul/li[5]/ul/li[1]/a")
	WebElement candidates;
	
	@FindBy(xpath = "//input[@id='btnAdd']")
	WebElement addbtn;
	
	@FindBy(xpath = "//input[@id='addCandidate_firstName']")
	WebElement firstname;
	
	@FindBy(xpath = "//input[@id='addCandidate_lastName']")
	WebElement lastname;
	
	@FindBy(xpath = "//input[@id='addCandidate_email']")
	WebElement email;
	
	@FindBy(xpath = "//select[@id='addCandidate_vacancy']")
	WebElement job_vacancy;
	
	@FindBy(xpath = "//input[@id='addCandidate_resume']")
	WebElement uploadfile;
	
	@FindBy(xpath = "//input[@id='addCandidate_appliedDate']")
	WebElement datepicker;
	
	@FindBy(xpath = "//table[@class='ui-datepicker-calendar']/tbody/tr[2]/td[4]/a")
	WebElement day;
	
	@FindBy(xpath = "//input[@id='btnSave']")
	WebElement savebtn;
	
	
	public RecruitmentPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	public void addCandidate()
	{
		candidates.click();
		addbtn.click();
		firstname.sendKeys("Sneha");
		lastname.sendKeys("Acharya");
		email.sendKeys("sneha@yahoo.in");
		selectDropDown(job_vacancy, "Senior QA Lead");
		uploadfile.sendKeys("C:\\Users\\sneha\\Downloads\\resume.txt");
		datepicker.click();
		day.click();
		savebtn.click();
		
	}
	
	
	
	
}
