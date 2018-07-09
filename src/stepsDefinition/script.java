package stepsDefinition;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

import com.github.mkolisnyk.cucumber.reporting.CucumberResultsOverview;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.AcceptPageObjects;
import util.Log;
import util.utility;

public class script extends AcceptPageObjects
{		
	WebDriver driver;	
	AcceptPageObjects objAccept;
	CucumberResultsOverview results;
	File file;
	FileInputStream fileInput;
	Properties prop;
	
	@Before
	public void beforeScenario() throws Exception
	{
		//Configuring logging
		DOMConfigurator.configure("log4j.xml");		
		Log.startTestCase("Accept Quote");	
		
		//Loading properties
		file = new File("config.properties");
		fileInput = new FileInputStream(file);
		prop = new Properties();
		prop.load(fileInput);		
	}
	
	@After
	public void afterScenario() throws Exception
	{
		//Generating cucumber report
		results = new CucumberResultsOverview();
		results.setOutputDirectory("target");
		results.setOutputName("cucumber-results");
		results.setSourceFile("target/cucumber.json");
		results.execute();		
	}
	
	//This step definition is for login into vision
	@Given("^Login into vision \"([^\"]*)\"$")
	public void login_into_vision(String url) throws Exception 
	{	
		//setting IE driver
		System.setProperty("webdriver.ie.driver",prop.getProperty("ieDriverPath"));		
		driver = new InternetExplorerDriver();
		
		if(url.equalsIgnoreCase("QA1"))
		{
			url = prop.getProperty("qa1URL"); 
		}
		else if(url.equalsIgnoreCase("QA2"))
		{
			url = prop.getProperty("qa2URL");
		}			
		//Maximizing IE window
	    driver.manage().window().maximize();	 
	    
	    //Creating object for accept page object class
	    objAccept = new AcceptPageObjects();
	    
	    //Login into vision
	    utility.loginIntoVision(driver,url,prop.getProperty("visionUserName"),prop.getProperty("visionPassword"));
	    Log.info("User logged into Vision");
	}  
	
	@When("^create quote in \"([^\"]*)\"$")
	public void create_quote_in(String arg1) throws Throwable 
	{
				
	}
	//This will click a url based in ID passed.
	@When("^Click \"([^\"]*)\" url$")
	public void click_url(String str) throws Throwable 
	{
		utility.link(driver,objAccept.findElementByID(driver,str),str);
	}
	//This will type text into a field
	@When("^Type \"([^\"]*)\" into the \"([^\"]*)\" field$")
	public void type_into_the_field(String testData, String fieldName) throws Throwable 
	{
		utility.textBox(driver,objAccept.findElementByID(driver,fieldName),fieldName,testData);		
	}
//This will click a button based in button label passed.
	@When("^Click \"([^\"]*)\" button$")
	public void click_button(String btnName) throws Throwable 
	{
		utility.button(driver,objAccept.findButton(driver,btnName),btnName);		
	}
	
	@When("^Select \"([^\"]*)\" from table$")
	public void select_record_from_table(String testData) throws Throwable 
	{
		for(int i=0;i<=1;i++)
		{
			utility.selectRecordFromTable(driver,objAccept.findRecord(driver,testData));	
		}		
	}
	
	@Then("^Accept success message display$")
	public void success_message_display() throws Throwable 
	{
		//check mssage mactches
		if(utility.compareMessage(objAccept.findMessage(driver),""))
		{
			System.out.println("PASS");
			//get unit number
		}
		else
		{
			System.out.println("FAIL");
		}	
	}

}



