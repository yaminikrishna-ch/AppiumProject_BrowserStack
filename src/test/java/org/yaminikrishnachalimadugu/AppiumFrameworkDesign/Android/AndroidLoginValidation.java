package org.yaminikrishnachalimadugu.AppiumFrameworkDesign.Android;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.yaminikrishnachalimadugu.AppiumFrameworkDesign.TestUtils.AndroidBaseTest;
import org.yaminikrishnachalimadugu.pageObjects.android.LoginPage;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.Activity;

public class AndroidLoginValidation extends AndroidBaseTest {
	
	@BeforeMethod(alwaysRun=true)
	public void preSetup() {
		Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
		//driver.startActivity(activity);
//		if(driver !=null) {
//			((JavascriptExecutor)driver).executeScript("mobile: startActivity", ImmutableMap.of("intent","com.androidsample.generalstore/com.androidsample.generalstore.SplashActivity"));
//		}
		driver.terminateApp("com.androidsample.generalstore");
		((JavascriptExecutor)driver).executeScript("mobile: startActivity", ImmutableMap.of("intent","com.androidsample.generalstore/com.androidsample.generalstore.SplashActivity"));
	}
	@Test(dataProvider = "getData", groups= {"Smoke"})
	public void AndroidLoginPositive(HashMap<String, String> data) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setCountry(data.get("country"));
		loginpage.setGender(data.get("gender"));
		loginpage.setNameField(data.get("name"));
		loginpage.shop();
		int  errormessage = loginpage.errorMessageList();
		Assert.assertEquals(errormessage, 0);
	}
	@Test(dataProvider="getData")
	public void AndroidLoginNegative(HashMap<String,String> data) throws InterruptedException {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setCountry(data.get("country"));
		//loginpage.setNameField("");
		loginpage.setGender(data.get("gender"));
		loginpage.shop();
		Thread.sleep(2000);
		String errormessage = loginpage.errorMessage();
		//System.out.println(errormessage.get(0).getAttribute("name"));
		Assert.assertEquals(errormessage, "Please enter your name");
	}
	
	@DataProvider
	public Object[][] getData() throws IOException{
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"//src//test//java/org//yaminikrishnachalimadugu//AppiumFrameworkDesign//Android//TestData//GeneralStoresLoginData.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}};
	}

}
