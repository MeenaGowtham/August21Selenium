package com.training.page;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class LoginPage extends BasePage {
	
	@FindBy(xpath = "//input[@id='username']")
	public WebElement username;
	
	@FindBy(xpath = "//input[@id='password']")
	public WebElement password;
	
	@FindBy(xpath = "//input[@id='Login']")
	public WebElement loginButton;
	
	@FindBy(xpath = "//div[@id='error']")
	public WebElement noPasswordMessage;
	
	@FindBy(xpath = "//form[@name='login']//div[@class='loginError']")
	public WebElement invalidCredentialsMessage;
	
	@FindBy(xpath = "//input[@class='r4 fl mr8']")
	public WebElement rememberMeCheckBox;
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	public WebElement logoutButton;
		
	@FindBy(xpath = "//div[@id='idcard']")
	public WebElement savedUserName;
	
	@FindBy(xpath = "//a[@id='forgot_password_link']")
	public WebElement forgotPasswordLink;
	
	@FindBy(xpath = "//input[@id='un']")
	public WebElement forgotPasswordUserNameField;
	
	@FindBy(xpath = "//input[@name='continue']")
	public WebElement continueButton;
		
	public LoginPage(WebDriver driver) {
		super(driver);
	}

}
