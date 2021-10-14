package com.qa.testcases;

import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.pageobjects.HomePage;
import com.qa.pageobjects.RecruitmentPage;

public class Recruitement_Add_candidates_002 extends BaseTest{
	HomePage hp;
	RecruitmentPage rp;
	
	@Test
	public void addCandidateTest()
	{
		logger.info("URL is opened");
		
		lp.enterUsername();
		logger.info("Username entered");
		
		lp.getPassword().sendKeys(pass);
		logger.info("Password entered");
		
		hp = lp.clickonLogin();
		
		rp = hp.clickRecruitement();
		
		rp.addCandidate();
	}

}
