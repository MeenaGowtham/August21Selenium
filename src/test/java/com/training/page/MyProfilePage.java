package com.training.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class MyProfilePage extends BasePage {
	
	public MyProfilePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@title='My Profile']")
	public WebElement myProfilelink;

	@FindBy(xpath = "//a[@class='contactInfoLaunch editLink']//img[@title='Edit Profile']")
	public WebElement editProfileIcon;

	@FindBy(xpath = "//div[@id='contactInfo']//iframe")
	public WebElement editProfileFrame;

	@FindBy(xpath = "//a[contains(text(),'About')]")
	public WebElement aboutTab;

	@FindBy(xpath = "//input[@name='lastName']")
	public WebElement updateLastNameField;

	@FindBy(xpath = "//input[@value='Save All']")
	public WebElement editFrameSaveAllButton;

	@FindBy(xpath = "//span[@id='tailBreadcrumbNode']")
	public WebElement lastName;

	@FindBy(xpath = "//a[@id='publisherAttachTextPost']")
	public WebElement postslink;

	@FindBy(xpath = "//iframe[@class='cke_wysiwyg_frame cke_reset']")
	public WebElement postsFrame;

	@FindBy(xpath = "//html//body[contains(text(),'Share an update,')]")
	public WebElement updatePostsTextBox;

	@FindBy(xpath = "//div[@class='bottomBarRight']/span/input")
	public WebElement shareButton;

	@FindBy(xpath = "//div[@class='cxfeeditem feeditem'][1]//p")
	public WebElement recentFeedInPosts;

	@FindBy(linkText = "File")
	public WebElement fileLink;

	@FindBy(xpath = "//a[contains(text(),'Upload')]")
	public WebElement uploadFromComputerButton;

	@FindBy(xpath = "//div[@class='requiredInput']//input[@id='chatterFile']")
	public WebElement chooseFile;

	@FindBy(xpath = "//*[@id='publishersharebutton']")
	public WebElement shareFileButton;

	@FindBy(xpath = "//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]/div[1]/span[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[2]/td[1]/a[1]/span[1]")
	public WebElement uploadedFileDownloadOption;

	@FindBy(xpath = "//span[@id='displayBadge']")
	public WebElement mouseHoverOnAddPhoto;

	@FindBy(xpath = "//div[@class='photoUploadSection']/a")
	public List<WebElement> listOfUploadPhotoOptions;

	@FindBy(linkText = "Add Photo")
	public WebElement addPhotoLink;

	@FindBy(linkText = "Update")
	public WebElement updatePhotoLink;

	@FindBy(id = "uploadPhotoContentId")
	public WebElement uploadProfilePhotoFrame;

	@FindBy(xpath = "//input[@class='fileInput']")
	public WebElement chooseProfilePhotoButton;

	@FindBy(xpath = "//input[@id='j_id0:uploadFileForm:uploadBtn']")
	public WebElement saveProfilePhotoButton;

	@FindBy(xpath = "//iframe[@id='uploadPhotoContentId']")
	public WebElement cropProfilePhotoFrame;

	@FindBy(xpath = "//input[@id='j_id0:j_id7:save']")
	public WebElement cropAndSaveProfilePhotoButton;

}
