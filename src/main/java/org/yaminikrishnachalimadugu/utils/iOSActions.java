package org.yaminikrishnachalimadugu.utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;


public class iOSActions extends AppiumUtils{
	AppiumDriver driver;
	public iOSActions(AppiumDriver driver) {
		this.driver=driver;
	}
	public void scrollToElement(WebElement element) {
	Map<String, Object> params = new HashMap <>();
	params.put("element",((RemoteWebElement) element).getId() );
	params.put("direction", "down");
	driver.executeScript("mobile:scroll", params);
	}
	
	public void pickerSlider(WebElement slider , String percent) {
		slider.sendKeys(percent);
	}
	
	public void longPress(WebElement element, String duration) {
		Map <String, Object> params  = new HashMap<>();
		params.put("element", ((RemoteWebElement) element). getId());
		//String duration=0;
		params.put("duration", duration);
		driver.executeScript("mobile:touchAndHold",params );
	}
	
}
