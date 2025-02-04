package MYNew.RahulShettyFramework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import MYTestComponents.BaseTest;
import Pages.LandingPage;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest2 extends BaseTest {
	LandingPage ln=new LandingPage(getDriver());
@Test

public void loginToTheApplication() throws Throwable
{

	ln.loginLandPage(getUN(),getPassword());
	Assert.assertTrue(false);
}
@Test(groups="smoke")
public void loginToTheSecondApplication() throws Throwable
{

	ln.loginLandPage(getUN(),getPassword());
	Assert.assertTrue(false);
	
}
}

