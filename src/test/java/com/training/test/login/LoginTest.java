package com.training.test.login;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.page.HomePage;
import com.training.page.LoginPage;
import com.training.utilities.CommonUtilities;

public class LoginTest extends BaseTest {
	WebDriver driver;
	CommonUtilities common = new CommonUtilities();
	LoginPage login;
	HomePage home;

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = getDriver();
		String url = common.getApplicationProperty("url");
		driver.manage().window().maximize();
		driver.get(url);
		login = new LoginPage(driver);
		home = new HomePage(driver);
	}

	@Test
	public void loginWithPartialCredentials() {
		enterTextFromKeyboard(login.username, "meego@tekarch.com");
		clickButton(login.loginButton);
		validateMessage(getTextFromElement(login.noPasswordMessage), "Please enter your password.");
	}

	@Test
	public void loginWithValidCredentials() throws InterruptedException {
		enterTextFromKeyboard(login.username, "meego@tekarch.com");
		enterTextFromKeyboard(login.password, "Scooby18");
		clickButton(login.loginButton);
		validateMessage(driver.getTitle(), "Home Page ~ Salesforce - Developer Edition");
	}

	@Test
	public void checkRememberMe() {
		enterTextFromKeyboard(login.username, "meego@tekarch.com");
		enterTextFromKeyboard(login.password, "Scooby18");
		clickButton(login.rememberMeCheckBox);
		clickButton(login.loginButton);
		clickButton(home.userMenuDropDown);
		clickButton(login.logoutButton);
		validateMessage(getTextFromElement(login.savedUserName), "meego@tekarch.com");
	}

	@Test
	public void forgotPassword() {
		clickButton(login.forgotPasswordLink);
		enterTextFromKeyboard(login.forgotPasswordUserNameField, "meego@tekarch.com");
		clickButton(login.continueButton);
	}

	@Test
	public void loginWithInvalidCredentials() {
		String expectedMessage = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		enterTextFromKeyboard(login.username, "trees");
		enterTextFromKeyboard(login.password, "y18");
		clickButton(login.loginButton);
		String actualMessage = getTextFromElement(login.invalidCredentialsMessage);
		validateMessage(actualMessage, expectedMessage);
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.close();
		}
	}

}
