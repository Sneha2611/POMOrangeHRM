package com.qa.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import com.qa.pageobjects.HomePage;
import com.qa.pageobjects.LoginPage;
import com.qa.pageobjects.RecruitmentPage;
import com.qa.utilities.ReadConfig;

public class BaseTest  {
	
	protected static WebDriver driver;
	WebDriverWait wait;
	ReadConfig readconfig = new ReadConfig();
	protected String username = readconfig.getUname();
	protected String pass = readconfig.getPwd();
	
	
	protected LoginPage lp;
	//protected HomePage hp;
	
	
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass()
	public void setUp(String br)
	{
		logger= Logger.getLogger("OrangeHRM.......");
		PropertyConfigurator.configure("C:\\Users\\sneha\\eclipse-workspace1\\POMOrangeHRM\\src\\main\\resources\\log4j.properties");
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readconfig.getChromeBrowserPath());
			driver=new ChromeDriver();
		}
		
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxBrowserPath());
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		driver.get(readconfig.getApplocationUrl());
		lp = new LoginPage();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
	}
	
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver, String tname) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/FailedTestsScreenshots/" + tname +".png");
		System.out.println("Target "+target);
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	
	}


public void waitForElementPresent(WebElement element)
{
	wait = new WebDriverWait(driver, 20);
	try {
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	catch (Exception e) {
		// TODO: handle exception
		System.out.println("Some exception occured while waiting for elemnet "+element.toString());
		
	}
}
	

public void selectDropDown(WebElement element,String text)
{
	Select select = new Select(element);
	select.selectByVisibleText(text);
}


}
