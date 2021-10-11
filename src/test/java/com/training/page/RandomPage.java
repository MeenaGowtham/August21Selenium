package com.training.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class RandomPage extends BasePage {

	public RandomPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "Home")
	public WebElement homeLink;
	
	@FindBy(xpath = "//h1[@class='currentStatusUserName']")
	public WebElement userNameLink;
	
	@FindBy(xpath = "//a[@class='contactInfoLaunch editLink']")
	public WebElement editContactLink;
	
	@FindBy(xpath = "//iframe[@id='contactInfoContentId']")
	public WebElement editFrame;
	
	@FindBy(xpath = "//li[@id='aboutTab']")
	public WebElement aboutTab;
	
	@FindBy(xpath = "//input[@id='firstName']")
	public WebElement firstNameInAbout;
	
	@FindBy(xpath = "//input[@id='lastName']")
	public WebElement lastNameInAbout;
	
	@FindBy(xpath = "//input[@value='Save All']")
	public WebElement saveAllInAbout;
	
	@FindBy(xpath = "//span[@id='tailBreadcrumbNode']")
	public WebElement nameInProfilePage;
	
	@FindBy(xpath = "//span[@id='userNavLabel']")
	public WebElement userMenuLabel;
	
	@FindBy(xpath = "//input[@name='customize']")
	public WebElement customizeMyTabs;
	
	@FindBy(xpath = "//select[@name='duel_select_1']")
	public WebElement selectedTabs;
	
	@FindBy(xpath = "//img[@class='leftArrowIcon']")
	public WebElement removeTab;
	
	@FindBy(xpath = "//input[@class='btn primary']")
	public WebElement saveTabs;
	
	@FindBy(xpath = "//ul[@id='tabBar']//li")
	public List<WebElement> tabsRibbon;
	
	@FindBy(xpath = "//span[@class='pageDescription']//a")
	public WebElement dateTimeLink;	
	
	@FindBy(xpath = "//a[contains(text(),'8:00 PM')]")
	public WebElement timeSlotEightPM;
	
	@FindBy(xpath = "//img[@class='comboboxIcon']")
	public WebElement comboBoxIcon;
	
	@FindBy(linkText = "Other")
	public WebElement otherLinkInComboBox;
	
	@FindBy(xpath = "//input[@id='EndDateTime_time']")
	public WebElement endTimeField;
	
	@FindBy(xpath = "//div[@id='timePickerItem_42']")
	public WebElement NinePM;
	
	@FindBy(xpath = "//td[@id='topButtonRow']//input[@name='save']")
	public WebElement saveEvent;
	
	@FindBy(xpath = "//div[@class='multiLineEventBlock dragContentPointer']")
	public WebElement scheduledEventInCalendar;
	
	@FindBy(xpath = "//input[@value='Dismiss All']")
	public WebElement dismissAll;
	
	@FindBy(linkText = "4:00 PM")
	public WebElement fourPMSlot;
	
	@FindBy(xpath = "//div[@id='timePickerItem_38']")
	public WebElement sevenPMSlot;
	
	@FindBy(xpath = "//input[@id='IsRecurrence']")
	public WebElement recurranceCheckBox;
	
	@FindBy(xpath = "//input[@id='rectypeftw']")
	public WebElement weeklyRecurranceRadioButton;
	
	@FindBy(xpath = "//div[@id='w']//div[2]//input")
	public List<WebElement> checkBoxesList;
	
	@FindBy(xpath = "//div[@id='w']//div[2]//label")
	public List<WebElement> daysList;
	
	@FindBy(xpath = "//input[@id='RecurrenceEndDateOnly']")
	public WebElement recurranceEndDate;
	
	@FindBy(xpath = "//input[@id='RecurrenceStartDateTime']")
	public WebElement recurranceStartDateTime;
	
	public void selectDate(String date) {
		try {
			 WebElement test = driver.findElement(By.xpath("//td[contains(text(),'"+date+"')]")) ;
			 System.out.println(test);
			 test.click();
			
		}catch (AssertionError Ae) {
			Ae.printStackTrace();
		}
		
	}
	
	@FindBy(xpath = "//img[@title='Month View']")
	public WebElement monthViewIcon;
	
//	@FindBy(xpath = "//td[@class='calToday']")
//	public WebElement ;
	
//	@FindBy(xpath = "")
//	public WebElement ;
	
//	@FindBy(xpath = "")
//	public WebElement ;
	
//	@FindBy(xpath = "")
//	public WebElement ;
	
//	@FindBy(xpath = "")
//	public WebElement ;
	
	
}
