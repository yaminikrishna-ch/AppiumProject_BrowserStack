package org.yaminikrishnachalimadugu.AppiumFrameworkDesign.Android;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.yaminikrishnachalimadugu.AppiumFrameworkDesign.TestUtils.AndroidBaseTest;
import org.yaminikrishnachalimadugu.pageObjects.android.CartPage;
import org.yaminikrishnachalimadugu.pageObjects.android.LoginPage;
import org.yaminikrishnachalimadugu.pageObjects.android.ProductCatalog;

import com.google.common.collect.ImmutableMap;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class AndroidFramework extends AndroidBaseTest{
	
//	@BeforeMethod
//	public void preSetup() {
//		Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
//		//((AndroidDriver) driver).startActivity(activity);
//		//((AndroidDriver) driver).startActivity(new Activity(""))
//		if(driver !=null) {
//			((JavascriptExecutor)driver).executeScript("mobile: startActivity", ImmutableMap.of("intent","com.androidsample.generalstore/com.androidsample.generalstore.SplashActivity"));
//		}
//		driver.terminateApp("com.androidsample.generalstore");
//		((JavascriptExecutor)driver).executeScript("mobile: startActivity", ImmutableMap.of("intent","com.androidsample.generalstore/com.androidsample.generalstore.SplashActivity"));
//	}
	
	@Test(dataProvider="getData")
	//@Test
	public void androidEndToEndFrameworkTest(HashMap<String,String> data) throws InterruptedException {
		//public void androidEndToEndFrameworkTest(String name, String gender, String country) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		LoginPage loginpage = new LoginPage(driver);
		Thread.sleep(2000);
		loginpage.setNameField(data.get("name"));
		loginpage.setGender(data.get("gender"));
		loginpage.setCountry(data.get("country"));
//		loginpage.setNameField(name);
//		loginpage.setGender(gender);
//		loginpage.setCountry(country);
		
		ProductCatalog productcatalog = loginpage.shop();
		Thread.sleep(2000);
		productcatalog.addItemToCartByIndex(0);
		productcatalog.addItemToCartByIndex(0);
		
		CartPage cartpage =  productcatalog.goToCart();
		Assert.assertEquals(cartpage.getPageTitle(),"Cart");
		Assert.assertEquals(cartpage.CartTotal(), cartpage.productSum());
		String alertTitle = cartpage.checkTermsAndConditions("Cancel");
		Assert.assertEquals(alertTitle, "Terms Of Conditions");
		cartpage.clickCheckBox();
		//cartpage.clickProceed();
	
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException{
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"//src//test//java/org//yaminikrishnachalimadugu//AppiumFrameworkDesign//Android//TestData//GeneralStoresLoginData.json");
		return new Object[][] {{data.get(0)}};
	}
}