package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BasePage;
import utils.Constants;

public class launchpage extends BasePage {

	//WebElements of Launch Page
	@FindBy(className = "zh-customers")
	public WebElement Customers;
	
	
	@FindBy(className = "zh-support")
	public WebElement Supports;
	
	@FindBy(className = "zh-login")
	public WebElement logIn;
	
	@FindBy(className = "zh-signup")
	public WebElement FreeSignUp;
	
	//Any Other Locator
	
	//Constructor code here
	public launchpage(WebDriver driver, ExtentTest eTest)
	{
		this.driver=driver;
		this.eTest=eTest;
	}
	
	//Reusable methods for launchPage
	
	public boolean goToLoginPage() {
		
		driver.get(Constants.APP_URL);
		eTest.log(Status.INFO, "Application URL"+Constants.APP_URL+"got opened");
		
		logIn.click();
		eTest.log(Status.INFO, "Login option got opened");
		
		LoginPage loginpage=new LoginPage(driver, eTest);
		PageFactory.initElements(driver, loginpage);
		
		boolean loginStatus=loginpage.doLogin();
		
		return true;
	}
	
	//Any other reusable method for launch page
	
}
