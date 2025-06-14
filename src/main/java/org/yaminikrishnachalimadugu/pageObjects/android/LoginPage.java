package org.yaminikrishnachalimadugu.pageObjects.android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.yaminikrishnachalimadugu.utils.AndroidActions;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends AndroidActions{
	String countrylocator;
	AppiumDriver driver;
	public LoginPage(AppiumDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	private WebElement femalegender;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
	private WebElement malegender;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='android:id/text1']")
	private WebElement countryselector;
	
	@AndroidFindBy(xpath ="(//android.widget.Toast)[1]")
	private WebElement toastMessage;
	
	@AndroidFindBy(xpath ="(//android.widget.Toast)[1]")
	private List <WebElement> toastMessageList;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;
	
	public void setNameField(String name) {
		waitForElementtoAppear(nameField, driver).sendKeys(name);
		((AndroidDriver)driver).hideKeyboard();
	}
	
	public void setGender(String gender) {
		if(gender == "male") {
			waitForElementtoAppear(malegender, driver).click();
		}
		else {
			waitForElementtoAppear(femalegender, driver).click();
		}
	}
	
	public void setCountry(String country) {
		waitForElementtoAppear(countryselector, driver).click();
		scrollIntoView(country).click();
	}
	public ProductCatalog shop() {
		waitForElementtoAppear(shopButton, driver).click();
		return  new ProductCatalog(driver);
	}
	public String errorMessage() {
		//toastMessage.get(0).getAttribute("name");
		return toastMessage.getAttribute("name");
	}
	public int errorMessageList() {
		return toastMessageList.size();
	}
	
}
