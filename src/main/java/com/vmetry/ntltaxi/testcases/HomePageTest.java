package com.vmetry.ntltaxi.testcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vmetry.ntltaxi.initializer.DriverFunctions;
import com.vmetry.ntltaxi.initializer.Initializer;
import com.vmetry.ntltaxi.inputreader.inputReader;
import com.vmetry.ntltaxi.pages.HomePage;
import com.vmetry.ntltaxi.utils.ScreenshotGenerator;

public class HomePageTest extends Initializer{
	
	@BeforeClass
	public void setup() throws IOException
	{
		initialize();
	}
	
	@Test(dataProvider="HomePageTest")//it will fetch data from data provider
	public void testHomePage(String testdata, String username, String mobileno, String pickup, String drop, String basic) throws IOException, InterruptedException
	{
		
		log=reports.startTest(testdata);
		DriverFunctions.loadURL();
		HomePage.enterUserName(username);
		HomePage.enterMobileNumber(mobileno);
		HomePage.enterPickupPlace(pickup);
		HomePage.enterDropPlace(drop);
		HomePage.selectBasic(basic);
		HomePage.clickBookLater();
	}
	
	@DataProvider(name="HomePageTest")
	public static Object[][] getHomePage() throws Exception{
		
		if(inputReader.runModeVerification("HomePageTest")){
 		Object[][] data=inputReader.selectSingleDataOrMulitiData("HomePageTest");
			//new Object[2][6];
//		//first data setup
//		
//		data[0][0]="HomePageTest_Data1";
//		data[0][1]="testa";
//		data[0][2]="13562145";
//		data[0][3]="ADYAR";
//		data[0][4]="ADYAR";
//		data[0][5]="Sedan";
//		
//		//second data setup
//		
//		data[1][0]="HomePageTest_Data2";
//		data[1][1]="testb";
//		data[1][2]="13562145";
//		data[1][3]="ADYAR";
//		data[1][4]="ADYAR";
//		data[1][5]="Sedan";
//		
		
		return data;
		}
		return null;
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult it) throws IOException{
		
		ScreenshotGenerator.getScreenShot(it);
		
	}

}
