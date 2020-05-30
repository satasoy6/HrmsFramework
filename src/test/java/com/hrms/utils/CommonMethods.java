package com.hrms.utils;

import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
import com.hrms.testbase.PageInitializer;

public class CommonMethods extends PageInitializer{


/**
 * Method that clears and sends keys
 * @param element
 * @param text
 */
	public static void sendText(WebElement element, String text) {
		
		element.clear();
		element.sendKeys(text);
	}
	
	
	/**
	 * This method checks if radio/checkbox is enabled and clicks it
	 * @param radioOrCheckBox
	 * @param value
	 */
	
	public static void clickRadioOrCheckBox(List<WebElement>radioOrCheckBox,String value) {
		
		String actualValue;
		
		for(WebElement el:radioOrCheckBox) {
			actualValue=el.getAttribute("value").trim();
			if(el.isEnabled()&& actualValue.equals(value)) {
				el.click();
				break;
			}
		}
	}
	
	/**
	 * Method that checks if text is there and then selects it.
	 * @param element
	 * @param textToSelect
	 */
	public static void selectDdValue(WebElement element,String textToSelect) {
		try {
		Select select=new Select(element);
		List<WebElement> options=select.getOptions();
		
		for(WebElement el:options) {
			if(el.getText().equals(textToSelect)) {
				select.selectByVisibleText(textToSelect);
				break;
			}
		}
	}catch(UnexpectedTagNameException e) {
		e.printStackTrace();
	}
		
		
}
	
	/**
	 * This method selects value by index
	 * @param element
	 * @param index
	 */
	public static void selectDdValue(WebElement element,int index) {
		try {
			Select select=new Select(element);
			List<WebElement> options=select.getOptions();
			int size=options.size();
			
				if(size>index) {
					select.selectByIndex(index);
				
				}
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void acceptAlert() {
		try {
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}catch(NoAlertPresentException e) {
		e.printStackTrace();
	}
}
	
	public static void dismissAlert() {
		try {
			Alert alert=driver.switchTo().alert();
			alert.dismiss();
			
		}catch(NoAlertPresentException e) {
			e.printStackTrace();
		}
	}
	public static String getAlertText() {
		String alertText=null;
		
		try {
			Alert alert=driver.switchTo().alert();
			alertText= alert.getText();
		}catch(NoAlertPresentException e) {
			e.printStackTrace();
	
		}
		return alertText;
	}
	
	public static void sendAlertText(String text) {
		try {
			Alert alert=driver.switchTo().alert();
			alert.sendKeys(text);
		}catch(NoAlertPresentException e) {
			e.printStackTrace();
		}
	}
	
	public static void switchToFrame(String nameOrId) {
		try {
			driver.switchTo().frame(nameOrId);
		}catch(NoSuchFrameException e) {
			e.printStackTrace();
		}
	}
	
	public static void switchToFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);
			
		}catch(NoSuchFrameException e) {
			e.printStackTrace();
		}
	}
	
	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		}catch(NoSuchFrameException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Method switches focus to child window
	 */
	public static void switchToChildWindow() {
		String mainWindow=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		for(String window : windows) {
			if(!window.equals(mainWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
	}
	
	public static WebDriverWait getWaitObject () {
		WebDriverWait wait=new WebDriverWait(driver,Constants.EXPLICIT_WAIT_TIME);
		return wait;
	}
	
	public static WebElement waitForClickability(WebElement element) {
		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}
	public static void waitAndClick(WebElement element) {
		waitForClickability(element);
		element.click();
	}
	public static void explicitWait(WebDriver driver, WebElement element, int timeout,String value) {
		new WebDriverWait(driver,timeout);
		until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}
	private static void until(ExpectedCondition<WebElement> visibilityOf) {
		// TODO Auto-generated method stub
		
	}

	public static WebElement waitForVisibility(WebElement element) {
		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}
	public static void click(WebElement element) {
		waitForClickability(element);
		element.click();
	}
	public static JavascriptExecutor getJSObject() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		return js;
	}

	public static void jsClick(WebElement element) {
		getJSObject().executeScript("arguments[0].click();", element);
	}

	public static void scrollToElement(WebElement element) {
		getJSObject().executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * Method that will scroll the page down based on the passed pixel parameters
	 * 
	 * @param pixel
	 */
	public static void scrollDown(int pixel) {
		getJSObject().executeScript("window.scrollBy(0," + pixel + ")");
	}

	/**
	 * Method that will scroll the page up based on the passed pixel parameters
	 * 
	 * @param pixel
	 */
	public static void scrollUp(int pixel) {
		getJSObject().executeScript("window.scrollBy(0,-" + pixel + ")");
	}

	/**
	 * This method will take a screenshot
	 * @param filename
	 */
	public static void takeScreenShot(String filename) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(file, new File("screenshot/" + filename + ".png"));
		} catch (Exception ex) {
			System.out.println("Cannot take screenshot!");
		}
		
	}

	public static void wait(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}