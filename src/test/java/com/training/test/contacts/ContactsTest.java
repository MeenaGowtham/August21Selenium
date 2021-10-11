package com.training.test.contacts;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.page.AccountsPage;
import com.training.page.ContactsPage;
import com.training.page.HomePage;
import com.training.page.LoginPage;
import com.training.utilities.CommonUtilities;

public class ContactsTest extends BaseTest {
	WebDriver driver;
	CommonUtilities common = new CommonUtilities();
	LoginPage loginPage;
	HomePage homePage;
	AccountsPage accountsPage;
	ContactsPage contactsPage;

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

		// login
		enterTextFromKeyboard(loginPage.username, "meego@tekarch.com");
		enterTextFromKeyboard(loginPage.password, "Scooby18");
		clickButton(loginPage.loginButton);
		clickButton(homePage.allTabsIcon);
		clickButton(contactsPage.contactsLink);
		clickButton(accountsPage.closeLightningExperiencePopup);
	}

	@Test
	public void createNewContact() {
		String expectedName = "2021";
		clickButton(contactsPage.newContacts);
		enterTextFromKeyboard(contactsPage.lastName, expectedName);
		clickButton(contactsPage.accountNameSearch);
		switchWindowsAndFrame(contactsPage.accountNamesFrame, contactsPage.selectAccountName);
		clickButton(contactsPage.saveContact);
		String actualName = contactsPage.validateContactName.getText();
		validateMessage(actualName, expectedName);
	}

	@Test
	public void createNewViewContacts() {
		String expectedContactViewName = "SuiteParameter1";
		clickButton(contactsPage.createNewView);
		enterTextFromKeyboard(contactsPage.newViewName, expectedContactViewName);
		clickButton(contactsPage.viewUniqueName);
		clickButton(accountsPage.saveViewButton);
		String actualContactViewName = getSelectedOptionFromDropDown(contactsPage.viewsDropDown);
		validateMessage(actualContactViewName, expectedContactViewName);
	}

	@Test
	public void recentlyCreatedContact() {
		String expectedName = "SuiteRunOnOct10";
		clickButton(contactsPage.newContacts);
		enterTextFromKeyboard(contactsPage.lastName, expectedName);
		clickButton(contactsPage.saveContact);
		clickButton(homePage.allTabsIcon);
		clickButton(contactsPage.contactsLink);
		selectFromDropDownByText(contactsPage.filterDropDown, "Recently Created");
		clickButton(contactsPage.showContactsLink);
		assertTrue(validateListWithText(contactsPage.contactNamesColumn, expectedName));
	}

	@Test
	public void myContactsView() {
		String expectedOwner = "MM";
		selectFromDropDownByText(contactsPage.viewsDropDown, "My Contacts");
		clickButton(contactsPage.goButton);
		ArrayList<String> ListOfOwners = getListOfItemsAsList(contactsPage.listOfContactOwners);
		for (String actualOwner : ListOfOwners) {
			validateMessage(actualOwner, expectedOwner);
		}
	}

	@Test
	public void viewContact() {

		// Creating New Contact
		String expcetedSalutation = "Mr.";
		String expectedFirstName = "TestNG";
		String expectedLastName = "Suite";
		String expectedEmail = "suite@testng.com";
		String expectedContactName = expcetedSalutation + " " + expectedFirstName + " " + expectedLastName;
		clickButton(contactsPage.newContacts);
		selectFromDropDownByText(contactsPage.salutationDropDown, expcetedSalutation);
		enterTextFromKeyboard(contactsPage.firstName, expectedFirstName);
		enterTextFromKeyboard(contactsPage.lastName, expectedLastName);
		clickButton(contactsPage.accountNameSearch);
		switchWindowsAndFrame(contactsPage.accountNamesFrame, contactsPage.selectAccountName);
		enterTextFromKeyboard(contactsPage.emailField, expectedEmail);
		clickButton(contactsPage.saveContact);

		// View Contact
		clickButton(homePage.allTabsIcon);
		clickButton(contactsPage.contactsLink);
		clickButton(contactsPage.recentContactName);
		String actualContactName = getTextFromElement(contactsPage.validateContactName);
		String actualEmail = getTextFromElement(contactsPage.validateEmail);
		validateMessage(actualContactName, expectedContactName);
		validateMessage(actualEmail, expectedEmail);
	}

	@Test
	public void checkErrorMessageInCreateView() {
		String expectedErrorMessage = "Error: You must enter a value";
		clickButton(contactsPage.createNewView);
		enterTextFromKeyboard(contactsPage.viewUniqueName, "ViewMew");
		clickButton(accountsPage.saveViewButton);
		String actualErrorMessage = getTextFromElement(contactsPage.errorMessage);
		validateMessage(actualErrorMessage, expectedErrorMessage);
	}

	@Test
	public void cancelCreateView() {
		String expectedViewName = "Last Year";
		clickButton(contactsPage.createNewView);
		enterTextFromKeyboard(contactsPage.newViewName, expectedViewName);
		clickButton(contactsPage.viewUniqueName);
		clickButton(contactsPage.cancelNewView);
		assertFalse(validateDropDownItems(contactsPage.viewsDropDown, expectedViewName));
	}

	@Test
	public void saveAndCreateNewContact() {
		clickButton(contactsPage.newContacts);
		String expectedPageTitle = "Contact Edit: New Contact ~ Salesforce - Developer Edition";
		String expectedContactName = "Indians";
		enterTextFromKeyboard(contactsPage.lastName, expectedContactName);
		enterTextFromKeyboard(contactsPage.accountNameField, "kk");
		clickButton(contactsPage.saveAndNewContact);

		// saved contact validation
		String actualContactName = getTextFromElement(contactsPage.mostRecentContact);
		validateMessage(actualContactName, expectedContactName);

		// new contact page validation
		String actualPageTitle = driver.getTitle();
		validateMessage(actualPageTitle, expectedPageTitle);
	}

	@AfterMethod
	public void tearDown() {
		clickButton(homePage.userMenuDropDown);
		clickButton(homePage.logout);
		driver.close();
	}

}
