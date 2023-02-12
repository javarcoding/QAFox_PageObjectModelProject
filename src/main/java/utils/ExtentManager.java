package utils;

import java.awt.DisplayMode;
import java.util.Date;

import org.apache.poi.xddf.usermodel.chart.DisplayBlanks;
import org.bouncycastle.asn1.x509.DisplayText;

import com.aventstack.extentreports.ExtentReports;

public class ExtentManager {

	public static ExtentReports getInstance()
	{
		Date date=new Date();
		
		String originalDateFormate = date.toString();
		
		String modifiedDAteFormate = originalDateFormate.replace(":", "_").replace(" ","_");
		
		String fileName = modifiedDAteFormate+".html";
		
		String FilePath = "reports//" + fileName;
		
		ExtentReports reports= new ExtentReports();
		
		
		 
		
		
		return reports;
	}
}
