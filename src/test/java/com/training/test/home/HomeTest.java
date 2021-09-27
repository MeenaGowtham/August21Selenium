package com.training.test.home;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.page.HomePage;
import com.training.page.LoginPage;
import com.training.utilities.CommonUtilities;

public class HomeTest extends BaseTest {
	WebDriver driver;
	CommonUtilities common = new CommonUtilities();
	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = getDriver();
		String url = common.getApplicationProperty("url");
		driver.manage().window().maximize();
		driver.get(url);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
	}

	@Test
	public void selectUserMenuDropDown() {
		ArrayList<String> expectedList = new ArrayList<String>(Arrays.asList("My Profile", "My Settings",
				"Developer Console", "Switch to Lightning Experience", "Logout"));
		enterTextFromKeyboard(loginPage.username, "meego@tekarch.com");
		enterTextFromKeyboard(loginPage.password, "Scooby18");
		clickButton(loginPage.loginButton);
		clickButton(homePage.userMenuDropDown);
		String actualList = homePage.getListOfItems(homePage.userMenuDropDownList);
		String strExpectedList = expectedList.toString();
		assertEquals(actualList, strExpectedList);
	}

	@Test
	public void selectMyProfile() throws InterruptedException {
		String expectedLastName = "Meena G ";
		String expectedPost = "Entering new text from framework";
		String actualPost = "";
		enterTextFromKeyboard(loginPage.username, "meego@tekarch.com");
		enterTextFromKeyboard(loginPage.password, "Scooby18");
		clickButton(loginPage.loginButton);
		clickButton(homePage.userMenuDropDown); // click user menu drop down
		clickButton(homePage.myProfilelink);
		mouseHoverOn(homePage.editProfileIcon);
		clickButton(homePage.editProfileIcon);

		switchToFrame(homePage.editProfileFrame);
		clickButton(homePage.aboutTab); // click on about tab
		homePage.updateLastNameField.clear();
		enterTextFromKeyboard(homePage.updateLastNameField, "G"); // updates last name
		clickButton(homePage.editFrameSaveAllButton);// save changes
		String actualLastName = getTextFromElement(homePage.lastName); // validates last name
		validateMessage(actualLastName, expectedLastName);

		// click on posts link

		clickButton(homePage.postslink);
		waitForFrame(homePage.postsFrame);
		enterTextFromKeyboard(homePage.updatePostsTextBox, expectedPost);
		driver.switchTo().defaultContent();
		if (homePage.shareButton.isEnabled()) {
			clickButton(homePage.shareButton);
		} else {
			waitForElementToDisappear(homePage.shareButton);
			actualPost = getTextFromElement(homePage.recentFeedInPosts);
			validateMessage(actualPost, expectedPost);
		}

		// click on file link
		Thread.sleep(1000);
		clickButton(homePage.fileLink);
//		action.moveToElement(homePage.uploadFromComputerButton).click().build().perform();

		clickButton(homePage.uploadFromComputerButton);
		enterTextFromKeyboard(homePage.chooseFile,
				"C:\\Users\\meena\\Desktop\\Resumes\\Meena\\Studies\\Java Projects\\Car.txt");
		clickButton(homePage.shareFileButton);
		String expectedText = "Download txt";
		String actualText = getTextFromElement(homePage.uploadedFileDownloadOption);
		validateMessage(actualText, expectedText);

		// click Add Photo
		System.out.println();
		mouseHoverOn(homePage.mouseHoverOnAddPhoto);
		System.out.println("Options size : " + homePage.listOfUploadPhotoOptions.size());
		for (int i = 0; i < homePage.listOfUploadPhotoOptions.size(); i++) {
			System.out.println(
					"List of upload options : " + getTextFromElement(homePage.listOfUploadPhotoOptions.get(i)));
		}

		if (getSizeOfWebElements(homePage.listOfUploadPhotoOptions) > 0) {
			clickButton(homePage.listOfUploadPhotoOptions.get(0));
		}

		switchToFrame(homePage.uploadProfilePhotoFrame);
		enterTextFromKeyboard(homePage.chooseProfilePhotoButton,
				"C:\\Users\\meena\\OneDrive\\Pictures\\Camera Roll\\Baby-Krishna-Wallpaper-HD-8.jpg");
		clickButton(homePage.saveProfilePhotoButton);
//		waitForFrame(homePage.cropProfilePhotoFrame);
		getListOfFramesAndSwitch(homePage.uploadProfilePhotoFrame);
//		switchToFrame(homePage.uploadProfilePhotoFrame);
		clickButton(homePage.cropAndSaveProfilePhotoButton);
	}

	@Test
	public void selectMySettings() throws InterruptedException {
		enterTextFromKeyboard(loginPage.username, "meego@tekarch.com");
		enterTextFromKeyboard(loginPage.password, "Scooby18");
		clickButton(loginPage.loginButton);
		clickButton(homePage.userMenuDropDown);
		clickButton(homePage.mySettingsLink);

		clickButton(homePage.personalLink);
		clickButton(homePage.loginHistoryLink);
		clickButton(homePage.downloadLoginHistoryLink);
		if (isFileDownloaded("C:\\Users\\meena\\Downloads", "LoginHistory")) {
			System.out.println("File has been downloaded and deleted");
		} else {
			System.out.println("OOPS !! File not downloaded !!!");
		}
		clickButton(homePage.displayLayoutLink);
		clickButton(homePage.customizeMyTabsLink);
		selectFromDropDown(homePage.customAppDropDown, "Salesforce Chatter");

		if (getTextFromElement(homePage.availableTabsDropDown).contains("Reports")) {
			selectFromDropDown(homePage.availableTabsDropDown, "Reports");
			clickButton(homePage.addTabLink);
			if (getTextFromElement(homePage.selectedTabsDropDown).contains("Reports")) {
				clickButton(homePage.saveTabsButton);
			}
		} else {
			System.out.println("Reports already added");
			clickButton(homePage.saveTabsButton);
		}

		if (getTextFromElement(homePage.homePageMenuDropDown).contentEquals("Marketing")) {
			System.out.println("In if part\nMarketing");
			newTabValidation(homePage.chatterPageTabBar, "Reports");

			clickButton(homePage.homePageMenuDropDown);
			clickButton(homePage.salesPageSelection);
			if (homePage.closePopUp.isDisplayed()) {
				clickButton(homePage.closePopUp);
			}
			System.out.println("Sales");
			newTabValidation(homePage.chatterPageTabBar, "Reports");

			clickButton(homePage.homePageMenuDropDown);
			clickButton(homePage.chatterPageSelection);
			if (homePage.closePopUp.isDisplayed()) {
				clickButton(homePage.closePopUp);
			}
			System.out.println("Chatter");
			newTabValidation(homePage.chatterPageTabBar, "Reports");
		} else {
			System.out.println("In else part");

			clickButton(homePage.homePageMenuDropDown);
			clickButton(homePage.marketingPageSelection);
			if (homePage.closePopUp.isDisplayed()) {
				clickButton(homePage.closePopUp);
			}
			System.out.println("Marketing");
			newTabValidation(homePage.chatterPageTabBar, "Reports");

			clickButton(homePage.homePageMenuDropDown);
			clickButton(homePage.salesPageSelection);
			System.out.println("Sales");
			newTabValidation(homePage.chatterPageTabBar, "Reports");

			clickButton(homePage.homePageMenuDropDown);
			clickButton(homePage.chatterPageSelection);
			System.out.println("Chatter");
			newTabValidation(homePage.chatterPageTabBar, "Reports");
		}

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	} 

}
