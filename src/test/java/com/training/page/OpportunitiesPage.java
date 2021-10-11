package com.training.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class OpportunitiesPage extends BasePage {

	public OpportunitiesPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "Opportunities")
	public WebElement opportunitiesLink;
	
	@FindBy(xpath = "//select[@name='fcf']")
	public WebElement opportunitiesViewDropDown; 
	
	@FindBy(xpath = "//input[@name='new']")
	public WebElement newOpportunity;
	
	@FindBy(xpath = "//input[@name='opp3']")
	public WebElement opportunityName;
	
	@FindBy(xpath = "//input[@name='opp4']")
	public WebElement accountName;
	
	@FindBy(xpath = "//a[@title='Account Name Lookup (New Window)']")
	public WebElement searchAccountname;
	
	@FindBy(xpath = "//frame[@name='resultsFrame']")
	public WebElement accountNamesFrame;
		
	@FindBy(xpath = "//tr[@class='dataRow even first']//th//a")
	public WebElement selectAccountName;
	
	@FindBy(xpath = "//input[@name='opp9']")
	public WebElement closeDateField;
	
	@FindBy(xpath = "//select[@id='calMonthPicker']")
	public WebElement monthDropDown;
	
	@FindBy(xpath = "//td[contains(text(),'15')]")
	public WebElement selectDate;
	
	@FindBy(xpath = "//select[@id='opp11']")
	public WebElement stageDropDown;
	
	@FindBy(xpath = "//input[@id='opp12']")
	public WebElement probability;

	@FindBy(xpath = "//select[@id='opp6']")
	public WebElement leadSource;
	
	@FindBy(xpath = "//input[@id='opp17']")
	public WebElement primaryCampaign;
	
	@FindBy(xpath = "//td[@id='topButtonRow']//input[@name='save']")
	public WebElement saveOpportunity;
	
	@FindBy(xpath = "//div[@id='opp3_ileinner']")
	public WebElement verifyOpportunityName;
	
	@FindBy(linkText = "Opportunity Pipeline")
	public WebElement opportunityPipeline;
	
	@FindBy(linkText = "Stuck Opportunities")
	public WebElement stuckOpportunities;
	
	@FindBy(xpath = "//select[@name='quarter_q']")
	public WebElement summaryInterval;

	@FindBy(xpath = "//select[@name='open']")
	public WebElement summaryInclude;
	
	@FindBy(xpath = "//input[@title='Run Report']")
	public WebElement runReport;
}
