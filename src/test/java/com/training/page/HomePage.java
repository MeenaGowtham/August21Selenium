package com.training.page;


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

	@FindBy(linkText = "Logout")
	public WebElement logout;
	
	@FindBy(xpath = "//img[@class='allTabsArrow']")
	public WebElement allTabsIcon;
	
	
}
