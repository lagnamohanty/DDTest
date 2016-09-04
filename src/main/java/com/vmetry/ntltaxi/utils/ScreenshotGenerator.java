package com.vmetry.ntltaxi.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import com.vmetry.ntltaxi.initializer.Initializer;

public class ScreenshotGenerator extends Initializer{
	
 public static void getScreenShot(ITestResult it) throws IOException{
    	 
	 Object[] data=it.getParameters();
    	 if(it.isSuccess())
    	 {
    	 String path=takeScreenshot(data[0].toString());
    	 log.addScreenCapture(path);
    	 log.log(LogStatus.PASS, "testcase pass", path);
    	 }else 
    	 {
        	 String path=takeScreenshot(data[0].toString());
        	 log.addScreenCapture(path);
        	 log.log(LogStatus.FAIL, "testcase pass", path);
          }
    	 reports.endTest(log);
    	 reports.flush();
     }
	
	public static String takeScreenshot(String name) throws IOException{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dst=new File("C:\\Users\\prachi\\Desktop\\DDFramework\\screenshot\\"+name+".jpg");
		FileUtils.copyFile(src, dst);
		return dst.toString();
		
	}

}
