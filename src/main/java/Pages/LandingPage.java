package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractClass;

public class LandingPage  extends AbstractClass{
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement userEmail=driver.findElement(By.cssSelector("input[formcontrolname='userEmail']"));
	@FindBy(css="input[formcontrolname='userEmail']")
	WebElement userEmail;
	@FindBy(id="userPassword")
	WebElement userPassword;
	@FindBy(id="login")
	WebElement loginButton;
	public void loginLandPage(String un, String pw)
	{
		userEmail.sendKeys(un);
		userPassword.sendKeys(pw);
		loginButton.click();
	}

}
