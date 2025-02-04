package MYNew.RahulShettyFramework;

import java.io.File;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import MYTestComponents.BaseTest;
import Pages.LandingPage;

public class ExtentReportsDemo extends BaseTest {
	ExtentReports extent;
	LandingPage ln=new LandingPage(getDriver());
	@BeforeTest
	public void getExtentReports()
	{
		String filePath=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(filePath);
		reporter.config().setDocumentTitle("AutomationExtentReports");
		reporter.config().setTheme(Theme.STANDARD);
		extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Radha");
		
	}
	@Test
	public void intialDemo()
	{
		extent.createTest("intialDemo");
		//ln.loginLandPage(getUN(), getPassword());
		extent.flush();
		
	}

}
