package com.training.base;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
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
	protected WebDriver driver;
	private Actions action;

	public WebDriver getDriver() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		action = new Actions(driver);
		return driver;
	}

	public void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForClick(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForClickToBeEnable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementSelectionStateToBe(element, true));
	}

	public void waitForElementToDisappear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void waitForFrameAndSwitch(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}

	public void waitForWindows() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
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
		} else {
			System.out.println("Not Clicked");
		}
	}

	public void validateMessage(String actualText, String expectedText) {
		assertEquals(actualText, expectedText);
	}

	public String getTextFromElement(WebElement element) {
		waitForElement(element);
		String valueInElement = element.getText();
		return valueInElement;
	}

	public void clearField(WebElement element) {
		element.clear();
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

	public void selectFromDropDownByText(WebElement element, String visibleText) {
		waitForElement(element);
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}
	
	public void selectFromDropDownByIndex(WebElement element, int index) {
		waitForElement(element);
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public String getSelectedOptionFromDropDown(WebElement element) {
		Select select = new Select(element);
		return getTextFromElement(select.getFirstSelectedOption());
	}
	
	public String getDropDownOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> dropDownList = select.getOptions();
		ArrayList<String> optionsList = new ArrayList<String>();
		for(int i=0; i<dropDownList.size(); i++) {
			String options = dropDownList.get(i).getText();
			optionsList.add(options);
		}
		System.out.println("Actual List : "+optionsList);
		return optionsList.toString();
	}
	
	public boolean validateDropDownItems(WebElement element, String expectedItem) {
		String actualItems = getDropDownOptions(element);
		if(actualItems.contains(expectedItem)) {
			return true;
		}
		return false;		
	}
	
	public void newTabValidation(WebElement element, String tabName) {
		if (getTextFromElement(element).contains(tabName)) {
			System.out.println("Successfully added " + tabName + " Tab");
		} else {
			System.out.println("Not added");
		}
	}

	public String getListOfItemsAsString(List<WebElement> element) {
		Iterator<WebElement> listMenu = element.iterator();
		ArrayList<String> getElementsList = new ArrayList<String>();

		while (listMenu.hasNext()) {
			String strUserMenu = listMenu.next().getText();
			getElementsList.add(strUserMenu);
		}
		return getElementsList.toString();
	}
	public ArrayList<String> getListOfItemsAsList(List<WebElement> element) {
		Iterator<WebElement> listMenu = element.iterator();
		ArrayList<String> getElementsList = new ArrayList<String>();

		while (listMenu.hasNext()) {
			String strUserMenu = listMenu.next().getText();
			getElementsList.add(strUserMenu);
		}
		return getElementsList;
	}
	
	public boolean validateListWithText(List<WebElement> element, String text) {
		Iterator<WebElement> listMenu = element.iterator();

		while (listMenu.hasNext()) {
			String accountName = listMenu.next().getText();
			if(!accountName.contains(text)) {
				return false;
			}
		}
		return true;
	}

	public void switchToWindows(WebElement element, String expectedText) {
		String MainWindow = driver.getWindowHandle();
		waitForWindows();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> i1 = windows.iterator();
		while (i1.hasNext()) {
			String ChildWindow = i1.next();

			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
				// Switching to Child window
				driver.switchTo().window(ChildWindow);

				// validating child window
				String actualText = getTextFromElement(element);
				validateMessage(actualText, expectedText);
				clickButton(element);
				driver.close();
			}
		}
	}

	public void switchBetweenWindowsValidateAndClose(String expectedPageTitle) {
		String parentWindow = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			if (!parentWindow.equalsIgnoreCase(handle)) {
				driver.switchTo().window(handle);
				String actualPageTitle = driver.getTitle();
				validateMessage(actualPageTitle, expectedPageTitle);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
	}
	
	public void switchWindowsAndClick(WebElement element) {
		String parentWindow = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			if (!parentWindow.equalsIgnoreCase(handle)) {
				driver.switchTo().window(handle);
				clickButton(element);
			}
		}
		driver.switchTo().window(parentWindow);
	}
	
	public void switchWindowsAndFrame(WebElement iframeElement1, WebElement element1) {
		String parentWindow = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			if (!parentWindow.equalsIgnoreCase(handle)) {
				driver.switchTo().window(handle);
				switchToFrame(iframeElement1);
				clickButton(element1);
			}
		}
		driver.switchTo().window(parentWindow);
	}
	
	public List<WebElement> getOptionsFromDropDown(WebElement element) {
		waitForElement(element);
		Select select = new Select(element);
		List<WebElement> dropDownList = select.getOptions();
		return dropDownList;
	}
	
	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public boolean validateHighlightedTab(WebElement element) {
		if(element.isSelected()) {
			return true;
		}
		return false;
	}
}
