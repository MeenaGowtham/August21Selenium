package com.training.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class DeveloperConsolePage extends BasePage {

	public DeveloperConsolePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "Developer Console")
	public WebElement developerConsole;

}
