package com.vmetry.ntltaxi.initializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.vmetry.ntltaxi.utils.ReportGenerator;

public class Initializer {
	
	
	//loading env property file
	public static FileInputStream envFis=null;
	public static Properties envProp=null;
	
	//loading env property file
	public static FileInputStream locatorFis=null;
	public static Properties locatorProp=null;
	
	//Initializing webdriver
	public static WebDriver driver=null;
	
	//Extents report declaration
	public static ExtentReports reports;
	public static ExtentTest log;
	
	
	public static boolean isArchived=true;

	public static void initialize() throws IOException
	{
		
		
		ReportGenerator.archiveFile();
		reports=new ExtentReports("/Users/vinothkumar/Documents/SeleniumWorkspace/web/smita/DDFramework/reports/DDReportsss.html");
		
		envFis= new FileInputStream(new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+"com"+File.separator+"vmetry"+File.separator+"ntltaxi"+File.separator+"config"+File.separator+"env.properties"));
		envProp= new Properties();
		envProp.load(envFis);
		
		locatorFis= new FileInputStream(new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+"com"+File.separator+"vmetry"+File.separator+"ntltaxi"+File.separator+"config"+File.separator+"locator.properties"));
		locatorProp= new Properties();
		locatorProp.load(locatorFis);
		
		if(envProp.getProperty("BROWSER").equals("firefox")){
			driver= new FirefoxDriver();
		}else if(envProp.getProperty("BROWSER").equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "");
			driver= new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
	}

}
