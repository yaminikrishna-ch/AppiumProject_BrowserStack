package org.yaminikrishnachalimadugu.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumUtils {
	AppiumDriver driver;
	public AppiumDriverLocalService service;
	
	public WebElement waitForElementtoAppear(WebElement element, AppiumDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException{
		String jsonContent =FileUtils.readFileToString(new File(jsonFilePath));
		 ObjectMapper mapper = new ObjectMapper();
		 List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
		return data;
	}
	
	public AppiumDriverLocalService startAppiumServer(String IPAddress, int port) {
		service = new AppiumServiceBuilder().withAppiumJS(new File("//opt//homebrew//lib/node_modules//appium//index.js"))
				.usingDriverExecutable(new File("//opt//homebrew//bin//node"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		return service;
	}
	
	public String getScreenshotPath(String testcaseName, AppiumDriver driver) throws IOException {
		
		File source =driver.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"//reports"+testcaseName+".png";
//		FileUtils.copyFile(source, destinationFile);
		FileUtils.copyFile(source, new File( destinationFile));
		return destinationFile;
	}
}
