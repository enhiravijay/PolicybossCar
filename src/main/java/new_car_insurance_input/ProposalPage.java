package new_car_insurance_input;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basePage.BasePage;

public class ProposalPage extends BasePage {
	
	@FindBy(xpath = "//div[@class='CRN']")
	WebElement crnNo;

	@FindBy(xpath = "//div[@class='insurer_ctn odometer odometer-auto-theme']/div/span/span[2]/span/span/span[@class='odometer-value']")
	WebElement Insurers;

	@FindBy(xpath = "//div[@class='boxLeft img2 pad-lft']/img")
	WebElement InsurerName;

	@FindBy(xpath = "//li[@class='LiClass']/div[@class='boxLeft resultPrice pad-lft dynamic']/h5")
	WebElement Idv;

	public ProposalPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	

	
}
