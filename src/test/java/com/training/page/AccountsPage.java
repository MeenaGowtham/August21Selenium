package com.training.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class AccountsPage extends BasePage {

	public AccountsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "Accounts")
	public WebElement accountsLink;
	
	@FindBy(xpath = "//div[@id='tryLexDialog']")
	public WebElement lightningExperiencePopup;
	
	@FindBy(xpath = "//div[@class='topLeft']//a[@title='Close']")
	public WebElement closeLightningExperiencePopup;
	
	@FindBy(xpath = "//input[@name='new']")
	public WebElement newAccountButton;
	
	@FindBy(xpath = "//input[@id='acc2']")
	public WebElement accountName;
	
	@FindBy(xpath = "//select[@id='acc6']")
	public WebElement accountTypeDropDown;
	
	@FindBy(xpath = "//select[@id='00N5f000006dbZd']")
	public WebElement customerPriorityDropDown;
	
	@FindBy(xpath = "//td[@id='bottomButtonRow']//input[@name='save']")
	public WebElement saveNewAccountButton;
	
	@FindBy(xpath = "//a[@id='ext-gen10']")
	public WebElement closeNewAccountPopUp;
	
	@FindBy(xpath = "//h2[@class='topName']")
	public WebElement newAccountNameConfirmation;
	
	@FindBy(linkText = "Create New View")
	public WebElement createNewViewLink;
	
	@FindBy(xpath = "//input[@id='fname']")
	public WebElement viewName;
	
	@FindBy(xpath = "//input[@id='devname']")
	public WebElement viewUniqueName;
	
	@FindBy(xpath = "//div[@class='pbBottomButtons']//input[@name='save']")
	public WebElement saveViewButton;
	
	@FindBy(xpath = "//select[@name='fcf']")
	public WebElement viewDropDown;
	
	@FindBy(linkText = "Edit")
	public WebElement editViewLink;
	
	@FindBy(xpath = "//select[@name='fcol1']")
	public WebElement fieldFilterDropDown;
	
	@FindBy(xpath = "//select[@name='fop1']")
	public WebElement operatorFilterDropDown;
	
	@FindBy(xpath = "//input[@name='fval1']")
	public WebElement valueTextBox;
	
	@FindBy(xpath = "//select[@name='colselector_select_0']")
	public WebElement fieldsToDisplay;
	
	@FindBy(xpath = "//a[@id='colselector_select_0_right']")
	public WebElement addFieldButton;
	
	@FindBy(xpath = "//div[@class='pbBottomButtons']//input[@value=' Save ']")
	public WebElement saveEditViewButton;
	
	@FindBy(xpath = "//div[@class='x-grid3-cell-inner x-grid3-col-Name']")
	public List<WebElement> listOfAccountNames;
	
	@FindBy(xpath = "//tr[@class='x-grid3-hd-row']")
	public List<WebElement> viewHeader;
	
	@FindBy(linkText = "Merge Accounts")
	public WebElement mergeAccountsLink;
	
	@FindBy(xpath = "//input[@id='srch']")
	public WebElement findAccountsTextBox;
	
	@FindBy(xpath = "//input[@name='srchbutton']")
	public WebElement findAccountsButton;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	public List<WebElement> numberOfCheckBoxes;
	
	@FindBy(xpath = "//div[@class='pbBottomButtons']//input[@name='goNext']")
	public WebElement nextButton;

	@FindBy(xpath = "//table[@class='mergeEntity']//tr[4]")
	public List<WebElement> accountNamesToBeMerged;
	
	@FindBy(xpath = "//div[@class='pbBottomButtons']//input[@title='Merge']")
	public WebElement mergeButton;
	
	@FindBy(xpath = "//table[@class='list']//tr//th//a")
	public List<WebElement> mergedAccountNames;
	
	@FindBy(partialLinkText = "activity > 30 days")
	public WebElement accountsActivity;
	
	@FindBy(xpath = "//button[@id='ext-gen189']")
	public WebElement noThanksButton;

	@FindBy(xpath = "//input[@name='dateColumn']")
	public WebElement dateField;
	
	@FindBy(xpath = "//div[contains(text(),'Created Date')]")
	public WebElement createdDate;
	
	@FindBy(xpath = "//img[@id='ext-gen152']")
	public WebElement fromDate;
	
	@FindBy(xpath = "//button[contains(text(),'Today')]")
	public WebElement todaysFromDate;
	
	@FindBy(xpath = "//img[@id='ext-gen154']")
	public WebElement toDate;
	
	@FindBy(xpath = "//li[@id='x-menu-el-ext-comp-1047']//div//table//tbody//tr[3]//td//table//tbody//tr//td//em//button[contains(text(),'Today')]")
	public WebElement todaysToDate;
	
	@FindBy(xpath = "//table[@id='saveReportBtn']//button[contains(text(),'Save')]")
	public WebElement saveReportsButton;
	
	@FindBy(xpath = "//input[@name='reportName']")
	public WebElement reportName;
	
	@FindBy(xpath = "//input[@name='reportDevName']")
	public WebElement reportUniqueName;
		
	@FindBy(xpath = "//textarea[@name='reportDescription']")
	public WebElement reportDescription;
	
	@FindBy(xpath = "//button[contains(text(),'Save and Run Report')]")
	public WebElement saveAndRunReport;
	
	@FindBy(xpath = "//h1[@class='noSecondHeader pageType']")
	public WebElement verifyReportName;
}
