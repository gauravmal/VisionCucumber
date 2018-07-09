package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.Log;

public class AcceptPageObjects 
{
	public WebDriver driver;
	public WebDriverWait wait;
	
	public WebElement findElementByID(WebDriver driver,String str)
	{
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(str)));
		return driver.findElement(By.id(str));		
	}
	
	public WebElement findLink(WebDriver driver, String str)
	{
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//a[text()='"+str+"']")));
		return driver.findElement(By.xpath(".//a[text()='"+str+"']"));
	}
	
	public WebElement findButton(WebDriver driver, String str)
	{
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//button[@role='button']//span[text()='"+str+"']"))));
		return driver.findElement(By.xpath(".//button[@role='button']//span[text()='"+str+"']"));
	}
	
	public WebElement findRecord(WebDriver driver, String str)
	{	
		try
		{
			wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[contains(text(),'"+str+"')]")));
			return driver.findElement(By.xpath(".//*[contains(text(),'"+str+"')]"));			
		}
		catch(Exception e)
		{
			Log.error("Class-AcceptPageObject | Method-findRecord | Exception desc : "+e.getMessage());
			throw(e);
		}
		
	}
	
	public WebElement findMessage(WebDriver driver)
	{
		return driver.findElement(By.xpath("//div[@id='messages']//span[@class='ui-messages-info-detail']"));
	}
}
