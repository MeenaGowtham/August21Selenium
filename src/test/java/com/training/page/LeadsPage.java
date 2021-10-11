package com.training.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class LeadsPage extends BasePage {

	public LeadsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "Leads")
	public WebElement leadsLink;
	
	@FindBy(xpath = "//select[@name='fcf']")
	public WebElement leadsDropDown;
	
	@FindBy(xpath = "//input[@name='go']")
	public WebElement goButton;
	
	@FindBy(xpath = "//input[@name='new']")
	public WebElement newLeads;
	
	@FindBy(xpath = "//input[@name='name_lastlea2']")
	public WebElement lastName;
	
	@FindBy(xpath = "//input[@name='lea3']")
	public WebElement companyName;
	
	@FindBy(xpath = "//td[@id='topButtonRow']//input[@name='save']")
	public WebElement saveNewLead;
}
