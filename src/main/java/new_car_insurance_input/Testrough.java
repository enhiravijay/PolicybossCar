package new_car_insurance_input;

import java.util.List;
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
			driver.get("http://qa.policyboss.com/car-insurance/buynow/2/ARN-CPV0TCUH-Y7QW-GKYI-0ZDN-C1KHZI963MC7_1726428_96299/NonPOSP/0");
			Thread.sleep(200);
			driver.findElement(By.xpath("//div[@class='popupScreen']/div[@class='popupclose']")).click();
			driver.findElement(By.xpath("//a[@id='TabPersonalInfo']")).click();
			Thread.sleep(200);
			WebElement ele = driver.findElement(By.xpath("//select[@id='Salutation']"));
			ele.click();
			Select sel = new Select(ele);
			sel.selectByVisibleText("Mr");
			WebElement ContactLastName = driver.findElement(By.xpath("//input[@id='ContactLastName']"));
			sendText(ContactLastName, "Kumar");
			driver.findElement(By.xpath("//input[@id='DOBofOwner']")).click();
			WebElement selYear = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
			selYear.click();
			Select selYear1 = new Select(selYear);
			selYear1.selectByVisibleText("1982");
			WebElement selMonth = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
			selMonth.click();
			Select selMonth1 = new Select(selMonth);
			selMonth1.selectByVisibleText("Oct");
			//driver.findElement(By.xpath("//input[@id='DOBofOwner']")).click();
			Testrough.selectDay("10");
			 WebElement marStatus = driver.findElement(By.xpath("//select[@id='MaritalStatus']"));
		/*	 marStatus.click();
			 Select marStatus1 = new Select(marStatus);
			 Thread.sleep(100);
			 marStatus1.selectByVisibleText("Married");*/
			dropDownHandle(marStatus,"Married");
			WebElement selOccupation = driver.findElement(By.xpath("//select[@id='ContactOccupationId']"));
			dropDownHandle(selOccupation,"Others");
			WebElement ContactMobile = driver.findElement(By.xpath("//input[@id='ContactMobile']"));
			sendText(ContactMobile, "9999988888");
			WebElement ContactEmail = driver.findElement(By.xpath("//input[@id='ContactEmail']"));
			sendText(ContactEmail, "policybosstesting@gmail.com");
			WebElement TabAddInfo = driver.findElement(By.xpath("//div/a[@id='TabAddInfo']"));
			TabAddInfo.click();
			WebElement CheckforToggle = driver.findElement(By.xpath("//a[@aria-expanded='true']"));
			if(CheckforToggle.getAttribute("aria-expanded").contains("false")) {
				WebElement ManField = driver.findElement(By.xpath("//div[@class='valerr']"));
				boolean manDis = ManField.isDisplayed();
				if(manDis==true) {
					System.out.println("Mandatory field's are not entered.");
				}
			}
			WebElement RegisteredAddress = driver.findElement(By.xpath("//input[@id='RegisteredAddress']"));
			sendText(RegisteredAddress, "208 b,Bhartideep CHS");
			WebElement RegisteredAddress2 = driver.findElement(By.xpath("//input[@id='RegisteredAddress2']"));
			sendText(RegisteredAddress2, "Saibaba navghar road,bhayandar east");
			WebElement RegisteredAddress3 = driver.findElement(By.xpath("//input[@id='RegisteredAddress3']"));
			sendText(RegisteredAddress3, "Thana 401105");
			WebElement RegisteredPinCode = driver.findElement(By.xpath("//input[@id='RegisteredPinCode']"));
			sendText(RegisteredPinCode, "401105");
			Thread.sleep(60);
			WebElement RegisteredCityName = driver.findElement(By.xpath("//input[@id='RegisteredCityName']"));
			RegisteredCityName.click();
			WebElement ddlRegisteredCity = driver.findElement(By.xpath("//select[@id='ddlRegisteredCityId']"));
			ddlRegisteredCity.click();
			Select ddlRegisteredCity1 = new Select(ddlRegisteredCity);
			ddlRegisteredCity1.selectByIndex(1);
			WebElement TabVehicleAddInfo = driver.findElement(By.xpath("//div/a[@id='TabVehicleAddInfo']"));
			TabVehicleAddInfo.click();
			Thread.sleep(50);
			WebElement CheckforToggle1 = driver.findElement(By.xpath("//a[@aria-expanded='true']"));
			if(CheckforToggle1.getAttribute("aria-expanded").contains("false")) {
				WebElement ManField = driver.findElement(By.xpath("//div[@class='valerr']"));
				boolean manDis = ManField.isDisplayed();
				if(manDis==true) {
					System.out.println("Mandatory field's are not entered.");
				}
			}
			WebElement RegistrationNumberPart2 = driver.findElement(By.xpath("//input[@id='RegistrationNumberPart2']"));
			sendText(RegistrationNumberPart2, "EQ");
			WebElement RegistrationNumberPart3 = driver.findElement(By.xpath("//input[@id='RegistrationNumberPart3']"));
			sendText(RegistrationNumberPart3, "5648");
			WebElement EngineNumber = driver.findElement(By.xpath("//input[@id='EngineNumber']"));
			sendText(EngineNumber, "EN9967192191");
			WebElement ChasisNumber = driver.findElement(By.xpath("//input[@id='ChasisNumber']"));
			sendText(ChasisNumber, "CH99671234567");
			WebElement PolicyNumber = driver.findElement(By.xpath("//input[@id='PolicyNumber']"));
			sendText(PolicyNumber, "PL677991234567");
			WebElement VehicleColor = driver.findElement(By.xpath("//select[@id='VehicleColor']"));
			dropDownHandle(VehicleColor, "Black");
			String labelvalue = driver.findElement(By.xpath("//label[@id='IsFinancedYes']")).getAttribute("class");
			System.out.println("Value of a label is "+labelvalue);
			if(labelvalue.contains("btn-primary")) {
				WebElement FinancerAgreementType = driver.findElement(By.xpath("//select[@id='FinancerAgreementType']"));
				dropDownHandle(FinancerAgreementType, "Hypothecation");
			}
			WebElement InstitutionName = driver.findElement(By.xpath("//input[@id='InstitutionName']"));
			InstitutionName.click();
			sendText(InstitutionName, "BAJAJ AUTO FINANCE");
			Thread.sleep(60);
			handleAutoDropDown(InstitutionName,"BAJAJ AUTO FINANCE LTD");
			WebElement TabNomineeInfo = driver.findElement(By.xpath("//a[@id='TabNomineeInfo']"));
			TabNomineeInfo.click();
			WebElement CheckforToggle2 = driver.findElement(By.xpath("//a[@aria-expanded='true']"));
			if(CheckforToggle2.getAttribute("aria-expanded").contains("false")) {
				WebElement ManField = driver.findElement(By.xpath("//div[@class='valerr']"));
				boolean manDis = ManField.isDisplayed();
				if(manDis==true) {
					System.out.println("Mandatory field's are not entered.");
				}
			}
			
	}
	
	private static void selectDay(String dayValue) {
		WebElement dayelem=driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td/a[contains(.,'" + dayValue + "')]"));
		//WebElement dayelem=driver.findElement(By.xpath("//table[@class='table dtp-picker-days']/tbody/tr/td/a[contains(.,'" + dayValue + "')]"));
		
		WebElement GetFirstRegDay = driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td/a"));
		int intcalday = Integer.parseInt(GetFirstRegDay.getText());
		System.out.println(intcalday);
		for (int i = 0; i <= 31; i++) {
			if (intcalday == Integer.parseInt(dayValue)) {
				System.out.println(intcalday + " mon value is equal to " + dayValue);
				dayelem.click();
				break;
			} else if(intcalday <= Integer.parseInt(dayValue)){
				intcalday++;
				//GetFirstRegPrevYearBtn.click();
			}
			System.out.println(intcalday);

		}
	}
	
	private static void dropDownHandle(WebElement ele,String value) {
		ele.click();
		Select sel = new Select(ele);
		sel.selectByVisibleText(value);
		}
	
	private static void sendText(WebElement ele,String value) {
		ele.click();
		ele.clear();
		ele.sendKeys(value);
	}
	
	private static void handleAutoDropDown(WebElement autoOptions,String Model) {
		List<WebElement> opList = autoOptions.findElements(By.xpath("//ul[@id='ui-id-1']/li[contains(text(),'" + Model + "')]"));
		int opSize = opList.size();
		for(int i = 0;i<opSize;i++) {
			if(opSize > 1) {
				opList.get(i).click();
				break;
			}else {
				opList.get(i).click();
				}
		}
	}

}
