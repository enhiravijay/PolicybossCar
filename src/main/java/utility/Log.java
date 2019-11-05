package utility;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;

import basePage.BasePage;

public class Log extends BasePage{
	 public Log(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Initialize Log4j instance
    public static Logger Log = Logger.getLogger(Log.class.getName());
    
    public static Logger getLogData(String className){
		String path = new File("").getAbsolutePath();
		DOMConfigurator.configure("log4j.xml");
		return Logger.getLogger(className);
	}
 
   
}
