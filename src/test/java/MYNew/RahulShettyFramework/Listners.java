package MYNew.RahulShettyFramework;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import MYTestComponents.BaseTest;

public class Listners extends BaseTest implements ITestListener{
	ExtentReports extent=ExtentReportsClass.getReportObject();
	ExtentTest test;
	String FilePath;
	ThreadLocal extentTest=new ThreadLocal();
	
	 public void onTestStart(ITestResult result) {
		test= extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		  }

		
		  public void onTestSuccess(ITestResult result) {
			 test.log(Status.PASS, result.getMethod().getMethodName()+"Is Passed"); 
			  
		  }

		 		  public void onTestFailure(ITestResult result) {
		 			 test.log(Status.FAIL, result.getMethod().getMethodName()+"Is Failed"); 
		 			 test.fail(result.getThrowable());
		 			
					try {
						 WebDriver driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
						FilePath = takeScreenShot(result.getMethod().getMethodName(),driver);
					} catch (Throwable e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		 			 test.addScreenCaptureFromPath(FilePath, result.getMethod().getMethodName()+".png");
		  }

		
		  public void onTestSkipped(ITestResult result) {
		    // not implemented
		  }

				  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		    // not implemented
		  }

		
		  public void onTestFailedWithTimeout(ITestResult result) {
		    onTestFailure(result);
		  }

	
		   
		  public void onStart(ITestContext context) {
		    // not implemented
		  }

		
		  public void onFinish(ITestContext context) {
		  extent.flush();
		  }
		}



