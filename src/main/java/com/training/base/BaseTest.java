package com.training.base;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	private Actions action;

	public WebDriver getDriver() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		action = new Actions(driver);
		return driver;
	}

	public void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForClick(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForElementToDisappear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void waitForFrame(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}

	public void switchToFrame(WebElement element) {
		waitForElement(element);
		driver.switchTo().frame(element);
	}

	public void enterTextFromKeyboard(WebElement element, String value) {
		waitForElement(element);
		element.sendKeys(value);
	}

	public void clickButton(WebElement element) {
		waitForClick(element);
		if (element.isDisplayed() && element.isEnabled()) {
			element.click();
		} else
			System.out.println("Not Clicked");
	}

	public void validateMessage(String actualText, String expectedText) {
		assertEquals(actualText, expectedText);
	}

	public String getTextFromElement(WebElement element) {
		waitForElement(element);
		String valueInElement = element.getText();
		return valueInElement;
	}

	public void mouseHoverOn(WebElement element) {
		waitForElement(element);
		action.moveToElement(element).build().perform();
	}
	
	public int getSizeOfWebElements(List<WebElement> list) {
		int locatorSize = list.size();
		return locatorSize;
	}
	
	public void getListOfFramesAndSwitch(WebElement element) {
		java.util.List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		System.out.println("iFrames size : " + iframes.size());
		for (WebElement iframe : iframes) {
			if (iframe.getAttribute("id").equals(element)) {
				driver.switchTo().frame(iframe);
			}
		}
	}
	
	public boolean isFileDownloaded(String downloadPath, String fileName) {
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();
		/*
		 * for(File file:dirContents) { System.out.println("Files in Folder : "+ file);
		 * }
		 * 
		 * System.out.println("Length : "+dirContents.length);
		 */
		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().contains(fileName)) {
				// File has been found, it can now be deleted:
//				dirContents[i].delete();
				return true;
			}
		}
		return false;
	}
	
	public void selectFromDropDown(WebElement element, String text) {
		waitForElement(element);
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public void newTabValidation(WebElement element, String tabName) {
		if(getTextFromElement(element).contains(tabName)) {
			System.out.println("Successfully added " +tabName +" Tab");
		}
		else {
			System.out.println("Not added");
		}
	}
	
}
