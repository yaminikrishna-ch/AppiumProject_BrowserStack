package org.yaminikrishnachalimadugu.AppiumFrameworkDesign.TestUtils;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.internal.ReporterConfig.Property;
import org.yaminikrishnachalimadugu.utils.AppiumUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class iOSBaseTest extends AppiumUtils {
	public AppiumDriverLocalService service;
	public IOSDriver driver;
	
	@BeforeMethod
	@BeforeClass
	public void setUp() throws URISyntaxException, IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//org//yaminikrishanchalimadugu//pageObjects//Resources//data.properties");
		prop.load(fis);
		String IPAdress = prop.getProperty("IPAddress");
		String port = prop.getProperty("port");
		service = startAppiumServer(IPAdress, Integer.parseInt(port));
		service.start();
		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName("iPhone 16 Pro");
		options.setApp("/Users/yaminikrishnachalimadugu/Documents/AppiumUdemy/UIKitCatalog.app");
		//options.setApp("/Users/yaminikrishnachalimadugu/eclipse-workspace/iOS/src/test/java/resources/TestApp 3.app");
		options.setPlatformVersion("18.3");
		options.setWdaLaunchTimeout(Duration.ofSeconds(20));
		driver = new IOSDriver(service.getUrl(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	
	@AfterMethod
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}
}
