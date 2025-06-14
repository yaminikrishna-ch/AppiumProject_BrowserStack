package org.yaminikrishnachalimadugu.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions extends AppiumUtils{

	AppiumDriver driver;
	public AndroidActions(AppiumDriver driver) {
		this.driver=driver;
	}
	public void longPress(WebElement element) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)element).getId(), 
						"duration", 2000));
	}
	

	public void longPressBrowserStack(WebElement element) {
		Actions actions = new Actions(driver);
		actions.clickAndHold(element).pause(Duration.ofSeconds(20)).release().perform();
	}
	
	public void swipe(WebElement firstImage) {
		((JavascriptExecutor) driver).executeScript("mobile : swipeGesture", ImmutableMap.of("elementId", ((RemoteWebElement)firstImage).getId(),
			"direction", "left",
			"percent", 0.75));
	}
	
	public WebElement scrollIntoView(String data) {
		return driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+data+"\"));"));
	}
	public double sumOfProducts(List <WebElement> products) {
		double sum=0;
		for (int i=0;i<products.size();i++) {
			String productInString = ((products.get(i).getAttribute("text")).substring(1));
			sum += Double.parseDouble(productInString);
		}
		return sum;
	}
	
	
}
