package com.training.test.leads;

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
import com.training.page.LeadsPage;
import com.training.page.LoginPage;
import com.training.page.OpportunitiesPage;
import com.training.utilities.CommonUtilities;

public class LeadsTest extends BaseTest{
	WebDriver driver;
	CommonUtilities common = new CommonUtilities();
	LoginPage loginPage;
	HomePage homePage;
	AccountsPage accountsPage;
	OpportunitiesPage opportunitiesPage;
	LeadsPage leadsPage;
	
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
		leadsPage = new LeadsPage(driver);
		
		//login
		enterTextFromKeyboard(loginPage.username, "meego@tekarch.com");
		enterTextFromKeyboard(loginPage.password, "Scooby18");
		clickButton(loginPage.loginButton);
		clickButton(homePage.allTabsIcon);
		clickButton(leadsPage.leadsLink);
		clickButton(accountsPage.closeLightningExperiencePopup);
	}
	
	@Test
	public void leadsHomePage() {
		String expectedPageTitle = "Leads: Home ~ Salesforce - Developer Edition";
		String actualPageTitle = driver.getTitle();
		validateMessage(actualPageTitle, expectedPageTitle);
	}
	
	@Test
	public void selectViewDropDown() {
		ArrayList<String> dropDownItems = new ArrayList<String>(Arrays.asList("All Open Leads", "My Unread Leads", "Recently Viewed Leads",
																"Today's Leads", "View - Custom 1", "View - Custom 2"));
		String expectedList = dropDownItems.toString();
		clickButton(leadsPage.leadsDropDown);
		String actualList = getDropDownOptions(leadsPage.leadsDropDown);
		validateMessage(actualList, expectedList);
	}
	
	@Test
	public void goFunctionality() {
		String optionToBeSelected = "Today's Leads";
		selectFromDropDownByText(leadsPage.leadsDropDown, optionToBeSelected);
		clickButton(homePage.userMenuDropDown);
		clickButton(homePage.logout);
		enterTextFromKeyboard(loginPage.username, "meego@tekarch.com");
		enterTextFromKeyboard(loginPage.password, "Scooby18");
		clickButton(loginPage.loginButton);
		clickButton(homePage.allTabsIcon);
		clickButton(leadsPage.leadsLink);
		String actualText = getSelectedOptionFromDropDown(leadsPage.leadsDropDown);
		validateMessage(actualText, optionToBeSelected);
		clickButton(leadsPage.goButton);		
	}
	
	@Test
	public void todaysLeads() {
		selectFromDropDownByText(leadsPage.leadsDropDown, "Today's Leads");
	}
	
	@Test
	public void createNewLeads() {
		String expectedText = "ABCD";
		String expectedPageTitle = "Lead: "+expectedText+" ~ Salesforce - Developer Edition";
		clickButton(leadsPage.newLeads);
		enterTextFromKeyboard(leadsPage.lastName, expectedText);
		enterTextFromKeyboard(leadsPage.companyName, expectedText);
		clickButton(leadsPage.saveNewLead);
		String actualPageTitle = driver.getTitle();
		validateMessage(actualPageTitle, expectedPageTitle);
	}
	
	@AfterMethod
	public void tearDown() {
		clickButton(homePage.userMenuDropDown);
		clickButton(homePage.logout);
		driver.close();
	}
}
