package com.training.test.opportunities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.page.AccountsPage;
import com.training.page.HomePage;
import com.training.page.LoginPage;
import com.training.page.OpportunitiesPage;
import com.training.utilities.CommonUtilities;

public class OpportunitiesTest extends BaseTest {
	WebDriver driver;
	CommonUtilities common = new CommonUtilities();
	LoginPage loginPage;
	HomePage homePage;
	AccountsPage accountsPage;
	OpportunitiesPage opportunitiesPage;
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = getDriver();
		String url = common.getApplicationProperty("url");
		driver.manage().window().maximize();
		driver.get(url);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		accountsPage = new AccountsPage(driver);
		opportunitiesPage = new OpportunitiesPage(driver);
		
		//login
		enterTextFromKeyboard(loginPage.username, "meego@tekarch.com");
		enterTextFromKeyboard(loginPage.password, "Scooby18");
		clickButton(loginPage.loginButton);
		clickButton(homePage.allTabsIcon);
		clickButton(opportunitiesPage.opportunitiesLink);
		clickButton(accountsPage.closeLightningExperiencePopup);
	}
	
	@Test
	public void opportunitiesDropDown() {
		ArrayList<String> List =  new ArrayList<String>(Arrays.asList("All Opportunities", "Closing Next Month", "Closing This Month",
																			  "My Opportunities", "New Last Week", "New This Week", 
																			  "Opportunity Pipeline", "Private", "Recently Viewed Opportunities",
																			  "Won")); 
		String expectedList = List.toString();
		String actualList = getDropDownOptions(opportunitiesPage.opportunitiesViewDropDown);
		validateMessage(actualList, expectedList);
	}
	
	@Test
	public void createOpportunity() {
		String expectedOpportunityName = "oppo3A";
		clickButton(opportunitiesPage.newOpportunity);
		enterTextFromKeyboard(opportunitiesPage.opportunityName, expectedOpportunityName);
		clickButton(opportunitiesPage.searchAccountname);
		switchWindowsAndFrame(opportunitiesPage.accountNamesFrame, opportunitiesPage.selectAccountName);	
		clickButton(opportunitiesPage.closeDateField);
		selectFromDropDownByIndex(opportunitiesPage.monthDropDown, 11);
		clickButton(opportunitiesPage.selectDate);
		selectFromDropDownByText(opportunitiesPage.stageDropDown, "Qualification");
		opportunitiesPage.probability.clear();
		enterTextFromKeyboard(opportunitiesPage.probability, "90");
		selectFromDropDownByIndex(opportunitiesPage.leadSource, 3);
//		enterTextFromKeyboard(opportunitiesPage.primaryCampaign, "NA");
		clickButton(opportunitiesPage.saveOpportunity);
		String actualOpportunityName = opportunitiesPage.verifyOpportunityName.getText();
		validateMessage(actualOpportunityName, expectedOpportunityName);
	}
	
	@Test
	public void pipelineReport() {
		String expectedPageTitle = "Opportunity Pipeline ~ Salesforce - Developer Edition";
		clickButton(opportunitiesPage.opportunityPipeline);
		String actualPageTitle = driver.getTitle();
		validateMessage(actualPageTitle, expectedPageTitle);
	}
	
	@Test
	public void stuckOpportunities() {
		String expectedPageTitle = "Stuck Opportunities ~ Salesforce - Developer Edition";
		clickButton(opportunitiesPage.stuckOpportunities);
		String actualPageTitle = driver.getTitle();
		validateMessage(actualPageTitle, expectedPageTitle);
	}
	
	@Test
	public void quarterlySummaryReport() {
		String expectedPageTitle = "Opportunity Report ~ Salesforce - Developer Edition";
		selectFromDropDownByIndex(opportunitiesPage.summaryInterval, 1);
		selectFromDropDownByIndex(opportunitiesPage.summaryInclude, 1);
		clickButton(opportunitiesPage.runReport);
		String actualPageTitle = driver.getTitle();
		validateMessage(actualPageTitle, expectedPageTitle);		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
