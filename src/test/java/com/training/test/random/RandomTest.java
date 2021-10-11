package com.training.test.random;

import static org.testng.Assert.assertFalse;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.page.AccountsPage;
import com.training.page.ContactsPage;
import com.training.page.HomePage;
import com.training.page.LoginPage;
import com.training.page.RandomPage;
import com.training.utilities.CommonUtilities;

public class RandomTest extends BaseTest {
	WebDriver driver;
	CommonUtilities common = new CommonUtilities();
	LoginPage loginPage;
	HomePage homePage;
	AccountsPage accountsPage;
	ContactsPage contactsPage;
	RandomPage randomPage;

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = getDriver();
		String url = common.getApplicationProperty("url");
		driver.manage().window().maximize();
		driver.get(url);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		accountsPage = new AccountsPage(driver);
		contactsPage = new ContactsPage(driver);
		randomPage = new RandomPage(driver);

		// login
		enterTextFromKeyboard(loginPage.username, "meego@tekarch.com");
		enterTextFromKeyboard(loginPage.password, "Scooby18");
		clickButton(loginPage.loginButton);
	}
	
	@Test
	public void verifyFirstAndLastName() {
		String expectedUserName = "Meena G";
		String expectedCurrentURL = "https://tekarch109-dev-ed.my.salesforce.com/_ui/core/userprofile/UserProfilePage?tab=sfdc.ProfilePlatformFeed";
		clickButton(randomPage.homeLink);
		clickButton(accountsPage.closeLightningExperiencePopup);
		String actualUserName = getTextFromElement(randomPage.userNameLink);
		validateMessage(actualUserName, expectedUserName);
		clickButton(randomPage.userNameLink);
		String actualCurrentURL = driver.getCurrentUrl();
		System.out.println(actualCurrentURL);
		validateMessage(actualCurrentURL, expectedCurrentURL);
	}
	
	@Test
	public void verifyLastNameUpdate() {
		String lastName = "Gowtham";
		clickButton(randomPage.homeLink);
		clickButton(accountsPage.closeLightningExperiencePopup);
		clickButton(randomPage.userNameLink);
		clickButton(randomPage.editContactLink);
		waitForFrameAndSwitch(randomPage.editFrame);
		clickButton(randomPage.aboutTab);
		String firstName = randomPage.firstNameInAbout.getAttribute("value");
		String expectedName = firstName+" "+lastName;
		String expectedPageTitle = "User: "+expectedName+" ~ Salesforce - Developer Edition";
		randomPage.lastNameInAbout.clear();
		enterTextFromKeyboard(randomPage.lastNameInAbout, lastName);
		clickButton(randomPage.saveAllInAbout);
		driver.switchTo().defaultContent();
		String actualProfilePageName = getTextFromElement(randomPage.nameInProfilePage).trim();
		validateMessage(actualProfilePageName, expectedName);
		String actualUserMenuName = getTextFromElement(randomPage.userMenuLabel);
		validateMessage(actualUserMenuName, expectedName);
		String actualPageTitle = driver.getTitle();
		validateMessage(actualPageTitle, expectedPageTitle);
	}
	
	@Test
	public void customizeTabs() {
		clickButton(homePage.allTabsIcon);
		clickButton(randomPage.customizeMyTabs);
		selectFromDropDownByIndex(randomPage.selectedTabs, 3);
		String tabToBeRemoved = getSelectedOptionFromDropDown(randomPage.selectedTabs);
		clickButton(randomPage.removeTab);
		clickButton(randomPage.saveTabs);
		assertFalse(validateListWithText(randomPage.tabsRibbon, tabToBeRemoved));
		clickButton(homePage.userMenuDropDown);
		clickButton(homePage.logout);
		enterTextFromKeyboard(loginPage.username, "meego@tekarch.com");
		enterTextFromKeyboard(loginPage.password, "Scooby18");
		clickButton(loginPage.loginButton);
		assertFalse(validateListWithText(randomPage.tabsRibbon, tabToBeRemoved));
	}
	
	@Test
	public void blockEventInCalendar() {
		String expectedEventName = "Other";
		clickButton(randomPage.homeLink);
		clickButton(accountsPage.closeLightningExperiencePopup);
		clickButton(randomPage.dateTimeLink);
		clickButton(randomPage.timeSlotEightPM);
		clickButton(randomPage.comboBoxIcon);
		switchWindowsAndClick(randomPage.otherLinkInComboBox);
		clickButton(randomPage.endTimeField);
		clickButton(randomPage.NinePM);
		clickButton(randomPage.saveEvent);
		String actualEventName = getTextFromElement(randomPage.scheduledEventInCalendar);
		validateMessage(actualEventName, expectedEventName);
		switchWindowsAndClick(randomPage.dismissAll);
	}
	
	@Test
	public void bookRecurranceEvent() {
		clickButton(randomPage.homeLink);
		clickButton(accountsPage.closeLightningExperiencePopup);
		clickButton(randomPage.dateTimeLink);
		clickButton(randomPage.fourPMSlot);
		clickButton(randomPage.comboBoxIcon);
		switchWindowsAndClick(randomPage.otherLinkInComboBox);
		clickButton(randomPage.endTimeField);
		clickButton(randomPage.sevenPMSlot);
		clickButton(randomPage.recurranceCheckBox);
		clickButton(randomPage.weeklyRecurranceRadioButton);
		 
		 DateFormat dateFormat = new SimpleDateFormat("dd");
		    Calendar cal = Calendar.getInstance();
		    cal.setTime(new Date());
		    String oldDate = dateFormat.format(cal.getTime());
		    cal.add(Calendar.DATE, 14);		   
		    String newDate = dateFormat.format(cal.getTime());
		    System.out.println("Old:"+oldDate+"New:"+ newDate);
		clickButton(randomPage.recurranceEndDate);
		randomPage.selectDate(newDate);
		clickButton(randomPage.saveEvent);
		clickButton(randomPage.monthViewIcon);
	}
	
	
	@AfterMethod
	public void tearDown() {
		clickButton(homePage.userMenuDropDown);
		clickButton(homePage.logout);
		driver.close();
	}


}
