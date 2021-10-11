package com.training.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class MySettingsPage extends BasePage{

	public MySettingsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(partialLinkText = "Settings")
	public WebElement mySettingsLink;

	@FindBy(linkText = "Personal")
	public WebElement personalLink;

	@FindBy(linkText = "Login History")
	public WebElement loginHistoryLink;

	@FindBy(linkText = "Display & Layout")
	public WebElement displayLayoutLink;

	@FindBy(partialLinkText = "Download login history for last six months")
	public WebElement downloadLoginHistoryLink;

	@FindBy(linkText = "Customize My Tabs")
	public WebElement customizeMyTabsLink;

	@FindBy(xpath = "//select[@id='p4']")
	public WebElement customAppDropDown;

	@FindBy(xpath = "//select[@id='duel_select_0']")
	public WebElement availableTabsDropDown;

	@FindBy(xpath = "//a[@id='duel_select_0_right']")
	public WebElement addTabLink;

	@FindBy(xpath = "//select[@id='duel_select_1']")
	public WebElement selectedTabsDropDown;

	@FindBy(xpath = "//input[@value=' Save ']")
	public WebElement saveTabsButton;

	@FindBy(xpath = "//div[@id='tsidButton']")
	public WebElement homePageMenuDropDown;
	
	@FindBy(linkText = "Sales")
	public WebElement salesPageSelection;
	
	@FindBy(linkText = "Marketing")
	public WebElement marketingPageSelection;

	@FindBy(linkText = "Salesforce Chatter")
	public WebElement chatterPageSelection;
	
	@FindBy(xpath = "//ul[@id='tabBar']")
	public WebElement chatterPageTabBar;
	
	@FindBy(xpath = "//a[@title='Close']")
	public WebElement closePopUp;
	
	@FindBy(xpath = "//div[@id='EmailSetup']//a[@class='header setupFolder']")
	public WebElement emailLink;
	
	@FindBy(linkText = "My Email Settings")
	public WebElement emailSettings;
	
	@FindBy(xpath = "//input[@id='sender_name']")
	public WebElement emailNameTextBox;
	
	@FindBy(xpath = "//input[@id='sender_email']")
	public WebElement emailAddressTextBox;
	
	@FindBy(xpath = "//input[@id='auto_bcc1']")
	public WebElement automaticBccButton;
	
	@FindBy(xpath = "//input[@name='save']")
	public WebElement saveEmailSettingsButton;
	
	@FindBy(xpath = "//div[@id='meSaveCompleteMessage']")
	public WebElement emailSettingsUpdatedMessage;
	
	@FindBy(partialLinkText = "Calendar")
	public WebElement calendarSettings;
	
	@FindBy(linkText = "Activity Reminders")
	public WebElement activityRemindersLink;
	
	@FindBy(xpath = "//input[@id='testbtn']")
	public WebElement openTestReminderButton;
	
	@FindBy(xpath = "//form[@name='reminder']//div//div//div[@id='summary0']//div[@class='subject'][1]")
	public WebElement childWindowElement;
	
	@FindBy(xpath = "//form[@name='reminder']//div//div//input[@value='Dismiss All']")
	public WebElement dismissChildWindowElement;

}
