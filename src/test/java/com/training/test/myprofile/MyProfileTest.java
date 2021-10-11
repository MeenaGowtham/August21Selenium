package com.training.test.myprofile;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.page.HomePage;
import com.training.page.LoginPage;
import com.training.page.MyProfilePage;
import com.training.utilities.CommonUtilities;

public class MyProfileTest extends BaseTest {
	
	CommonUtilities common = new CommonUtilities();
	LoginPage loginPage;
	HomePage homePage;
	MyProfilePage myprofilePage;
	

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = getDriver();
		String url = common.getApplicationProperty("url");
		driver.manage().window().maximize();
		driver.get(url);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		myprofilePage = new MyProfilePage(driver);
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
		clickButton(myprofilePage.myProfilelink);
		mouseHoverOn(myprofilePage.editProfileIcon);
		clickButton(myprofilePage.editProfileIcon);

		switchToFrame(myprofilePage.editProfileFrame);
		clickButton(myprofilePage.aboutTab); // click on about tab
		clearField(myprofilePage.updateLastNameField);
		enterTextFromKeyboard(myprofilePage.updateLastNameField, "G"); // updates last name
		clickButton(myprofilePage.editFrameSaveAllButton);// save changes
		String actualLastName = getTextFromElement(myprofilePage.lastName); // validates last name
		validateMessage(actualLastName, expectedLastName);

		// click on posts link

		clickButton(myprofilePage.postslink);
		waitForFrameAndSwitch(myprofilePage.postsFrame);
		enterTextFromKeyboard(myprofilePage.updatePostsTextBox, expectedPost);
		driver.switchTo().defaultContent();
		if (myprofilePage.shareButton.isEnabled()) {
			clickButton(myprofilePage.shareButton);
		} else {
			waitForElementToDisappear(myprofilePage.shareButton);
			actualPost = getTextFromElement(myprofilePage.recentFeedInPosts);
			validateMessage(actualPost, expectedPost);
		}

		// click on file link
		clickButton(myprofilePage.fileLink);
		clickButton(myprofilePage.uploadFromComputerButton);
		enterTextFromKeyboard(myprofilePage.chooseFile,
				"C:\\Users\\meena\\Desktop\\Resumes\\Meena\\Studies\\Java Projects\\Car.txt");
		clickButton(myprofilePage.shareFileButton);
		String expectedText = "Download txt";
		String actualText = getTextFromElement(myprofilePage.uploadedFileDownloadOption);
		validateMessage(actualText, expectedText);

		// click Add Photo
		System.out.println();
		mouseHoverOn(myprofilePage.mouseHoverOnAddPhoto);
		System.out.println("Options size : " + myprofilePage.listOfUploadPhotoOptions.size());
		for (int i = 0; i < myprofilePage.listOfUploadPhotoOptions.size(); i++) {
			System.out.println(
					"List of upload options : " + getTextFromElement(myprofilePage.listOfUploadPhotoOptions.get(i)));
		}

		if (getSizeOfWebElements(myprofilePage.listOfUploadPhotoOptions) > 0) {
			clickButton(myprofilePage.listOfUploadPhotoOptions.get(0));
		}

		switchToFrame(myprofilePage.uploadProfilePhotoFrame);
		enterTextFromKeyboard(myprofilePage.chooseProfilePhotoButton,
				"C:\\Users\\meena\\OneDrive\\Pictures\\Camera Roll\\Baby-Krishna-Wallpaper-HD-8.jpg");
		clickButton(myprofilePage.saveProfilePhotoButton);
		getListOfFramesAndSwitch(myprofilePage.uploadProfilePhotoFrame);
		clickButton(myprofilePage.cropAndSaveProfilePhotoButton);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
