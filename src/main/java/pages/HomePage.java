package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;

import base.BasePage;

public class HomePage extends BasePage{

	
	
	@FindBy(css="span[class^='zicon-apps-calender']")
	public WebElement Calender;
	
	@FindBy(css="span[class^='zicon-apps-chat']")
	public WebElement Cliq;
	
	@FindBy(css="span[class^='zicon-apps-crm']")
	public WebElement CRM;
	
	@FindBy(css="span[class^='zicon-apps-mail']")
	public WebElement mail;
	
	@FindBy(css="span[class^='zicon-apps-salesiq']")
	public WebElement SalesIQ;
	
	//Constructor code
	public HomePage(WebDriver driver, ExtentTest eTest)
	{
		this.driver=driver;
		this.eTest=eTest;
	}
	
	//Reusable method for verifying method whether the user got successfully logged in or not
	public boolean verifyDisplayOfHmePage()
	{
		return isElementPresent(CRM);
	}
	//Reusable method to navigate to Calendar page
	
	//Reusable method to navigate to Calendar page
	
	//Reusable method to navigate to Calendar page
	
	//Reusable method to navigate to Calendar page
}
