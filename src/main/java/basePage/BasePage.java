package basePage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constant;

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
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        wait.until(ExpectedConditions.visibilityOf(element));
	        return element.isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}
	
	public  boolean isElementClickable(WebElement element) {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	        return element.isEnabled();
	    } catch (Exception e) {
	        return false;
	    }
	}
	
	public  void waitForElementToBeGone(WebElement element, int timeout) {
	    if (isElementDisplayed(element)) {
	        new WebDriverWait(driver, timeout).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));
	    }
	}
	
	public void jsExecute(WebElement element) {
		waitHandle(driver, element, 20);
		//WebElement  element=driver.findElement(By.xpath"");  
		JavascriptExecutor ex=(JavascriptExecutor)driver;
		ex.executeScript("arguments[0].click()", element);
	}
	
	public  String capture(String screenshotName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = Constant.Path_ScreenShot;
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);
 
        return dest;
    }
	
	public static void handleWait(WebElement ele,WebDriver driver,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public static void sendText(WebElement ele,String value) {
		ele.click();
		ele.clear();
		ele.sendKeys(value);
	}

	public static String verifyElementTxt(WebElement ele) {
		String eleText = ele.getText();
		return eleText;
	}
	
}
