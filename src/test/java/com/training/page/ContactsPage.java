package com.training.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class ContactsPage extends BasePage {

	public ContactsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "Contacts")
	public WebElement contactsLink;
	
	@FindBy(xpath = "//input[@name='new']")
	public WebElement newContacts;

	@FindBy(xpath = "//input[@name='name_firstcon2']")
	public WebElement firstName;

	@FindBy(xpath = "//input[@name='name_lastcon2']")
	public WebElement lastName;
	
	@FindBy(xpath = "//input[@name='con4']")
	public WebElement accountNameField;

	@FindBy(xpath = "//a[@title='Account Name Lookup (New Window)']//img[@class='lookupIcon']")
	public WebElement accountNameSearch;
	
	@FindBy(xpath = "//frame[@name='resultsFrame']")
	public WebElement accountNamesFrame;
	
	@FindBy(xpath = "//table[@class='list']//tbody//tr[7]//th//a")
	public WebElement selectAccountName;
		
	@FindBy(xpath = "//input[@name='con15']")
	public WebElement emailField;
	
	@FindBy(xpath = "//td[@id='topButtonRow']//input[@name='save']")
	public WebElement saveContact; 
	
	@FindBy(xpath = "//td[@id='topButtonRow']//input[@name='save_new']")
	public WebElement saveAndNewContact; 
	
	@FindBy(xpath = "//div[@id='con2_ileinner']")
	public WebElement validateContactName;
	
	@FindBy(xpath = "//div[@id='con15_ileinner']")
	public WebElement validateEmail;
	
	@FindBy(linkText = "Create New View")
	public WebElement createNewView;
	
	@FindBy(xpath = "//input[@name='fname']")
	public WebElement newViewName;
	
	@FindBy(xpath = "//input[@name='devname']")
	public WebElement viewUniqueName;
	
	@FindBy(xpath = "//div[@class='pbHeader']//input[@name='save']")
	public WebElement saveView;
	
	@FindBy(xpath = "//select[@name='fcf']")
	public WebElement viewsDropDown;
	
	@FindBy(xpath = "//select[@name='hotlist_mode']")
	public WebElement filterDropDown;
	
	@FindBy(partialLinkText = "Show")
	public WebElement showContactsLink;
	
	@FindBy(xpath = "//table[@class='list']//tr//th//a")
	public List<WebElement> contactNamesColumn;
	
	@FindBy(xpath = "//div[@class='x-grid3-scroller']//td[9]")
	public List<WebElement> listOfContactOwners;
	
	@FindBy(xpath = "//input[@name='go']")
	public WebElement goButton;
	
	@FindBy(xpath = "//select[@name='name_salutationcon2']")
	public WebElement salutationDropDown;
	
	@FindBy(xpath = "//tr[2]//th//a[1]")
	public WebElement recentContactName;
	
	@FindBy(xpath = "//div[@class='x-grid3-body']//tr/td[4]")
	public List<WebElement> contactNamesList;

	@FindBy(xpath = "//div[@class='pbSubbody']//tr[1]//div[@class='errorMsg']")
	public WebElement errorMessage;
	
	@FindBy(xpath = "//div[@class='pbHeader']//input[@value='Cancel']")
	public WebElement cancelNewView;
	
	@FindBy(xpath = "//div[@class='contactBlock'][1]//span[@class='mruText']")
	public WebElement mostRecentContact;
//	
//	@FindBy(xpath = "")
//	public WebElement
}
