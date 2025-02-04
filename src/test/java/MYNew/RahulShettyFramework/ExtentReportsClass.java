package MYNew.RahulShettyFramework;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsClass {
	
	public static ExtentReports getReportObject()
	{
		String filePath=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(filePath);
		reporter.config().setDocumentTitle("AutomationExtentReports");
		reporter.config().setTheme(Theme.STANDARD);
		ExtentReports extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Radha");
		return extent;
	}

}
