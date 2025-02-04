package MYTestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Pages.LandingPage;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	
	 WebDriver driver;
	 Properties prop;
	public  WebDriver intializeDriver() throws Throwable
	{
		
		prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//Resources//GlobalVariables.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		}
		else if(browserName.equalsIgnoreCase("FireFox"))
		{
			
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			
		}
		driver.manage().window().maximize();
		return driver;
		
			
	
	}
	@BeforeMethod(alwaysRun=true)
	public  LandingPage launchApplication() throws Throwable
	{
	WebDriver driver=	intializeDriver();
	LoginPage loginPage=new LoginPage(driver);
	loginPage.goTo(prop.getProperty("url"));
	LandingPage landingPage=new LandingPage(driver);
	return landingPage;
	
	}
	public String getUN()
	{
		return prop.getProperty("userName");
		
}
public String getPassword()
{
	return prop.getProperty("password");
}
public WebDriver getDriver()
{
	return driver;
}
public String takeScreenShot(String testCaseName,WebDriver driver) throws Throwable
{
	File sourceFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(sourceFile, new File(System.getProperty("user.dir")+"//Reports"+testCaseName+".png"));
	return System.getProperty("user.dir")+"//Reports"+testCaseName+".png";
}
@AfterMethod(alwaysRun  =true)
public void closeMethod()
{
	driver.close();
}
}
