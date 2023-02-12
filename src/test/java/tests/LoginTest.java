package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.baseTest;
import pages.launchpage;
import utils.Constants;
import utils.ExtentManager;

public class LoginTest extends baseTest {

	
	
	@Test
	public void loginTest() {
		
		
		
		//eTest= eReports.startTest("LoginTest");
		
		eTest.log(Status.INFO, "Login Test has started");
		
		openBrowser(Constants.BROWSER_TYPE);
		
		launchpage launchPage=new launchpage(driver, eTest);
		
		PageFactory.initElements(driver, launchPage);
		
		boolean loginStatus=launchPage.goToLoginPage();
		
		if (loginStatus) {
			reportPass("LoginTest Test passed");
		}else {
			reportPass("LoginTest Test Failed");
		}
		
	}
	
	public void testClosure() {
		if (eReports!=null) {
			//eReports.endTest(eTest);
			eReports.flush();
		}
	}
	}