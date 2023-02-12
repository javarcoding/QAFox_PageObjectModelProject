package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

public class BasePage {


	public WebDriver driver=null;
	public ExtentTest eTest=null;
	
	public boolean isElementPresent(WebElement element)
	{
		boolean displayedSatus=element.isDisplayed();
		
		if (displayedSatus) {
			return true;
		}else {
			return false;
		}
	}
}
