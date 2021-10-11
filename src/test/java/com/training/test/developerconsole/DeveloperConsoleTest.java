package com.training.test.developerconsole;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.page.DeveloperConsolePage;
import com.training.page.HomePage;
import com.training.page.LoginPage;
import com.training.utilities.CommonUtilities;

public class DeveloperConsoleTest extends BaseTest {
	
	CommonUtilities common = new CommonUtilities();
	LoginPage loginPage;
	HomePage homePage;
	DeveloperConsolePage developerConsolePage;

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = getDriver();
		String url = common.getApplicationProperty("url");
		driver.manage().window().maximize();
		driver.get(url);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		developerConsolePage = new DeveloperConsolePage(driver);
	}
	
	@Test
	public void selectDeveloperConsole() {
		ArrayList<String> expectedList = new ArrayList<String>(Arrays.asList("My Profile", "My Settings",
				"Developer Console", "Switch to Lightning Experience", "Logout"));
		String expectedPageTitle = "Developer Console";
		enterTextFromKeyboard(loginPage.username, "meego@tekarch.com");
		enterTextFromKeyboard(loginPage.password, "Scooby18");
		clickButton(loginPage.loginButton);
		clickButton(homePage.userMenuDropDown);
		String actualList = getListOfItemsAsString(homePage.userMenuDropDownList);
		String strExpectedList = expectedList.toString();
		validateMessage(actualList, strExpectedList);

		// click Developer console
		clickButton(developerConsolePage.developerConsole);
		switchBetweenWindowsValidateAndClose(expectedPageTitle);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
