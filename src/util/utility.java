package util;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class utility 
{
	//Enter text in text box
	public static void textBox(WebDriver driver,WebElement element,String fieldName,String testData) throws Exception
	{
		try
		{
			element.clear();
			highlightElement(driver,element);
			element.sendKeys(testData);			
			Log.info("Value Entered Field Name:-"+fieldName+", Value:-"+testData);
		}
		catch(Exception e)
		{
			Log.error("Class Utils | Method textBox | Exception desc : "+e.getMessage());
			throw(e);
		}
	}
	
	//Clicking button
	public static void button(WebDriver driver, WebElement element, String fieldName) throws Exception
	{
		try
		{
			highlightElement(driver,element);
			element.click();
			Log.info("Button clicked:- "+fieldName);
		}
		catch(Exception e)
		{
			Log.error("Class Utils | Method button | Exception desc : "+e.getMessage());
			throw(e);
		}
	}
	//selecting record from web table
	public static void selectRecordFromTable(WebDriver driver,WebElement element) throws Exception
	{
		try
		{
			highlightElement(driver,element);
			element.click();
			Log.info("Record selected");		
		}
		catch(Exception e)
		{
			Log.error("Class-utility | Method-selectRecordFromTable | Exception desc : "+e.getMessage());
			throw(e);
		}		
	}
	//Click Link
	public static void link(WebDriver driver, WebElement element,String linkName)throws Exception
	{
		try
		{			
			highlightElement(driver,element);
			element.click();
			Log.info("Link clicked Name:- "+linkName);
		}
		catch(Exception e)
		{
			Log.error("Class-utility | Method-link | Exception desc : "+e.getMessage());
			throw(e);
		}
	}
	
	//This method highlights WebElement with Red boarder during script execution.  
	public static void highlightElement(WebDriver driver,WebElement element) throws Exception
	{
		try
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].style.border='4px solid red'",element);
			Thread.sleep(500);
			js.executeScript("arguments[0].style.border='0px solid white'",element);			
		}
		catch(Exception e)
		{
			Log.error("Class-utility | Method highlightElement | Exception desc : "+e.getMessage());
			throw(e);
		}	
	}

	//Login function
	public static void loginIntoVision(WebDriver driver,String url,String un,String pw) throws Exception
	{
		try
		{
			//Navigating to QA env.
			if(url.equalsIgnoreCase("QA1"))
			{
				driver.get(url);
			}
					
			 
				driver.get(url);    
			//Entering user name
			textBox(driver,driver.findElement(By.id("j_username")),"User Name",un);
			//Entering password
			textBox(driver,driver.findElement(By.id("j_password")),"User Password",pw);
			//Clicking Login button
			button(driver,driver.findElement(By.id("login")),"Login");			
		}
		catch(Exception e)
		{
			Log.error("Class-utility | Method loginIntoVision | Exception desc : "+e.getMessage());
			throw(e);
		}	
	}
	
	//This function is to compare two success messages matches or not
	public static boolean compareMessage(WebElement element,String msg)
	{
		if(element.getText().equalsIgnoreCase(msg))
		{
			return true;
		}
		else
		{
			return false;
		}
								
	}	
	
	/*
	public static String createQuotation(String env) 
	{
		try
		{
			if(env.equalsIgnoreCase("QA1"))
			{
				
			}
			else if(env.equalsIgnoreCase("QA2"))
			{
				URL url = new URL(env);
				
			}			
		}
		catch(Exception e)
		{
			Log.error("Class-utility | Method createQuotation | Exception desc : "+e.getMessage());
			throw(e);
		}
					
	}
	*/
}
