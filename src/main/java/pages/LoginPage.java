package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BasePage;
import utils.Constants;

public class LoginPage extends BasePage{

	
	
	@FindBy(id="login_id")
	public WebElement emailField;
	
	@FindBy(id="sign_submmit")
	public WebElement SignInButton;
	
	@FindBy(id="password")
	public WebElement passwordField;
	
	//Any other WebElement on loginPage
	//Constructor code 
	public LoginPage(WebDriver driver, ExtentTest eTest)
	{
		this.driver=driver;
		this.eTest=eTest;
	}
	
	
	
	//Reusable methods of loginPage
	
	public boolean doLogin()
	{
		emailField.sendKeys(Constants.USERNAME);
		eTest.log(Status.INFO, "UserName got entered into Email address field on Login Page");
		passwordField.sendKeys(Constants.PASSWORD);
		eTest.log(Status.INFO, "Password got eneterd successfully");
		
		SignInButton.click();
		eTest.log(Status.INFO, "Signin button got clicked");
		
		HomePage homepage=new HomePage(driver, eTest);
		PageFactory.initElements(driver, homepage);
		
		boolean loginStatus=homepage.verifyDisplayOfHmePage();
		return true;
	}
	
	//Any Other reusable methods 
	
}
