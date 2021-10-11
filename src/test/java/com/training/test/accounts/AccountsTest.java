package com.training.test.accounts;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.page.AccountsPage;
import com.training.page.HomePage;
import com.training.page.LoginPage;
import com.training.utilities.CommonUtilities;

public class AccountsTest extends BaseTest {

	WebDriver driver;
	CommonUtilities common = new CommonUtilities();
	LoginPage loginPage;
	HomePage homePage;
	AccountsPage accountsPage;

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = getDriver();
		String url = common.getApplicationProperty("url");
		driver.manage().window().maximize();
		driver.get(url);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		accountsPage = new AccountsPage(driver);

		// login
		enterTextFromKeyboard(loginPage.username, "meego@tekarch.com");
		enterTextFromKeyboard(loginPage.password, "Scooby18");
		clickButton(loginPage.loginButton);
		clickButton(homePage.allTabsIcon);
		clickButton(accountsPage.accountsLink);
		clickButton(accountsPage.closeLightningExperiencePopup);
	}

	@Test
	public void createNewAccount() {
		String expectedName = "Automated Name";
		clickButton(accountsPage.newAccountButton);
		enterTextFromKeyboard(accountsPage.accountName, expectedName);
		selectFromDropDownByText(accountsPage.accountTypeDropDown, "Technology Partner");
		selectFromDropDownByText(accountsPage.customerPriorityDropDown, "High");
		clickButton(accountsPage.saveNewAccountButton);
		String actualName = getTextFromElement(accountsPage.newAccountNameConfirmation);
		validateMessage(actualName, expectedName);
	}

	@Test
	public void createNewViewAccounts() {
		String newListViewName = "newSuiteView";
		clickButton(accountsPage.createNewViewLink);
		enterTextFromKeyboard(accountsPage.viewName, newListViewName);
		clickButton(accountsPage.viewUniqueName);
		clickButton(accountsPage.saveViewButton);
		List<WebElement> actualListView = getOptionsFromDropDown(accountsPage.viewDropDown);
		assertTrue(validateListWithText(actualListView, newListViewName));
	}

	@Test
	public void editViewLinkAccounts() {
		selectFromDropDownByText(accountsPage.viewDropDown, "newSuiteView");
		String currentViewName = getSelectedOptionFromDropDown(accountsPage.viewDropDown);
		clickButton(accountsPage.editViewLink);
		accountsPage.viewName.clear();
		String newViewName = "new".concat(currentViewName);
		enterTextFromKeyboard(accountsPage.viewName, newViewName);
		selectFromDropDownByText(accountsPage.fieldFilterDropDown, "Account Name");
		selectFromDropDownByText(accountsPage.operatorFilterDropDown, "contains");
		enterTextFromKeyboard(accountsPage.valueTextBox, "n");
		selectFromDropDownByText(accountsPage.fieldsToDisplay, "Last Activity");
		clickButton(accountsPage.addFieldButton);
		clickButton(accountsPage.saveEditViewButton);
		String actualViewName = getTextFromElement(accountsPage.viewDropDown);
		if (actualViewName.contains(newViewName)) {
			System.out.println("Edit View is successful");
		} else {
			System.out.println("Edit is not success");
		}
		assertTrue(validateListWithText(accountsPage.listOfAccountNames, "n"));
		assertTrue(validateListWithText(accountsPage.viewHeader, "Last Activity"));
	}

	@Test
	public void mergeAccounts() {
		String accountNameToBeMerged = "testsuite";
		clickButton(accountsPage.newAccountButton);
		enterTextFromKeyboard(accountsPage.accountName, accountNameToBeMerged);
		selectFromDropDownByText(accountsPage.accountTypeDropDown, "Technology Partner");
		selectFromDropDownByText(accountsPage.customerPriorityDropDown, "High");
		clickButton(accountsPage.saveNewAccountButton);

		clickButton(homePage.allTabsIcon);
		clickButton(accountsPage.accountsLink);
		clickButton(accountsPage.newAccountButton);
		enterTextFromKeyboard(accountsPage.accountName, accountNameToBeMerged);
		selectFromDropDownByText(accountsPage.accountTypeDropDown, "Technology Partner");
		selectFromDropDownByText(accountsPage.customerPriorityDropDown, "High");
		clickButton(accountsPage.saveNewAccountButton);

		clickButton(homePage.allTabsIcon);
		clickButton(accountsPage.accountsLink);
		clickButton(accountsPage.mergeAccountsLink);
		enterTextFromKeyboard(accountsPage.findAccountsTextBox, accountNameToBeMerged);
		clickButton(accountsPage.findAccountsButton);
		if (accountsPage.numberOfCheckBoxes.size() > 2) {
			for (int row = 2; row < accountsPage.numberOfCheckBoxes.size(); row++) {
				if (accountsPage.numberOfCheckBoxes.get(row).isSelected()) {
					clickButton(accountsPage.numberOfCheckBoxes.get(row));
				}
			}
		} else if (accountsPage.numberOfCheckBoxes.size() < 2) {
			System.out.println("Two accounts are required to merge");
		}
		clickButton(accountsPage.nextButton);
		assertTrue(validateListWithText(accountsPage.accountNamesToBeMerged, accountNameToBeMerged));
		clickButton(accountsPage.mergeButton);
		acceptAlert();
		assertTrue(validateListWithText(accountsPage.mergedAccountNames, accountNameToBeMerged));
	}

	@Test
	public void createAccountReport() throws InterruptedException, AWTException {
		String expectedPageTitle = "Unsaved Report ~ Salesforce - Developer Edition";
		String expectedReportName = "October-10";
		clickButton(accountsPage.accountsActivity);
		String actualPageTitle = driver.getTitle();
		validateMessage(actualPageTitle, expectedPageTitle);
		clickButton(accountsPage.dateField);
		clickButton(accountsPage.createdDate);
		clickButton(accountsPage.fromDate);
		clickButton(accountsPage.todaysFromDate);
		clickButton(accountsPage.toDate);
		clickButton(accountsPage.todaysToDate);
		clickButton(accountsPage.saveReportsButton);
		enterTextFromKeyboard(accountsPage.reportName, expectedReportName);
		clickButton(accountsPage.reportUniqueName);
		enterTextFromKeyboard(accountsPage.reportDescription, "creating from framework");
		Thread.sleep(1000);
		clickButton(accountsPage.saveAndRunReport);
		waitForElement(accountsPage.verifyReportName);
		String actualReportName = getTextFromElement(accountsPage.verifyReportName);
		validateMessage(actualReportName, expectedReportName);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
