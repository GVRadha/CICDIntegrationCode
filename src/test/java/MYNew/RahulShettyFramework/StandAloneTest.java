package MYNew.RahulShettyFramework;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import MYTestComponents.BaseTest;
import Pages.LandingPage;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest extends BaseTest {
	LandingPage ln=new LandingPage(getDriver());
@Test(dataProvider="getData",groups= {"smoke"})
public void loginToTheApplication(HashMap<Object, Object> input) throws Throwable
{

	System.out.println("UserName is"+input.get("email"));
	System.out.println("Password is"+input.get("password"));
	//ln.loginLandPage(getUN(),getPassword());
	//ln.loginLandPage(un,pw);
}
@Test(dataProvider="getData",groups= {"smoke"})
public void loginToTheSecondApplication(String un,String pw) throws Throwable
{


	ln.loginLandPage(un,pw);
	
}


@DataProvider
public Object[][] getData()
{
	//return new Object[][]  {{"anshika@gmail.com","Iamking@000"},{"anshika@gmail.com","Iamking@000"}};
	HashMap<Object, Object> map=new HashMap<Object, Object>();
	map.put("email","anshika@gmail.com");
	map.put("password", "Iamking@000");
	return new Object[][] {{map}};
	
}


	
}

