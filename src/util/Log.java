package util;

import org.apache.log4j.Logger;

public class Log 
{	
	// Initialize Log4j logs
	private static Logger Log = Logger.getLogger(Log.class.getName());
	
	// This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite
	public static void startTestCase(String sTestCaseName)
	{
		Log.info("****************************************************************************************");
		Log.info("****************************************************************************************");
		Log.info("$$$$$$$$$$$$$$$$$$$$$                 "+sTestCaseName+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");
		Log.info("****************************************************************************************");
		Log.info("****************************************************************************************");
	}
		 
	//This is to print log for the ending of the test case
	public static void endTestCase(String sTestCaseName)
	{
		Log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");
		Log.info("X");		
	}
		 
	//Method to display INFO	
	public static void info(String message)
	{
		Log.info(message);
	}
	
	//Method to display Warning
	public static void warn(String message)
	{
		Log.warn(message);
	}
	
	//Method to display Error
	public static void error(String message)
	{
	   Log.error(message);
	}
	
	//Method to display Fatal Error
	public static void fatal(String message) 
	{
	   Log.fatal(message);
	}
		 
	//Method to display debug message
	public static void debug(String message) 
	{
	   Log.debug(message);
	}
}
