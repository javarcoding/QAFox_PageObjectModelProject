package base;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.Constants;
import utils.ExtentManager;

public class baseTest {

	public ExtentReports eReports = ExtentManager.getInstance();
	public ExtentTest eTest;
	public WebDriver driver;

	public void openBrowser(String browserType) {

		if (browserType.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();

		} else if (browserType.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_EXE);
			driver = new ChromeDriver();

		} else if (browserType.equalsIgnoreCase("ie")) {

			System.setProperty("webdriver.ie.driver", Constants.IE_DRIVER_EXE);
			driver = new InternetExplorerDriver();

		}

		eTest.log(Status.INFO, "Successfully opened the browser" + browserType);

		driver.manage().window().maximize();
		eTest.log(Status.INFO, "Browser got maximize");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public void reportPass(String message) {

		eTest.log(Status.PASS, message);
	}

	public void reportFail(String message) throws IOException {

		eTest.log(Status.FAIL, message);
		takeScreenshot();
		Assert.fail(message);
	}
	
	//Reusable method for taking screenshot
		public void takeScreenshot() throws IOException{
			
			// fileName of the screenshot
			Date d=new Date();
			String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
			// store screenshot in that file
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile, new File("screenshots//"+screenshotFile));
			} catch (IOException e) {
				e.printStackTrace();
			}
			//put screenshot file into the reports
			eTest.log(Status.INFO,"Screenshot-> "+ eTest.addScreenCaptureFromPath(System.getProperty("user.dir")+"//screenshots//"+screenshotFile));
				
		}
}
