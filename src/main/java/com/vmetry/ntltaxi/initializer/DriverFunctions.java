package com.vmetry.ntltaxi.initializer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DriverFunctions extends Initializer {
	
	public static void loadURL()
	{
	
		driver.get(envProp.getProperty("URL"));
	}
	
	public static WebElement getWebElementByXpath(String xpath) throws InterruptedException
	{
		WebElement element=driver.findElement(By.xpath(locatorProp.getProperty(xpath)));
		highlightElement(driver,element);
		return element ;
	}
	
	public static void selectDropdown(String xpath, String data) throws InterruptedException
	{
		WebElement dropdown=driver.findElement(By.xpath(locatorProp.getProperty(xpath)));
		highlightElement(driver,dropdown);
		Select s=new Select(dropdown);
		s.selectByVisibleText(data);
	}
	public static void highlightElement(WebDriver driver,WebElement we) throws InterruptedException{
		
		for(int i=0; i<3;i++){
		((JavascriptExecutor)driver).executeScript("arguments[0].style.border='5px solid red'", we);
		Thread.sleep(1000);
		((JavascriptExecutor)driver).executeScript("arguments[0].style.border=''", we);
		}
	}

}
