package org.yaminikrishnachalimadugu.AppiumFrameworkDesign.TestUtils;

import org.yaminikrishnachalimadugu.utils.AppiumUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AndroidBaseTest extends AppiumUtils{
	public AppiumDriverLocalService service;
	public AndroidDriver driver;
	@BeforeClass(alwaysRun=true)
	public void setUp() throws URISyntaxException, IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java/org//yaminikrishnachalimadugu//pageObjects//Resources//data.properties");
		prop.load(fis);
		String IPAddress = prop.getProperty("IPAddress");
		String port = prop.getProperty("port");
		String deviceName = prop.getProperty("deviceName");
		service=startAppiumServer(IPAddress , Integer.parseInt(port));
		service.start();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(deviceName);
		options.setApp(System.getProperty("user.dir")+"//src//main//java/org//yaminikrishnachalimadugu//pageObjects//Resources//General-Store.apk");
		options.setCapability("autoGrantPermissions", true);
		options.setChromedriverExecutable("/Users/yaminikrishnachalimadugu/Documents/Drivers/chromedriver");
		options.setCapability("newCommandTimeout", 3000);
		driver = new AndroidDriver(service.getUrl(), options);
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
	@AfterClass(alwaysRun=true)
	public void tearDown() {
		driver.quit();
		service.stop();
	}
}
