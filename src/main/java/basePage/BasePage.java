package basePage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Log;

public class BasePage  {
	
	public WebDriver driver;
	public boolean bResult;
	
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		bResult = true;
		
	}

	public void printt() {
		System.out.println("base page driver is"+driver);
	}
	
	public static void handleDropDown(WebElement ele,String Value) throws Exception {
		Thread.sleep(5000);
		Select selectByVisibleText = new Select(ele);
		selectByVisibleText.selectByVisibleText(Value);
	}
	
	public static void selectDate() {
		
		
	}
	
	public static void waitHandle(WebDriver driver,WebElement ele,int timeout) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		}
	
	public  boolean isElementDisplayed(WebElement element) {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, 1);
	        wait.until(ExpectedConditions.visibilityOf(element));
	        return element.isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}
	
	public  void waitForElementToBeGone(WebElement element, int timeout) {
	    if (isElementDisplayed(element)) {
	        new WebDriverWait(driver, timeout).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));
	    }
	}

}
