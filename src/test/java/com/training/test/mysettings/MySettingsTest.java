package com.training.test.mysettings;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.page.HomePage;
import com.training.page.LoginPage;
import com.training.page.MySettingsPage;
import com.training.utilities.CommonUtilities;

public class MySettingsTest extends BaseTest{
	CommonUtilities common = new CommonUtilities();
	LoginPage loginPage;
	HomePage homePage;
	MySettingsPage mysettingsPage;

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = getDriver();
		String url = common.getApplicationProperty("url");
		driver.manage().window().maximize();
		driver.get(url);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		mysettingsPage = new MySettingsPage(driver);
	}

	@Test
	public void selectMySettings() throws InterruptedException {
		String expectedSuccessMessage = "Your settings have been successfully saved.";
		String expectedTextInChildWindow = "  Sample Event.";
		enterTextFromKeyboard(loginPage.username, "meego@tekarch.com");
		enterTextFromKeyboard(loginPage.password, "Scooby18");
		clickButton(loginPage.loginButton);
		clickButton(homePage.userMenuDropDown);
		clickButton(mysettingsPage.mySettingsLink);

		clickButton(mysettingsPage.personalLink);
		clickButton(mysettingsPage.loginHistoryLink);
		clickButton(mysettingsPage.downloadLoginHistoryLink);
		if (isFileDownloaded("C:\\Users\\meena\\Downloads", "LoginHistory")) {
			System.out.println("File has been downloaded and deleted");
		} else {
			System.out.println("OOPS !! File not downloaded !!!");
		}
		clickButton(mysettingsPage.displayLayoutLink);
		clickButton(mysettingsPage.customizeMyTabsLink);
		selectFromDropDownByText(mysettingsPage.customAppDropDown, "Salesforce Chatter");

		if (getTextFromElement(mysettingsPage.availableTabsDropDown).contains("Reports")) {
			selectFromDropDownByText(mysettingsPage.availableTabsDropDown, "Reports");
			clickButton(mysettingsPage.addTabLink);
			if (getTextFromElement(mysettingsPage.selectedTabsDropDown).contains("Reports")) {
				clickButton(mysettingsPage.saveTabsButton);
			}
		} else {
			System.out.println("Reports already added");
			clickButton(mysettingsPage.saveTabsButton);
		}

		if (getTextFromElement(mysettingsPage.homePageMenuDropDown).contentEquals("Marketing")) {
			System.out.println("In if part\nMarketing");
			newTabValidation(mysettingsPage.chatterPageTabBar, "Reports");

			clickButton(mysettingsPage.homePageMenuDropDown);
			clickButton(mysettingsPage.salesPageSelection);
			if (mysettingsPage.closePopUp.isDisplayed()) {
				clickButton(mysettingsPage.closePopUp);
			}
			System.out.println("Sales");
			newTabValidation(mysettingsPage.chatterPageTabBar, "Reports");

			clickButton(mysettingsPage.homePageMenuDropDown);
			clickButton(mysettingsPage.chatterPageSelection);
			if (mysettingsPage.closePopUp.isDisplayed()) {
				clickButton(mysettingsPage.closePopUp);
			}
			System.out.println("Chatter");
			newTabValidation(mysettingsPage.chatterPageTabBar, "Reports");
		} else {
			System.out.println("In else part");

			clickButton(mysettingsPage.homePageMenuDropDown);
			clickButton(mysettingsPage.marketingPageSelection);
			if (mysettingsPage.closePopUp.isDisplayed()) {
				clickButton(mysettingsPage.closePopUp);
			}
			System.out.println("Marketing");
			newTabValidation(mysettingsPage.chatterPageTabBar, "Reports");

			clickButton(mysettingsPage.homePageMenuDropDown);
			clickButton(mysettingsPage.salesPageSelection);
			System.out.println("Sales");
			newTabValidation(mysettingsPage.chatterPageTabBar, "Reports");

			clickButton(mysettingsPage.homePageMenuDropDown);
			clickButton(mysettingsPage.chatterPageSelection);
			System.out.println("Chatter");
			newTabValidation(mysettingsPage.chatterPageTabBar, "Reports");
		}

		// Email Settings
		clickButton(homePage.userMenuDropDown);
		clickButton(mysettingsPage.mySettingsLink);
		clickButton(mysettingsPage.emailLink);
		clickButton(mysettingsPage.emailSettings);
		clearField(mysettingsPage.emailNameTextBox);
		enterTextFromKeyboard(mysettingsPage.emailNameTextBox, "Meena G");
		clearField(mysettingsPage.emailAddressTextBox);
		enterTextFromKeyboard(mysettingsPage.emailAddressTextBox, "meenakmm90@gmail.com");
		if (!mysettingsPage.automaticBccButton.isSelected()) {
			clickButton(mysettingsPage.automaticBccButton);
		} else {
			System.out.println("Automatic BCC option is selected");
		}
		clickButton(mysettingsPage.saveEmailSettingsButton);
		String actualSuccessMessage = getTextFromElement(mysettingsPage.emailSettingsUpdatedMessage);
		validateMessage(actualSuccessMessage, expectedSuccessMessage);

		// Calendars & Reminders
		clickButton(mysettingsPage.calendarSettings);
		clickButton(mysettingsPage.activityRemindersLink);
		clickButton(mysettingsPage.openTestReminderButton);
		switchToWindows(mysettingsPage.childWindowElement, expectedTextInChildWindow);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
