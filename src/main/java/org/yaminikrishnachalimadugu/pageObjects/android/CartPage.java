package org.yaminikrishnachalimadugu.pageObjects.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.yaminikrishnachalimadugu.utils.AndroidActions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions {
	
	AppiumDriver driver;
	public CartPage(AppiumDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/toolbar_title")
	private WebElement pageTitle;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
	private WebElement termAndConditionsButton;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	private List <WebElement> products;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
	private WebElement okButton;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement cartTotal;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/alertTitle")
	private WebElement alertTitle;
	
	@AndroidFindBy(className = "android.widget.CheckBox")
	private WebElement checkboxButton;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement proceedButton;
	
	public String getPageTitle() {
		return pageTitle.getText();
	}
	
	public String checkTermsAndConditions(String accept) {
		longPressBrowserStack(waitForElementtoAppear(termAndConditionsButton, driver));
		String alertTitlevalue = waitForElementtoAppear(alertTitle, driver).getText();
		if(accept == "Cancel") {
			okButton.click();
		}
		return alertTitlevalue;
	}
	
	public double productSum() {
		return sumOfProducts(products);
	}
	
	public double CartTotal() {
		return Double.parseDouble(cartTotal.getText().substring(1));
	}
	
//	public String getAlertTitle() {
//		return alertTitle.getText();
//	}
//	
	public void clickCheckBox() {
		waitForElementtoAppear(checkboxButton, driver).click();
	}
	
	public void clickProceed() {
		waitForElementtoAppear(proceedButton, driver).click();
	}
	
//	public void checkPageTitle(String title) {
//		return pageTitle.getAttribute("text") == title;
//	}

}
