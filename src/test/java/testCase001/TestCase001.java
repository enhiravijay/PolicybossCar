package testCase001;

import java.io.File;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import new_car_insurance_input.New_car_input_page;
import new_car_insurance_input.QuotePage;
import testBase.TestBase;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class TestCase001 extends TestBase {
	//public WebDriver driver;
	public Properties prop;
	public Constant constant;
	public ExcelUtils EU;
	public int iTestCaseRow = 1;
	public int iTestCaseRow1 = 2;
	public int iTestCaseRow3 = 3;
	public static ExtentReports extent;
	public static ExtentTest test;
	@BeforeSuite
	public void beforeSuite() {
		//extent = new ExtentReports("C:\\Users\\Vijay\\git\\New_Test\\New_Car_insurance\\New_Insurance\\test-output\\MyExtentReport.html",true);
		extent = new ExtentReports(Constant.Path_ExtentReport,true);
		//extent.loadConfig(new File("C:\\Users\\Vijay\\git\\New_Test\\New_Car_insurance\\New_Insurance\\src\\main\\resources\\configfile\\extent-config.xml"));
		extent.loadConfig(new File(Constant.Path_ExtentReport_Config));
	}
	
	@BeforeTest
	public void beforeTest() throws Exception {
		openBrowser();
		prop = getprop();
		EU = new ExcelUtils();
		//ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");
		System.out.println("sssttttaaarrrttt");
		driver.get(prop.getProperty("qaurl"));
		
	}
	
	@BeforeMethod
	public void beforeMethod(Method method) {
	test = extent.startTest((this.getClass().getSimpleName() + " :: " + method.getName()),method.getName());
	test.assignAuthor("Vijay Chetgiri");
	test.assignCategory("SmokeReport--Prod");
	}
	
	@Test
	public void Test0001() throws Exception {
		New_car_input_page car = new New_car_input_page(driver);
		//Log.startLog(Class.forName(TestCase001));
		car.enterVehicleDetail();
		test.log(LogStatus.INFO, "Vehicle details entered Successfully");
		car.enterPolicyDetail();
		test.log(LogStatus.INFO, "Policy details entered Successfully");
		car.enterPsnlDetail();
		test.log(LogStatus.INFO, "Psnl details entered Successfully");
		QuotePage quote = new QuotePage(driver);
		quote.getCrn();
		quote.getQuoteDetails();
		quote.getNoOfInsurers();
		quote.getIdv();
		quote.getPremium();
		quote.getDataMap();
		Map<Integer, Map<Integer, List<String>>> abcmap = quote.getDataMap();
		ExcelUtils.writeToExcel(abcmap);
		test.log(LogStatus.INFO, "Data written successfully in Excel");
		}
	
	@AfterMethod //AfterMethod annotation - This method executes after every test execution
	 public void screenShot(ITestResult result){
	 //using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
	 if(ITestResult.FAILURE==result.getStatus()){
	 try{
	 // To create reference of TakesScreenshot
	 TakesScreenshot screenshot=(TakesScreenshot)driver;
	 // Call method to capture screenshot
	 File src=screenshot.getScreenshotAs(OutputType.FILE);
	 // Copy files to specific location 
	 // result.getName() will return name of test case so that screenshot name will be same as test case name
	 FileUtils.copyFile(src, new File("C:\\Users\\Vijay\\git\\New_Test\\New_Car_insurance\\New_Insurance\\test-output\\screenshot\\"+result.getName()+".png"));
	 System.out.println("Successfully captured a screenshot");
	 }catch (Exception e){
	 System.out.println("Exception while taking screenshot "+e.getMessage());
	 } 
	 }
	}
	

	@AfterSuite
	public void afterSuite() throws Exception {
		extent.flush();
		extent.endTest(test);
		Thread.sleep(20);		
		extent.close();
	}
	

}

