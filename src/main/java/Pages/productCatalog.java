package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractClass;

public class productCatalog extends AbstractClass{
	WebDriver driver;
	public productCatalog(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".mb-3")
    List<WebElement> products;
	
	public List<WebElement> getProductList(By locator)
	{
		waitForElementToBeAppear(locator);
		locator.findElement(driver);
		return products;
	}

}
