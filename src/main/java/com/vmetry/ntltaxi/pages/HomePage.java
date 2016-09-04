package com.vmetry.ntltaxi.pages;

import com.vmetry.ntltaxi.initializer.DriverFunctions;

public class HomePage extends DriverFunctions {
	
	public static void enterUserName(String userName) throws InterruptedException
	{
		getWebElementByXpath("HOMEPAGE_USERNAME_TYPE_XPATH").sendKeys(userName);;
	}
	public static void enterMobileNumber(String mobileNumber) throws InterruptedException
	{
		getWebElementByXpath("HOMEPAGE_MOBILENUMBER_TYPE_XPATH").sendKeys(mobileNumber);;
	}
	public static void enterPickupPlace(String pickUpAddress) throws InterruptedException
	{
		getWebElementByXpath("HOMEPAGE_PICKUPPLACE_TYPE_XPATH").sendKeys(pickUpAddress);;
	}
	public static void enterDropPlace(String dropPlace) throws InterruptedException
	{
		getWebElementByXpath("HOMEPAGE_DROPPLACE_TYPE_XPATH").sendKeys(dropPlace);;
	}
	public static void selectBasic(String basic) throws InterruptedException
	{
		selectDropdown("HOMEPAGE_BASICSELECT_SELECT_XPATH",basic);
	}
	public static void clickBookLater() throws InterruptedException
	{
		getWebElementByXpath("HOMEPAGE_BOOKLATER_CLICK_XPATH").click();
	}

}
