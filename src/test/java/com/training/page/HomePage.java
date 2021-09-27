package com.training.page;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='menuButtonButton']/span")
	public WebElement userMenuDropDown;

	@FindBy(xpath = "//div[@id='userNav-menuItems']/a")
	public List<WebElement> userMenuDropDownList;

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

	@FindBy(xpath = "//a[@id='publisherAttachContentPost']")
	public WebElement fileLink;

	@FindBy(xpath = "//a[contains(text(),'Upload')]")
	public WebElement uploadFromComputerButton;

	@FindBy(xpath = "//*[@id='chatterFile']")
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

	public String getListOfItems(List<WebElement> element) {
		Iterator<WebElement> listMenu = element.iterator();
		ArrayList<String> getElementsList = new ArrayList<String>();

		while (listMenu.hasNext()) {
			String strUserMenu = listMenu.next().getText();
			getElementsList.add(strUserMenu);
		}
		return getElementsList.toString();
	}

}
