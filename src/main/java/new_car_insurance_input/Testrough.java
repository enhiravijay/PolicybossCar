package new_car_insurance_input;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Testrough {

	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get("http://qa.policyboss.com/car-insurance/buynow/2/ARN-OUJYYNIT-8TN3-BXHD-GBZC-VQ6N1KX90WRT_1724228_96210/NonPOSP/0");
			Thread.sleep(200);
			driver.findElement(By.xpath("//div[@class='popupScreen']/div[@class='popupclose']")).click();
			driver.findElement(By.xpath("//a[@id='TabPersonalInfo']")).click();
			Thread.sleep(200);
			WebElement ele = driver.findElement(By.xpath("//select[@id='Salutation']"));
			ele.click();
			Select sel = new Select(ele);
			sel.selectByVisibleText("Mr");
			driver.findElement(By.xpath("//input[@id='DOBofOwner']")).click();
			WebElement selMonth = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
			selMonth.click();
			Select selMonth1 = new Select(selMonth);
			selMonth1.selectByVisibleText("9");
			driver.findElement(By.xpath("//input[@id='DOBofOwner']")).click();
			WebElement selYear = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
			selMonth.click();
			Select selYear1 = new Select(selYear);
			selYear1.selectByVisibleText("1982");
			
			
					

	}

}
